package com.fragment;

import java.util.Locale;

import com.Base.MyApplication;
import com.activity.MainActivity;
import com.dialog.Dialog_setip;
import com.example.jiaotong.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Settingfragment extends Fragment implements OnClickListener {

	private View view;
	private TextView showguide,language,setip;
	private static Settingfragment instance  =null;
	private AlertDialog alertDialog;
	
	public Settingfragment getInstance() {
		if(instance == null) {
			instance = new Settingfragment();
		}
		return instance;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view =inflater.inflate(R.layout.fragment_setting, null);
		
    	showguide = (TextView) view.findViewById(R.id.setting_showguide);
    	showguide.setOnClickListener(this);
    	language = (TextView) view.findViewById(R.id.setting_language);
    	language.setOnClickListener(this);
    	setip = (TextView) view.findViewById(R.id.settting_setip);
    	setip.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.setting_showguide:
			showAlertDialog("设置显示导航页","是否设置导航页","是","否");
			break;
		case R.id.setting_language:
			Resources resources = getResources();//获得资源对象
			Configuration configuration  = resources.getConfiguration();//获得设置对象
			DisplayMetrics displayMetrics = resources.getDisplayMetrics();//获得屏幕参数
			if(configuration.locale.getCountry().equals("CN")) {
				configuration.locale = Locale.ENGLISH;
			} else {
				configuration.locale = Locale.SIMPLIFIED_CHINESE;
			}
			resources.updateConfiguration(configuration, displayMetrics);
			startActivity(new Intent(getActivity(), MainActivity.class));
			getActivity().finish();
			break;
		case R.id.settting_setip:
			new Dialog_setip(getActivity()).show();
			break;

		default:
			break;
		}
	}

	private void showAlertDialog( String string, String string2,
			String string3, String string4) {
		// TODO Auto-generated method stub
		MyOnClickListener listener = new MyOnClickListener();
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle(string);
		builder.setMessage(string2);
		builder.setPositiveButton(string3, listener);
		builder.setNegativeButton(string4, listener);
		alertDialog = builder.create();
		alertDialog.show();
	}

	private class MyOnClickListener implements DialogInterface.OnClickListener {
		
		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			switch (arg1) {
			case DialogInterface.BUTTON_POSITIVE:
				MyApplication.share.setShow(true);
				Toast.makeText(getActivity(), "设置成功！", Toast.LENGTH_SHORT).show();
				break;
			case DialogInterface.BUTTON_NEGATIVE:
				MyApplication.share.setShow(false);
					Toast.makeText(getActivity(), "设置成功！", Toast.LENGTH_SHORT)
					.show();
				break;
				}
              alertDialog.cancel();
			}

		}

}
