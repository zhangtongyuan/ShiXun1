package com.bwie.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.btn_add_frag1);
        Button btn2 = (Button) findViewById(R.id.btn_add_frag2);
        Button btn_remove = (Button) findViewById(R.id.btn_remove_frag2);
        Button btn_repalce = (Button) findViewById(R.id.btn_repalce_frag1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment0 fragment0 = new Fragment0();
                addFragment(fragment0, "fragment0");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment1 fragment1 = new Fragment1();
                addFragment(fragment1, "fragment1");
            }
        });



        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            removeFragment2();
            }
        });
        btn_repalce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            replaceFragment0();
            }
        });

    }

    private void addFragment(Fragment fragment, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment, tag);
        transaction.commit();
    }

    //移除fragment2
    private void removeFragment2() {
        FragmentManager manager = getSupportFragmentManager();
        //找你所要删除的fragment.xml
        Fragment fragment1 = manager.findFragmentByTag("fragment1");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment1);
        transaction.commit();
    }

    //替换
    private void replaceFragment0() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment0 fragment0 = new Fragment0();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment0);
        transaction.commit();
    }
}
