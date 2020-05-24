/*
 * 
 */
package k_io;

import java.io.Serializable;


public class MemberVo implements Serializable{ //����ȭ(����, ����) :  �߻�޼ҵ尡 ����X.
	public static long serialVerssionUID = 1L; //���� �ٸ� ��ǻ�Ϳ��� �������ϴ��� ��ȣ���� ������ ������ ��ǻ�Ϳ��� �������� ���Ϸ� �ν� --> ������ ��ȣ����.
	
	//�쿬�� ��ŷ�� �����ϱ� ���Ͽ� �ʵ�� private�� ����� ���� ����.
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
		
		return mid.hashCode() + phone.hashCode(); //���ü �Ǻ�(mid�� phone�� �ؽ��ڵ尪�� ������ ����) --> ���� �ٸ� �� ��ü�� ���ٴ� ����X, ���� ���ٴ� ��X.
	}
	
	@Override
	public boolean equals(Object obj) { //���� ���� ���� �Ǻ�.
		String find = (String)obj;
		boolean result = false;
			if(mid.indexOf(find) >=0 || mNmae.indexOf(find) >=0 ||phone.indexOf(find) >=0) { //������ �Ϻκ��� ������. �����κ��̾����� -1�� ����.
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
