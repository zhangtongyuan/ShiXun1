package com.example.zty.myredbaby.fragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zty.myredbaby.bean.Bean;
import com.example.zty.myredbaby.imagerloader.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;


public class MyPagerAdapter extends PagerAdapter {
	private final Bean tags;
	private Context context;

	public MyPagerAdapter(Context context, Bean tags) {
		this.context = context;
		this.tags=tags;
	}

	@Override
	public int getCount() {
		return tags.data.get(0).tag.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		ImageView imageView = new ImageView(context);

		ImageLoader.getInstance().displayImage("http://image1.suning.cn/" + tags.data.get(0).tag.get(position ).picUrl, imageView, ImageLoaderUtils.initOptions());
		container.addView(imageView);
		return imageView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView((View) object);
	}

}
