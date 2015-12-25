package com.util;

import org.achartengine.model.CategorySeries;
import org.apache.http.ReasonPhraseCatalog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class requestParse02 {

	public static String responsejsonStr(String jsonStr,int itemposition){
		JSONArray jsonArray = null;
		JSONObject reqJson = null;
		JSONObject resJson = null;
		Object reqOb = null;
		Object resOb = null;
		String responseStr =  null;
		try {
			jsonArray = new JSONArray(jsonStr);
		} catch (JSONException e) {
			e.printStackTrace();
			System.out.println("响应异常");
		}
		switch (itemposition) {
		case 0:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "小车："+reqJson.optInt("CarId",-1)+"的速度："+resJson.optInt("CarSpeed",-1);
			break;
		case 1:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "小车："+reqJson.optInt("CarId",-1)+"的位置："+resJson.optInt("CarLocation",-1);
			break;
		case 2:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "小车："+reqJson.optInt("CarId",-1)+"的账户记录："+resJson.optInt("Balance",-1);
			break;
		case 3:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseStr = "设置成功";
			}else{
				responseStr = "设置失败";
			}
			break;
		case 4:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseStr = "充值成功";
			}else{
				responseStr = "充值失败";
			}
			break;
		case 5:
			resOb = jsonArray.optJSONArray(1);
			if(resOb.toString().equals("[]")){
				responseStr = "暂无记录";
			}
			break;
		case 6:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "红绿灯："+reqJson.optInt("TrafficLightId",-1)+"\n黄灯："+resJson.optInt("YellowTime",-1)
					+"\n绿灯："+resJson.optInt("GreenTime",-1)+"\n红灯:"+resJson.optInt("RedTime",-1);
			break;
		case 7:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseStr = "设置停车场费率信息成功";
			}else{
				responseStr = "设置失败,检查Logcat";
			}
			break;
		case 8:
			resOb = jsonArray.optJSONArray(1);
			JSONArray resJsonarray = (JSONArray) resOb;
			int one = resJsonarray.optJSONObject(0).optInt("ParkFreeId",-1);
			int two = resJsonarray.optJSONObject(1).optInt("ParkFreeId",-1);
			if(one==two){
				responseStr = "有两个车位";
			}else{
				responseStr = "只一个车位";
			}
			break;
		case 9:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseStr = "当前收费信息：\n费率："+resJson.optInt("Money",-1)+"/辆\n费率类型："+resJson.optString("RateType","未知费率类型");
			break;
		case 10:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseStr = resJson.toString();
			System.out.println("item=10(AllSensor)"+responseStr);
			break;
		case 11:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseStr = "光照阀值："+resJson.optInt("Down",-1)+"~"+resJson.optInt("Up",-1);
			break;
		case 12:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			JSONArray BusresJsonArray = (JSONArray) resOb;
			Object resJsonOb01 = BusresJsonArray.optJSONObject(0);
			Object resJsonOb02 = BusresJsonArray.optJSONObject(1);
			JSONObject BusresJson01 = (JSONObject) resJsonOb01;
			JSONObject BusresJson02 = (JSONObject) resJsonOb02;
			responseStr = "站台："+reqJson.optInt("BusStationId",-1)+"\n距离一号巴士:"+BusresJson01.optInt("Distance",-1)+"千米\n距离二号巴士："+BusresJson02.optInt("Distance",-1)+"千米";
			break;
		case 13:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "道路："+reqJson.optInt("RoadId",-1)+"状态："+resJson.optInt("Status",-1);
			break;
		}
		return responseStr;
	}
	
}
