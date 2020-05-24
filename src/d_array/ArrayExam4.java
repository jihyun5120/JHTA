package d_array;

import java.util.Scanner;

public class ArrayExam4 {
	String[] n = new String[10];
	int[][] s = new int[10][2];
	int count = 0; //배열에 입력된 자료의 개수
	
	// 무한루프를 돌면서 메뉴를 출력.
 	ArrayExam4() {
 		Scanner scanner = new Scanner(System.in); //System.in : 시스템에 입력되는 장치는 표준입력장치다.
		boolean run = true;
		
		//샘플용 데이터를 배열에 저장.
		n[0] = "kim";
		n[1] = "hong";
		n[2] = "park";
		n[3] = "lee";
		s[0][0] = 90; s[0][1] = 80;
		s[1][0] = 80; s[1][1] = 40;
		s[2][0] = 50; s[2][1] = 60;
		s[3][0] = 60; s[3][1] = 70;
		
		count = 4;
		
		while(run) {
			System.out.println("-----------------------------------");
			System.out.println("1.입력 | 2.수정 | 3.조회 및 출력 | 4.종료");
			System.out.println("-----------------------------------");
			System.out.print("메뉴 선택 : ");
			int menu = scanner.nextInt();
			switch(menu) { //if 문으로 해도 됨.
			case 1 :
				this.input();
				break;
				
			case 2 : 	
				this.modify();
				break;
				
			case 3 : 
				this.search();
				break;
				
			case 4 : 
				run = false;
				break;
			} // switch 끝.
		} // while 끝.
		System.out.println("프로그램이 종료되었습니다.");	
		
}
	// 학생의 성적 정보를 배열에 입력.
	public void input() {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		int kor = 0;
		int eng = 0;
		int tot = 0;
		double avg = 0;
		
		System.out.print("성명 : ");
		name = scanner.nextLine();
		System.out.print("국어 : ");
		kor = scanner.nextInt();
		System.out.print("영어 : ");
		eng = scanner.nextInt();
		
		tot = kor + eng;
		avg = (double)tot/2;
		
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);
		
		n[count] = name;
		s[count][0] = kor;
		s[count][1] = eng;
		count++;
	}
	//학생의 성적 정보를 수정.
	/* 1) 수정할 학생명을 입력받아 검색
	 * 2) 검색된 정보를 표시
	 * 3) 수정
	 * 4) 배열 정보 수정 */
	public void modify() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 성명은? ");
		String findName = scanner.nextLine();
		int tot = 0;
		double avg = 0;
		
		for( int i=0; i<count; i++) {
			if((n[i]).equals(findName)){
				tot = s[i][0] + s[i][1];
				avg = tot/2.0;
				System.out.print(n[i] + " ");
				System.out.print(s[i][0] + " ");
				System.out.print(s[i][1] + " ");
				System.out.print(tot + " ");
				System.out.printf("%5.1f", avg);
				System.out.println();
				
				System.out.print("수정할 국어 성적은? ");
				s[i][0] = scanner.nextInt();
				System.out.print("수정할 영어 성적은?");
				s[i][1] = scanner.nextInt();
				System.out.println("자료가 수정되었습니다.");
				System.out.println();
			} // if문 끝.
		} // for문 끝.
		
		
	}
	//학생의 성적 정보를 조회 및 출력.
	public void search() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 성명은? ");
		String findName = scanner.nextLine();
		int tot = 0;
		double avg = 0;
		for( int i=0; i<count; i++) {
			if(n[i].equals(findName)||findName.equals("")) {
				//TODO(총점, 평균을 계산하여 출력)
				tot = s[i][0] + s[i][1];
				avg = tot/2.0;
				
				System.out.print(n[i] + "  ");
				System.out.print(s[i][0] + "  ");
				System.out.print(s[i][1] + "  ");
				System.out.print(tot + "  ");
				System.out.printf("%5.1f", avg);
				System.out.println();
			}
			
				
		}
	}
	
	public static void main(String[] args) {
		new ArrayExam4();
	}
}
