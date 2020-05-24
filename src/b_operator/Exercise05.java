/*
 * 1. 세금계산 : 10단위 이하의 금액은 무조건 절삭하여 과금하시오.
 *    12,340 ==> 12,300
 * 2. 이자계산 : 10단위 이하의 금액은 무조건 절상하여 지급하시오.
 *    12,340.5 ==> 12,400   
 */

package b_operator;

public class Exercise05 {
	
	Exercise05(){
		
		//1. 10단위 절삭(세금계산)
		int i = 12340;
		System.out.println((i/100)*100);
		/*
		 * int i = 12340;
		 * int r1 = i/100*100;
		 * System.out.println(r2);
		 */
		
		//2. 10단위 절상(이자계산)
		double d = 12340.5;
		System.out.println((int)d/100*100+100);
		/*
		 * int v = 12340;
		 * int r2 = (int)(v+99.999)/100*100);
		 * System.out.println(r2);
		 */
	}
	
	public static void main(String[] args) {
	new Exercise05();	
	}
}
