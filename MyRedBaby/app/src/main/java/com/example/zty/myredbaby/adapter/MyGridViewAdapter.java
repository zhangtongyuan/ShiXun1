package com.example.zty.myredbaby.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zty.myredbaby.R;
import com.example.zty.myredbaby.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;


/**
 * Created by zty on 2016/11/9.
 */

public class MyGridViewAdapter extends BaseAdapter {


    private final Context context;
    private final Bean tags;

    //加载布局
    private LayoutInflater inflater = null;

    public MyGridViewAdapter(Context context, Bean tags) {
        this.context = context;
        this.tags = tags;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return tags.data.get(1).tag.size( );
    }

    @Override
    public Object getItem(int i) {
        return tags.data.get(1).tag.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;
        if (view == null) {
            vh = new ViewHolder();
            view = inflater.inflate(R.layout.griditem, null);
            vh.img = (ImageView) view.findViewById(R.id.iten_img);
            vh.tv = (TextView) view.findViewById(R.id.iten_tv);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        vh.tv.setText(tags.data.get(1).tag.get(i).elementName);
        ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(1).tag.get(i).picUrl, vh.img);

        return view;
    }

    class ViewHolder {
        ImageView img;
        TextView tv;
    }
}
