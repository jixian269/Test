package com.HttpThread;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore.PrivateKeyEntry;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.activity.SensorActivity;
import com.request.MyHttpRequest;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

public class MyHttpThread extends Thread {

	private Handler mHandler;
	private String src;
	private Activity context;
	private int ItemPosition;
	private String strJson;
	private MyHttpRequest myRequest;
	
	
	public MyHttpThread(Handler mHandler,String src,int ItemPosition,String strJson,Activity context) {
		this.mHandler = mHandler;
		this.src = src;
		this.ItemPosition = ItemPosition;
		this.strJson = strJson;
		this.context = context;
	}
	
	@Override
	public void run() {
		System.out.println("请求地址:"+src);
		if(ItemPosition==10){
			Intent sensorIntent = new Intent(context, SensorActivity.class);
			sensorIntent.putExtra("src",src);
			sensorIntent.putExtra("strJson",strJson);
			context.startActivity(sensorIntent);
		}else{
			myRequest = new MyHttpRequest(mHandler, src, strJson);
			int status = myRequest.requestHttp();
			Message msg = new Message();
			String webContent = null;
			if(status==1){
				webContent = myRequest.getWebContent();
				webContent = "["+strJson+","+webContent+"]";
			}else if(status==901){
				webContent = "Timeout!";
			}else{
				webContent = "IP地址不正确";
			}
			System.out.println("连接状态--------:"+status);
			System.out.println("Handler返回数据----:"+webContent);
			msg.what = status;
			msg.obj = webContent;
			msg.arg1 = ItemPosition;
			mHandler.sendMessage(msg);
		}
		
	}
	
}
