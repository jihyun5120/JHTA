/*
 * ��ø for���� �̿��Ͽ� ������ 4x + 5y = 60�� ��� �ظ� ���ؼ� (x,y)���·� ����ϼ���.
 * ��, x�� y�� 10������ �ڿ����Դϴ�.
 * [������]
 * (5,8)
 * (10,4)
 */
package c_control;

public class Exercise05 {
	Exercise05(){
		for( int x=1; x<=10; x++ ) {
			for( int y=1; y<=10; y++ ) {
				if((4*x) + (5*y)==60) {
					System.out.println("(" + x + "," + y  + ")");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Exercise05();
	}
}
