package c_control;

public class WhileExam {
	WhileExam(){
		//i의 초기값이 1일 때 1~10출력 
		int i = 1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
		
		//i의 초기값이 0일 때 1~10출력
		i = 0;
		while(i<10) {
			i++;
			System.out.println(i);
		}
	}
}
