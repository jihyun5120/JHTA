package semishit;

import java.util.Date;
import java.text.SimpleDateFormat;


public class JoinVo {
	  int eno ;
	  String mId;
	  String pwd;
	  String mName;
	 String pwdQu;
	  String pwdAn;
	 
	  
	
	
	
	
	public JoinVo() { }
	
	public JoinVo(int eno,String mN,String mI,String pw, String pQ,String pA) {
				
		this.eno = eno;
		this.mName = mN;
		this.mId = mI;
		this.pwd = pw;
		this.pwdQu = pQ;
		this.pwdAn = pA;
		
		
	}
	
	
	
	
	

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}
	
	

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdQu() {
		return pwdQu;
	}

	public void setPwdQu(String pwdQu) {
		this.pwdQu = pwdQu;
	}

	public String getPwdAn() {
		return pwdAn;
	}

	public void setPwdAn(String pwdAn) {
		this.pwdAn = pwdAn;
	}
	


	

		
	
	
	

}
