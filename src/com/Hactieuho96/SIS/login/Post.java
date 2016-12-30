package com.Hactieuho96.SIS.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.*;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Post {
	
	private String url;
	private HttpPost post;
	private List<NameValuePair> urlParameters;
	private HttpClient client;
	private HttpResponse response;
	protected String srcPage;
	private int responseCode;
	/**
	 * Constructor
	 */
	public Post(){
		this.client = HttpClients.createDefault();
		
		//Danh sách tham số
        this.urlParameters = new ArrayList<NameValuePair>();
	}
	
	public int getResponseCode(){
		return responseCode;
	}
	
	public void Read(){

		BufferedReader rd;
		StringBuffer result;
		try {
			rd = new BufferedReader(
			        new InputStreamReader(this.response.getEntity().getContent(), "UTF-8"));
			result = new StringBuffer();
			String line = "";
	        while ((line = rd.readLine()) != null) {
	            result.append(line + '\n');
	        }
	        
	        this.srcPage = new String(result.toString());
	        
	        rd.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Send(){
		
		try {

			//Chèn danh sách tham số vào đối tượng tham số
			this.post.setEntity(new UrlEncodedFormEntity(urlParameters, Charset.forName("UTF-8")));
			
			//Gửi gói tin đi và nhận về kết quả
			this.response = client.execute(post);
			
			//Trả về mã trạng thái của gói tin
			this.responseCode = response.getStatusLine().getStatusCode();
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setParam(String name, String value){
		this.urlParameters.add(new BasicNameValuePair(name, value));
	}
	
	public void setHeader(String name, String value){
		this.post.setHeader(name, value);
	}
	
	public void setUrl(String url){
		
		this.url = new String(url);

        this.post = new HttpPost(this.url);
	}
}
