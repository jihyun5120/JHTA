package a_begin;

public class PromotionExample {
	int a = 80;
	int b = 90;
	int c = 50;
	//c = a+b; 클래스요소에는 필드와 메소드가 있다. 필드에는 필드선언만 해당되는데 연산자가 들어갔기때문에 오류발생 --> 메소드 영역으로 들어가야 함.
	
	// 생성자로 불려지는 메소드.(생성자로 불려지려면 반드시 클래스명과 동일해야 함), 생성자 앞에는 호출명령어?가 붙지x.
	//void PromotionExample1(){} 클래스 명과 다르면 일반메소드여서 앞에 호출명령어?가 필요함.
	PromotionExample(){
		c = a+b;
		System.out.println(c);
		
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println(intValue);
		
		char charValue = '가';
		intValue = charValue;
		System.out.println("가의유니코드=" + intValue);
		
		intValue = 500;
		long longValue = intValue;
		System.out.println(longValue);
		
		intValue = 200;
		double doubleValue = intValue;
		System.out.println(doubleValue);
	}
	
	public static void main(String[] args) { //클래스 안에 선언되어있지만, 클래스와는 전혀 상관x. static이 붙으면 메모리에 가장 먼저 올라감.
		new PromotionExample();
	}
	
}
