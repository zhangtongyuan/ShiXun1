package com.bwie.day3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Seekbar extends AppCompatActivity implements View.OnClickListener {
    //声明两个控件
    ProgressBar bar = null;
    Button startButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        findViews();
    }

    //通过控件ID得到控件
    private void findViews() {
        bar = (ProgressBar) this.findViewById(R.id.bar);
        startButton = (Button) this.findViewById(R.id.startBtn);
        //为控件添加监听器；
        bar.setOnClickListener(this);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startBtn:
                //设置进度条显示方式为可见
                bar.setVisibility(View.VISIBLE);
                //将线程添加到Handler消息队列
                updateBarHandler.post(updateThread);
                break;
        }
    }

    //使用匿名内部类
    Handler updateBarHandler = new Handler() {
        public void handleMessage(Message msg) {
            bar.setProgress(msg.arg1);
            Log.i("SWORD", "startHandler");
            updateBarHandler.post(updateThread);
        }
    };
    //使用匿名内部类声明线程类
    Runnable updateThread = new Runnable() {
        int i = 0;

        public void run() {
            Log.i("SWORD", "Begin Thread");
            i += 10;
            //得到一个消息对象
            Message msg = updateBarHandler.obtainMessage();
            //将msg对象的arg1参数的值设置为i;
            msg.arg1 = i;
            try {
                //设置当前线程休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //将msg对象加入到消息队列当中（尾部）
            updateBarHandler.sendMessage(msg);

            if (i == 100) {
                //如果当i的值为100时将当前线程从handler中移除
                updateBarHandler.removeCallbacks(updateThread);
            }
        }
    };
}
