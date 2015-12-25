package com.db;

public class Mysensor {
	private String time;
	private int pm25;
	private int co2;
	private int temp;
	private int  humidity;
	private int  LightIntensity;
	private String Sensorname;
	public Mysensor(String Sensorname) {
		super();
	this.Sensorname=Sensorname;
		
	}
	public Mysensor(){
		
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getco2() {
		return co2;
	}
	public void setco2(int co2) {
		this.co2 = co2;
	}
	public int gettemp() {
		return temp;
	}
	public void settemp(int temp) {
		this.temp = temp;
	}
	public int getpm25() {
		return pm25;
	}
	public void setpm25(int pm25) {
		this.pm25 = pm25;
	}
	public int getLightIntensity() {
		return LightIntensity;
	}
	public void setpLightIntensity(int LightIntensity) {
		this.LightIntensity = LightIntensity;
	}
	public int gethumidity() {
		return humidity;
	}
	public void sethumidity(int humidity) {
		this.humidity = humidity;
	}
	public String getSensorname() {
		return Sensorname;
	}
	public void setSensorname(String Sensorname) {
		this.Sensorname =Sensorname;
	}
	
	
}