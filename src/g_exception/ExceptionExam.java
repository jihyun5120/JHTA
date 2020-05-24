package g_exception;

public class ExceptionExam {

	public static void main(String[] args) {
		//NullPointerException
		String data = "";
		try {
			System.out.println(data.toString());		
			System.out.println("오류가 없는 경우 실행됨.");
		} catch(NullPointerException ex) { //asending형태로 나열해야함(작은 거부터 큰 순으로)
			System.out.println("Null Pointer Error!");
			
			System.out.println(ex.toString());
			ex.printStackTrace(); // 시스템이 가지고 있는 오류 메세지가 콘솔에 출력.
			
		} catch(Exception ex2) { //NullPointerException외의 오류를 실행(Exception이 가장 큰 범위).
			System.out.println("문자열 변수 data에 값이 없음.");
		} finally { // 오류와 상관없이 무조건 실행.
			System.out.println("오류발생과 상관없이 무조건 실행.");
		}
		
		//ArrayIndexOutOfBoundsException(첨자오류)
		int[] s = {1, 2, 3};
		try {
			for(int i=0; i<=3; i++) {
				System.out.println(s[i]);			
			}
		} catch(ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
//			System.out.println("인덱스범위를 초과함.");
		}
		
		//NumberFormatException
		try {
			data = "123a";
			int su = Integer.parseInt(data);
		} catch(NumberFormatException ex) {
			ex.printStackTrace();
//			System.out.println("숫자로 변환할 수 없는 문자가 있음.");
		} finally {
			System.out.println("다음 처리가 진행됨.");
		}
		
		//ClassCastException
		try {
			Car myCar = new Car();
			SportsCar c = (SportsCar)myCar; //부모를 만들고 자식으로 캐스팅 할 수X.			
		} catch(ClassCastException ex) {
			ex.printStackTrace();
//			System.out.println("타입변환을 할 수 없음.");
		} finally {
			System.out.println("끝~~~");
		}
	}
}
