package com.bwie.fragmentargments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * 作用  :Fragment2
 * 作者 :张桐源
 * 日期 ： 2016/11/29
 */
public class Fragment2 extends Fragment {

    private TextView te;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2, container, false);
        te = (TextView) view.findViewById(R.id.text1);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       //获得传过来的值
        Bundle bu = getArguments();
        String name = bu.getString("name");
        te.setText(name);
    }

    //使用bundle传值到Activity
    public Fragment getFra(String name) {
        Bundle b = new Bundle();
        Fragment2 f = new Fragment2();
        b.putString("name", name);
        f.setArguments(b);
        return f;
    }
}
