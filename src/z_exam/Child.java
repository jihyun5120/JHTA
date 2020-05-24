package z_exam;

public class Child extends MyClass{
	//다형성을 사용하는 이유 : 여러형태의 자식클래스가 파생되어 생성되었을 때 부모타입의 매개변수를 갖는 메소드 하나만으로 모든 자식클래스를
	//전달받아 사용하기 위해서.
	public MyClass method1(MyClass mc) {
		MyClass m = new MyClass();
		return m;
	}
	
	public Child method2(Child c) {
		Child myC = new Child();
		return myC;
	}
	
	public static void main(String[] args) {
		MyClass mc = new Child(); //다형성의 가장 기본적인 형태.
		Child c = (Child)mc;
		
		Child c2 = new Child(); //c가 가지고 있는 것과 똑같이 나오지만 다형성은X.
	
		c2.method1(mc); //MyClass mc = mc; ,  MyClass mc = c2;(O) 부모타입에는 자식타입의 변수를 넣을 수O.
						//MyClass mc=mc; -> MyClass mc = new Child(); : mc가  new Child()로 만들어짐.
		c2.method1(c);  //MyClass mc=c; -> MyClass mc = new Child(); : 결국은 new Child()로 만들어짐.
					    //method1의 매개변수 타입이 MyClass이기 때문에 MyClass에 변수 mc와 c 사용가능.
		
		//c2.method2(mc); //Child c = mc;(X) 자식타입의 매개변수에 부모타입의 변수를 넣을 수X.
		c2.method2(c);
	}
}
