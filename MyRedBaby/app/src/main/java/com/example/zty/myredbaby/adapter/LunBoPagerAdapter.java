package com.example.zty.myredbaby.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zty.myredbaby.activity.WebViewActivity;
import com.example.zty.myredbaby.bean.Bean;
import com.example.zty.myredbaby.imagerloader.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;


/**
 * Created by zty on 2016/11/9.
 */
public class LunBoPagerAdapter extends PagerAdapter {
    private final Bean tags;
    private Context context;
    private Handler handler;

    public LunBoPagerAdapter(Context context, Bean tags, Handler handler) {
        this.context = context;
        this.handler = handler;
        this.tags = tags;
    }


    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        ImageView imageView = new ImageView(context);
        // 进行网络请求

        //对imageView设置触摸监听
        imageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent event) {
                // TODO Auto-generated method stub
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        //停止轮播任务--移除所有信息和任务
                        handler.removeCallbacksAndMessages(null);
                        break;
                    case MotionEvent.ACTION_UP:

                        Intent intent = new Intent(context, WebViewActivity.class);
                        intent.putExtra("path", tags.data.get(0).tag.get(position%4).linkUrl);
                        context.startActivity(intent);

                    case MotionEvent.ACTION_CANCEL:
                        //重新开始轮播任务
                        handler.sendEmptyMessageDelayed(0, 2000);
                        break;

                    default:
                        break;
                }
                //true 消费事件,false 不消费
                return true;
            }
        });

        ImageLoader.getInstance().displayImage("http://image1.suning.cn/" + tags.data.get(0).tag.get(position % 4).picUrl, imageView, ImageLoaderUtils.initOptions());
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        container.removeView((View) object);
    }

}
