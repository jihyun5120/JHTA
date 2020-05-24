package e_class;

public class Static {
	static int v1 = 5000; // 정적형(공용자원) : 모든 객체가 하나의 값만 사용, 초기화는 1회만 가능, 클래스명과 멤버 또는 객체명과 멤버으로 모두 접근 가능.
	int v2 = 5000; // 인스턴스형 : 객체가 가지고있는 멤버.
	
	public static void main(String[] args) {
		Static s1 = new Static();
		s1.v1 = 1000;
		s1.v2 = 1000;
		
		Static s2 = new Static();
		System.out.println(s2.v1);
		System.out.println(Static.v1);//static형은 초기화가 1번이라 s2.v1과 Statoc.v1값이 같음.
		System.out.println(s2.v2); //다시 초기화가 되어서 5000
	}
}
