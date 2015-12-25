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
			System.out.println("��Ӧ�쳣");
		}
		switch (itemposition) {
		case 0:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "С����"+reqJson.optInt("CarId",-1)+"���ٶȣ�"+resJson.optInt("CarSpeed",-1);
			break;
		case 1:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "С����"+reqJson.optInt("CarId",-1)+"��λ�ã�"+resJson.optInt("CarLocation",-1);
			break;
		case 2:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "С����"+reqJson.optInt("CarId",-1)+"���˻���¼��"+resJson.optInt("Balance",-1);
			break;
		case 3:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseStr = "���óɹ�";
			}else{
				responseStr = "����ʧ��";
			}
			break;
		case 4:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseStr = "��ֵ�ɹ�";
			}else{
				responseStr = "��ֵʧ��";
			}
			break;
		case 5:
			resOb = jsonArray.optJSONArray(1);
			if(resOb.toString().equals("[]")){
				responseStr = "���޼�¼";
			}
			break;
		case 6:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "���̵ƣ�"+reqJson.optInt("TrafficLightId",-1)+"\n�Ƶƣ�"+resJson.optInt("YellowTime",-1)
					+"\n�̵ƣ�"+resJson.optInt("GreenTime",-1)+"\n���:"+resJson.optInt("RedTime",-1);
			break;
		case 7:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			if(resJson.optString("result","no").equals("ok")){
				responseStr = "����ͣ����������Ϣ�ɹ�";
			}else{
				responseStr = "����ʧ��,���Logcat";
			}
			break;
		case 8:
			resOb = jsonArray.optJSONArray(1);
			JSONArray resJsonarray = (JSONArray) resOb;
			int one = resJsonarray.optJSONObject(0).optInt("ParkFreeId",-1);
			int two = resJsonarray.optJSONObject(1).optInt("ParkFreeId",-1);
			if(one==two){
				responseStr = "��������λ";
			}else{
				responseStr = "ֻһ����λ";
			}
			break;
		case 9:
			resOb = jsonArray.optJSONObject(1);
			resJson = (JSONObject) resOb;
			responseStr = "��ǰ�շ���Ϣ��\n���ʣ�"+resJson.optInt("Money",-1)+"/��\n�������ͣ�"+resJson.optString("RateType","δ֪��������");
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
			responseStr = "���շ�ֵ��"+resJson.optInt("Down",-1)+"~"+resJson.optInt("Up",-1);
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
			responseStr = "վ̨��"+reqJson.optInt("BusStationId",-1)+"\n����һ�Ű�ʿ:"+BusresJson01.optInt("Distance",-1)+"ǧ��\n������Ű�ʿ��"+BusresJson02.optInt("Distance",-1)+"ǧ��";
			break;
		case 13:
			reqOb = jsonArray.optJSONObject(0);
			resOb = jsonArray.optJSONObject(1);
			reqJson = (JSONObject) reqOb;
			resJson = (JSONObject) resOb;
			responseStr = "��·��"+reqJson.optInt("RoadId",-1)+"״̬��"+resJson.optInt("Status",-1);
			break;
		}
		return responseStr;
	}
	
}
