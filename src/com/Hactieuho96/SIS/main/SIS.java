package com.Hactieuho96.SIS.main;

import com.Hactieuho96.SIS.login.LoginSIS;

public class SIS {
	
	private LoginSIS http;
	
	public SIS(){
		
		this.http = new LoginSIS();
        this.http.scanKeyBoard();
        
        try {
        	this.http.sendPost();
			String src = this.http.sendGet();
			this.http.parse(src);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
