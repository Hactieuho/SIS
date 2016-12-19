package test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LoginCheck {

	private static boolean loginresult;
	
	public LoginCheck(){
		
	}
	
	public LoginCheck(String src){
		//Tao 1 doi tuong Document phan tich 1 String tra ve tu ham post()
		Document doc = Jsoup.parse(src);
		
		//Lấy header chứa tên sinh viên
		Element ele = doc.select("html>body>h2>a").first();
	   	
	   	String ahref = ele.attr("href");
	   	
	   	if(ahref.equals("/")){
	   		loginresult = true;
	   	}
	   	else{
	   		loginresult = false;
	   	}
	   	
	}
	
	public boolean LoginResult(){
		return loginresult;
	}
}
