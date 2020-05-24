package c_control;

public class IfExample {
	
	public static void main(String[] args) { //static이 붙어있는 멤버는 정적형멤버, 붙어있지 않은 멤버들은 instance형(객체형, object형)
		IfExample obj = new IfExample(); //<--IfExample형(참조형)JVM이 매개변수가 없는 생성자를 임대.(클래스명 객체명 = new 생성자명)
		int k = obj.type1(); //메소드 호출.
//		System.out.println(k); //0 출력.
//		System.out.println(obj.type1()); //type1()에 있는 내용 모두 출력.
		
		String m = obj.type2();
		System.out.println(m);
		
		char c = obj.type3(); //가공할 필요가 있으면 변수에 담아 출력.
		System.out.println(c);  
//		System.out.println(obj.type3()); 가공할 필요가 없으면 그냥 바로 출력.
		
		obj.type4();
	}
	
	//if문
	int type1() { 
		int r = 0;
		int score = 93;
		
		if(score>=90) {
			System.out.println("점수가 90점 이상입니다.");
			System.out.println("등급은 A입니다.");
		}
		
		if(score<90) 
			System.out.println("점수가 90점 미만입니다.");
			System.out.println("등급은 B입니다."); //if문에 중괄호가 없어서 항상 실행됨.
		
		return r; //return은 한 메소드 당 1개만 사용가능. 맨마지막에. return에 오면 자신을 호출한 곳으로 되돌아감.
	}
	
	//null : 주소가 없다.
	String type2() { 
		String r = null; 
		int score = 89;
		
		if(score>=90) {
			r = "점수가 90이상이다.";
			r += "\nA등급이다.";
		} else {
			r = "점수가 90미만이다.";
			r += "\nB등급이다.";
		}
		
		return r;
	}
	
	/*
	 * 성적을 if-else if를 사용하여 학점을 구하여 r에 저장하시오.(F학점까지)
	 */
	char type3() {
		char r = ' '; 
		int score = 77;
		
		if(score>=90) {
			r = 'A';
		} else if(score>=80) {
			r = 'B';
		} else if(score>=70) {
			r = 'C';
		} else if(score>=60) {
			r = 'D';
		} else {
			r = 'F';
		}
		
		return r;
    }
	
	/*
	 * 성적이 0~100점일 때만 60이상이면 '합격', 60미만이면 '불합격'을 출력하고, 성적이 범위 밖이면 '성적오류'를 출력하시오.
	 */
	void type4(){ //void쓰면 처리된 값에 반환할 값이 없다는 뜻으로, return을 사용하지 않아도 됨.
		int score = 70;
		String result = "";
		
		if(score>=0 && score<=100) {
			if(score>=60) {
			result = "합격";
			} else {
			result = "불합격";
			}
		} else {
			result = "성적오류";
		}
		System.out.println(result);
	}
}
