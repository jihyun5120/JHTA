package c_control;

public class ForExam1 {
	ForExam1(){
		int sum = 0;
		for(int i=1 ; i<=100 ; i++) { //1~100까지의 합. 홀수만+ : (i=1;i<=100;i+=2), 짝수만+ : (i=2;i<=100;i+=2).
			sum = sum + i; //sum += i
			System.out.println(i + " 까지의 합 : " + sum); //더한과정을 다 보고 싶을 때.
		}
		System.out.println("1~100까지의 합 : " + sum); //최종으로 다 더한값만 보고 싶을 때.
	}
}
