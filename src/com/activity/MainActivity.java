package com.activity;

import com.Base.MyApplication;
import com.example.jiaotong.R;
import com.fragment.Controlfragment;
import com.fragment.Historyfragment;
import com.fragment.Homefragment;
import com.fragment.Selecrfragment;
import com.fragment.Settingfragment;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener {

	private TextView homeview;
	private TextView historyview;
	private TextView controlview;
	private TextView settingview;
	private TextView selectview;
	private Homefragment homefragment;
	private Historyfragment historyfragment;
	private Controlfragment controlfragment;
	private Selecrfragment selecrfragment;
	private Settingfragment settingfragment;
	
	private FragmentManager fm;
	private FragmentTransaction ft;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		selectfragment(0);
	}

	private void initView() {
		// TODO Auto-generated method stub
		homeview = (TextView) findViewById(R.id.main_home);
		historyview = (TextView) findViewById(R.id.main_history);
		controlview = (TextView) findViewById(R.id.main_control);
		selectview =  (TextView) findViewById(R.id.main_select);
		settingview = (TextView) findViewById(R.id.main_setting);
		
		homeview.setOnClickListener(this);
		historyview.setOnClickListener(this);
		controlview.setOnClickListener(this);
		selectview.setOnClickListener(this);
		settingview.setOnClickListener(this);
		MyApplication.getInstance().setContext(MainActivity.this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.main_home:
			selectfragment(0);
			break;
		case R.id.main_history:
			selectfragment(1);
			break;
		case R.id.main_control:
			selectfragment(2);
			break;
		case R.id.main_select:
			selectfragment(3);
			break;
		case R.id.main_setting:
			selectfragment(4);
		default:
			break;
		}
	}

	private void selectfragment(int i) {
		// TODO Auto-generated method stub
		fm = getFragmentManager();
		ft = fm.beginTransaction();
		hidefragment(ft);
		switch (i) {
		case 0:
			if(homefragment == null) {
				homefragment = new Homefragment();
				ft.add(R.id.main_frame,homefragment);
			} else {
				ft.show(homefragment);
			}
			break;
		case 1:
			if(historyfragment == null) {
				historyfragment = new Historyfragment();
			    ft.add(R.id.main_frame, historyfragment);
			} else {
				ft.show(historyfragment);
			}
			break;
		case 2:
			if(controlfragment == null) {
				controlfragment = new Controlfragment();
				ft.add(R.id.main_frame, controlfragment);
			} else {
				ft.show(controlfragment);
			}
			break;
		case 3:
			if(selecrfragment == null) {
				selecrfragment = new Selecrfragment();
				ft.add(R.id.main_frame, selecrfragment);
			} else {
				ft.show(selecrfragment);
			}
			break;
		case 4:
			if(settingfragment == null) {
				settingfragment = new Settingfragment();
				ft.add(R.id.main_frame, settingfragment);
			} else {
				ft.show(settingfragment);
			}
			break;

		default:
			break;
		}
		ft.commit();
	}

	private void hidefragment(FragmentTransaction ft2) {
		// TODO Auto-generated method stub
		if(homefragment != null) {
			ft2.hide(homefragment);
		}
		if(historyfragment != null) {
			ft2.hide(historyfragment);
		}
		if(controlfragment != null) {
			ft2.hide(controlfragment);
		}
		if(selecrfragment != null) {
			ft2.hide(selecrfragment);
		}
		if(settingfragment != null) {
			ft2.hide(settingfragment);
		}
	}
	
	protected void update(Object ob) {
		// TODO Auto-generated method stub

	}
	
}
