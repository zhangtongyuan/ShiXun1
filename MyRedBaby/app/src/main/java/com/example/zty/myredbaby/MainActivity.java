package com.example.zty.myredbaby;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TabHost;

import com.umeng.analytics.MobclickAgent;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost();
    }

    private void tabHost() {
        // ��ȡTabHost

        TabHost tabHost = getTabHost();
        // ����ͼ��
        ImageView imageView = new ImageView(this);

        imageView.setImageResource(R.drawable.firstpage_selector);
        // ���ѡ�
        // ���ѡ� tab ��� indicator ͼ�� contentָ���� ����Activity

        tabHost.addTab(tabHost.newTabSpec("a").setIndicator(imageView)
                .setContent(new Intent(this, FistPageActivity.class)));

        //------------------------------------------------------------------
        // ����ͼ��

        ImageView imageView1 = new ImageView(this);

        imageView1.setImageResource(R.drawable.fenlei_selector);
        // ���ѡ�
        // ���ѡ� tab ��� indicator ͼ�� contentָ���� ����Activity

        tabHost.addTab(tabHost.newTabSpec("b").setIndicator(imageView1)
                .setContent(new Intent(this, BayCarActivity.class)));

        //------------------------------------------------------------------
        // ����ͼ��
        ImageView imageView2 = new ImageView(this);

        imageView2.setImageResource(R.drawable.baycar_selector);
        // ���ѡ�
        // ���ѡ� tab ��� indicator ͼ�� contentָ���� ����Activity

        tabHost.addTab(tabHost.newTabSpec("c").setIndicator(imageView2)
                .setContent(new Intent(this, FenleiActivity.class)));

        //------------------------------------------------------------------// ����ͼ��
        ImageView imageView3 = new ImageView(this);

        imageView3.setImageResource(R.drawable.my_selector);
        // ���ѡ�
        // ���ѡ� tab ��� indicator ͼ�� contentָ���� ����Activity

        tabHost.addTab(tabHost.newTabSpec("d").setIndicator(imageView3)
                .setContent(new Intent(this, MyActivity.class)));

        //------------------------------------------------------------------


    }

}
