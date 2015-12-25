package com.Base;


import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.Achart.ChartService02;
import com.HttpThread.historyinsert;
import com.activity.SensorActivity;
import com.hint.PlayMusic;
import com.util.MyShareUtil;
import com.util.requestParse;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

public class MyApplication extends Application {

	public static MyShareUtil share;
	public static MyApplication mAp;
	public Activity context;
	private String username;
	private ArrayList<ChartService02> charts;
	public Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if (msg.what==1) {
				if(msg.arg2==2){
					charts = (ArrayList<ChartService02>) msg.obj;
					String webSensor = new SensorActivity().getSensorContent();
					String webShow = requestParse.responsejsonStr(webSensor, 10);
					new historyinsert(context, webShow).start();
					try {
						JSONObject webJson = new JSONObject(webShow);
							charts.get(0).updateChart(webJson.optInt("pm2.5",-1));
							charts.get(1).updateChart(webJson.optInt("co2",-1));
							charts.get(2).updateChart(webJson.optInt("LightIntensity",-1));
							charts.get(3).updateChart(webJson.optInt("humidity",-1));
							charts.get(4).updateChart(webJson.optInt("temperature",-1));
					}catch (JSONException e) {
						e.printStackTrace();
					}
					
				}else{
					
					PlayMusic pmusic = new PlayMusic(context);
					pmusic.play();
					
					String webContent = (String) msg.obj;
					String webShow = requestParse.responsejsonStr(webContent,(int)msg.arg1);
					System.out.println(webShow);
					AlertDialog.Builder alert = new AlertDialog.Builder(context);
					alert.setMessage(webShow);
					alert.setPositiveButton("确定",null).show();
				}	
			}else{
				String webContent = (String) msg.obj;
				AlertDialog.Builder alert = new AlertDialog.Builder(context);
				alert.setMessage(webContent);
				alert.setPositiveButton("确定",null).show();
			}
		};
		
	};
	
	public void setContext(Activity context) {
		this.context = context;
	}
	public Activity getContext() {
		return context;
	}
	
	public Handler getmHandler(){
		return mHandler;
	}
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		mAp = this;
		share = new MyShareUtil(mAp);
	}
	
	public static MyApplication getInstance() {
		return mAp;
	}
	
	public String getUsername() {
		if(TextUtils.isEmpty(username)) {
			username = share.getName();
		}
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		share.setName(username);
	}
}
