package f_inheri;

public class Airplane {
	public Airplane() {
		System.out.println("나는 일반비행기");
	}
	public Airplane(int tire) {
		System.out.println("타이어가 " + tire + "개인 일반 비행기");
	}
	public void land() {
		System.out.println("착륙합니다.");
	}
	public void fly() {
		System.out.println("일반비행입니다.");
	}
	public void takeoff() {
		System.out.println("이륙합니다.");
	}
}
