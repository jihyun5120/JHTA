package semishit;

import java.util.Date;

public class StuVo {

	int sno;
	String sname;
	Date sbirth;
	String saddress;
	String sphone;
	String semail;
	String smale;
	int eno; // 강사코드
	String imname;
	String impath;
	
	public String getImname() {
		return imname;
	}


	public void setImname(String imname) {
		this.imname = imname;
	}


	public String getImpath() {
		return impath;
	}


	public void setImpath(String impath) {
		this.impath = impath;
	}


	public StuVo() {
	}
	
	public StuVo(int no, String name, Date birth, String address, String phone, String email, String male, int eno, String iname, String ipath) {
		this.sno = no;
		this.sname = name;
		this.sbirth = birth; 
		this.saddress = address;
		this.sphone = phone;
		this.semail= email;
		this.smale = male; 
		this.eno = eno;
		this.imname = iname;
		this.impath = ipath;
	}


	public int getEno() {
		return eno;
	}


	public void setEno(int eno) {
		this.eno = eno;
	}


	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public Date getSbirth() {
		return sbirth;
	}


	public void setSbirth(Date sbirth) {
		this.sbirth = sbirth;
	}


	public String getSaddress() {
		return saddress;
	}


	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}


	public String getSphone() {
		return sphone;
	}


	public void setSphone(String sphone) {
		this.sphone = sphone;
	}


	public String getSemail() {
		return semail;
	}


	public void setSemail(String semail) {
		this.semail = semail;
	}


	public String getSmale() {
		return smale;
	}


	public void setSmale(String smale) {
		this.smale = smale;
	}
}
