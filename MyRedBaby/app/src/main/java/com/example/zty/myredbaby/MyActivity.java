package com.example.zty.myredbaby;

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
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zty.myredbaby.imagerloader.ImageLoaderUtils;
import com.example.zty.myredbaby.my.ZhuCeActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.Set;

public class MyActivity extends AppCompatActivity implements View.OnClickListener {

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
	private ImageView back;
	private ImageView my_fenxiang;
	private ImageView my_img_weixin;
	private ImageView my_img_qq;
	private TextView my_tv_qq;
	private DisplayImageOptions options;
	private ImageView my_img_xinlang;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		//将options转成成员变量
		options = ImageLoaderUtils.initOptions();

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
				Intent intent = new Intent(MyActivity.this, ZhuCeActivity.class);
				startActivity(intent);
			}
		});
		//判断登录按钮的颜色
		denglu();
		qq();
	}

	private void qq() {
		my_qq.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				youMengQQ();
			}


		});

		my_fenxiang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				youmengFenxiang();
			}
		});
		my_img_weixin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//微信
				weixin();
			}
		});
		my_img_xinlang.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新浪微博
				xinlang();
			}
		});
	}
	//新浪微博

	private void xinlang() {

		UMShareAPI mShareAPI = UMShareAPI.get(MyActivity.this);
		mShareAPI.doOauthVerify(MyActivity.this, SHARE_MEDIA.SINA, umAuthListener);

	}


	//微信
	private void weixin() {

		UMShareAPI mShareAPI = UMShareAPI.get(MyActivity.this);
		mShareAPI.doOauthVerify(MyActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
	}


	//第三方分享
	private void youmengFenxiang() {
		new ShareAction(MyActivity.this).setPlatform(SHARE_MEDIA.QQ)
				.withText("hello")
				.withTitle("分享")
				.setCallback(umShareListener)
				.share();

	}

	//第三方分享
	private UMShareListener umShareListener = new UMShareListener() {
		@Override
		public void onResult(SHARE_MEDIA platform) {
			Log.d("plat", "platform" + platform);

			Toast.makeText(MyActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onError(SHARE_MEDIA platform, Throwable t) {
			Toast.makeText(MyActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
			if (t != null) {
				Log.d("throw", "throw:" + t.getMessage());
			}
		}

		@Override
		public void onCancel(SHARE_MEDIA platform) {
			Toast.makeText(MyActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
		}
	};

	//第三方登录
	private void youMengQQ() {
		UMShareAPI mShareAPI = UMShareAPI.get(MyActivity.this);
		//  mShareAPI.doOauthVerify(UmDengluActivity.this, SHARE_MEDIA.QQ, umAuthListener);
		mShareAPI.getPlatformInfo(MyActivity.this, SHARE_MEDIA.QQ, umAuthListener);

	}

	//第三方登录
	private UMAuthListener umAuthListener = new UMAuthListener() {
		@Override
		public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

			Set<String> set = data.keySet();
			for (String string : set) {
				Log.i("msg",
						"============================Map=========================");
				Log.i("msg", string + "::::" + data.get(string));
				String str = data.get(string);
				// 设置头像
				if (string.equals("profile_image_url")) {
					ImageLoader.getInstance().displayImage(str,
							my_img_qq, options);

				}
				// 设置昵称
				if (string.equals("screen_name")) {
					my_tv_qq.setText(str);
				}

			}
		}

		@Override
		public void onError(SHARE_MEDIA platform, int action, Throwable t) {
			Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onCancel(SHARE_MEDIA platform, int action) {
			Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
		}
	};

	//第三方需要的回回调
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

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
					Toast.makeText(MyActivity.this, "手机号不合法", Toast.LENGTH_SHORT).show();
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
					//设置按钮不能点击
					my_tv_dl.setClickable(false);
				} else {
					my_img_detele.setVisibility(View.VISIBLE);
					String phonenumber = my_ed_phonenumber.getText().toString();
					int length = phonenumber.length();
					//如果有内容设置按钮可以单击获得点击事件
					if (length > 0) {
						//设置按钮的颜色为黄色
						my_tv_dl.setBackgroundColor(Color.rgb(251, 203, 61));
						//设置按钮能点击
						my_tv_dl.setClickable(true);

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
		back = (ImageView) findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
		my_img_chear.setOnClickListener(this);
		my_img_detele.setOnClickListener(this);
		my_qq = (ImageView) findViewById(R.id.my_qq);
		my_img_weixin = (ImageView) findViewById(R.id.my_img_weixin);
		my_fenxiang = (ImageView) findViewById(R.id.my_fenxiang);
		my_img_qq = (ImageView) findViewById(R.id.my_img_qq);
		my_tv_qq = (TextView) findViewById(R.id.my_tv_qq);
		my_img_xinlang = (ImageView) findViewById(R.id.my_img_xinlang);
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

