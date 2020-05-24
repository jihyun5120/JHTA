package d_array;

import java.util.Scanner;

public class ArrayExam3 {

	//메소드 : 접근자 반환형 메소드명 (매개변수){...} , 반환형이 있으면 클래스명과 같아도 무조건 메소드.
	
	//정수형 2차원 배열을 선언하고 초기값을 4행 3열의 데이터를 대입하시오.
	public void test1() { //메인에서 호출하는 방법, 다른 클래스에서 호출하는 방법.
		int[][] s = new int[][] {
			{ 1, 2, 2 },
			{ 4, 2, 4 },
			{ 4, 5, 7 },
			{ 7, 8, 9 }
		};
		
		// 배열의 행수를 출력.
		System.out.println("행수 : " + s.length);
		// 첫번째 행의 열수.
		System.out.println("첫번째 행의 열수 : " + s[0].length);
		// 두번째 행의 세번째 열의 값은?
		System.out.println("두번째 행의 세번째 열의 값 : " + s[1][2]);
		// 첫번째 행의 값들의 합계	
		int sum = s[0][0] + s[0][1] + s[0][2];
		System.out.println("첫번째 행의 합계 : " + sum);
		// 첫번째 열의 값들의 합계
		sum = s[0][0] + s[1][0] + s[2][0] + s[3][0];
		System.out.println("첫번째 열의 값들의 합계 : " + sum);
		// 두번째행의 값들 중 짝수만
		if(s[1][0]%2==0) {
			System.out.print(s[1][0] + " ");
		}
		if(s[1][1]%2==0) {
			System.out.print(s[1][1] + " ");
		}
	
		if(s[1][2]%2==0) {
			System.out.println(s[1][2] + " ");
		}
		
//		for(int i=0; i<s[1].length; i++) {
//			if(s[1][i]%2==0) {
//			System.out.print(s[1][i] + " " );	
//			}
//		}
//		System.out.println();	
		
		//세번째 열의 짝수의 평균을 출력
		int hap = 0;
		int count = 0;
		double avg = 0.0;
		
		for(int i=0; i<s.length; i++) {
			if(s[i][2]%2==0) {
				hap += s[i][2];
				count++;
			}
		}
		if(count>0) {
		avg = (double)hap/count;
		}
		System.out.println("합계 : " + hap);
		System.out.println("짝수의 개수 : " + count);
		System.out.println("세번째 열 짝수의 평균 : " + avg);
	}
	
	public int test2() {
		//문자열 1차원배열(names)에 임의의 성명 5개를 대입.
		//정수형 2차원배열(s)에 5명의 국어, 영어성적을 대입.
		String[] names = new String[] {"최","김","윤","박","이"};
		int[][] s = new int[][]{
			{90, 80},
			{95, 100},
			{75, 90},
			{80, 60},
			{85, 90}
			};
			int tot = 0;
			double avg = 0;
		// 배열의 첫번째 학생의 이름과 성적 및 총점, 평균을 출력
			System.out.println("이름 : " + names[0]);
			System.out.println("국어성적 : " + s[0][0]);
			System.out.println("영어성적 : " + s[0][1]);
			tot = s[0][0] + s[0][1];
			avg = (double)tot/s[0].length;
			System.out.println("총점 : " + tot);
			System.out.println("평균 : " + avg);
			
			//세번째 학생의 국어점수를 100점으로 수정하시오.
			s[2][0] = 100;
			//세번째 학생의 이름과 국어성적을 출력하시오.
			System.out.println("세번째 학생명 : " + names[2]);
			System.out.println("국어점수 : " + s[2][0]);
		
			//학생명이 "박"인 사람의 국어, 영어, 총점, 평균을 계산하여 출력하되 없으면 "자료없음"을 출력.
			//검색어를 입력하여 검색하고 검색을 중지하려면 "quite"을 입력하도록 프로그램을 수정하시오.
			Scanner scanner = new Scanner(System.in);
			String findStr = "";
			 while(!findStr.equals("quit")) {
				 System.out.println("검색할 이름은?");
				 findStr = scanner.nextLine(); //next(); 는 띄어쓰기 전까지의 문자를 읽음, nextLine(); 은 문자열 한 줄 전체를 읽음.
				 int p = -1;
				for( int i=0; i<names.length; i++ ) {
					if( names[i].equals(findStr) ) { //names가 String배열이므로 .equals 사용.
						p=i;
						tot = s[i][0] + s[i][1];
						avg = (double)tot/s[i].length;
						System.out.println("----검색결과----");
						System.out.println("이름 : " + names[i]);
						System.out.println("국어점수 : " + s[i][0]);
						System.out.println("영어점수 : " + s[i][1]);
						System.out.println("총점 : " + tot);
						System.out.println("평균 : " + avg);
						break;
					} 
				}
				if(p==-1 || findStr=="quit") {
					System.out.println("자료없음");
				}
			}
			
		return 0;
		}
	
	public static void main(String[] args) {
		ArrayExam3 a3 = new ArrayExam3(); //객체생성.
//		a3.test1(); //void는 반환값이 없으므로 반환값을 담는 변수사용x.
		a3.test2();
	}

}