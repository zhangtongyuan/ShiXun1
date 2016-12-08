package com.example.zty.myredbaby;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zty.myredbaby.QR.QrCodeActivity;
import com.example.zty.myredbaby.activity.GoodsDetailsActivity;
import com.example.zty.myredbaby.activity.SouSuoActivity;
import com.example.zty.myredbaby.activity.WebViewActivity;
import com.example.zty.myredbaby.adapter.LunBoPagerAdapter;
import com.example.zty.myredbaby.adapter.MuyingRecyclerViewAdapter1;
import com.example.zty.myredbaby.adapter.MuyingRecyclerViewAdapter2;
import com.example.zty.myredbaby.adapter.MyGridViewAdapter;
import com.example.zty.myredbaby.adapter.PinPaiRecyclerViewAdapter;
import com.example.zty.myredbaby.adapter.RecyclerViewAdapter;
import com.example.zty.myredbaby.adapter.ZhutiRecyclerViewAdapter;
import com.example.zty.myredbaby.bean.Bean;
import com.example.zty.myredbaby.imagerloader.ImageLoaderUtils;
import com.example.zty.myredbaby.utils.OkHttp;
import com.example.zty.myredbaby.utils.RecyclerViewClickListener;
import com.example.zty.myredbaby.view.PullBaseView;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;


