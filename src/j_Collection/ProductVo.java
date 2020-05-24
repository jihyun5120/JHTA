package j_Collection;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductVo {
	private String serial; // yyyyy-MM-dd-serial
	private String pCode; // ��ǰ�ڵ�
	private String pName; // ��ǰ��
	private int ea; // ����
	private Date nal; // �԰�, �������

	public ProductVo() {} // ��������ʾƵ� �Ű��������� �����ڵ� ������ ��(��ü�� ������ �� �ڹٿ��� �ڵ����� ���������X)

	public ProductVo(String s, String pC, String pN, int ea, Date nal) {
		this.serial = s;
		this.pCode = pC;
		this.pName = pN;
		this.ea = ea;
		this.nal = nal;
	}

	@Override
	public int hashCode() { //hash�� ����ϸ� hash�� equals �������̵��� �ʼ�.
		return this.serial.hashCode();
	}

	@Override
	public boolean equals(Object obj) { // ����Ǿ� �ִ� �Ϳ��� �˻��� �Ͱ� ���� ���� �̾Ƴ��� ����(equals ������ ��ɰ� �ణ ������ ����)
		boolean result = false;
		if (obj instanceof ProductVo) {
			ProductVo vo = (ProductVo) obj;

			// �� ���� �� �Ϻκ� ���� ���ڰ� �ִ� ���� �̾Ƴ�.
			result = this.serial.indexOf(vo.getSerial()) > -1 || this.pCode.indexOf(vo.getpCode()) > -1
					|| this.pName.indexOf(vo.getpName()) > -1;

			// �� ���ڰ� ��� �´� �͸� �̾Ƴ�.
//			 result = vo.getSerial().equals(this.serial) ||
//					  vo.getpCode().equals(this.pCode) ||
//					  vo.getpName().equals(this.pName);
		}
		return result;
	}

	@Override
	public String toString() { //��µ� ���¸� �̸� ������ ���� toString�� ������ �ϴ� ���� ����.	
		DecimalFormat df = new DecimalFormat("#,###,###");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");

		String tempEa = df.format(this.ea);
		String tempDate = sdf.format(this.nal);

		String temp = String.format("%s\t%s\t%s\t%s\t%s\n", this.serial, this.pCode, this.pName, tempEa, tempDate);
		return temp;
	}

	// private���� getter, setter�� ���� �ٸ� ������ �� �� �ֵ��� �ؾ���.
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
