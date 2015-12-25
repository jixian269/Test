package com.fragment;

import java.util.ArrayList;
import java.util.List;

import com.dialog.CaractionDialog;
import com.dialog.EtcrateDialog;
import com.dialog.ParkrateDialog;
import com.dialog.PayDialog;
import com.example.jiaotong.R;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Controlfragment extends Fragment {

	private Button actionbtn,parkratebtn,etcratebtn,paybtn;
	List<View> list = new ArrayList<View>();
	private  static Controlfragment instance  =null;
	
	public static Controlfragment getInstance() {
		if(instance == null) {
			instance = new Controlfragment();
		}
		return instance;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_control, null);
		ViewPager viewPager = (ViewPager) view.findViewById(R.id.control_viewpager);
		View actionView = inflater.inflate(R.layout.viewpager_caraction, null);
		View parkrateView = inflater.inflate(R.layout.viewpager_parkrate, null);
		View etcrateView = inflater.inflate(R.layout.viewpager_etcrate, null);
		View payView = inflater.inflate(R.layout.viewpager_pay, null);
		actionbtn = (Button) actionView.findViewById(R.id.viewpager_caraction);
		parkratebtn = (Button) parkrateView.findViewById(R.id.viewpager_parkrate);
		etcratebtn = (Button) etcrateView.findViewById(R.id.viewpager_etcrate);
		paybtn = (Button) payView.findViewById(R.id.viewpager_pay);
		actionbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new CaractionDialog(getActivity()).show();
			}
		});
		parkratebtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new ParkrateDialog(getActivity()).show();
			}
		});
		etcratebtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new EtcrateDialog(getActivity()).show();
			}
		});
		paybtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new PayDialog(getActivity()).show();
			}
		});
		
		list.add(actionView);
		list.add(parkrateView);
		list.add(etcrateView);
		list.add(payView);
		viewPager.setAdapter(new MyAdapter());
		return view;
	}

	class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager) container).removeView(list.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			((ViewPager)container).addView(list.get(position));
			return list.get(position);
		}
		
	}
	
}
