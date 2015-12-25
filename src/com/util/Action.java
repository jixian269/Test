package com.util;

/**
 * 请求动作信息的封装
 * @author changlie
 */
public class Action {
	
	public static String[] actionNames = new String[]{
		"查询小车当前速度",	
		"查询小车当前位置",	
		"查询小车账户余额",	
		"设置小车动作",	
		"小车账户充值",	
		"查询账户记录",	
		"查询红绿灯的配置信息",	
		"停车场费率设置",	
		"查询当前空闲车位",	
		"查询当前停车场费率信息",	
		"查询所有传感器的当前值",	
		"查询光照传感器阀值",	
		"站台信息查询",	
		"查询道路状态",	
	};
	public final static String[] gets = {
			"/GetCarSpeed.do",
			"/GetCarLocation.do",
			"/GetCarAccountBalance.do",
			"/SetCarMove.do",
			"/SetCarAccountRecharge.do",
			"/GetCarAccountRecord.do",
			"/GetTrafficLightConfigAction.do",
			"/SetParkRate.do",
			"/GetParkFree.do",
			"/GetParkRate.do",
			"/GetAllSense.do",
			"/GetLightSenseValve.do",
			"/GetBusStationInfo.do",
			"/GetRoadStatus.do"
	};
	public final static String GetCarSpeed = "GetCarSpeed.do";// 查询小车当前速度
	public final static String GetCarLocation = "GetCarLocation.do";// 查询小车当前位置
	public final static String GetCarAccountBalance = "GetCarAccountBalance.do";// 查询小车账户余额
	public final static String SetCarMove = "SetCarMove.do";// 设置小车动作
	public final static String SetCarAccountRecharge = "SetCarAccountRecharge.do";// 小车账户充值
	public final static String GetCarAccountRecord = "GetCarAccountRecord.do";// 查询账户记录
	public final static String GetTrafficLightConfigAction = "GetTrafficLightConfigAction.do";// 查询红绿灯的配置信息
	public final static String SetParkRate = "SetParkRate.do";// 停车场费率设置
	public final static String GetParkFree = "GetParkFree.do";// 查询当前空闲车位
	public final static String GetParkRate = "GetParkRate.do";// 查询当前停车场费率信息
	public final static String GetAllSense = "GetAllSense.do";// 查询所有传感器的当前值
	public final static String GetLightSenseValve = "GetLightSenseValve.do";// 查询光照传感器阀值
	public final static String GetBusStationInfo = "GetBusStationInfo.do";// 站台信息查询
	public final static String GetRoadStatus = "GetRoadStatus.do";// 查询道路状态
}
