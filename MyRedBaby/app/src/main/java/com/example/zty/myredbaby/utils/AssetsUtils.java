package com.example.zty.myredbaby.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zty on 2016/11/17.
 */
public class AssetsUtils {
    public static String getFromAssets(Context context, String fileName){
        try {
            InputStreamReader inputReader =
                    new InputStreamReader(
                            context.getResources().getAssets().open(fileName) );
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line="";
            StringBuilder result=new StringBuilder();
            while((line = bufReader.readLine()) != null)
                result.append(line) ;
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
