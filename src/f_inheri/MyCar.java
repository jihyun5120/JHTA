package f_inheri;

public class MyCar {
	KumhoTire[] front = new KumhoTire[2];
	HankookTire[] back = new HankookTire[2];
	
	Tire[] tire = new Tire[4];
	
	public static void main(String[] args) {
		MyCar m = new MyCar();
		//m.front[0] = new HankookTire(); //front�� ��ȣŸ���̶� ����.
		m.tire[0] = new KumhoTire(); //������
		m.back[0] = new HankookTire(); //Ÿ���� �¾Ƽ�(O)
		
		m.tire[0].run();
		
		// ��ü�� HankookTire�� ������� ���.
		Tire h1 = new HankookTire();
		if(h1 instanceof KumhoTire) {
			System.out.println("��ȣŸ�̾�� �������");
		} else {
			System.out.println("��ȣŸ�̾�� ��������� ����.");
		}
		
	}
}
