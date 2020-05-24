package h_api;

import java.util.Arrays;

public class MemberExam {

	public static void main(String[] args) {
		Member original = new Member("blue","hong","1234", 25, true );
		
		Member cloned = original.getMembre();
		
		System.out.println("복제된 객체의 필드값");
		System.out.println("id : " + cloned.id);
		System.out.println("name : " + cloned.name);
		System.out.println("password : " + cloned.password);
		System.out.println("age : " + cloned.age);
		System.out.println("adult : " + cloned.adult);
		
		System.out.println();
		
		System.out.println("원본 객체의 필드값");
		System.out.println("id : " + original.id);
		System.out.println("name : " + original.name);
		System.out.println("password : " + original.password);
		System.out.println("age : " + original.age);
		System.out.println("adult : " + original.adult);
		
		//원본이 훼손되는 경우.
		cloned.scores[0] = 100;
		
//		System.out.println(original.scores);//이렇게하면 배열의 값이 있는 주소만 출력됨.
//		System.out.println(cloned.scores);//이렇게하면 배열의 값이 있는 주소만 출력됨.
		
		System.out.println(Arrays.toString(original.scores));
		System.out.println(Arrays.toString(cloned.scores));
		
		cloned.car.model = "소나타";
		
		System.out.println(original.car.model);
		System.out.println(cloned.car.model);
	}

}
