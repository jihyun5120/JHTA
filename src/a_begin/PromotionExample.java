package a_begin;

public class PromotionExample {
	int a = 80;
	int b = 90;
	int c = 50;
	//c = a+b; Ŭ������ҿ��� �ʵ�� �޼ҵ尡 �ִ�. �ʵ忡�� �ʵ弱�� �ش�Ǵµ� �����ڰ� ���⶧���� �����߻� --> �޼ҵ� �������� ���� ��.
	
	// �����ڷ� �ҷ����� �޼ҵ�.(�����ڷ� �ҷ������� �ݵ�� Ŭ������� �����ؾ� ��), ������ �տ��� ȣ���ɾ�?�� ����x.
	//void PromotionExample1(){} Ŭ���� ��� �ٸ��� �Ϲݸ޼ҵ忩�� �տ� ȣ���ɾ�?�� �ʿ���.
	PromotionExample(){
		c = a+b;
		System.out.println(c);
		
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println(intValue);
		
		char charValue = '��';
		intValue = charValue;
		System.out.println("���������ڵ�=" + intValue);
		
		intValue = 500;
		long longValue = intValue;
		System.out.println(longValue);
		
		intValue = 200;
		double doubleValue = intValue;
		System.out.println(doubleValue);
	}
	
	public static void main(String[] args) { //Ŭ���� �ȿ� ����Ǿ�������, Ŭ�����ʹ� ���� ���x. static�� ������ �޸𸮿� ���� ���� �ö�.
		new PromotionExample();
	}
	
}
