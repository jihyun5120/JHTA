package e_class;

public class CarExam {

	public static void main(String[] args) {
		Car2 car = new Car2();
		
		car.setGas(50);
		
		if(car.isLeftGas()) {
			System.out.println("����մϴ�.");
			car.run();
		}
		
		
		if(car.isLeftGas()) {
			System.out.println("gas�� ������ �ʿ䰡 �����ϴ�.");
		} else {
			System.out.println("gas�� �����ϼ���.");
		}
	}

}
