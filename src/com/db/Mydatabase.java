package com.db;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Mydatabase {
	MyOpenHelper myOpenHelper;
	Context context;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private String getTime() {
		return simpleDateFormat.format(new Date());

	}

	public Mydatabase(Context context) {
		this.context = context;
		myOpenHelper = new MyOpenHelper(context);
	}

	// 查询1分钟历史表
	public ArrayList<Mysensor> query60() {
		ArrayList<Mysensor> list = new ArrayList<Mysensor>();
		SQLiteDatabase db = myOpenHelper.getReadableDatabase();
		String sql = "SELECT * FROM " + DatabaseConfig.databasename
				+" WHERE time<>?"	;
		Cursor cursor = db.rawQuery(sql, new String[] {""});
		int tol = cursor.getCount();
		for (int i = 0; i < tol; i++) {
		if (cursor.moveToNext()) {		
				Mysensor mysensor = new Mysensor();
				mysensor.setco2(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.co2)));
				mysensor.setpm25(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.pm25)));
				mysensor.settemp(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.temp)));
				mysensor.sethumidity(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.humidity)));
				mysensor.setTime(cursor.getString(cursor
						.getColumnIndex(DatabaseConfig.time)));
				mysensor.setpLightIntensity(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.LightIntensity)));
				list.add(mysensor);
			}
		}
		db.close();

		return list;

	}

	// 查询5分钟历史表
	public ArrayList<Mysensor> query5() {
		ArrayList<Mysensor> list = new ArrayList<Mysensor>();
		SQLiteDatabase db = myOpenHelper.getReadableDatabase();
		String sql = "SELECT * FROM " + DatabaseConfig.databasename
				+ " WHERE id%5=0";// 每5条拿一个值
		System.out.println(sql);
		Cursor cursor = db.rawQuery(sql, new String[] {});
		int tol = cursor.getCount();
			for (int i = 0; i < tol; i++) {
		if (cursor.moveToNext()) {
			
				Mysensor mysensor = new Mysensor();
				mysensor.setco2(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.co2)));
				mysensor.setpm25(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.pm25)));
				mysensor.settemp(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.temp)));
				mysensor.sethumidity(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.humidity)));
				mysensor.setTime(cursor.getString(cursor
						.getColumnIndex(DatabaseConfig.time)));
				mysensor.setpLightIntensity(cursor.getInt(cursor
						.getColumnIndex(DatabaseConfig.LightIntensity)));
				list.add(mysensor);
			}
		}
		db.close();

		return list;

	}

	public void insert(String webcontent) throws JSONException {
		JSONObject webJson = new JSONObject(webcontent);
		SQLiteDatabase db = myOpenHelper.getWritableDatabase();
		String sqlinsert = "INSERT INTO " + DatabaseConfig.databasename + " ("
				+ DatabaseConfig.pm25 + "," + DatabaseConfig.co2 + ","

				+ DatabaseConfig.LightIntensity + "," + DatabaseConfig.humidity
				+ "," + DatabaseConfig.temp + "," + DatabaseConfig.time + ")"
				+ " VALUES(?,?,?,?,?,?)";
		db.execSQL(
				sqlinsert,
				new String[] { "" + webJson.optInt("pm2.5", -1),
						"" + webJson.optInt("co2", -1),
						"" + webJson.optInt("temperature", -1),
						"" + webJson.optInt("LightIntensity", -1),
						"" + webJson.optInt("humidity", -1), getTime() });
		db.close();
	}

}
