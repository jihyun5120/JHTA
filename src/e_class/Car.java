package e_class;

public class Car {
	String model = "그랜져";
	String color = "까망";
	int maxspeed = 0;
	
	Car(){}
	Car(String maodel){
		this.model = maodel; //this.model 은 필드의 있는 model을 가르키고, = 왼쪽에 있는 model은 매개변수의 값을 가르킴.(그랜져가 아반떼로 바뀜)
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
		Car c1 = new Car(); //c1은 매개변수가 없기 때문에 그랜져,까망,0의 값을 가지고 있음.
		Car c2 = new Car("아반떼");
		Car c3 = new Car("아반떼", "노랑");
		Car c4 = new Car("아반떼", "노랑", 100);
		
		
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
