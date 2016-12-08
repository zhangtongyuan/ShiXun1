package com.example.zty.myredbaby.my;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.example.zty.myredbaby.R;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class NextActivity extends AppCompatActivity {

    private EditText mima_ed_shuru;
    private Button mima_bt_tijiao;
    private Button mima_bt_huoqu;
    private String messageNum;
    private boolean flag = true;
    private long time;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        mima_ed_shuru = (EditText) findViewById(R.id.mima_ed_shuru);
        mima_bt_tijiao = (Button) findViewById(R.id.mima_bt_tijiao);
        mima_bt_huoqu = (Button) findViewById(R.id.mima_bt_huoqu);
        //接收注册界面传来的手机号码
        TextView mima_tv_phone = (TextView) findViewById(R.id.mima_tv_phone);
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        mima_tv_phone.setText("短信已发送至 :  " + phone);
        //返回图片按钮
        ImageView mima_back = (ImageView) findViewById(R.id.mima_back);
        mima_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        long saveTime = DuanXinUtils.getsaveTime(NextActivity.this, "time");
        long currentTimeMillis = System.currentTimeMillis();
        time = 3000 - (currentTimeMillis - saveTime);
        if (time > 0) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    flag = false;
                    //获取短信验证
                    getMessageNum();
                    //获取当前的时间
                    long currentTimeMillis = System.currentTimeMillis();
                    //存入  获取的时间
                    DuanXinUtils.saveTime(NextActivity.this, "time", currentTimeMillis);

                    for (; time > 0; time = time - 1000) {
                        // final int i1 = time;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mima_bt_huoqu.setText(time / 1000 + "秒后重新获取");
                                mima_bt_huoqu.setTextColor(Color.parseColor("#d0d0d0"));
                            }
                        });
                        SystemClock.sleep(1000);
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mima_bt_huoqu.setText("重新获取");
                            mima_bt_huoqu.setTextColor(Color.parseColor("#FFFF00"));

                        }
                    });

                    flag = true;
                }
            }.start();
        }
        //点击事件
        onclick();

    }

    private void onclick() {
        //获取验证码界面
        mima_bt_huoqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            flag = false;
                            //获取短信验证
                            getMessageNum();
                            //获取当前的时间
                            long currentTimeMillis = System.currentTimeMillis();
                            //存入  获取的时间
                            DuanXinUtils.saveTime(NextActivity.this, "time", currentTimeMillis);

                            for (int i = 30; i > 0; i--) {
                                final int i1 = i;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mima_bt_huoqu.setText(i1 + "秒后重新获取");
                                        mima_bt_huoqu.setTextColor(Color.parseColor("#d0d0d0"));
                                    }
                                });
                                SystemClock.sleep(1000);
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mima_bt_huoqu.setText("重新获取");
                                }
                            });

                            flag = true;
                        }
                    }.start();
                }

            }
        });
        //提交按钮
        mima_bt_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String huoqu = mima_ed_shuru.getText().toString().trim();
                if (huoqu.equals(messageNum)) {
                    Toast.makeText(NextActivity.this, "正确", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NextActivity.this, "错误", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void getMessageNum() {
        HashMap<String, Object> result = null;

        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

        //******************************注释*********************************************
        //*初始化服务器地址和端口                                                       *
        //*沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
        //*生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883");       *
        //*******************************************************************************
        restAPI.init("app.cloopen.com", "8883");

        //******************************注释*********************************************
        //*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN     *
        //*ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
        //*参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。                   *
        //*******************************************************************************
        restAPI.setAccount("8a216da858ce0b3c0158d7fc61bd0719", "fc934cf352cf43aeb659f5bdd2d2339f");


        //******************************注释*********************************************
        //*初始化应用ID                                                                 *
        //*测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID     *
        //*应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID*
        //*******************************************************************************
        restAPI.setAppId("8a216da858ce0b3c0158d841602a0795");


        //******************************注释****************************************************************
        //*调用发送模板短信的接口发送短信                                                                  *
        //*参数顺序说明：                                                                                  *
        //*第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号                          *
        //*第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。    *
        //*系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
        //*第三个参数是要替换的内容数组。																														       *
        //**************************************************************************************************

        //**************************************举例说明***********************************************************************
        //*假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为           *
        //*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});																		  *
        //*则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于5分钟内正确输入     *
        //*********************************************************************************************************************

        messageNum = (new Random().nextInt(8999) + 1000) + "";

        result = restAPI.sendTemplateSMS(phone, "1", new String[]{messageNum, "3"});

        System.out.println("SDKTestGetSubAccounts result=" + result);
        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
    }


}
