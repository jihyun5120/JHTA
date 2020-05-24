/*
 * while문과 Math.random()메소드를 이용해서 두 개의 주사위를 던졌을 때 나오는 눈을(눈1, 눈2) 형태로 출력하고,
 *  눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드를 작성해보세요.
 *  눈의 합이 5가 되는 조합은 (1,4), (4,1), (2,3), (3,2)입니다.
 */
package c_control;

public class Exercise04 {
	Exercise04(){
		int score1 = 0;
		int score2 = 0;
		boolean a = true;
		
		
		while(a) {
			score1 = (int)(Math.random()*6)+1;
			score2 = (int)(Math.random()*6)+1;
			int sum = score1+score2;
			System.out.println("(" + score1 + ", " + score2 + ")");
			
			while(sum==5) {
				a = false;
				break;
			}
		}	
	}
	
	public static void main(String[] args) {
		new Exercise04();
	}
}
