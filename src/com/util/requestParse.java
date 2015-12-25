package com.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class requestParse {

	public static String responsejsonStr(String webContent, int ItemPosition) {
		JSONArray jsonArray = null;
		Object reqOb = null;
		Object resOb = null;
		JSONObject reqJson = null;
		JSONObject resJson = null;
		String responseJsonStr = null;
		try {
			jsonArray = new JSONArray(webContent);
		} catch (JSONException e) {
			System.out.println("响应异常");
			e.printStackTrace();
		}
		switch (ItemPosition) {
		case 0:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson =(JSONObject)reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "小车"+reqJson.optInt("CarId",-1)+"的速度:"+resJson.optInt("CarSpeed",-1);
			break;
		case 1:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "小车"+reqJson.optInt("CarId",-1)+"的位置:"+resJson.optInt("CarLocation",-1);
			break;
		case 2:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "小车"+reqJson.optInt("CarId",-1)+"的账户余额:"+resJson.optInt("Balance",-1);
			break;
		case 3:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","on").equals("ok")){
				responseJsonStr = "设置成功";
			}else{
				responseJsonStr = "设置失败";
			}
			break;
		case 4:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseJsonStr = "设置成功";
			}else{
				responseJsonStr = "设置失败";
			}
			break;
		case 5:
			resOb = jsonArray.optJSONArray(1);
			if(resOb.toString().equals("[]")){
				responseJsonStr = "暂无记录";
			}else{
				responseJsonStr = "操作失败";
			}
			break;
		case 6:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "红绿灯"+reqJson.optInt("TrafficLightId",-1)+":红灯:"+resJson.optString("RedTime","-1")+"秒,绿灯:"+resJson.optString("GreenTime","-1")+"秒,黄灯:"+resJson.optString("YellowTime","-1")+"秒";
			break;
		case 7:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseJsonStr = "设置成功";
			}else{
				responseJsonStr = "设置失败";
			}
			break;
		case 8:
			resOb = jsonArray.optJSONArray(1);
			JSONArray jsonArrayRes = (JSONArray) resOb;
			int one = jsonArrayRes.optJSONObject(0).optInt("ParkFreeId",-1);
			int two = jsonArrayRes.optJSONObject(1).optInt("ParkFreeId",-1);
			if(one==two){
				responseJsonStr = "有两个空闲车位";
			}else{
				responseJsonStr = "有一个空闲车位";
			}
			break;
		case 9:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseJsonStr = "当前停车场收费:"+resJson.optInt("Money",-1)+"/辆，费率类型:"+resJson.optString("RateType","未知");
			break;
		case 10:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseJsonStr = resJson.toString();
			System.out.println(responseJsonStr+"10--------");
//			responseJsonStr = ""+resJson.optInt("pm2.5",-1);
//			responseJsonStr = "PM2.5:"+resJson.optInt("pm2.5",-1)+"\nCo2:"+resJson.optInt("co2",-1)+"\n光照强度:"+resJson.optInt("LightIntensity",-1)+"\n空气湿度:"+resJson.optInt("humidity",-1)+"\n温度:"+resJson.optInt("temperature",-1);
			break;
		case 11:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseJsonStr = "光照传感器阀值:"+resJson.optInt("Down",-1)+"-"+resJson.optInt("Up",-1);
			break;
		case 12:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONArray(1);
			reqJson = (JSONObject) reqOb;
			JSONArray jsonArrayResBusStation = (JSONArray) resOb;
			Object DistanceresOb01 = jsonArrayResBusStation.optJSONObject(0);
			Object DistanceresOb02 = jsonArrayResBusStation.optJSONObject(1);
			JSONObject DistanceresJson01 = (JSONObject) DistanceresOb01;
			JSONObject DistanceresJson02 = (JSONObject) DistanceresOb02;
			responseJsonStr = "站台:"+reqJson.optInt("BusStationId",-1)+"距离\n一号巴士:"+DistanceresJson01.optInt("Distance",-1)+"千米\n二号巴士:"+DistanceresJson02.optInt("Distance",-1)+"千米";
			break;
		case 13:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "道路："+reqJson.optInt("RoadId",-1)+"状态为:"+resJson.optInt("Status",-1);
			break;
		}
		return responseJsonStr;
	}

}
