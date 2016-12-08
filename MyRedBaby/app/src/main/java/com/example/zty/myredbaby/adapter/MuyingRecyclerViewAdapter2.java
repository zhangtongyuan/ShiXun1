
package com.example.zty.myredbaby.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zty.myredbaby.R;
import com.example.zty.myredbaby.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class MuyingRecyclerViewAdapter2 extends RecyclerView.Adapter<MuyingRecyclerViewAdapter2.MyViewHolder> {
    private final Context context;
    private final LayoutInflater inflater;
    private final ArrayList<Bean.Tag> myList1;

    public MuyingRecyclerViewAdapter2(Context context, ArrayList<Bean.Tag> myList1) {
        this.context = context;
        this.myList1 = myList1;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.muying2, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    // goods.data.get(position).goods_name
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage("http://image1.suning.cn" + myList1.get(position).picUrl, holder.pinpai_img1);
       // ImageLoader.getInstance().displayImage("http://image1.suning.cn" + tags.data.get(5).tag.get(1).picUrl, holder.pinpai_img2);
    }

    @Override
    public int getItemCount() {
        //tags.data.get(2).tag.get().size() - 1
        return myList1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView pinpai_img1;
       // ImageView pinpai_img2;

        public MyViewHolder(View view) {
            super(view);
            pinpai_img1 = (ImageView) view.findViewById(R.id.muying_img2);
         //   pinpai_img2 = (ImageView) view.findViewById(R.id.pinpai_img2);

        }

    }
}

