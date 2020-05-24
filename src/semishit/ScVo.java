package semishit;

import java.util.Date;

public class ScVo {
	
	int sno;
	String name;
	String sub;
	int sco;
	String pass;
	String nTry;
	Date rDate;
	
	public ScVo(){
		
	}
	

	public ScVo(int sno, String name, String sub, int sco, String pass, String nTry, Date rdate) {
		
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public int getSco() {
		return sco;
	}
	public void setSco(int sco) {
		this.sco = sco;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getnTry() {
		return nTry;
	}
	public void setnTry(String nTry) {
		this.nTry = nTry;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
}