public class FistPageActivity extends Activity implements PullBaseView.OnHeaderRefreshListener,
        PullBaseView.OnFooterRefreshListener, EasyPermissions.PermissionCallbacks {

    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;
    private GridView shouye_gridview;
    private LinearLayout shouye_ll_dots;
    private TextView shouye_head_hint;
    private LinearLayout shouye_ll_hint;
    private ViewPager shouye_viewpager;
    private Bean tags;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            //获取viewPager当前所在页码
            int currentItem = shouye_viewpager.getCurrentItem();
            //对页码加加
            currentItem++;
            //重新设置
            shouye_viewpager.setCurrentItem(currentItem);
            //重新发送方法
            handler.sendEmptyMessageDelayed(0, 2000);

        }
    };


    private DisplayImageOptions options;
    private ImageView shouye_img;
    private RecyclerView recyclerview;
    private ImageView shouye_pinpai;
    private RecyclerView pinpai_recyclerview;
    private ImageView muying_img;
    private RecyclerView muying_recyclerview;
    private RecyclerView muying_recyclerview1;
    private ImageView zhuti_img;
    private RecyclerView zhuti_recyclerview;
    private ImageView zhuti_da;
    private ImageView juyou_img;
    private RecyclerView juyou_recyclerview;
    private ImageView liangfanhui_img;
    private RecyclerView liangfanhui_recyclerview;
    private RecyclerView shengqian_recyclerview;
    private ImageView shengqian_img;
    private ImageView lama_img;
    private ImageView lama_img1;
    private ImageView lama_img2;
    private ImageView lama_img3;
    private ImageView lama_img4;
    private ImageView jiazaigengduo;
    private View shouye_head_lift;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fist_page);

        //将options转成成员变量
        options = ImageLoaderUtils.initOptions();
        //初始化控件
        initView();
        //OKHttp解析
        okHttp();
        //点击事件
        initOnclick();
        // 滑动监听圆点
        shouye_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // 判断索引值是否和小点的position对应
                for (int i = 0; i < tags.data.get(0).tag.size(); i++) {
                    ImageView imageView = (ImageView) shouye_ll_dots.getChildAt(i);
                    if (i == position % tags.data.get(0).tag.size()) {
                        // 图片变亮
                        imageView.setImageResource(R.mipmap.label_search_cuxiao);
                    } else {
                        // 图片变暗
                        imageView.setImageResource(R.mipmap.commodity_picture_recommend_up_hui);
                    }
                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        // 设置当前页
        shouye_viewpager.setCurrentItem(4 * 1000);
        handler.sendEmptyMessageDelayed(0, 2000);

    }
   /* @Override
    protected void onStop() {
        handler.removeCallbacksAndMessages(null);
        super.onStop();
    }*/


    private void okHttp() {
        OkHttp.getAsync("http://mock.eoapi.cn/success/jSWAxchCQfuhI6SDlIgBKYbawjM3QIga", new OkHttp.DataCallBack() {


            private ZhutiRecyclerViewAdapter zAdapter;
            private MuyingRecyclerViewAdapter1 myAdapter;
            private MuyingRecyclerViewAdapter2 myAdapter1;
            private PinPaiRecyclerViewAdapter pAdapter;
            private RecyclerViewAdapter mAdapter;

            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                tags = gson.fromJson(result, Bean.class);
                //gridview适配器
                shouye_gridview.setAdapter(new MyGridViewAdapter(FistPageActivity.this, tags));

                // 轮播图设置数据适配器

                shouye_viewpager.setAdapter(new LunBoPagerAdapter(FistPageActivity.this, tags, handler));
                // 添加圆点
                initDots(tags);
                //设置10点抢购
                recyclerview.setAdapter(mAdapter = new RecyclerViewAdapter(FistPageActivity.this, tags));
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(2).tag.get(0).picUrl,shouye_img,ImageLoaderUtils.initOptions());
                //傲娇品牌
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(4).tag.get(0).picUrl,shouye_pinpai,ImageLoaderUtils.initOptions());

                shouye_pinpai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
                ArrayList<Bean.Tag> pinpaiList = new ArrayList<>();
                pinpaiList.addAll(tags.data.get(5).tag);
                pinpaiList.addAll(tags.data.get(6).tag);
                pinpaiList.addAll(tags.data.get(7).tag);


                pinpai_recyclerview.setAdapter(pAdapter = new PinPaiRecyclerViewAdapter(FistPageActivity.this, pinpaiList));
                //母婴专区
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(9).tag.get(0).picUrl,muying_img,ImageLoaderUtils.initOptions());

                ArrayList<Bean.Tag> muyList = new ArrayList<>();
                muyList.addAll(tags.data.get(10).tag);
                muying_recyclerview.setAdapter(myAdapter = new MuyingRecyclerViewAdapter1(FistPageActivity.this, muyList));

                ArrayList<Bean.Tag> myList1 = new ArrayList<>();
                myList1.addAll(tags.data.get(11).tag);
                muying_recyclerview1.setAdapter(myAdapter1 = new MuyingRecyclerViewAdapter2(FistPageActivity.this, myList1));
                //主题特卖
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(13).tag.get(0).picUrl,zhuti_img,ImageLoaderUtils.initOptions());
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(14).tag.get(0).picUrl,zhuti_da,ImageLoaderUtils.initOptions());

                ArrayList<Bean.Tag> hwList = new ArrayList<>();
                hwList.addAll(tags.data.get(15).tag);
                // hwList.addAll(tags.data.get(17).tag);

                zhuti_recyclerview.setAdapter(zAdapter = new ZhutiRecyclerViewAdapter(FistPageActivity.this, hwList));
                //聚优
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(16).tag.get(0).picUrl,juyou_img,ImageLoaderUtils.initOptions());


                ArrayList<Bean.Tag> jyList = new ArrayList<>();
                jyList.addAll(tags.data.get(17).tag);

                juyou_recyclerview.setAdapter(zAdapter = new ZhutiRecyclerViewAdapter(FistPageActivity.this, jyList));

                //量贩卖
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(18).tag.get(0).picUrl,liangfanhui_img,ImageLoaderUtils.initOptions());
                ArrayList<Bean.Tag> lfhList = new ArrayList<>();
                lfhList.addAll(tags.data.get(19).tag);

                liangfanhui_recyclerview.setAdapter(zAdapter = new ZhutiRecyclerViewAdapter(FistPageActivity.this, lfhList));

                //省钱

                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(20).tag.get(0).picUrl,shengqian_img,ImageLoaderUtils.initOptions());

                ArrayList<Bean.Tag> sqList = new ArrayList<>();
                sqList.addAll(tags.data.get(21).tag);

                shengqian_recyclerview.setAdapter(zAdapter = new ZhutiRecyclerViewAdapter(FistPageActivity.this, sqList));
                //喇嘛拼团
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(24).tag.get(0).picUrl,lama_img,ImageLoaderUtils.initOptions());

                lama_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                        intent.putExtra("path", tags.data.get(24).tag.get(0).linkUrl);
                        startActivity(intent);
                    }
                });

                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(26).tag.get(0).picUrl,lama_img1,ImageLoaderUtils.initOptions());
                lama_img1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                        intent.putExtra("path", tags.data.get(26).tag.get(0).linkUrl);
                        startActivity(intent);
                    }
                });

                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(28).tag.get(0).picUrl,lama_img2,ImageLoaderUtils.initOptions());

                lama_img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                        intent.putExtra("path", tags.data.get(28).tag.get(0).linkUrl);
                        startActivity(intent);
                    }
                });
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(30).tag.get(0).picUrl,lama_img3,ImageLoaderUtils.initOptions());

                lama_img3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                        intent.putExtra("path", tags.data.get(30).tag.get(0).linkUrl);
                        startActivity(intent);
                    }
                });
                BitmapUtils bitlama4 = new BitmapUtils(FistPageActivity.this);
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(32).tag.get(0).picUrl,lama_img4,ImageLoaderUtils.initOptions());

                lama_img4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                        intent.putExtra("path", tags.data.get(32).tag.get(0).linkUrl);
                        startActivity(intent);
                    }
                });
                ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(33).tag.get(0).picUrl,jiazaigengduo,ImageLoaderUtils.initOptions());
                jiazaigengduo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                        intent.putExtra("path", tags.data.get(33).tag.get(0).linkUrl);
                        startActivity(intent);
                    }
                });
            }
        });
    }



    //添加小圆点
    private void initDots(Bean b) {
        for (int i = 0; i < b.data.get(0).tag.size(); i++) {
            // 创建ImageView控件
            ImageView dotsImages = new ImageView(this);
            if (i == 0) {
                dotsImages.setImageResource(R.mipmap.label_search_cuxiao);
            } else {
                dotsImages.setImageResource(R.mipmap.commodity_picture_recommend_up_hui);
            }
            // dp值20 ---将dp--转成px--宽 高
            LinearLayout.LayoutParams parmas = new LinearLayout.LayoutParams(20, 20);
            // 距离左上右下的间距值
            parmas.setMargins(5, 2, 5, 2);
            // 动态添加到线性布局中
            shouye_ll_dots.addView(dotsImages, parmas);
        }
    }

    //初始化控件
    private void initView() {
        webview = (WebView) findViewById(R.id.webview);
        //viewpager
        shouye_viewpager = (ViewPager) findViewById(R.id.shouye_viewpager);
        //圆点
        shouye_ll_dots = (LinearLayout) findViewById(R.id.shouye_ll_dots);
        shouye_head_hint = (TextView) findViewById(R.id.shouye_head_hint);
        shouye_ll_hint = (LinearLayout) findViewById(R.id.shouye_ll_hint);
        shouye_gridview = (GridView) findViewById(R.id.shouye_gridview);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        shouye_img = (ImageView) findViewById(R.id.shouye_img);
        //二维码
        shouye_head_lift = findViewById(R.id.shouye_head_lift);
        //设置横向排列
        recyclerview.setLayoutManager(new GridLayoutManager(this, 6));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        //品牌
        shouye_pinpai = (ImageView) findViewById(R.id.shouye_pinpai);
        pinpai_recyclerview = (RecyclerView) findViewById(R.id.pinpai_recyclerview);
        pinpai_recyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        pinpai_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //母婴
        muying_img = (ImageView) findViewById(R.id.muying_img);

        muying_recyclerview = (RecyclerView) findViewById(R.id.muying_recyclerview);
        muying_recyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        muying_recyclerview.setItemAnimator(new DefaultItemAnimator());

        muying_recyclerview1 = (RecyclerView) findViewById(R.id.muying_recyclerview1);
        muying_recyclerview1.setLayoutManager(new GridLayoutManager(this, 4));
        muying_recyclerview1.setItemAnimator(new DefaultItemAnimator());

        //主题
        zhuti_img = (ImageView) findViewById(R.id.zhuti_img);
        zhuti_da = (ImageView) findViewById(R.id.zhuti_da);
        zhuti_da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                String path = tags.data.get(14).tag.get(0).linkUrl;
                intent.putExtra("path", path);
                startActivity(intent);
            }
        });
        zhuti_recyclerview = (RecyclerView) findViewById(R.id.zhuti_recyclerview);
        zhuti_recyclerview.setLayoutManager(new GridLayoutManager(this, 6));
        zhuti_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //聚优
        juyou_img = (ImageView) findViewById(R.id.juyou_img);
        juyou_recyclerview = (RecyclerView) findViewById(R.id.juyou_recyclerview);
        juyou_recyclerview.setLayoutManager(new GridLayoutManager(this, 6));
        juyou_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //量贩买
        liangfanhui_img = (ImageView) findViewById(R.id.liangfanhui_img);
        liangfanhui_recyclerview = (RecyclerView) findViewById(R.id.liangfanhui_recyclerview);
        liangfanhui_recyclerview.setLayoutManager(new GridLayoutManager(this, 6));
        liangfanhui_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //省钱
        shengqian_img = (ImageView) findViewById(R.id.shengqian_img);
        shengqian_recyclerview = (RecyclerView) findViewById(R.id.shengqian_recyclerview);
        shengqian_recyclerview.setLayoutManager(new GridLayoutManager(this, 6));
        shengqian_recyclerview.setItemAnimator(new DefaultItemAnimator());
        //辣妈拼团
        lama_img = (ImageView) findViewById(R.id.lama_img);
        lama_img1 = (ImageView) findViewById(R.id.lama_img1);
        lama_img2 = (ImageView) findViewById(R.id.lama_img2);
        lama_img3 = (ImageView) findViewById(R.id.lama_img3);
        lama_img4 = (ImageView) findViewById(R.id.lama_img4);

        jiazaigengduo = (ImageView) findViewById(R.id.jiazaigengduo);

    }

    //点击事件
    private void initOnclick() {

        //搜索框
        shouye_ll_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FistPageActivity.this, SouSuoActivity.class);
                startActivity(intent);
            }
        });

        shouye_head_lift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 添加二维码扫描
                Intent intent = new Intent(FistPageActivity.this, QrCodeActivity.class);
                startActivity(intent);
            }
        });
        //grid点击事件
        shouye_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<String> grLsit = new ArrayList<String>();
                grLsit.add(tags.data.get(1).tag.get(0).linkUrl);
                grLsit.add(tags.data.get(1).tag.get(1).linkUrl);
                grLsit.add(tags.data.get(1).tag.get(2).linkUrl);
                grLsit.add(tags.data.get(1).tag.get(3).linkUrl);
                grLsit.add(tags.data.get(1).tag.get(4).linkUrl);
                grLsit.add(tags.data.get(1).tag.get(5).linkUrl);
                grLsit.add(tags.data.get(1).tag.get(6).linkUrl);
                grLsit.add(tags.data.get(1).tag.get(7).linkUrl);
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);

                intent.putExtra("path", grLsit.get(i));
                startActivity(intent);
            }
        });
        //10点
        recyclerview.addOnItemTouchListener(new RecyclerViewClickListener(FistPageActivity.this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ArrayList<String> sdList = new ArrayList<>();
                sdList.add(tags.data.get(2).tag.get(1).linkUrl);
                sdList.add(tags.data.get(2).tag.get(2).linkUrl);
                sdList.add(tags.data.get(2).tag.get(3).linkUrl);
                sdList.add(tags.data.get(2).tag.get(4).linkUrl);
                sdList.add(tags.data.get(2).tag.get(5).linkUrl);
                sdList.add(tags.data.get(2).tag.get(6).linkUrl);
                Intent intent = new Intent(FistPageActivity.this, GoodsDetailsActivity.class);
                intent.putExtra("path", sdList.get(position));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));

        //品牌的点击事件
        pinpai_recyclerview.addOnItemTouchListener(new RecyclerViewClickListener(FistPageActivity.this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ArrayList<String> ppList = new ArrayList<>();
                ppList.add(tags.data.get(5).tag.get(0).linkUrl);
                ppList.add(tags.data.get(5).tag.get(1).linkUrl);
                ppList.add(tags.data.get(6).tag.get(0).linkUrl);
                ppList.add(tags.data.get(6).tag.get(1).linkUrl);
                ppList.add(tags.data.get(7).tag.get(0).linkUrl);
                ppList.add(tags.data.get(7).tag.get(1).linkUrl);
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                intent.putExtra("path", ppList.get(position));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
        //母婴的点击事件
        muying_recyclerview.addOnItemTouchListener(new RecyclerViewClickListener(FistPageActivity.this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ArrayList<String> myList = new ArrayList<>();
                myList.add(tags.data.get(10).tag.get(0).linkUrl);
                myList.add(tags.data.get(10).tag.get(1).linkUrl);
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                intent.putExtra("path", myList.get(position));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
        //母婴1的点击事件
        muying_recyclerview1.addOnItemTouchListener(new RecyclerViewClickListener(FistPageActivity.this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ArrayList<String> myList1 = new ArrayList<>();
                myList1.add(tags.data.get(11).tag.get(0).linkUrl);
                myList1.add(tags.data.get(11).tag.get(1).linkUrl);
                myList1.add(tags.data.get(11).tag.get(2).linkUrl);
                myList1.add(tags.data.get(11).tag.get(3).linkUrl);
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                intent.putExtra("path", myList1.get(position));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
        //主题的点击事件
        zhuti_da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                intent.putExtra("path", tags.data.get(14).tag.get(0).linkUrl);
                startActivity(intent);
            }
        });
        //聚优的点击事件
        juyou_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                intent.putExtra("path", tags.data.get(16).tag.get(0).linkUrl);
                startActivity(intent);
            }
        });
        //量贩惠的点击事件
        liangfanhui_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                intent.putExtra("path", tags.data.get(18).tag.get(0).linkUrl);
                startActivity(intent);
            }
        });
        //省钱的点击事件
        shengqian_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                intent.putExtra("path", tags.data.get(20).tag.get(0).linkUrl);
                startActivity(intent);
            }
        });

        //主题特卖
        zhuti_recyclerview.addOnItemTouchListener(new RecyclerViewClickListener(FistPageActivity.this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ArrayList<String> ztList = new ArrayList<>();
                ztList.add(tags.data.get(15).tag.get(0).linkUrl);
                ztList.add(tags.data.get(15).tag.get(1).linkUrl);
                ztList.add(tags.data.get(15).tag.get(2).linkUrl);
                ztList.add(tags.data.get(15).tag.get(3).linkUrl);
                ztList.add(tags.data.get(15).tag.get(4).linkUrl);
                ztList.add(tags.data.get(15).tag.get(5).linkUrl);
                Intent intent = new Intent(FistPageActivity.this, GoodsDetailsActivity.class);
                intent.putExtra("path", ztList.get(position));
                startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));

        //聚优
        juyou_recyclerview.addOnItemTouchListener(new RecyclerViewClickListener(FistPageActivity.this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ArrayList<String> jyList = new ArrayList<>();
                jyList.add(tags.data.get(17).tag.get(0).linkUrl);
                jyList.add(tags.data.get(17).tag.get(1).linkUrl);
                jyList.add(tags.data.get(17).tag.get(2).linkUrl);
                jyList.add(tags.data.get(17).tag.get(3).linkUrl);
                jyList.add(tags.data.get(17).tag.get(4).linkUrl);
                jyList.add(tags.data.get(17).tag.get(5).linkUrl);
                Intent intent = new Intent(FistPageActivity.this, GoodsDetailsActivity.class);
                intent.putExtra("path", jyList.get(position));
                startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
        //两贩卖
        liangfanhui_recyclerview.addOnItemTouchListener(new RecyclerViewClickListener(FistPageActivity.this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ArrayList<String> jyList = new ArrayList<>();
                jyList.add(tags.data.get(19).tag.get(0).linkUrl);
                jyList.add(tags.data.get(19).tag.get(1).linkUrl);
                jyList.add(tags.data.get(19).tag.get(2).linkUrl);
                jyList.add(tags.data.get(19).tag.get(3).linkUrl);
                jyList.add(tags.data.get(19).tag.get(4).linkUrl);
                jyList.add(tags.data.get(19).tag.get(5).linkUrl);
                Intent intent = new Intent(FistPageActivity.this, GoodsDetailsActivity.class);
                intent.putExtra("path", jyList.get(position));
                startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
        //省钱
        shengqian_recyclerview.addOnItemTouchListener(new RecyclerViewClickListener(FistPageActivity.this, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                ArrayList<String> sqList = new ArrayList<>();
                sqList.add(tags.data.get(21).tag.get(0).linkUrl);
                sqList.add(tags.data.get(21).tag.get(1).linkUrl);
                sqList.add(tags.data.get(21).tag.get(2).linkUrl);
                sqList.add(tags.data.get(21).tag.get(3).linkUrl);
                sqList.add(tags.data.get(21).tag.get(4).linkUrl);
                sqList.add(tags.data.get(21).tag.get(5).linkUrl);
                Intent intent = new Intent(FistPageActivity.this, WebViewActivity.class);
                intent.putExtra("path", sqList.get(position));
                startActivity(intent);
            }
            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));

    }

    @Override
    public void onStart() {
        super.onStart();
        requestCodeQrcodePermissions();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    public void onPermissionsGranted(int requestCode, List<String> perms) {
    }


    public void onPermissionsDenied(int requestCode, List<String> perms) {
    }

    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQrcodePermissions() {
        String[] perms = {Manifest.permission.CAMERA};
        if (!EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        }
    }

    //上啦加载
    @Override
    public void onFooterRefresh(PullBaseView view) {

    }

    //刷新
    @Override
    public void onHeaderRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  mDatas.add(0, "TEXT新增");
                //recycleAdapter.notifyDataSetChanged();
                //shouye_pullRecyclerview.onHeaderRefreshComplete();
            }
        }, 3000);
    }
}
