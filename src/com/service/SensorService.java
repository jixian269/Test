package com.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SensorService extends Service {

	private String src = "http://192.168.228.18:8080/transportservice/type/jason/action/GetAllSense.do";
	private Timer timer;
	@Override
	public void onCreate() {
		System.out.println("onCreate");
		timer = new Timer();
		super.onCreate();
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		System.out.println("onStart");
		super.onStart(intent, startId);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand");
		timer.schedule(new TimerTask() {	
			@Override
			public void run() {
				HttpClient client = new DefaultHttpClient();
				client.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT,5000);
				client.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT,3000);
				HttpPost post = new HttpPost(src);
				try {
					post.setEntity(new StringEntity("{}"));
					HttpResponse response = client.execute(post);
					HttpEntity entity = response.getEntity();
					if(entity!=null){
						String info  = EntityUtils.toString(entity);
						JSONObject responseJson = new JSONObject(info);
						System.out.println("serveinfo"+responseJson.getString("serverinfo"));
					}
					System.out.println("Á¬½Ó×´Ì¬£º"+response.getStatusLine().getStatusCode());
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}, 500, 1000);
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		if(timer!=null){
			timer.cancel();
		}
		super.onDestroy();
	}
	
	
	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}

}
