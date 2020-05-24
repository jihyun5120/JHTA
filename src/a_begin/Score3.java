/* 
 * 1. 클래스명은 Score3으로 작성한 후 단독으로 실행되도록 main()함수를 작성.
 * 2. main()안에서 Score3 클래스가 메모리에 로딩되도록 조치.
 * 3. 생성자를 기술하고 아래의 내용을 처리할 수 있도록 프로그램 하시오.
 *  ㄱ) 정수형 성적 2개를 대입하시오.
 *  ㄴ) 입력된 정수형 성적을 사용하여 합계를 구하여 저장하시오.
 *  ㄷ) 합계를 사용하여 두 성적의 평균을 구하여 저장하시오.
 *  ㄹ) 두 성적과 합계, 평균을 표준 출력 장치에 출력하시오.
 *  [출력 예]
 *  -------------------------
 *  성적 처리 결과
 *  -------------------------
 *  작성일자 : 2019. 11. 27(수)
 *  작성자 : 본인이름
 *  국어 : 95
 *  영어 : 80
 *  합계 : xxx
 *  평균 : xxx
 *  -------------------------- 
 */ 

package a_begin;

public class Score3 {
	Score3(){
		String date = "2019. 11. 27(수)";
		String name = "최지현";
		int kor = 95;  
		int eng = 80;
		int sum = kor+eng;
		double avg = sum/2.0; //2.0보다 둘 중에 하나를(double)로 캐스팅 하는 것을 더 선호함.
		/* int kor = 95, eng = 80;
		 * int tot = 0;
		 * double avg = 0;
		 * 
		 * tot = kor+eng;
		 * avg = (double)tot/2;
		 */
		
		System.out.println("--------------------------");
		System.out.println("성적 처리 결과");
		System.out.println("--------------------------");
		System.out.println("작성일자 : " + date + "\n" + "작성자 : " + name);
		System.out.println("국어 : " + kor + "\n" + "영어 : " + eng);
		System.out.println("합계 : "+sum + "\n" + "평균 : " + avg);
		System.out.println("--------------------------");
	}
	public static void main(String[] args) { //인스턴스(객체) : 클래스가 메모리에 로딩되는 것.
		new Score3();
	}
}
