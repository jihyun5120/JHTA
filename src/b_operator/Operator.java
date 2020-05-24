/*
 * 작성일자 : 2019.11
 * 작성자 : 최지현
 * 각종 연산자에 대한 샘플
 */
package b_operator;

public class Operator {
	Operator(){
		// 나머지 연산자
		System.out.println("12%5 => " + (12%5));
		
		//나머지 연산자와 삼항 연산자
		int n = 122;
		
	    String r = (n%2==0)?"짝수":"홀수";
	    System.out.println(n + " ==> " + r);
	    
	    //증감 연산자
	    //전치/후치
	    int a = 10;
	    int b = 10;
	    
	    a++;
	    ++b;
	    System.out.println(a + "," + b);
	    
	    int c = a++; //후치 : 다항에서는 대입 후 증감함, 단항에서는 전치/후치 같음.
	    int d = ++b; //전치 : 증감한 후 대입.
	    System.out.println(c + "," + d);
	    System.out.println(a + "," + b);
	    
	    //문자열 비교연산자
	    String name = "박";
	    String irum = "박"; //문자열이 name가 같아 같은 객체주소를 사용.
	    String irum2 = new String("박"); //new가 붙으면 같은 문자열인것과 관계없이 하나의 객체를 생성함.
	    
	    System.out.println(name==irum); //객체주소가 같아 true.
	    System.out.println(name==irum2); //다른 객체로 false.
	    
	    System.out.println(name.equals(irum));//equals : 객체주소를 상관하지않고 문자열이 같은지만 확인.
	    System.out.println(name.equals(irum2));  
	}
	
	public static void main(String[] args) {
	new Operator();	//new뒤에는 항상 생성자명만 온다.
	}
}
