package e_class;

public class Car {
	String model = "�׷���";
	String color = "���";
	int maxspeed = 0;
	
	Car(){}
	Car(String maodel){
		this.model = maodel; //this.model �� �ʵ��� �ִ� model�� ����Ű��, = ���ʿ� �ִ� model�� �Ű������� ���� ����Ŵ.(�׷����� �ƹݶ��� �ٲ�)
	}
	Car(String model, String color){
		this.model = model;
		this.color = color;
	}
	Car(String model, String color, int maxspeed){
		this.model = model;
		this.color = color;
		this.maxspeed = maxspeed;
	}
	public void speedUp() {
		this.maxspeed += 10;
	}
	public void speedDown() {
		this.maxspeed -=10;
	}
	
	public static void main(String[] args) {
		Car c1 = new Car(); //c1�� �Ű������� ���� ������ �׷���,���,0�� ���� ������ ����.
		Car c2 = new Car("�ƹݶ�");
		Car c3 = new Car("�ƹݶ�", "���");
		Car c4 = new Car("�ƹݶ�", "���", 100);
		
		
		c1.maxspeed = 200;
		System.out.println("madel : " + c1.model);
		System.out.println("color : " + c1.color);
		System.out.println("max speed : " + c1.maxspeed);
		
		System.out.println("c4 spac....");
		System.out.println("model : " + c4.model);
		System.out.println("color : " + c4.color);
		System.out.println("max speed : " + c4.maxspeed);
		
		System.out.println("---------------------------------");
		c1.speedUp();
		System.out.println("c1 max speed : " + c1.maxspeed);
	}	
}
