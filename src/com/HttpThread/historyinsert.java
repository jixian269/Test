package com.HttpThread;


import org.json.JSONException;
import com.db.Mydatabase;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;

public class historyinsert extends Thread {
	private Context context;
	private String webSensor;

	public historyinsert(Context context, String webShow) {
		this.context = context;
		this.webSensor = webShow;

	}

	public void run() {
		try {
			new Mydatabase(context).insert(webSensor);
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			return;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
