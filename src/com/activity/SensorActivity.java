package com.activity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.Achart.ChartService02;
import com.Base.MyApplication;
import com.HttpThread.historyinsert;
import com.example.jiaotong.R;
import com.request.MyHttpRequest;

import MyPagerAdapter.MyPagerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;

public class SensorActivity extends Activity {
	
	private MyApplication myApp;
	private Handler mHandler;
	private String src;
	private String strJson;
	private ArrayList<ChartService02> charts = new ArrayList<ChartService02>();
	private View chartPm,chartCo,chartLight,chartHumidity,chartTemp;
	private Timer timer;
	private MyHttpRequest myRequest;
	private ChartService02 chart;
	private static String SensorContent;
	private ViewPager viewpager;
	private ArrayList<View> views;
	private MyPagerAdapter adapter;
	
	public void setSensorContent(String sensorContent) {
		SensorContent = sensorContent;
	}
	public static String getSensorContent() {
		return SensorContent;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sensor_viewpager_activity);
		initViews();
		initData();
       
		myApp = (MyApplication) getApplication();
		mHandler = myApp.getmHandler();
		src = getIntent().getStringExtra("src");
		strJson = getIntent().getStringExtra("strJson");
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				myRequest = new MyHttpRequest(mHandler, src, strJson);
				int status = myRequest.requestHttp();
				String webContent = null;
				Message msg = new Message();
				if(status==1){
					webContent = myRequest.getWebContent();
					webContent = "["+strJson+","+webContent+"]";
				}else{
					webContent = "["+strJson+","+"{\"pm2.5\":-1,\"co2\":-1,\"LightIntensity\":-1,\"humidity\":-1,\"temperature\":-1}"+"]";
				}
				setSensorContent(webContent);
				msg.what = 1;
				msg.arg2 = 2;
				msg.obj = charts;
				mHandler.sendMessage(msg);
			}
		}, 500, 1000);
	}
	
	private void initViews(){
		viewpager = (ViewPager) this.findViewById(R.id.sensor_viewpager);
		views = new ArrayList<View>();
		adapter = new MyPagerAdapter(views);
	};
	
	private void initData() {
		for(int i=0;i<5;i++){
			switch(i){
			case 0:
				chart = new ChartService02(SensorActivity.this);
				chart.setXYMultipleSeriesDataset("PM2.5");
				chart.setXYMultipleSeriesRenderer(10, 100, "PM2.5", "秒", "实时数据", Color.RED, Color.RED, Color.RED,R.color.blue1);
				chartPm = chart.getGraphicalView();
				views.add(chartPm);
				charts.add(chart);
				break;
			case 1:
				chart = new ChartService02(SensorActivity.this);
				chart.setXYMultipleSeriesDataset("Co2");
				chart.setXYMultipleSeriesRenderer(10, 100, "Co2", "秒", "实时数据", Color.RED, Color.RED, Color.RED, Color.GRAY);
				chartCo = chart.getGraphicalView();
				views.add(chartCo);
				charts.add(chart);
				break;
			case 2:
				chart= new ChartService02(SensorActivity.this);
				chart.setXYMultipleSeriesDataset("光照强度");
				chart.setXYMultipleSeriesRenderer(10, 100, "光照强度", "秒", "实时数据", Color.RED, Color.RED, Color.RED, Color.GRAY);
				chartLight = chart.getGraphicalView();
				views.add(chartLight);
				charts.add(chart);
				break;
			case 3:
				chart = new ChartService02(SensorActivity.this);
				chart.setXYMultipleSeriesDataset("空气湿度");
				chart.setXYMultipleSeriesRenderer(10, 100, "空气湿度", "秒", "实时数据", Color.RED, Color.RED, Color.RED, Color.GRAY);
				chartHumidity = chart.getGraphicalView();
				views.add(chartHumidity);
				charts.add(chart);
				break;
			case 4:
				chart = new ChartService02(SensorActivity.this);
				chart.setXYMultipleSeriesDataset("温度");
				chart.setXYMultipleSeriesRenderer(10, 100, "温度", "秒", "实时数据", Color.RED, Color.RED, Color.RED, Color.GRAY);
				chartTemp = chart.getGraphicalView();
				views.add(chartTemp);
				charts.add(chart);
				break;
			}
		}
		viewpager.setCurrentItem(getIntent().getIntExtra("item",0));
		viewpager.setAdapter(adapter);
	}
	@Override
	protected void onDestroy() {
		if(timer!=null){
			timer.cancel();
		}
		super.onDestroy();
	}
	
}
