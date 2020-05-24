/*
 * 예제3) switch문 응용.
 * 정수형 성적이 score에 저장되어 있다. score를 사용하여 학점을 구하되, switch문을 사용하여 처리하시오.
 * [출력예시]
 * 성적 : xx
 * 학점 : x
 */
package c_control;

public class SwitchExample5 {
	public SwitchExample5() {
		int score = 50;
		char grade = ' ';
		
		switch(score/10) {
		case 10 :
		case 9 :
			grade = 'A'; break;
		case 8 :
			grade = 'B'; break;
		case 7 :
			grade = 'C'; break;
		case 6 :
			grade = 'D'; break;
		default : 
			grade = 'F'; break;
		}
		System.out.println("성적 : " + score + "\n학점 : " + grade);
		
		//switch --> if
		if(score>=90)      { grade = 'A';} 
		else if(score>=80) { grade = 'B';} 
		else if(score>=70) { grade = 'C';} 
		else if(score>=60) { grade = 'D';} 
		else               { grade = 'F';}
		System.out.println("성적 : " + score + "\n학점 : " + grade);
	}
}
