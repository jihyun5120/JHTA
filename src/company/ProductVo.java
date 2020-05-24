package company;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductVo {
   String imName; //��ǰ ������
   String pId; //PK, ��ǰ�ڵ�
   String pName; //NN, ��ǰ��
   int ea; //NN, ����
   Date iDate; //NN, ���Գ�¥
   int price; //NN, ����
   String note; //Ư�̻���
   String imPath; //��ǰ ���� ��������
   int totPrice; //���� * ����
   public ProductVo() {}
   public ProductVo(String imPath, String imName, String pId, String pName, int ea, Date iDate, int price, String note, int totPrice) {
	  this.imPath = imName;
      this.imName = imName; 
      this.pId = pId;
      this.pName = pName;
      this.ea = ea;
      this.iDate = iDate;
      this.price = price;
      this.note = note; 
      this.totPrice = totPrice;
   }
   
public String toString() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
      String date = sdf.format(iDate);
      DecimalFormat df = new DecimalFormat("#,###,###");
      String pri = df.format(price);
      
      if(note==null) {
         note = "";
      }
  
      String str = String.format("%10s\t%15s\t%10d\t%10s\t%15s\t%30s\n", pId, pName, ea, date, price, note);
      return str;
   }
   
   public String getImName() {
      return imName;
   }   
   public void setImName(String imName) {
      this.imName = imName;
   }
   public String getImPath() {
	      return imPath;
   }
   public void setImPath(String imPath) {
	  this.imPath = imPath;
   }
   public String getpId() {
      return pId;
   }
   public void setpId(String pId) {
      this.pId = pId;
   }
   public String getpName() {
      return pName;
   }
   public void setpName(String pName) {
      this.pName = pName;
   }
   public int getEa() {
      return ea;
   }
   public void setEa(int ea) {
      this.ea = ea;
   }
   public Date getiDate() {
      return iDate;
   }
   public void setiDate(Date iDate) {
      this.iDate = iDate;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public String getNote() {
      return note;
   }
   public void setNote(String note) {
      this.note = note;
   }
   public int getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(int totPrice) {
		this.totPrice = totPrice;
	}
}