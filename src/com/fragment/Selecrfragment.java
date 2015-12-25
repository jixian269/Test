package com.fragment;

import com.Base.MyApplication;
import com.activity.SensorActivity;
import com.dialog.Dialog_common;
import com.example.jiaotong.R;
import com.util.Action;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class Selecrfragment extends Fragment implements OnClickListener {

	private View view;
	private TextView carspeed,carmoney,carlocation,carrecord,parklist,parkrate,parkfree;
	private TextView trafficconfig,trafficstatus,etcrate,etclist,allsense,lightsense,busstation,roadstatus;
	
	private static Selecrfragment instance = null;
	
	public static Selecrfragment getInstance() {
		if(instance == null) {
			instance = new Selecrfragment();
		}
		return instance;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_select, null);
		
		initView();
		
		return view;
	}

	private void initView() {
		// TODO Auto-generated method stub
		carspeed = (TextView) view.findViewById(R.id.isselectcarspeed);
		carspeed.setOnClickListener(this);
		carmoney = (TextView) view.findViewById(R.id.isselectcarbalance);
		carmoney.setOnClickListener(this);
		carlocation = (TextView) view.findViewById(R.id.isselectcarlocation);
		carlocation.setOnClickListener(this);
		carrecord = (TextView) view.findViewById(R.id.isselectcarrecord);
		carrecord.setOnClickListener(this);
		parkrate = (TextView) view.findViewById(R.id.isselectparkrate);
		parkrate.setOnClickListener(this);
		parklist = (TextView) view.findViewById(R.id.isselectparklist);
		parklist.setOnClickListener(this);
		parkfree = (TextView) view.findViewById(R.id.isselectfreecar);
		parkfree.setOnClickListener(this);
		trafficconfig = (TextView) view.findViewById(R.id.isselecttrafficconfig);
		trafficconfig.setOnClickListener(this);
		trafficstatus = (TextView) view.findViewById(R.id.isselecttrafficstatus);
		trafficstatus.setOnClickListener(this);
		etcrate = (TextView) view.findViewById(R.id.isselectetcrate);
		etcrate.setOnClickListener(this);
		etclist = (TextView) view.findViewById(R.id.isselectetclist);
		etclist.setOnClickListener(this);
		allsense = (TextView) view.findViewById(R.id.isselectallsense);
		allsense.setOnClickListener(this);
		lightsense = (TextView) view.findViewById(R.id.isselectlightsense);
		lightsense.setOnClickListener(this);
		busstation = (TextView) view.findViewById(R.id.isselectbusstation);
		busstation.setOnClickListener(this);
		roadstatus = (TextView) view.findViewById(R.id.isselectroadstatus);
		roadstatus.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.isselectcarspeed:
			new Dialog_common(getActivity(), R.id.isselectcarspeed).show();
			break;
		case R.id.isselectcarlocation:
			new Dialog_common(getActivity(), R.id.isselectcarlocation).show();
			break;
		case R.id.isselectcarbalance:
			new Dialog_common(getActivity(), R.id.isselectcarbalance).show();
			break;
		case R.id.isselectcarrecord:
			new Dialog_common(getActivity(), R.id.isselectcarrecord).show();
			break;
		case R.id.isselecttrafficconfig:
			new Dialog_common(getActivity(), R.id.isselecttrafficconfig).show();
			break;
		case R.id.isselectfreecar:
			
			break;
		case R.id.isselectparkrate:
			
			break;
		case R.id.isselectallsense:
			
			String SensorrequestStr = "{}";
			String Sensorsrc = MyApplication.getInstance().share.getBaseUrl()+Action.gets[10];
			Intent intentSensor = new Intent(getActivity(),SensorActivity.class);
			intentSensor.putExtra("src",Sensorsrc);
			intentSensor.putExtra("strJson",SensorrequestStr);
			startActivity(intentSensor);
			
			break;
		case R.id.isselectlightsense:
			
			break;
		case R.id.isselectbusstation:
			new Dialog_common(getActivity(),R.id.isselectbusstation).show();
			break;
//		case R.id.isselectroadstatus:
//			
//			break;

		default:
			break;
		}
	}

}
