package e_class;

public class ArrayParam2 {

	void input(int s) {
		
	}
	
	void input(Student s) {
		s.prn();
	}
	
	//�Ű��������� Car�� �޼ҵ�.
	void intput(Car c) {
		System.out.println(c.model);
		System.out.println(c.color);
		System.out.println(c.maxspeed);
	}

	public static void main(String[] args) {
		ArrayParam2 ap2 = new ArrayParam2();
		Student std = new Student();
		ap2.input(std);
		
		Car c1 = new Car();
		ap2.intput(c1);
		Car c2 = new Car("����","���",40);
		ap2.intput(c2);
		System.out.println();
	}

}
