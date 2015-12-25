package com.dialog;

import com.Base.MyApplication;
import com.HttpThread.MyHttpThread;
import com.example.jiaotong.R;
import com.hint.PlayMusic;
import com.util.Action;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;;

public class Dialog_common extends Dialog implements OnClickListener {

	private TextView titlename;
	private EditText value;
	private Button confirm,cancel;
	private int id;
	private String reqJsonStr;
	private String reqSrc;
	private int itemposition;
	private Context context;
	
	public Dialog_common(Context context, int id) {
		super(context, id);
		this.id = id;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_common);
		setCanceledOnTouchOutside(false);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		titlename = (TextView) findViewById(R.id.dialog_common_tv);
		value = (EditText) findViewById(R.id.dialog_common_et);
		confirm = (Button) findViewById(R.id.dialog_comfirm);
		cancel = (Button) findViewById(R.id.dialog_cancel);
		confirm.setOnClickListener(this);
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cancel();
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
//		id = v.getId();
		
		switch (id) {
		case R.id.isselectcarspeed:
			titlename.setText("查询小车速度");
			String speed = value.getText().toString().trim();
			if(TextUtils.isEmpty(speed)) {
				Toast.makeText(getContext(), "请输入小车编号!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			/*
			 * 开始请求
			 */
			reqJsonStr = "{\"CarId\":"+Integer.parseInt(speed)+"}";
			reqSrc = MyApplication.getInstance().share.getBaseUrl()+Action.gets[0];
			itemposition = 0;
			
			break;
		case R.id.isselectcarlocation:
			titlename.setText("查询小车位置");
			String location = value.getText().toString().trim();
			if(TextUtils.isEmpty(location)) {
				Toast.makeText(getContext(), "请输入小车编号!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			reqJsonStr = "{\"CarId\":"+Integer.parseInt(location)+"}";
			reqSrc = MyApplication.getInstance().share.getBaseUrl()+Action.gets[1];
			itemposition = 1;
			
			break;
		case R.id.isselectcarbalance:
			titlename.setText("查询小车账户余额");
			String money = value.getText().toString().trim();
			if(TextUtils.isEmpty(money)) {
				Toast.makeText(getContext(), "请输入小车编号!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			reqJsonStr = "{\"CarId\":"+Integer.parseInt(money)+"}";
			reqSrc = MyApplication.getInstance().share.getBaseUrl()+Action.gets[2];
			itemposition = 2;
			
			break;
		case R.id.isselectcarrecord:
			titlename.setText("查询账户记录");
			String record = value.getText().toString().trim();
			if(TextUtils.isEmpty(record)) {
				Toast.makeText(getContext(), "请输入小车编号!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			reqJsonStr = "{\"CarId\":"+Integer.parseInt(record)+",\"CostTypr\":}";
			reqSrc = MyApplication.getInstance().share.getBaseUrl()+Action.gets[5];
			itemposition = 5;
			
			break;
		case R.id.isselecttrafficconfig:
			titlename.setText("查询红绿灯配置信息");
			String config = value.getText().toString().trim();
			if(TextUtils.isEmpty(config)) {
				Toast.makeText(getContext(), "请输入红绿灯编号!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			reqJsonStr = "{\"TrafficLightId\":"+Integer.parseInt(config)+"}";
			reqSrc = MyApplication.getInstance().share.getBaseUrl()+Action.gets[6];
			itemposition = 6;
			
			break;
		case R.id.isselectbusstation:
			titlename.setText("查询站台信息");
			String station = value.getText().toString().trim();
			if(TextUtils.isEmpty(station)) {
				Toast.makeText(getContext(), "请输入站台编号!", Toast.LENGTH_SHORT).show();
				return;
			}
			
			reqJsonStr = "{\"BusStationId\":"+Integer.parseInt(station)+"}";
			reqSrc = MyApplication.getInstance().share.getBaseUrl()+Action.gets[12];
			itemposition = 12;
			
			break;
		}
		System.out.println("请求的JSON数据:"+reqJsonStr);
		System.out.println("请求的URL:"+reqSrc);
		new MyHttpThread(MyApplication.getInstance().getmHandler(),reqSrc,itemposition,reqJsonStr,MyApplication.getInstance().getContext()).start();
	}

	
	
}
