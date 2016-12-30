package com.Hactieuho96.SIS.login;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LoginPost extends Post {
	
	public LoginPost(){
		super();
	}
	
	/**
	 * Hàm kiểm tra trạng thái login
	 * Nếu không chuyển hướng đến login module tức là đăng nhập thành công
	 * @return true nếu đăng nhập thành công
	 */
	public boolean loginResult(){
		
		Document doc = Jsoup.parse(srcPage);
		
		//Lấy header chứa tên sinh viên
		Element ele = doc.select("html>body>h2>a").first();
	   	
	   	String ahref = ele.attr("href");
	   	
	   	//Nếu không chuyển hướng đến login module tức là đăng nhập thành công
	   	if(ahref.equals("/")){
	   		return true;
	   	}
	   	else{
	   		return false;
	   	}
	}
}
