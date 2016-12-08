package com.example.zty.myredbaby.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zty.myredbaby.R;

import java.util.ArrayList;

/**
 * Created by zty on 2016/11/16.
 */
public class DetailsFragment extends Fragment implements View.OnClickListener {

    private TextView baozhuang;
    private TextView guige;
    private TextView tuwen;
    private FragmentManager supportFragmentManager;
    private TuWenFragment tuwwenfragment;
    private GuiGeFragment guigefragment;
    private BaoZhuangFragment baozhuangfragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f1, container, false);
        tuwen = (TextView) view.findViewById(R.id.f1_tuwen);
        guige = (TextView) view.findViewById(R.id.f1_guige);
        baozhuang = (TextView) view.findViewById(R.id.f1_baozhuang);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<TextView> list = new ArrayList<TextView>();
        list.add(tuwen);
        list.add(guige);
        list.add(baozhuang);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setOnClickListener(DetailsFragment.this);
        }
        tuwen.setTextColor(Color.RED);
        guige.setTextColor(Color.BLACK);
        baozhuang.setTextColor(Color.BLACK);
        supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager
                .beginTransaction();
        tuwwenfragment = new TuWenFragment();
        guigefragment = new GuiGeFragment();
        baozhuangfragment = new BaoZhuangFragment();

        beginTransaction.add(R.id.f1_fragment, tuwwenfragment, "fragment01");
        beginTransaction.add(R.id.f1_fragment, guigefragment, "fragment02");
        beginTransaction.add(R.id.f1_fragment, baozhuangfragment, "fragment03");
        beginTransaction.show(tuwwenfragment);
        beginTransaction.hide(guigefragment);
        beginTransaction.hide(baozhuangfragment);
        beginTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.f1_tuwen:
                tuwen.setTextColor(Color.RED);
                guige.setTextColor(Color.BLACK);
                baozhuang.setTextColor(Color.BLACK);
                beginTransaction.show(tuwwenfragment);
                beginTransaction.hide(guigefragment);
                beginTransaction.hide(baozhuangfragment);
                break;
            case R.id.f1_guige:
                guige.setTextColor(Color.RED);
                tuwen.setTextColor(Color.BLACK);
                baozhuang.setTextColor(Color.BLACK);
                beginTransaction.show(guigefragment);
                beginTransaction.hide(tuwwenfragment);
                beginTransaction.hide(baozhuangfragment);
                break;
            case R.id.f1_baozhuang:
                baozhuang.setTextColor(Color.RED);
                tuwen.setTextColor(Color.BLACK);
                guige.setTextColor(Color.BLACK);
                beginTransaction.show(baozhuangfragment);
                beginTransaction.hide(tuwwenfragment);
                beginTransaction.hide(guigefragment);
                break;
            default:

                break;

        }
        beginTransaction.commit();
    }

}
