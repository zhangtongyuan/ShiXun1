package com.bwie.day3;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int time = 10;
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0) {
                if (time > 0) {
                    tv_time.setText(time + "");
                } else {
                    tv_time.setText("ShowDown");
                    //停止timer任务
                    timer.cancel();
                }
                time--;
            }
        };
    };

    private Timer timer;
    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_time = (TextView) findViewById(R.id.tv_time);
    }

    public void kill(View v) {
        timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        };
        timer.schedule(task, 1000, 1000);
    }


}
