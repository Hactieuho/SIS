package com.Hactieuho96.SIS.login;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LoginSIS {
	
	private String src;
	private static String username;
	private static String password;
	private static Scanner scanIn;
	private LoginPost post;
	private Get get;
	private String url;
	
	/**
	 * Constructor
	 */
	public LoginSIS(){
		url = new String("http://sis.hust.edu.vn/");
	}
	
    public void scanKeyBoard(){
    	
    	scanIn = new Scanner(System.in);
    	
    	// Tiến hành đọc tài khoản và mật khẩu từ bàn phím, ấn phím enter để kết thúc
    	try {
    	
    	System.out.println("Nhập username:");
    	username = new String(scanIn.nextLine());
    	
    	System.out.println("Nhập password:");
    	password = new String(scanIn.nextLine());
    	} catch (Exception e) {
    	System.out.println("Error!");
    	}
    }
    
    //HTTP GET request    
    public String sendGet() throws Exception {
    	  
        this.get = new Get();
        this.get.setUrl(url);
  
        // add request header
        this.get.setHeader("Host","sis.hust.edu.vn");
		this.get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; rv:50.0) Gecko/20100101 Firefox/50.0");
		this.get.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		this.get.setHeader("Accept-Language", "vi-VN,vi;q=0.8,en-US;q=0.5,en;q=0.3");
		this.get.setHeader("Accept-Encoding","UTF-8");
		this.get.setHeader("Referer","http://sis.hust.edu.vn/");
		this.get.setHeader("Cookie","_ga=GA1.3.1316060145.1481982529; ASP.NET_SessionId=1svmbfjdzy40a4dy4hobu3i5; _gat=1");
		this.get.setHeader("Connection","keep-alive");
		this.get.setHeader("Upgrade-Insecure-Requests","1");
		//this.get.setHeader("Content-Type","application/x-www-form-urlencoded");
        
		this.get.Send();
		this.get.Read();
        if(this.get.getResponseCode() != 200 && this.get.getResponseCode() != 302){
        	System.out.println("Lỗi mạng!");
        	System.exit(0);
        }
        this.src = this.get.srcPage;
        
        return this.src;
    }
    
    // HTTP POST request
    public void sendPost() throws Exception {
    	
    	this.post = new LoginPost();
    	
    	//Set header
    	this.post.setUrl("http://sis.hust.edu.vn/");
    	this.post.setHeader("Host","sis.hust.edu.vn");
    	this.post.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; rv:50.0) Gecko/20100101 Firefox/50.0");
    	this.post.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    	this.post.setHeader("Accept-Language", "vi-VN,vi;q=0.8,en-US;q=0.5,en;q=0.3");
    	this.post.setHeader("Accept-Encoding","gzip, deflate");
    	this.post.setHeader("Referer","http://sis.hust.edu.vn/");
    	this.post.setHeader("Connection","keep-alive");
    	this.post.setHeader("Upgrade-Insecure-Requests","1");
    	this.post.setHeader("Content-Type","application/x-www-form-urlencoded");
    	this.post.setHeader("Cookie","_ga=GA1.3.1316060145.1481982529; ASP.NET_SessionId=1svmbfjdzy40a4dy4hobu3i5; _gat=1");
    	
    	//Set parameters
    	this.post.setParam("__EVENTTARGET", "ctl00$cLogIn1$bt_cLogIn");
    	this.post.setParam("__EVENTARGUMENT", "Click");
    	this.post.setParam("__VIEWSTATE", "/wEPDwUKMjE0MzQwNjk4Mw9kFgJmD2QWAgIDD2QWBAIFD2QWAmYPPCsABAEADxYCHgVWYWx1ZQV7SOG7jWMga+G7syAyMDE2MSx0deG6p24gdGjhu6kgMTgsbmfDoHkgMTggdGjDoW5nIDEyIG7Eg20gMjAxNgpDaMO6bmcgdGEgY8OzIDExMiBraMOhY2ggdsOgIDMyOSB0aMOgbmggdmnDqm4gdHLhu7FjIHR1eeG6v24gZGQCBw9kFgJmD2QWAmYPPCsACQIADxYCHg5fIVVzZVZpZXdTdGF0ZWdkBg9kEBYBZhYBPCsADAEAFgIeCFNlbGVjdGVkZ2RkGAgFNGN0bDAwJE1haW5Db250ZW50JFRow7RuZyBiw6FvIGPhu6dhIGJhbiBRdeG6o24gdHLhu4sPFCsAB2RmZmZmZmhkBTRjdGwwMCRNYWluQ29udGVudCRUaMO0bmcgYsOhbyDEkcSDbmcga8O9IGjhu41jIHThuq1wDxQrAAdkZmZmZmZoZAUxY3RsMDAkTWFpbkNvbnRlbnQkVGjDtG5nIGLDoW8geMOpdCB04buRdCBuZ2hp4buHcA8UKwAHZGZmZmZmaGQFHGN0bDAwJE1haW5Db250ZW50JEzhu4tjaCB0aGkPFCsAB2RmZmZmZmhkBUJjdGwwMCRNYWluQ29udGVudCRUaMO0bmcgYsOhbyB4w6l0IG5o4bqtbiDEkeG7kyDDoW4gdOG7kXQgbmdoaeG7h3APFCsAB2RmZmZmZmhkBR5fX0NvbnRyb2xzUmVxdWlyZVBvc3RCYWNrS2V5X18WCQUXY3RsMDAkY0xvZ0luMSRidF9jTG9nSW4FGGN0bDAwJGNUb3BNZW51MSRVc2VyTWVudQUcY3RsMDAkTWFpbkNvbnRlbnQkTOG7i2NoIHRoaQU0Y3RsMDAkTWFpbkNvbnRlbnQkVGjDtG5nIGLDoW8gY+G7p2EgYmFuIFF14bqjbiB0cuG7iwU0Y3RsMDAkTWFpbkNvbnRlbnQkVGjDtG5nIGLDoW8gxJHEg25nIGvDvSBo4buNYyB04bqtcAVCY3RsMDAkTWFpbkNvbnRlbnQkVGjDtG5nIGLDoW8geMOpdCBuaOG6rW4gxJHhu5Mgw6FuIHThu5F0IG5naGnhu4dwBTFjdGwwMCRNYWluQ29udGVudCRUaMO0bmcgYsOhbyB4w6l0IHThu5F0IG5naGnhu4dwBTJjdGwwMCRNYWluQ29udGVudCRUaMO0bmcgYsOhbyB44butIGzDvSBo4buNYyB04bqtcAUXY3RsMDAkTWFpbkNvbnRlbnQkY3RsMDcFMmN0bDAwJE1haW5Db250ZW50JFRow7RuZyBiw6FvIHjhu60gbMO9IGjhu41jIHThuq1wDxQrAAdkZmZmZmZoZAUXY3RsMDAkTWFpbkNvbnRlbnQkY3RsMDcPFCsAB2RmZmZmZmhkmGD4ggr8stYSv9WLrdpqg95m0yLsB2AIqYuf8g538Ik=");
    	this.post.setParam("__VIEWSTATEGENERATOR", "CA0B0334");
    	this.post.setParam("__EVENTVALIDATION", "/wEdAAie+ZkGdQVYpJyJvHJfjpWGkbBvJ1h1zFdPA0dnBiNK+SlxNcPI2syDuR2JYSD1wB2lJGSXjsoggbbLr9g7drtLU38qeSLK/Lrg8/BlZ+zeFvU27kB1jR9leFspiaq91xccRVZZFLBI2uYsH+boOfhTduP2Li5D4O1sesuMb/2lvKpG1QrsBs0xaLO0dhrcNLihqpgJXWjSb+4nXJKpowhL");
    	this.post.setParam("ctl00$cLogIn1$tb_cLogIn_User", username);
    	this.post.setParam("ctl00$cLogIn1$tb_cLogIn_Pass", password);
    	this.post.setParam("ctl00$MainContent$Lịch thi", "0;3;5;0");
    	this.post.setParam("ctl00$MainContent$Thông báo của ban Quản trị", "0;3;17;0");
    	this.post.setParam("ctl00$MainContent$Thông báo đăng ký học tập", "0;3;20;0");
    	this.post.setParam("ctl00$MainContent$Thông báo xét nhận đồ án tốt nghiệp", "0;3;4;0");
    	this.post.setParam("ctl00$MainContent$Thông báo xét tốt nghiệp", "0;3;14;0");
    	this.post.setParam("ctl00$MainContent$Thông báo xử lý học tập", "0;3;6;0");
    	this.post.setParam("ctl00$MainContent$ctl07", "0;3;1;0");
    	this.post.setParam("DXScript", "1_145,1_81,1_137,1_99,1_106,1_92,1_130,1_135,1_121,1_126,1_84,1_124");
    	
    	this.post.Send();
    	this.post.Read();
    	
    	System.out.println(this.post.getResponseCode());
    	System.out.println(this.post.loginResult());
    	
    	
    }

    //Parse
    public void parse(String s) throws Exception{
		
		//Tao 1 doi tuong Document phan tich 1 String tra ve tu ham post()
		Document doc = Jsoup.parse(s);
		
		//Lấy header chứa tên sinh viên
		Element ele = doc.getElementById("site_header");
		
		//Tao 1 doi tuong Elements bao gom tat ca cac the tr
      	Elements eles = ele.select(">table>tbody>tr>td");
      	
      	Element td = eles.get(2);
      	
      	System.out.println(td.select("p").first().text().substring(0, 25));
	}
}