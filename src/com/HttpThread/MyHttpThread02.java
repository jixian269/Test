package com.HttpThread;

import com.activity.SensorActivity;
import com.request.MyHttpRequest02;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

public class MyHttpThread02 extends Thread {

	private Handler mHandler;
	private String src;
	private String strJson;
	private int itemposition;
	private Activity context;
	
	public MyHttpThread02(Handler mHandler,String src,String strJson,int itemposition,Activity context) {
		this.mHandler = mHandler;
		this.src  = src;
		this.strJson = strJson;
		this.itemposition = itemposition;
		this.context = context;
	}
	
	@Override
	public void run() {
		System.out.println("开始线程："+currentThread()+"请求地址："+src);
		if(itemposition==10){
			Intent SensorIntent = new Intent(context,SensorActivity.class);
			SensorIntent.putExtra("src",src);
			SensorIntent.putExtra("strJson",strJson);
			context.startActivity(SensorIntent);
		}else{
			MyHttpRequest02 request = new MyHttpRequest02(mHandler, src, strJson);
			int status = request.getHttRequest();
			String webContent = null;
			if(status==1){
				webContent = request.getWebContent();
				webContent = "{"+strJson+","+webContent+"}";
			}else if(status==901){
				webContent = "Timeout!";
			}else{
				webContent = "IP地址不正确";
			}
			System.out.println("连接状态："+status);
			System.out.println("handler返回的数据："+webContent);
			Message msg = new Message().obtain();
			msg.what = status;
			msg.arg1 = itemposition;
			msg.obj = webContent;
			mHandler.sendMessage(msg);
		}
		
	}
	
}
