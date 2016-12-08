package com.example.zty.myredbaby.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zty.myredbaby.R;
import com.example.zty.myredbaby.bean.Bean;
import com.example.zty.myredbaby.bean.Detail;
import com.example.zty.myredbaby.map.LocationClientActivity;
import com.example.zty.myredbaby.utils.OkHttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Request;

/**
 * Created by zty on 2016/11/16.
 */
public class GoodsFragment extends Fragment {
    private Bean tags;
    private Detail detail;
    private ViewPager goods_viewpager;
    private LinearLayout goods_ll_dots;
    private LinearLayout baidumap;
    private TextView address_tv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f0, container, false);
        goods_viewpager = (ViewPager) view.findViewById(R.id.goods_viewpager);
        goods_ll_dots = (LinearLayout) view.findViewById(R.id.goods_ll_dots);
        address_tv = (TextView) view.findViewById(R.id.address);
        baidumap = (LinearLayout) view.findViewById(R.id.baidumap);
        baidumap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LocationClientActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String address = data.getStringExtra("address");
        switch (requestCode) {
            case 0:
                address_tv.setText(address);
                break;

        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        okHttp();
        // 滑动监听圆点
        goods_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // 判断索引值是否和小点的position对应
                for (int i = 0; i < tags.data.get(0).tag.size(); i++) {
                    ImageView imageView = (ImageView) goods_ll_dots.getChildAt(i);
                    if (i == position) {
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
    }


    private void okHttp() {

        OkHttp.getAsync("http://mock.eoapi.cn/success/jSWAxchCQfuhI6SDlIgBKYbawjM3QIga", new OkHttp.DataCallBack() {

            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                tags = gson.fromJson(result, Bean.class);
                // 轮播图设置数据适配器
                goods_viewpager.setAdapter(new MyPagerAdapter(getActivity(), tags));
                // 添加圆点
                initDots(tags);
            }

            //添加小圆点
            private void initDots(Bean b) {
                for (int i = 0; i < b.data.get(0).tag.size(); i++) {
                    // 创建ImageView控件
                    ImageView dotsImages = new ImageView(getActivity());
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
                    goods_ll_dots.addView(dotsImages, parmas);
                }
            }

        });
        OkHttp.getAsync("http://mock.eoapi.cn/success/jSWAxchCQfuhI6SDlIgBKYbawjM3QIga", new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result1) throws Exception {
                Gson gson = new Gson();
                detail = gson.fromJson(result1, Detail.class);

                String name = "#花王（Merries）妙而舒 婴幼儿纸尿裤 中号M64片（6-11kg） 宝宝尿不湿";
                SpannableStringBuilder builder = new SpannableStringBuilder(name);
                String rexgString = "#";
                Pattern pattern = Pattern.compile(rexgString);
                Matcher matcher = pattern.matcher(name);

                while (matcher.find()) {
                    builder.setSpan(
                            new ImageSpan(getActivity(), R.mipmap.self_suning), matcher.start(), matcher
                                    .end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }

            }
        });

    }
}
