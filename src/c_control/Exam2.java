/*
 * ����2) Exam2.java
 * 1. ����Ÿ��� ���� �ýÿ���� ����Ͽ� ���.
 * 2. �⺻ 2000mm ������ �⺻����� 3000��.
 * 3. 200mm�� �߰���� 500���� ���ݵ�.
 * 4. ���� �մ��� ����Ÿ��� 4530mm�� ��� �ý� ����� ����Ͻÿ�.
 * - �⺻�Ÿ� : base
 * - �⺻��� : basePrice
 * - ����Ÿ� : totM
 * - �߰��Ÿ� : m
 * - �߰���� :mPrice
 * - �ѱݾ� : totPrice
 */

package c_control;

public class Exam2 {
	Exam2(){
		int base = 2000; // �⺻�Ÿ�
		int basePrice = 3000; //�⺻���
		int totM = 4350; //����Ÿ�
		int m = totM-base; //�߰��Ÿ�
		int mPrice = 500; //�߰����
		int totPrice = 0; //�ѱݾ�
		
		if(m>0) {
			int v = m/200;
			if(m%200>0) {
				v++;				
			}
		    totPrice = basePrice + (mPrice*v);
		}else {
			totPrice = 3000;
		}
		System.out.println(totPrice + "��");

// �ؿ� �ڵ��� 2200�� ��°��� ����������.		
//		int base = 2000; // �⺻�Ÿ�
//		int basePrice = 3000; //�⺻���
//		int totM = 4350; //����Ÿ�
//		int m = totM-base; //�߰��Ÿ�
//		int mPrice = 500; //�߰����
//		int totPrice = basePrice+(m/200)*mPrice+mPrice; //�ѱݾ�
//		
//		if(m>0) {
//			if(m%200>0) {System.out.println(totPrice + "��");}
//		} else { System.out.println(basePrice + "��"); }
	}
	public static void main(String[] args) {
		new Exam2();
	}
}
