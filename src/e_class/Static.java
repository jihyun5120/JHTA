package e_class;

public class Static {
	static int v1 = 5000; // ������(�����ڿ�) : ��� ��ü�� �ϳ��� ���� ���, �ʱ�ȭ�� 1ȸ�� ����, Ŭ������� ��� �Ǵ� ��ü��� ������� ��� ���� ����.
	int v2 = 5000; // �ν��Ͻ��� : ��ü�� �������ִ� ���.
	
	public static void main(String[] args) {
		Static s1 = new Static();
		s1.v1 = 1000;
		s1.v2 = 1000;
		
		Static s2 = new Static();
		System.out.println(s2.v1);
		System.out.println(Static.v1);//static���� �ʱ�ȭ�� 1���̶� s2.v1�� Statoc.v1���� ����.
		System.out.println(s2.v2); //�ٽ� �ʱ�ȭ�� �Ǿ 5000
	}
}
