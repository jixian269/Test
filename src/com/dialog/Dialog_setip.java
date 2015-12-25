package com.dialog;

import com.Base.MyApplication;
import com.example.jiaotong.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dialog_setip extends Dialog {

	private EditText etip1,etip2,etip3,etip4,etport;
	private Button confirm,cancel;
	
	public Dialog_setip(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_setip);
		setCanceledOnTouchOutside(false);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
//		String[] ips = MyApplication.share.getIp().split("\\.");//split表示用.隔开	
		etip1 = (EditText) findViewById(R.id.setip1);
//		etip1.setText(ips[0]);
		etip2 = (EditText) findViewById(R.id.setip2);
//		etip2.setText(ips[1]);
		etip3 = (EditText) findViewById(R.id.setip3);
//		etip3.setText(ips[2]);
		etip4 = (EditText) findViewById(R.id.setip4);
//		etip4.setText(ips[3]);
		etport = (EditText) findViewById(R.id.setport);
		confirm = (Button) findViewById(R.id.setip_confirm);
		cancel = (Button) findViewById(R.id.setip_cancel);
		
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
				confirm();
			}
		});
	}
	
	/**
	 * 
	 * 确定按钮
	 */
	private void confirm() {
		// TODO Auto-generated method stub
		String ip1 = etip1.getText().toString().trim();
		String ip2 = etip2.getText().toString().trim();
		String ip3 = etip3.getText().toString().trim();
		String ip4 = etip4.getText().toString().trim();
		String port = etport.getText().toString().trim();
		
		if(TextUtils.isEmpty(ip1) || TextUtils.isEmpty(ip2) || TextUtils.isEmpty(ip3) || TextUtils.isEmpty(ip4)) {
			Toast.makeText(getContext(), "请输入完整IP地址！", Toast.LENGTH_SHORT).show();
			return;
		}
		if(TextUtils.isEmpty(port)) {
			Toast.makeText(getContext(), "请输入端口号！", Toast.LENGTH_SHORT).show();
			return;
		}
		String ip = ip1 + "." + ip2 + "." + ip3 + "." + ip4;
		String BaseUrl = "http://"+ip+":"+port+"/transportservice/type/jason/action/";
		MyApplication.share.setBaseUrl(BaseUrl);
		Toast.makeText(getContext(), "设置成功！当前IP地址为：" + ip + ":" + port, Toast.LENGTH_SHORT).show();
		cancel();
	}
}
