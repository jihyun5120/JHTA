/*
 * while���� Math.random()�޼ҵ带 �̿��ؼ� �� ���� �ֻ����� ������ �� ������ ����(��1, ��2) ���·� ����ϰ�,
 *  ���� ���� 5�� �ƴϸ� ��� �ֻ����� ������, ���� ���� 5�̸� ������ ���ߴ� �ڵ带 �ۼ��غ�����.
 *  ���� ���� 5�� �Ǵ� ������ (1,4), (4,1), (2,3), (3,2)�Դϴ�.
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
