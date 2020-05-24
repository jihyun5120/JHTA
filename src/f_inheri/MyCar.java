package f_inheri;

public class MyCar {
	KumhoTire[] front = new KumhoTire[2];
	HankookTire[] back = new HankookTire[2];
	
	Tire[] tire = new Tire[4];
	
	public static void main(String[] args) {
		MyCar m = new MyCar();
		//m.front[0] = new HankookTire(); //front는 금호타입이라 오류.
		m.tire[0] = new KumhoTire(); //다형성
		m.back[0] = new HankookTire(); //타입이 맞아서(O)
		
		m.tire[0].run();
		
		// 객체가 HankookTire로 만들어진 경우.
		Tire h1 = new HankookTire();
		if(h1 instanceof KumhoTire) {
			System.out.println("금호타이어로 만들어짐");
		} else {
			System.out.println("금호타이어로 만들어지지 않음.");
		}
		
	}
}
