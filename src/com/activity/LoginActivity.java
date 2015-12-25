package com.activity;

import com.Base.MyApplication;
import com.dialog.Dialog_register;
import com.dialog.Dialog_setip;
import com.example.jiaotong.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText name,pass;
	private Button confirm;
	private CheckBox rempass;
	private TextView register,setip;
	
	private ProgressDialog dialog;
	private boolean isCheck = true;
	private String name1;
	private String pass1;
	private MyApplication mAp;
	
	public LoginActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		name =(EditText) findViewById(R.id.login_name);
		pass = (EditText) findViewById(R.id.login_pass);
		confirm = (Button) findViewById(R.id.login_confirm);
		rempass = (CheckBox) findViewById(R.id.login_remberpass);
		register = (TextView) findViewById(R.id.login_register);
		setip = (TextView) findViewById(R.id.login_setip);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new Dialog_register(LoginActivity.this).show();
			}
		});
		setip.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new Dialog_setip(LoginActivity.this).show();
			}
		});
		rempass.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(!arg1) {
					isCheck = false;
				} else {
					isCheck = true;
				}
			}
		});
		
		confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				login();
			}
		});
	}

	/**
	 * 确定登录按钮
	 */
	private void login() {
		// TODO Auto-generated method stub
		name1 = name.getText().toString().trim();
		pass1 = pass.getText().toString().trim();
		if(TextUtils.isEmpty(name1)) {
			Toast.makeText(getApplicationContext(), "请输入正确的用户名！", Toast.LENGTH_SHORT).show();
			return;
		}
		if(TextUtils.isEmpty(pass1)) {
			Toast.makeText(getApplicationContext(), "请输入正确的密码！", Toast.LENGTH_SHORT).show();
			return;
		}
		
		/**
		 * 开始登录
		 */
//		dialog = new ProgressDialog(LoginActivity.this);
//		dialog.setMessage("正在登录。。。");
//		dialog.show();
		startActivity(new Intent(LoginActivity.this, MainActivity.class));
	}
	
	
	protected void update(Object ob) {
		if(ob instanceof Boolean) {
			if((Boolean) ob) {
				
				//登录成功，保存用户名, 密码
				mAp.setUsername(name1);
				if(isCheck) {
					MyApplication.share.setPass(pass1);
				} else {
					MyApplication.share.setPass("");
				}
				
				dialog.cancel();
				Toast.makeText(mAp, "登录成功！", Toast.LENGTH_SHORT);
				
				finish();
			} else {
				Toast.makeText(mAp, "登录失败！",Toast.LENGTH_SHORT).show();
				dialog.cancel();
			}
		}
		
	}
	
}
