/*
 * for���� �̿��ؼ� �������� ���� �ﰢ���� ����ϴ� �ڵ带 �ۼ��غ�����.
 * [��¿���]
 *  *
 *  **
 *  ***
 *  ****
 *  *****
 */
package c_control;

public class Exercise06 {
	Exercise06(){
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");				
			}
			System.out.println();
		}
		
		System.out.println("---------");
		//�ݴ�� *�� 5��, 4��, 3��, 2��, 1���� ���.
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=(6-i);j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] aegs) {
		new Exercise06();
	}
}
