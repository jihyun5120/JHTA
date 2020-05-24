package c_control;

public class Lotto {
	private int n[] = new int[6]; //변수 1개에 여러 값을 넣으려면 배열을 사용. new로 만드는 순간 기본형x 참조형o
	int count = 0; //접근제한자를 사용하지 않았으므로 같은 패키지 안에서 count사용가능.
	
	void process() {
	    boolean b = false; //중복되지않았다.
		this.n[count] = (int)(Math.random()*45)+1;	//멤버형 변수는 앞에 this. 가 붙음.
	   
		for(int i=0 ;i<count;i++) {
			if(n[i]==n[count]) {
				b = true; //중복되었다.
			}
		}
	    
	    if(!b) { //중복되지않았다면	    	
	    	count++;
	    	prn(); // 같은 클래스에 있어서 k.이 안들어감.
	    }
	}
	
	void prn() {
		System.out.println(n[count-1]); // [count]만 넣으면 위에서 카운트가 증감되어 출력카운드값이랑 달라 오류가 생김.
	}                                   // [count-1]은 count값에서 -1 만 연산한것, [count--]는 count자체의 값을 1낮춘것.  
	
	public static void main(String[] args) { //static영역에서 선언된 것은 모두 static형.
		Lotto k = new Lotto();
		int a = 6;
		for(;k.count<a;) { // static영역에서 count앞에 k. 이니깐 멤버변수 --> 멤버변수영역을 살펴보기!
			k.process();
		}
		
// 중독되는 숫자가 나올 수 있음.
//		k.process(); k.prn();
//		k.process(); k.prn();
//		k.process(); k.prn();
//		k.process(); k.prn();
//		k.process(); k.prn();
//		k.process(); k.prn();
	}
}
