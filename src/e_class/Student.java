/*
 *  예제1) 
 * 1. Student 클래스 작성
 *  2. 매개변수가 없는 생성자로 객체를 생성하면 이름, 주소, 연락처를 "홍길동", "종로구", "010-1111-1111"으로 필드를 초기화하시오.
 *    (irum, address. phone)
 * 3. 이름을 파라메터로 전달하면 전달된 이름만 필드에 적용되는 생성자를 중복 선언 하시오.
 * 4. 이름, 주소, 연락처를 파라메터를 전달하면 모든 값을 필드에 적용하는 생성자를 중복 선언 하시오.
 * 5. main()를 작성하여 위의 요구 조건이 처리되는지를 테스트 하시오.
 */
package e_class;

public class Student {
	String irum;
	String address;
	String phone;
	
	Student(){
		this.irum = "홍길동";
		this.address = "종로구";
		this.phone = "010-1111-1111";
	}
	Student(String irum){
		this.irum = irum;
	}
	Student(String irum, String address, String phone){
		this.irum = irum;
		this.address = address;
		this.phone = phone;
	}
	
	void prn() {
		System.out.println("이름 : " + this.irum + "\n주소 : " + this.address + "\n연락처 : "  + this.phone);
		System.out.println("--------------------");
	}
	
	public static void main(String[] args) {
		Student st1 = new Student();
		st1.prn();
		
		Student st2 = new Student("최지현");
		st2.prn();
		
		Student st3 = new Student("올라프", "동대문구", "010-0000-0000");
		st3.prn();
	
		
		
	}
}
