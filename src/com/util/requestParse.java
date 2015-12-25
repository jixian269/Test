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
			System.out.println("��Ӧ�쳣");
			e.printStackTrace();
		}
		switch (ItemPosition) {
		case 0:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson =(JSONObject)reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "С��"+reqJson.optInt("CarId",-1)+"���ٶ�:"+resJson.optInt("CarSpeed",-1);
			break;
		case 1:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "С��"+reqJson.optInt("CarId",-1)+"��λ��:"+resJson.optInt("CarLocation",-1);
			break;
		case 2:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "С��"+reqJson.optInt("CarId",-1)+"���˻����:"+resJson.optInt("Balance",-1);
			break;
		case 3:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","on").equals("ok")){
				responseJsonStr = "���óɹ�";
			}else{
				responseJsonStr = "����ʧ��";
			}
			break;
		case 4:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseJsonStr = "���óɹ�";
			}else{
				responseJsonStr = "����ʧ��";
			}
			break;
		case 5:
			resOb = jsonArray.optJSONArray(1);
			if(resOb.toString().equals("[]")){
				responseJsonStr = "���޼�¼";
			}else{
				responseJsonStr = "����ʧ��";
			}
			break;
		case 6:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "���̵�"+reqJson.optInt("TrafficLightId",-1)+":���:"+resJson.optString("RedTime","-1")+"��,�̵�:"+resJson.optString("GreenTime","-1")+"��,�Ƶ�:"+resJson.optString("YellowTime","-1")+"��";
			break;
		case 7:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseJsonStr = "���óɹ�";
			}else{
				responseJsonStr = "����ʧ��";
			}
			break;
		case 8:
			resOb = jsonArray.optJSONArray(1);
			JSONArray jsonArrayRes = (JSONArray) resOb;
			int one = jsonArrayRes.optJSONObject(0).optInt("ParkFreeId",-1);
			int two = jsonArrayRes.optJSONObject(1).optInt("ParkFreeId",-1);
			if(one==two){
				responseJsonStr = "���������г�λ";
			}else{
				responseJsonStr = "��һ�����г�λ";
			}
			break;
		case 9:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseJsonStr = "��ǰͣ�����շ�:"+resJson.optInt("Money",-1)+"/������������:"+resJson.optString("RateType","δ֪");
			break;
		case 10:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseJsonStr = resJson.toString();
			System.out.println(responseJsonStr+"10--------");
//			responseJsonStr = ""+resJson.optInt("pm2.5",-1);
//			responseJsonStr = "PM2.5:"+resJson.optInt("pm2.5",-1)+"\nCo2:"+resJson.optInt("co2",-1)+"\n����ǿ��:"+resJson.optInt("LightIntensity",-1)+"\n����ʪ��:"+resJson.optInt("humidity",-1)+"\n�¶�:"+resJson.optInt("temperature",-1);
			break;
		case 11:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseJsonStr = "���մ�������ֵ:"+resJson.optInt("Down",-1)+"-"+resJson.optInt("Up",-1);
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
			responseJsonStr = "վ̨:"+reqJson.optInt("BusStationId",-1)+"����\nһ�Ű�ʿ:"+DistanceresJson01.optInt("Distance",-1)+"ǧ��\n���Ű�ʿ:"+DistanceresJson02.optInt("Distance",-1)+"ǧ��";
			break;
		case 13:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseJsonStr = "��·��"+reqJson.optInt("RoadId",-1)+"״̬Ϊ:"+resJson.optInt("Status",-1);
			break;
		}
		return responseJsonStr;
	}

}
