package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity  ;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@SuppressWarnings("deprecation")
public class LoginSIS {
	
	private static String src;
	private HttpClient client;
	
	private static String username = "";
	private static String password = "";
	private static Scanner scanIn;
	private static int responsecode;
	
    public static void main(String[] args) throws Exception {
  
        LoginSIS http = new LoginSIS();
        scanKeyBoard();
        http.sendPost();
        http.sendGet();
        LoginSIS.parse(src);
    }
    
    public static void scanKeyBoard(){
    	
    	scanIn = new Scanner(System.in);
    	// Tiến hành đọc từ bàn phím, ấn phím enter để kết thúc
    	try {
    	System.out.println("Nhập username:");
    	username = scanIn.nextLine();
    	System.out.println("Nhập password:");
    	password = scanIn.nextLine();
    	} catch (Exception e) {
    	System.out.println("Error!");
    	}
    }
    
    //HTTP GET request    
    private void sendGet() throws Exception {
    	  
        String url = "http://sis.hust.edu.vn/";
  
        client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
  
        // add request header
        request.setHeader("Host","sis.hust.edu.vn");
		request.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; rv:50.0) Gecko/20100101 Firefox/50.0");
		request.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		request.setHeader("Accept-Language", "vi-VN,vi;q=0.8,en-US;q=0.5,en;q=0.3");
		
		//Doan code nay se cho ra ma nguon website bi loi encode:
		request.setHeader("Accept-Encoding","UTF-8");
		
		request.setHeader("Referer","http://sis.hust.edu.vn/");
		request.setHeader("Cookie","_ga=GA1.3.1316060145.1481982529; ASP.NET_SessionId=1svmbfjdzy40a4dy4hobu3i5; _gat=1");
		request.setHeader("Connection","keep-alive");
		request.setHeader("Upgrade-Insecure-Requests","1");
		//request.setHeader("Content-Type","application/x-www-form-urlencoded");
        
        HttpResponse response = client.execute(request);
  
        BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        
        responsecode = response.getStatusLine().getStatusCode();
        if(responsecode != 200 && responsecode != 302){
        	System.out.println("Lỗi mạng!");
        	System.exit(0);
        }
        
        StringBuffer result = new StringBuffer();
        String line = "";
        
        while ((line = rd.readLine()) != null) {
        	
        	result.append(line + '\n');
        }
        
        rd.close();
        
