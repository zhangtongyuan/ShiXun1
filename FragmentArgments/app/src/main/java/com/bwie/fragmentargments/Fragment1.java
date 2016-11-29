package com.bwie.fragmentargments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * 作用  :Fragment1
 * 作者 :张桐源
 * 日期 ： 2016/11/29
 */
public class Fragment1 extends Fragment {

    private TextView te;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f1, container, false);
        te = (TextView) view.findViewById(R.id.te);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("xxxxxxxxxxxx", "Fragment1        *****onAttach()方法******");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("xxxxxxxxxxxx", "Fragment1        *****onCreate()方法******");
        Lei lei = Fragment0.getstr();
        String name = lei.getName();
        te.setText(name);

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("xxxxxxxxxxxx", "Fragment1        *****onStart()方法******");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("xxxxxxxxxxxx", "Fragment1        *****onResume()方法******");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("xxxxxxxxxxxx", "Fragment1       *****onPause()方法******");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("xxxxxxxxxxxx", "Fragment1        *****onStop()方法******");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("xxxxxxxxxxxx", "Fragment1       *****onDestroyView()方法******");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("xxxxxxxxxxxx", "Fragment1        *****onDetach()方法******");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("xxxxxxxxxxxx", "Fragment1       *****onDestroy()方法******");
    }

}
