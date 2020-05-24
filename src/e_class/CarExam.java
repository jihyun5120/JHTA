package e_class;

public class CarExam {

	public static void main(String[] args) {
		Car2 car = new Car2();
		
		car.setGas(50);
		
		if(car.isLeftGas()) {
			System.out.println("출발합니다.");
			car.run();
		}
		
		
		if(car.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
	}

}
