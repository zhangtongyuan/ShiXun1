package com.bwie.um;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 作用: 登录界面
 * 作者: 张桐源
 * 日期: 2016/12/5
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText my_ed_password;
    private EditText my_ed_phonenumber;
    private TextView my_tv_dl;
    private TextView my_tv_wangjimima;
    private ImageView my_img_show;
    private ImageView my_img_zhuce;

    private boolean isHidden = true;
    private ImageView my_img_chear;
    private ImageView my_img_detele;
    private ImageView my_qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        findView();
        //判断输入的是否是手机号码如果是就往下执行不是就吐司
        panDuan();
        //password显示与隐藏的切换
        showHide();
        //跳转注册界面
        my_img_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ZhuCeActivity.class);
                startActivity(intent);
            }
        });
        //判断登录按钮的颜色
        denglu();
    }
    

    //判断手机号
    private void panDuan() {
        my_tv_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = my_ed_phonenumber.getText().toString();
                boolean judge = isMobile(number);
                if (judge == true) {


                } else {
                    Toast.makeText(MainActivity.this, "手机号不合法", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //设置密码显示隐藏的切换
    private void showHide() {

        my_img_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHidden) {
                    //设置EditText文本为可见的
                    my_img_show.setImageResource(R.drawable.cart_switch_on);
                    my_ed_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //设置EditText文本为隐藏的
                    my_img_show.setImageResource(R.drawable.cart_switch_unenabled);

                    my_ed_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                isHidden = !isHidden;
                my_ed_password.postInvalidate();
                //切换后将EditText光标置于末尾
                CharSequence charSequence = my_ed_password.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }

            }
        });

    }

    //登录按钮的颜色改变
    private void denglu() {

        my_ed_phonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    my_tv_dl.setBackgroundColor(Color.rgb(202, 202, 197));
                    my_img_chear.setVisibility(View.GONE);
                } else {
                    my_img_chear.setVisibility(View.VISIBLE);
                    String password = my_ed_password.getText().toString();
                    int length = password.length();
                    if (length > 0) {
                        my_tv_dl.setBackgroundColor(Color.rgb(251, 203, 61));
                    }
                }
            }
        });
        my_ed_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.length() == 0) {
                    my_img_detele.setVisibility(View.GONE);
                    my_tv_dl.setBackgroundColor(Color.rgb(202, 202, 197));

                } else {
                    my_img_detele.setVisibility(View.VISIBLE);
                    String phonenumber = my_ed_phonenumber.getText().toString();
                    int length = phonenumber.length();
                    if (length > 0) {
                        my_tv_dl.setBackgroundColor(Color.rgb(251, 203, 61));
                    }
                }
            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_img_chear:
                my_ed_phonenumber.setText("");
                break;
            case R.id.my_img_detele:
                my_ed_password.setText("");
                break;
        }
    }

    private void findView() {
        //初始化控件
        my_ed_phonenumber = (EditText) findViewById(R.id.my_ed_phonenumber);
        my_ed_password = (EditText) findViewById(R.id.my_ed_password);
        my_tv_dl = (TextView) findViewById(R.id.my_tv_dl);
        my_tv_wangjimima = (TextView) findViewById(R.id.my_tv_wangjimima);
        my_img_show = (ImageView) findViewById(R.id.my_img_show);
        my_img_zhuce = (ImageView) findViewById(R.id.my_img_zhuce);
        my_img_chear = (ImageView) findViewById(R.id.my_img_chear);
        my_img_detele = (ImageView) findViewById(R.id.my_img_detele);
        my_img_chear.setOnClickListener(this);
        my_img_detele.setOnClickListener(this);
        my_qq = (ImageView) findViewById(R.id.my_qq);
        my_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DiSanFangActivity.class);
                startActivity(intent);
            }
        });
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
