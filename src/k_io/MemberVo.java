/*
 * 
 */
package k_io;

import java.io.Serializable;


public class MemberVo implements Serializable{ //직렬화(저장, 전송) :  추상메소드가 존재X.
	public static long serialVerssionUID = 1L; //서로 다른 컴퓨터에서 컴파일하더라도 번호값이 같으면 동일한 컴퓨터에서 컴파일한 파일로 인식 --> 임의의 번호넣음.
	
	//우연한 해킹을 예방하기 위하여 필드는 private로 만드는 것이 좋음.
	private String mid;
	private String pwd;
	private String mNmae;
	private String phone;
	
	
	public MemberVo(String mid, String pwd, String mName, String phone){
		this.mid = mid;
		this.pwd = pwd;
		this.mNmae = mName;
		this.phone = phone;
	}
	
	@Override
	public int hashCode() {
		
		return mid.hashCode() + phone.hashCode(); //동등객체 판별(mid와 phone의 해쉬코드값이 같으면 같다) --> 서로 다른 두 객체가 같다는 말이X, 값이 같다는 말X.
	}
	
	@Override
	public boolean equals(Object obj) { //값이 같은 것을 판별.
		String find = (String)obj;
		boolean result = false;
			if(mid.indexOf(find) >=0 || mNmae.indexOf(find) >=0 ||phone.indexOf(find) >=0) { //문자의 일부분이 같으면. 같은부분이없으면 -1이 나옴.
				result = true;
			}
		
		return result;			
	}
	
	@Override
	public String toString() {
		return mid + "\t" + pwd + "\t" + mNmae + "\t" + phone + "\n";
	}
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getmNmae() {
		return mNmae;
	}

	public void setmNmae(String mNmae) {
		this.mNmae = mNmae;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
