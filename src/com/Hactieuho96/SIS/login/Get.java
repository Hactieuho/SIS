package com.Hactieuho96.SIS.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class Get {
	private String url;
	private HttpGet get;
	private HttpClient client;
	private HttpResponse response;
	protected String srcPage;
	private int responseCode;
	/**
	 * Constructor
	 */
	public Get(){
		
		get = new HttpGet();
		this.client = HttpClients.createDefault();
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

			//Gửi gói tin đi và nhận về kết quả
			this.response = client.execute(get);
			
			//Trả về mã trạng thái của gói tin
			this.responseCode = response.getStatusLine().getStatusCode();
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setHeader(String name, String value){
		this.get.setHeader(name, value);
	}
	
	public void setUrl(String url){
		
		this.url = new String(url);
        this.get = new HttpGet(this.url);
	}
}
