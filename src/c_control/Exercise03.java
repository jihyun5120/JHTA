/*
 * for문을 이용해서 1~100까지의 정수 중에서 3의 배수의 총합을 구하는 코드를 작성하세요.
 */
package c_control;

public class Exercise03 {
 Exercise03(){
	 int i = 0;
	 int sum = 0;
	 
	 for(i=3;i<=100;i=i+3) {
		 sum+=i;
	 }
	 System.out.println("3의 배수의 합 : " + sum);
 }
	public static void main(String[] args) {
	 new Exercise03();
 }
}
