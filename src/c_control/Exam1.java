/*
 * 예제1) Exam1.java
 * 1. 모든 처리는 생성자를 사용하여 해결.
 * 2. 성명, 주소, 연락처가 문자열로 발생한다. 각각의 데이터를 name, address, phone에 저장.
 * 3. 성적이 정수형으로 발생하여 각각 kor, eng, mat에 저장함.
 * 4. 저장된 성적을 사용하여 총점, 평균을 tot, avg에 저장함.
 * 5. if~else if문을 사용하여 평균값을 사용하여 학점을 구해서 문자형 변수 grade에 저장.
 * 6. 처리된 모든 내용을 표준 출력 장치에 출력.
 * [출력결과]
 * ----------------------
 * 성적 처리 결과
 * ----------------------
 * 성명 : xxx
 * 주소 : xxx
 * 연락처 : xxx
 * 국어 : xx
 * 영어 : xx
 * 수학 : xx
 * 총점 : xx
 * 평균 : xx
 * 학점 : x
 * ----------------------
 */

package c_control;

public class Exam1 {
	Exam1(){
		String name = "최지현";
		String address = "서울시 동대문구 용두동";
		String phone = "010-8793-0000";
		int kor = 100;
		int eng = 97;
		int mat = 86;
		int tot = kor+eng+mat;
		double avg = (double)tot/3;
		char grade = ' ';
		
		if(avg>=90)      { grade = 'A'; } 
		else if(avg>=80) { grade = 'B'; } 
		else if(avg>=70) { grade = 'C'; } 
		else if(avg>=60) { grade = 'D'; } 
		else             { grade = 'F'; }
		
		System.out.println("------------------------");
		System.out.println("성적 처리 결과");
		System.out.println("------------------------");
		System.out.println("성명 : " + name + "\n주소 : " + address + "\n연락처 : " + phone);
		System.out.println("국어 : " + kor + "\n영어 : " + eng + "\n수학 : " + mat);
		System.out.println("총점 : " + tot + "\n평균 : " + avg + "\n학점 : " + grade);
		System.out.println("------------------------");
		
//		 String msg = "성명 : " + name;
//		 msg += "\n주소 : " + address;
//		 msg += "\n연락처 : " + phone;
//		 msg += "\n국어 : " + kor;
//		 msg += "\n영어 : " + eng;
//		 msg += "\n수학 : " + mat;
//		 msg += "\n총점 : " + tot;
//		 msg += "\n평균 : " + avg;
//		 msg += "\n학점 : " + grade;
//		 System.out.println(msg);
		
	}
	
	public static void main(String[] aegs) {
		new Exam1();
	}
}
