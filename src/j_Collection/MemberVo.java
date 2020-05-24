/*
 * Membermain, M
 */
package j_Collection;

//import java.text.MessageFormat;

public class MemberVo {
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
		
		return mid.hashCode() + phone.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj instanceof MemberVo) {
			MemberVo vo = (MemberVo)obj;
			if(vo.getMid().equals(mid) && vo.getPhone().equals(phone)) {
				result = true;
			}
		}
		return true;			
	}
	
	@Override
	public String toString() {
//		String str = "{0}\t, {1}\t, {2}\t, {3}\t \n";
//		MemberVo[] str1 = {mid, pwd, mNmae, phone};
//		String text = MessageFormat.format(str, str1);
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
