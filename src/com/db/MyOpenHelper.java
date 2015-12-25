package com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

	public MyOpenHelper(Context context) {
		super(context, DatabaseConfig.databasename, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlhistory = "CREATE TABLE " + DatabaseConfig.databasename + "("
				+ "id INTEGER PRIMARY KEY," + DatabaseConfig.pm25
				+ " VARCHAR(20)," + DatabaseConfig.co2 + " VARCHAR(20),"
				+ DatabaseConfig.LightIntensity + " VARCHAR(20),"
				+ DatabaseConfig.humidity + " VARCHAR(20),"
				+ DatabaseConfig.temp + " VARCHAR(20)," + DatabaseConfig.time
				+ " VARCHAR(20) " + " )";
		// System.out.println(sqlhistory);
		db.execSQL(sqlhistory);
		// db.close();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

}
