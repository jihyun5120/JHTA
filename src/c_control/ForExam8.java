/*
 * for���� ����Ͽ� �Ʒ��� �䱸 ������ ó���� �� �ֵ��� ���α׷� �Ͻÿ�. ��� ó���� ������ ForExam8()�ȿ��� ó���ϰ�, ������ Main.java���� �����Ͻÿ�.
 * 1~100������ ���� 1000���� �߻����� 
 * s1 : ���ڸ���(0~9)
 * s10 : 10�ڸ���(10~19)
 * s20 : 20�ڸ���(20~29)
 * s30 : 30�ڸ���(30~39)
 * ...
 * s90 : 90 �ڸ���(90~100)�� ������ ī��Ʈ�Ͽ� �Ʒ��� ��¿��ÿ� ���� ����Ͻÿ�.
 * ���ڸ� : xx��
 * 10�ڸ� : xx��
 * ...
 * 90�ڸ� : xx��
 */
package c_control;

public class ForExam8 {
	
	ForExam8(){
		int num = 0;
		int s1=0, s10=0, s20=0, s30=0, s40=0, s50=0, s60=0, s70=0, s80=0, s90=0;
		
		for(int i=1;i<=1000;i++) {
			num = (int)(Math.random()*100)+1;
			
			if(num<=9)       { s1++; } 
			else if(num<=19) { s10++; } 
			else if(num<=29) { s20++; } 
			else if(num<=39) { s30++; }
			else if(num<=49) { s40++; } 
			else if(num<=59) { s50++; }
			else if(num<=69) { s60++; }
			else if(num<=79) { s70++; }
			else if(num<=89) { s80++; }
			else             { s90++; }
		}
		System.out.println("���ڸ� : " + s1 + "��");
		System.out.println("10�ڸ� : " + s10 + "��");
		System.out.println("20�ڸ� : " + s20 + "��");
		System.out.println("30�ڸ� : " + s30 + "��");
		System.out.println("40�ڸ� : " + s40 + "��");
		System.out.println("50�ڸ� : " + s50 + "��");
		System.out.println("60�ڸ� : " + s60 + "��");
		System.out.println("70�ڸ� : " + s70 + "��");
		System.out.println("80�ڸ� : " + s80 + "��");
		System.out.println("90�ڸ� : " + s90 + "��");
	}
} 
