package j_Collection;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductVo {
	private String serial; // yyyyy-MM-dd-serial
	private String pCode; // 제품코드
	private String pName; // 제품명
	private int ea; // 수량
	private Date nal; // 입고, 출고일자

	public ProductVo() {} // 사용하지않아도 매개변수없는 생성자도 만들어야 함(객체가 생성될 때 자바에서 자동으로 만들어주지X)

	public ProductVo(String s, String pC, String pN, int ea, Date nal) {
		this.serial = s;
		this.pCode = pC;
		this.pName = pN;
		this.ea = ea;
		this.nal = nal;
	}

	@Override
	public int hashCode() { //hash를 사용하면 hash와 equals 오버라이딩은 필수.
		return this.serial.hashCode();
	}

	@Override
	public boolean equals(Object obj) { // 저장되어 있는 것에서 검색한 것과 같은 것을 뽑아내기 위해(equals 본연의 기능과 약간 가르게 설정)
		boolean result = false;
		if (obj instanceof ProductVo) {
			ProductVo vo = (ProductVo) obj;

			// 쓴 문자 중 일부분 같은 문자가 있는 것을 뽑아냄.
			result = this.serial.indexOf(vo.getSerial()) > -1 || this.pCode.indexOf(vo.getpCode()) > -1
					|| this.pName.indexOf(vo.getpName()) > -1;

			// 쓴 문자가 모두 맞는 것만 뽑아냄.
//			 result = vo.getSerial().equals(this.serial) ||
//					  vo.getpCode().equals(this.pCode) ||
//					  vo.getpName().equals(this.pName);
		}
		return result;
	}

	@Override
	public String toString() { //출력된 형태를 미리 설정할 때는 toString을 재정의 하는 것이 좋음.	
		DecimalFormat df = new DecimalFormat("#,###,###");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");

		String tempEa = df.format(this.ea);
		String tempDate = sdf.format(this.nal);

		String temp = String.format("%s\t%s\t%s\t%s\t%s\n", this.serial, this.pCode, this.pName, tempEa, tempDate);
		return temp;
	}

	// private여서 getter, setter을 만들어서 다른 곳에서 쓸 수 있도록 해야함.
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
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

	public Date getNal() {
		return nal;
	}

	public void setNal(Date nal) {
		this.nal = nal;
	}
}
