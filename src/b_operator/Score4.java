/*
 * 논리식을 사용한 응용 (파일명 : Score4.java)
 * 1. 국어, 영어, 수학 점수를 정수형으로 변수에 저장한 후 총점과 평균을 계산하여 적당한 변수에 저장하시오.
 * 2. 세 개의 점수중 하나라도 40미만이 있으면 '불합격'처리
 * 3. 평균이 60미만이여도 '불합격'처리를 하여 점수와 총점, 평균, 합격여부를 표준출력장치에 출력하시오.
 * **package b_operator
 * [출력예시]
 * ---------------------
 * 합격 여부 통지
 * ---------------------
 * 국어 : 50
 * 영어 : 50
 * 수학 : 50
 * 총점 : 150
 * 평균 : 50
 * 결과 : 불합격
 * ---------------------
 */

package b_operator;

public class Score4 {
	/*
	 * int kor = 50;
	 * int eng = 50;
	 * int mat = 50;
	 * int sum = 0;
	 * double avg = 0.0;
	 * boolean b;
	 * String str;
	 */
	
	Score4(){
		/*
		 * this.sum = kor+eng+mat;  변수이름이 같기 때문에 this. 은 생략해도 가능.
		 * this.avg = (double)sum/3;
		 * b = (kor>=40)&&(eng>=40)&&(mat>=40)&&(avg>=60); 또는 b = (kor<40)||(eng<40)||(mat<40)||(avg<60);
		 * str = (b)?"합격":"불합격;                          또는 str = (b)?"불합격":"합격; 
		 */
		int kor = 50;
		int eng = 50;
		int mat = 50;
		int sum = kor+eng+mat;
		int avg = sum/3;
		
		boolean b = (kor>=40)&&(eng>=40)&&(mat>=40)&&(avg>=60);
		String str = (b?"합격":"불합격");
		
		System.out.println("-------------------");
		System.out.println("합격 여부 통지");
		System.out.println("-------------------");
		System.out.println("국어 : " + kor + "\n" + "영어 : " + eng + "\n" + "수학 : " + mat);
		System.out.println("총점 : " + sum + "\n" + "평균 : " + avg);
		System.out.println("결과 : " + str);
		System.out.println("-------------------");
		
	}
	
	public static void main(String[] args) {
		new Score4();
		
		//대입연산자
		int a = 10;
		int b = 20;
		
		int c = 0;
		c += a; //c = c + a;
		c -= a; //c = c - a;
		c %= 2; //c = c % 2;
	}

}
