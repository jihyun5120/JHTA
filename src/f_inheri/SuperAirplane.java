package f_inheri;

public class SuperAirplane extends Airplane{ //��Ӱ��迡���� �׻� �θ� �켱����, �� ���� �ڽ��� ����.
	public static final int NOMAL = 1;
	public static final int SUPERSONIC = 2;
	
	public int flymode = NOMAL;
	
	public SuperAirplane(){
		super(50);
		System.out.println("���� �����Ӻ����");
	}
	
	@Override
	public void fly() {
		if(flymode == SUPERSONIC) {
			System.out.println("�����Ӻ����մϴ�.");
		} else {
			super.fly();
		}
	}
}
