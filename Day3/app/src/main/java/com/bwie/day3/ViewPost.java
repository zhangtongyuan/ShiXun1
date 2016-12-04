package com.bwie.day3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        TextView tt = (TextView) findViewById(R.id.tt);
        tt.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
