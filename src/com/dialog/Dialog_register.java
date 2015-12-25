package com.dialog;

import com.activity.LoginActivity;
import com.activity.MainActivity;
import com.example.jiaotong.R;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dialog_register extends Dialog {

	private EditText name,pass;
	private Button confirm,cancel;
	private ProgressDialog registerdialog;
	
	public Dialog_register(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_register);
		setCanceledOnTouchOutside(false);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		name = (EditText) findViewById(R.id.register_name);
		pass = (EditText) findViewById(R.id.register_pass);
		confirm = (Button) findViewById(R.id.register_confirm);
		cancel = (Button) findViewById(R.id.register_cancel);
		
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cancel();
			}
		});
		confirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name1 =name.getText().toString().trim();
				String pass1 = pass.getText().toString().trim();
				
				if(TextUtils.isEmpty(name1)) {
					Toast.makeText(getContext(), "请输入用户名！" , Toast.LENGTH_SHORT).show();
					return;
				}
				if(TextUtils.isEmpty(pass1)) {
					Toast.makeText(getContext(), "请输入密码！", Toast.LENGTH_SHORT).show();
					return;
				}
				
				registerdialog = new ProgressDialog(getContext());
				registerdialog.setMessage("正在注册。。。");
				registerdialog.show();
				
			}
		});
	}

	

}
