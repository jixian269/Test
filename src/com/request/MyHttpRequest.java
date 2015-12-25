package com.request;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;

public class MyHttpRequest {
	
	private Handler mHandler;
	private String src;
	private String requestJsonStr;
	private String webContent;
	
	public MyHttpRequest(Handler mHandler,String src,String requestJsonStr) {
		this.mHandler = mHandler;
		this.src = src;
		this.requestJsonStr = requestJsonStr;
	}
	
	public void setWebContent(String webContent) {
		this.webContent = webContent;
	}
	
	public String getWebContent() {
		return webContent;
	}
		
	public int requestHttp(){
		int status = 0;
		try {
			HttpClient client = new DefaultHttpClient();
			client.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT,5000);
			client.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT,3000);
			System.out.println("client");
			HttpPost post = new HttpPost(src);
			System.out.println("post");
			post.setEntity(new StringEntity(requestJsonStr));
			HttpResponse response = client.execute(post);
			int res = response.getStatusLine().getStatusCode();
			if(res==200){
				HttpEntity entity = response.getEntity();
				if(entity!=null){
					String info = EntityUtils.toString(entity);
					JSONObject responseJson = new JSONObject(info);
					info = responseJson.getString("serverinfo");
					System.out.println("请求的URL:"+src);
					System.out.println("请求的JSON字符串:"+requestJsonStr);
					System.out.println("response数据JSON中Key为serverinfo的值："+info);
					setWebContent(info);
					status = 1;
				}	
			}else{
				status = res;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (JSONException e) {
			e.printStackTrace();
		}catch (ConnectTimeoutException e) {
			status = 901;
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
