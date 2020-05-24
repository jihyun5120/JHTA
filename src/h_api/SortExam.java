package h_api;

import java.util.Arrays;
import java.util.Objects;

public class SortExam {
	
//숫자형 배열값을 오름차순으로 정렬.
	public void numberSort() {
		int[] n = {312,434,1,3,23,4,34,1,34,13,254,31,};
		int temp = 0; //대피소
		
		System.out.println("정렬전");
		System.out.println(Arrays.toString(n));
		
		for(int i=0; i<n.length-1; i++) { // 비교기준.(맨 마지막 수는 뒤에 비교할 대상이 없으니까 length-1)
			for(int j=i+1; j<n.length; j++) { // 비교대상.
				if(n[i]>n[j]) { //swap (부등호만 바꾸면 내림차순)
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if of end
			} // for j of end
		} // for i of end
		
		System.out.println("정렬후");
		System.out.println(Arrays.toString(n));	
	}
	
//문자열형 배열값을 오름차순으로 정렬.
	public void strSort() {
		String[] n = new String[] {"김자바", "홍길동", "올라프", "abc", "가나다", "2", "fdikd3j", "1dskfj"};
		String temp = "";
		
		System.out.println("정렬전");
		System.out.println(Arrays.toString(n));
		
		for(int i=0; i<n.length-1; i++) {
			for(int j=i+1; j<n.length; j++) {
				if(n[i].compareTo(n[j])>0) { //n[i]가 n[j]보다 크면 양수가 나와서 자리를 바꿔야됨 --> 0보다 큰지 비교.
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if of end
			} // for j of end
		} // for i of end
		
		System.out.println("정렬후");
		System.out.println(Arrays.toString(n));	
	}
	
	//학생 학번, 성적 오름차순
	public void objSort() {
		Student[] n = new Student[] {
				new Student(10, "hong", 60 ),
				new Student(1, "kim", 90),
				new Student(3, "park", 40),
				new Student(8, "lee", 99),
				new Student(2, "hong", 66)
		};
		Student temp = null;
		for(int i=0; i<n.length-1; i++) {
			for(int j=i+1; j<n.length; j++) {
				int result = Objects.compare(n[i],n[j], new StudentComp('s'));
				if(result>0) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if of end
			} // for j of end
		} // for i of end
		
		for(int i=0; i<n.length; i++) {
			System.out.println(n[i]); //학번오름차순 출력.
		}
				
	}
	
	public static void main(String[] args) {
		SortExam se = new SortExam();
//		se.numberSort();
//		se.strSort();
		se.objSort();
	}
}
