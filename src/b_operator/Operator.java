/*
 * �ۼ����� : 2019.11
 * �ۼ��� : ������
 * ���� �����ڿ� ���� ����
 */
package b_operator;

public class Operator {
	Operator(){
		// ������ ������
		System.out.println("12%5 => " + (12%5));
		
		//������ �����ڿ� ���� ������
		int n = 122;
		
	    String r = (n%2==0)?"¦��":"Ȧ��";
	    System.out.println(n + " ==> " + r);
	    
	    //���� ������
	    //��ġ/��ġ
	    int a = 10;
	    int b = 10;
	    
	    a++;
	    ++b;
	    System.out.println(a + "," + b);
	    
	    int c = a++; //��ġ : ���׿����� ���� �� ������, ���׿����� ��ġ/��ġ ����.
	    int d = ++b; //��ġ : ������ �� ����.
	    System.out.println(c + "," + d);
	    System.out.println(a + "," + b);
	    
	    //���ڿ� �񱳿�����
	    String name = "��";
	    String irum = "��"; //���ڿ��� name�� ���� ���� ��ü�ּҸ� ���.
	    String irum2 = new String("��"); //new�� ������ ���� ���ڿ��ΰͰ� ������� �ϳ��� ��ü�� ������.
	    
	    System.out.println(name==irum); //��ü�ּҰ� ���� true.
	    System.out.println(name==irum2); //�ٸ� ��ü�� false.
	    
	    System.out.println(name.equals(irum));//equals : ��ü�ּҸ� ��������ʰ� ���ڿ��� �������� Ȯ��.
	    System.out.println(name.equals(irum2));  
	}
	
	public static void main(String[] args) {
	new Operator();	//new�ڿ��� �׻� �����ڸ� �´�.
	}
}
