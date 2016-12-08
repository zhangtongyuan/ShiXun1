
package com.example.zty.myredbaby.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zty.myredbaby.R;
import com.example.zty.myredbaby.bean.Bean;
import com.example.zty.myredbaby.imagerloader.ImageLoaderUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private final Context context;
    private final LayoutInflater inflater;
    private final Bean tags;

    public RecyclerViewAdapter(Context context, Bean tags) {
        this.context = context;
        this.tags = tags;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.srcview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    // goods.data.get(position).goods_name
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(2).tag.get(position+1).picUrl, holder.list_img2, ImageLoaderUtils.initOptions());
    }

    @Override
    public int getItemCount() {
        //tags.data.get(2).tag.get().size() - 1
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //ImageView list_img1;
        ImageView list_img2;

        public MyViewHolder(View view) {
            super(view);
            //list_img1 = (ImageView) view.findViewById(R.id.list_img1);
            list_img2 = (ImageView) view.findViewById(R.id.list_img2);

        }

    }
}

