package com.fnfh;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.fnfh.fragment.GuanYuFragment;
import com.fnfh.fragment.LiShiFragment;
import com.fnfh.fragment.MeiziFragment;
import com.fnfh.fragment.ShouCangFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.mToolBar)
    Toolbar mToolBar;
    @BindView(R.id.mFragment)
    FrameLayout mFragment;
    @BindView(R.id.hideLayout)
    LinearLayout hideLayout;
    //NavigationView导航栏
    @BindView(R.id.nav)
    NavigationView mNavigationView;
    @BindView(R.id.drawer)
    DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //设置标题
        mToolBar.setTitle("历史的今天");
        mNavigationView.setCheckedItem(R.id.item1);
        mNavigationView.getMenu().getItem(0).setChecked(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.mFragment, new LiShiFragment()).commit();
       //Fragment
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mToolBar.setTitle(item + "");
                switch (item.getItemId()) {
                    case R.id.item1:
                        mNavigationView.setCheckedItem(R.id.item1);
                        getSupportFragmentManager().beginTransaction().replace(R.id.mFragment, new LiShiFragment()).commit();
                        break;
                    case R.id.item2:
                        mNavigationView.setCheckedItem(R.id.item2);
                        getSupportFragmentManager().beginTransaction().replace(R.id.mFragment, new MeiziFragment()).commit();

                        break;
                    case R.id.item3:
                        mNavigationView.setCheckedItem(R.id.item3);
                        getSupportFragmentManager().beginTransaction().replace(R.id.mFragment, new ShouCangFragment()).commit();

                        break;
                    case R.id.item4:
                        mNavigationView.setCheckedItem(R.id.item4);
                        getSupportFragmentManager().beginTransaction().replace(R.id.mFragment, new GuanYuFragment()).commit();

                        break;
                }
                //menuItem.setChecked(true);//点击了把它设为选中状态
                mDrawer.closeDrawers();//关闭抽屉
                return true;
            }
        });

        //设置NavigationView菜单条目的点击监听


        mToolBar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setSupportActionBar(mToolBar);

        //设置左上角的图标响应
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolBar, 0, 0) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawer.setDrawerListener(mDrawerToggle); //设置侧滑监听
    }

}
