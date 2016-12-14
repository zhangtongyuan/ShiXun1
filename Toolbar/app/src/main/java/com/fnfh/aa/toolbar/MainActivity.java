package com.fnfh.aa.toolbar;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("历史上的今天");//设置标题
        // toolbar.setLogo(R.mipmap.base_common_default_icon_big);//设置logo
        setSupportActionBar(toolbar);//设置toolbar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(MainActivity.this,"aaaaaaaaaaaaaaa",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDrawerClosed(View  drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(MainActivity.this,"shibai",Toast.LENGTH_SHORT).show();

            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);//设置监听器


    }

    /**
     * 设置按钮
     */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //膨胀菜单;这将条目添加到操作栏是否存在。
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //处理操作栏项点击这里。操作栏将
        //自动处理单击Home /按钮,这么长时间
        //当你指定一个AndroidManifest.xml家长活动。
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //点击的是个人中心
        if (id == R.id.action_zone) {
            // return toggleDrawerLayout();
        }

        return super.onOptionsItemSelected(item);
    }

 /* protected boolean toggleDrawerLayout(){
        //如果左边的已打开，则关闭左边的，不进行后续操作
        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawer(Gravity.START);
            return true;
        }
        //如果左边的没打开，右边的打开了关闭，关闭了打开
        if (mDrawerLayout.isDrawerOpen(Gravity.END)) {
            mDrawerLayout.closeDrawer(Gravity.END);
        } else {
            mDrawerLayout.openDrawer(Gravity.END);
        }
        return true;
    }*/
}
