package com.bwie.um;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 作用: 注册界面
 * 作者: 张桐源
 * 日期: 2016/12/5
 */
public class ZhuCeActivity extends AppCompatActivity {

    private TextView zhuce_tv_tongyi;
    private TextView zhuce_tv_next;
    private CheckBox zhuce_cb;
    private EditText zhuce_ed_phone;
    //private boolean falg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        //初始化控件
        initView();
        //设置协议
        setTvtongyi();
        //设置checkboxj监听事件
        // checkBox();
        //判断输入的是否是手机号码如果是就往下执行不是就吐司
        panDuan();

    }

    //判断手机号和登陆下一步按钮
    private void panDuan() {
        zhuce_tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = zhuce_ed_phone.getText().toString();
                boolean judge = isMobile(phone);
                if (judge == true) {
                    boolean checked = zhuce_cb.isChecked();

                    if (checked) {
                        Intent intent = new Intent(ZhuCeActivity.this, NextActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ZhuCeActivity.this, "您必须同意服务条款才可以注册", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(ZhuCeActivity.this, "手机号不合法", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //设置协议
    private void setTvtongyi() {
        //SpannableString文本类，包含不可变的文本但可以用已有对象替换和分离。
        //可变文本类参考SpannableStringBuilder
        SpannableString ss = new SpannableString("同意苏宁易购会员章程和易付宝协议");
        ss.setSpan(new ForegroundColorSpan(Color.RED), 2, 10,
                //setSpan时需要指定的 flag,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括).
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用超链接标记文本
        ss.setSpan(new URLSpan("http://res.m.suning.com/project/newuser_redpacket/member_agreement.html"), 2, 10,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new ForegroundColorSpan(Color.RED), 11, 16,
                //setSpan时需要指定的 flag,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括).
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //用超链接标记文本
        ss.setSpan(new URLSpan("https://pay.suning.com/epp-paycore/pay/static/quickPayRelatedServiceContract.htm"), 11, 16,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //让URLSpan可以点击
        zhuce_tv_tongyi.setMovementMethod(new LinkMovementMethod());
        zhuce_tv_tongyi.setText(ss);
    }

    //初始化控件
    private void initView() {
        zhuce_tv_tongyi = (TextView) findViewById(R.id.zhuce_tv_tongyi);
        zhuce_cb = (CheckBox) findViewById(R.id.zhuce_cb);
        zhuce_tv_next = (TextView) findViewById(R.id.zhuce_tv_next);
        zhuce_ed_phone = (EditText) findViewById(R.id.zhuce_ed_phone);
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobile(String number) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String num = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }
}
