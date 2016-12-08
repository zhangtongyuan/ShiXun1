package com.example.zty.myredbaby.bean;

import java.util.ArrayList;

/**
 * Created by zty on 2016/11/9.
 */

public class Bean {
    public ArrayList<Data> data;

    public class Data {
        public ArrayList<Tag> tag;
    }

 public class Tag {


        public  String linkUrl;
        public  String elementName;
        public  String picUrl;
    }
}
