package com.bwie.fragmentargments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * 作用 ：Main
 * 作者 :张桐源
 * 日期 ： 2016/11/29
 */
public class MainActivity extends AppCompatActivity implements Fragment0.JieKou{
    private ArrayList<Button> btList = new ArrayList<>();
    private TextView te;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        te = (TextView) findViewById(R.id.text);
        final ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        LinearLayout item_ll = (LinearLayout) findViewById(R.id.item_ll);

        // 循环添加button
        for (int i = 0; i < item_ll.getChildCount(); i++) {
            Button bt = (Button) item_ll.getChildAt(i);
            final int num = i;
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    viewpager.setCurrentItem(num);
                }
            });
            btList.add(bt);
        }
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;

                switch (position) {
                    case 0:
                        fragment = new Fragment0();
                        break;
                    case 1:
                        fragment = new Fragment1();
                        break;
                    case 2:
                        fragment = new Fragment2().getFra("Bundle  方法");
                        break;
                    case 3:
                        fragment = new Fragment3();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return btList.size();
            }
        });
        // 点击变颜色
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                for (int i = 0; i < btList.size(); i++) {
                    if (i == arg0) {
                        btList.get(i).setTextColor(Color.RED);
                    } else {
                        btList.get(i).setTextColor(Color.BLACK);
                    }
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    @Override
    public void canshu(String name) {
        te.setText(name);
    }
}
