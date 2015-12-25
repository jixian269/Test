package com.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyShareUtil {

	public static final String NAME ="share_name";
	public static final String PASS = "share_pass";
	public String BaseUrl;
	public static final String ISSHOW = "share_isshow";
	
	private SharedPreferences share;
	
	public MyShareUtil(Context context) {
		share = PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	public void save(String key,Object value) {
		if(value instanceof String) {
			share.edit().putString(key, (String)value).commit();
		}
		else if(value instanceof Boolean) {
			share.edit().putBoolean(key, (Boolean)value).commit();
		}
		else if(value instanceof Integer) {
			share.edit().putInt(key, (Integer)value).commit();
		}
	}
	
	public void setName(String name) {
		save(NAME, name);
	}
	public String getName() {
		return share.getString(NAME, "");
	}

	public void setPass(String pass) {
		save(PASS, pass);
	}
	public String getPass() {
		return share.getString(PASS, "");
	}
	
	public void setBaseUrl(String baseUrl) {
		BaseUrl = baseUrl;
	}
	
	public String getBaseUrl() {
		return BaseUrl;
	}
	
	
	public void setShow(boolean show) {
		save(ISSHOW, show);
	}
	public boolean getShow() {
		return share.getBoolean(ISSHOW, true);
	}
}
