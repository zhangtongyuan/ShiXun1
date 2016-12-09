package com.example.zty.myredbaby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.umeng.analytics.MobclickAgent;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_welcome);
        MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(WelcomeActivity.this, "584a99b199f0c77609000db9", "aaa"));

        new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
