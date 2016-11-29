package com.bwie.fragmentargments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
/**
 * 作用  :Fragment0
 * 作者 :张桐源
 * 日期 ： 2016/11/29
 */
public class Fragment0 extends Fragment {


    private Button fragment;
    JieKou jiekou;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("xxxxxxxxxxxx", "Fragment0        *****onActivityCreated()方法******");

        View view = inflater.inflate(R.layout.f0, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("xxxxxxxxxxxx", "Fragment0        *****onAttach()方法******");
            jiekou= (JieKou) getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        jiekou.canshu("借口回调");

        Log.i("xxxxxxxxxxxx", "Fragment0        *****onCreate()方法******");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("xxxxxxxxxxxx", "Fragment0        *****onStart()方法******");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("xxxxxxxxxxxx", "Fragment0        *****onResume()方法******");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("xxxxxxxxxxxx", "Fragment0        *****onPause()方法******");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("xxxxxxxxxxxx", "Fragment0        *****onStop()方法******");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("xxxxxxxxxxxx", "Fragment0        *****onDestroyView()方法******");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("xxxxxxxxxxxx", "Fragment0        *****onDetach()方法******");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("xxxxxxxxxxxx", "Fragment0        *****onDestroy()方法******");
    }

    public static Lei getstr() {
        Lei l = new Lei();
        l.setName("啦啦啦啦拉拉setget方法！");
        return l;
    }
    public interface JieKou{
        public void canshu(String name);
    }
}