        src = result.toString();
    }
    
    // HTTP POST request
    private void sendPost() throws Exception {
  
        String url = "http://sis.hust.edu.vn/";
  
        client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
		 
        // add header
		post.setHeader("Host","sis.hust.edu.vn");
		post.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; rv:50.0) Gecko/20100101 Firefox/50.0");
		post.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		post.setHeader("Accept-Language", "vi-VN,vi;q=0.8,en-US;q=0.5,en;q=0.3");
		
		//Doan code nay se cho ra ma nguon website bi loi encode:
		post.setHeader("Accept-Encoding","gzip, deflate");
		
		post.setHeader("Referer","http://sis.hust.edu.vn/");
		post.setHeader("Connection","keep-alive");
		post.setHeader("Upgrade-Insecure-Requests","1");
		post.setHeader("Content-Type","application/x-www-form-urlencoded");
		post.setHeader("Cookie","_ga=GA1.3.1316060145.1481982529; ASP.NET_SessionId=1svmbfjdzy40a4dy4hobu3i5; _gat=1");
		
		//Tham số
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("__EVENTTARGET", "ctl00$cLogIn1$bt_cLogIn"));
        urlParameters.add(new BasicNameValuePair("__EVENTARGUMENT", "Click"));
        urlParameters.add(new BasicNameValuePair("__VIEWSTATE", "/wEPDwUKMjE0MzQwNjk4Mw9kFgJmD2QWAgIDD2QWBAIFD2QWAmYPPCsABAEADxYCHgVWYWx1ZQV7SOG7jWMga+G7syAyMDE2MSx0deG6p24gdGjhu6kgMTgsbmfDoHkgMTggdGjDoW5nIDEyIG7Eg20gMjAxNgpDaMO6bmcgdGEgY8OzIDExMiBraMOhY2ggdsOgIDMyOSB0aMOgbmggdmnDqm4gdHLhu7FjIHR1eeG6v24gZGQCBw9kFgJmD2QWAmYPPCsACQIADxYCHg5fIVVzZVZpZXdTdGF0ZWdkBg9kEBYBZhYBPCsADAEAFgIeCFNlbGVjdGVkZ2RkGAgFNGN0bDAwJE1haW5Db250ZW50JFRow7RuZyBiw6FvIGPhu6dhIGJhbiBRdeG6o24gdHLhu4sPFCsAB2RmZmZmZmhkBTRjdGwwMCRNYWluQ29udGVudCRUaMO0bmcgYsOhbyDEkcSDbmcga8O9IGjhu41jIHThuq1wDxQrAAdkZmZmZmZoZAUxY3RsMDAkTWFpbkNvbnRlbnQkVGjDtG5nIGLDoW8geMOpdCB04buRdCBuZ2hp4buHcA8UKwAHZGZmZmZmaGQFHGN0bDAwJE1haW5Db250ZW50JEzhu4tjaCB0aGkPFCsAB2RmZmZmZmhkBUJjdGwwMCRNYWluQ29udGVudCRUaMO0bmcgYsOhbyB4w6l0IG5o4bqtbiDEkeG7kyDDoW4gdOG7kXQgbmdoaeG7h3APFCsAB2RmZmZmZmhkBR5fX0NvbnRyb2xzUmVxdWlyZVBvc3RCYWNrS2V5X18WCQUXY3RsMDAkY0xvZ0luMSRidF9jTG9nSW4FGGN0bDAwJGNUb3BNZW51MSRVc2VyTWVudQUcY3RsMDAkTWFpbkNvbnRlbnQkTOG7i2NoIHRoaQU0Y3RsMDAkTWFpbkNvbnRlbnQkVGjDtG5nIGLDoW8gY+G7p2EgYmFuIFF14bqjbiB0cuG7iwU0Y3RsMDAkTWFpbkNvbnRlbnQkVGjDtG5nIGLDoW8gxJHEg25nIGvDvSBo4buNYyB04bqtcAVCY3RsMDAkTWFpbkNvbnRlbnQkVGjDtG5nIGLDoW8geMOpdCBuaOG6rW4gxJHhu5Mgw6FuIHThu5F0IG5naGnhu4dwBTFjdGwwMCRNYWluQ29udGVudCRUaMO0bmcgYsOhbyB4w6l0IHThu5F0IG5naGnhu4dwBTJjdGwwMCRNYWluQ29udGVudCRUaMO0bmcgYsOhbyB44butIGzDvSBo4buNYyB04bqtcAUXY3RsMDAkTWFpbkNvbnRlbnQkY3RsMDcFMmN0bDAwJE1haW5Db250ZW50JFRow7RuZyBiw6FvIHjhu60gbMO9IGjhu41jIHThuq1wDxQrAAdkZmZmZmZoZAUXY3RsMDAkTWFpbkNvbnRlbnQkY3RsMDcPFCsAB2RmZmZmZmhkmGD4ggr8stYSv9WLrdpqg95m0yLsB2AIqYuf8g538Ik="));
        urlParameters.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", "CA0B0334"));
        urlParameters.add(new BasicNameValuePair("__EVENTVALIDATION", "/wEdAAie+ZkGdQVYpJyJvHJfjpWGkbBvJ1h1zFdPA0dnBiNK+SlxNcPI2syDuR2JYSD1wB2lJGSXjsoggbbLr9g7drtLU38qeSLK/Lrg8/BlZ+zeFvU27kB1jR9leFspiaq91xccRVZZFLBI2uYsH+boOfhTduP2Li5D4O1sesuMb/2lvKpG1QrsBs0xaLO0dhrcNLihqpgJXWjSb+4nXJKpowhL"));
        urlParameters.add(new BasicNameValuePair("ctl00$cLogIn1$tb_cLogIn_User", username));
        urlParameters.add(new BasicNameValuePair("ctl00$cLogIn1$tb_cLogIn_Pass", password));
        urlParameters.add(new BasicNameValuePair("ctl00$MainContent$Lịch thi", "0;3;5;0"));
        urlParameters.add(new BasicNameValuePair("ctl00$MainContent$Thông báo của ban Quản trị", "0;3;17;0"));
        urlParameters.add(new BasicNameValuePair("ctl00$MainContent$Thông báo đăng ký học tập", "0;3;20;0"));
        urlParameters.add(new BasicNameValuePair("ctl00$MainContent$Thông báo xét nhận đồ án tốt nghiệp", "0;3;4;0"));
        urlParameters.add(new BasicNameValuePair("ctl00$MainContent$Thông báo xét tốt nghiệp", "0;3;14;0"));
        urlParameters.add(new BasicNameValuePair("ctl00$MainContent$Thông báo xử lý học tập", "0;3;6;0"));
        urlParameters.add(new BasicNameValuePair("ctl00$MainContent$ctl07", "0;3;1;0"));
        urlParameters.add(new BasicNameValuePair("DXScript", "1_145,1_81,1_137,1_99,1_106,1_92,1_130,1_135,1_121,1_126,1_84,1_124"));
        //urlParameters.add(new BasicNameValuePair("", ""));
        
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
  
        HttpResponse response = client.execute(post);
  
        BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        
        
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line + '\n');
        }
        
        String srcpage = result.toString();
        LoginCheck lc = new LoginCheck(srcpage);
        
        if(!lc.LoginResult()){

    	   	System.out.println("Sai username hoặc password");
        	System.exit(0);
        }
        
        rd.close();
    }

    //Parse
    public static void parse(String s) throws Exception{
		
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