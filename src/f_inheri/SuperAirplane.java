package f_inheri;

public class SuperAirplane extends Airplane{ //상속관계에서는 항상 부모가 우선생성, 그 다음 자식이 생성.
	public static final int NOMAL = 1;
	public static final int SUPERSONIC = 2;
	
	public int flymode = NOMAL;
	
	public SuperAirplane(){
		super(50);
		System.out.println("나는 초음속비행기");
	}
	
	@Override
	public void fly() {
		if(flymode == SUPERSONIC) {
			System.out.println("초음속비행합니다.");
		} else {
			super.fly();
		}
	}
}
