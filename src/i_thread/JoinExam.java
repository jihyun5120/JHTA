/*
 *  SumThread
 */
package i_thread;

public class JoinExam { //�ٸ� �����尡 ����� ������ �Ͻ�������������
	public static void main(String[] args) {		
		
		SumThread st = new SumThread();
		
		st.start();
		
		
		try {
			st.join(); //SumThread�� ����ɶ����� ���� �����带 �Ͻ�������Ŵ.
		} catch(Exception ex) {}
		
		System.out.println("1~100�� �հ� : " + st.sum);
	}
}
