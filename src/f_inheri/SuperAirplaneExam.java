package f_inheri;

public class SuperAirplaneExam {
	public static void main(String[] args) {
		SuperAirplane s = new SuperAirplane();
		s.takeoff();
		s.fly();
		s.flymode = SuperAirplane.SUPERSONIC;
		s.fly();
		s.flymode = SuperAirplane.NOMAL;
		s.fly();
		s.land();
		
	}
}
