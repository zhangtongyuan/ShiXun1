package com.bwie.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {

    private int mImageThumbSize;
    private int mImageThumbSpacing;
    private PhotoWallAdapter mAdapter;
    // private GridView mPhotoWall;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         final RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
           recyclerview.setLayoutManager(new GridLayoutManager(this,4));
          // MyAdapter myAdapter = new MyAdapter();
    //      recyclerview.setAdapter(myAdapter);

        mImageThumbSize = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_size);
        mImageThumbSpacing = getResources().getDimensionPixelSize(
                R.dimen.image_thumbnail_spacing);
        //mPhotoWall = (GridView) findViewById(R.id.recyclerview);
        mAdapter = new PhotoWallAdapter(this, 0, Images.imageThumbUrls,
                recyclerview);
        recyclerview.setAdapter(mAdapter);
        recyclerview.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        final int numColumns = (int) Math.floor(recyclerview
                                .getWidth()
                                / (mImageThumbSize + mImageThumbSpacing));
                        if (numColumns > 0) {
                            int columnWidth = (recyclerview.getWidth() / numColumns)
                                    - mImageThumbSpacing;
                            mAdapter.setItemHeight(columnWidth);
                            recyclerview.getViewTreeObserver()
                                    .removeGlobalOnLayoutListener(this);
                        }
                    }
                });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAdapter.fluchCache();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        mAdapter.cancelAllTasks();
    }

}
