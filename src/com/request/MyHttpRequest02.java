package com.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.jiaotong.R.id;

import android.os.Handler;

public class MyHttpRequest02 {

	private String webContent;
	private String src;
	private String StrJson;
	private Handler mHandler;
	
	
	public void setWebContent(String webContent) {
		this.webContent = webContent;
	}
	
	public String getWebContent() {
		return webContent;
	}
	
	public MyHttpRequest02(Handler mHandler,String src,String strJson) {
		this.mHandler = mHandler;
		this.src =src;
		this.StrJson = strJson;
	}
	
	public int getHttRequest(){
		int status = 0;
		HttpClient client = new DefaultHttpClient();
		client.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT,5000);
		client.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT,3000);
		HttpPost post = new HttpPost(src);
		try {
			post.setEntity(new StringEntity(StrJson));
			HttpResponse response = client.execute(post);
			int res = response.getStatusLine().getStatusCode();
			if(res==200){
				HttpEntity entity = response.getEntity();
				if(entity!=null){
					String info = EntityUtils.toString(entity);
					JSONObject responseJson = new JSONObject(info);
					info = responseJson.getString("serverinfo");
					setWebContent(info);
					System.out.println("服务器返回值（key:serverinfo）："+info);
				}
				status = 1;
			}else{
				status = res;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch(ConnectException e){
			status = 901;
		}catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
