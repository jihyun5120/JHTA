/*
 *  ����1) 
 * 1. Student Ŭ���� �ۼ�
 *  2. �Ű������� ���� �����ڷ� ��ü�� �����ϸ� �̸�, �ּ�, ����ó�� "ȫ�浿", "���α�", "010-1111-1111"���� �ʵ带 �ʱ�ȭ�Ͻÿ�.
 *    (irum, address. phone)
 * 3. �̸��� �Ķ���ͷ� �����ϸ� ���޵� �̸��� �ʵ忡 ����Ǵ� �����ڸ� �ߺ� ���� �Ͻÿ�.
 * 4. �̸�, �ּ�, ����ó�� �Ķ���͸� �����ϸ� ��� ���� �ʵ忡 �����ϴ� �����ڸ� �ߺ� ���� �Ͻÿ�.
 * 5. main()�� �ۼ��Ͽ� ���� �䱸 ������ ó���Ǵ����� �׽�Ʈ �Ͻÿ�.
 */
package e_class;

public class Student {
	String irum;
	String address;
	String phone;
	
	Student(){
		this.irum = "ȫ�浿";
		this.address = "���α�";
		this.phone = "010-1111-1111";
	}
	Student(String irum){
		this.irum = irum;
	}
	Student(String irum, String address, String phone){
		this.irum = irum;
		this.address = address;
		this.phone = phone;
	}
	
	void prn() {
		System.out.println("�̸� : " + this.irum + "\n�ּ� : " + this.address + "\n����ó : "  + this.phone);
		System.out.println("--------------------");
	}
	
	public static void main(String[] args) {
		Student st1 = new Student();
		st1.prn();
		
		Student st2 = new Student("������");
		st2.prn();
		
		Student st3 = new Student("�ö���", "���빮��", "010-0000-0000");
		st3.prn();
	
		
		
	}
}
