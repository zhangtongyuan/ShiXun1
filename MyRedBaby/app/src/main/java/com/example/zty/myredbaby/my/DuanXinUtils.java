package com.example.zty.myredbaby.my;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作用
 * 作者
 * 日期： 2016/12/7
 */
public class DuanXinUtils {
    private static SharedPreferences sp;

    //存
    public static void saveTime(Context context, String name, Long l) {
        if (sp == null) {
            context.getSharedPreferences("appinfo.xml", Context.MODE_PRIVATE);
        }
        sp.edit().putLong(name, l).commit();
    }

    //取
    public static long getsaveTime(Context context, String name) {
        if (sp == null) {
            sp = context.getSharedPreferences("appinfo.xml", Context.MODE_PRIVATE);
        }
        return sp.getLong(name, 0);
    }
}
