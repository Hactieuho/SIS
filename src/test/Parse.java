package test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parse {

	public static void start(String s) throws Exception{
		
		//Tao 1 doi tuong Document phan tich 1 String tra ve tu ham post()
		Document doc = Jsoup.parse(s);
		
		//Lấy header chứa tên sinh viên
		Element ele = doc.getElementById("site_header");
		
		//Tao 1 doi tuong Elements bao gom tat ca cac the tr
      	Elements eles = ele.select(">table>tbody>tr");
      	
      	//Element td = eles.get(2);
      	System.out.println(eles.toString());
      	System.out.println(eles.attr("valign"));
      	
      	//Element p = td.select(">p").first();
      	
      	//System.out.println(p.text());
      	
      	/*int i = 1;
      	
      	//Lay ra tung the tr trong doi tuong elements
      	Element tr = trs.get(i);
      	while(true){
      		System.out.println(i);
      		try{
      			
      			//Lay ra tung the <tr>
      			tr = trs.get(i);
      			for(int j = 0; j < 5; j++){
      				
      				//Lay ra tung the <td> trong the <tr> dang xet
      				Element td = tr.select("td").get(j);
      				
      				//In text cua the <td> ra man hinh
      				String text = td.text();
      				System.out.print(text + "\t");
      			}
      			System.out.println();
      		}
      		catch(IndexOutOfBoundsException e){
      			
      			//Khi khong lay duoc the tr nao nua thi ket thuc ct
      			System.out.println("End");
      			break;
      		}
      		i++;
      	}*/
	}
}
