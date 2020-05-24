package b_operator;

public class Exercise04 {
	int pencils = 534;
	int students = 30;
	int ps;
	int pl;
	
	Exercise04(){
	//학생 한 명이 가지는 연필 수
		ps = pencils/students;
		System.out.println("학생 한 명이 가지는 연필 수 : " + ps);
		
	//남는 연필 수	
		pl = pencils%students;
		System.out.println("남는 연필 수 : " + pl);
	}
	
	public static void main(String[] args) {
		new Exercise04();
	}
}
