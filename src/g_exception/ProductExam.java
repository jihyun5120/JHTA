package g_exception;

public class ProductExam {
	public static void main(String[] args) {
		Radio radio = new Radio();
		Video video = new Video();
		Tv tv = new Tv();
		Product product = null;
		
		//2. 자식 클래스에서는 getProductName()을 Override하여 자신의 이름을 출력.
		System.out.println("---------2번");
		System.out.println(radio.getProductName());
		System.out.println(video.getProductName());
		System.out.println(tv.getProductName());
		
		//3.1 Radio 클래스와 Video 클래스는 형변환이 안됨을 증명.
		System.out.println("---------3.1번 ");
//		System.out.println(radio instanceof Video); //에러 : 형변환불가.
//		System.out.println(video instanceof Radio); //에러 : 형변환불가.
		
		//3.2 Radio, Video, TV 클래스는 Product 클래스로 형변환이 될수 있음을 증명.
		System.out.println("---------3.2번 ");
		System.out.println(radio instanceof Product);
		System.out.println(video instanceof Product);
		System.out.println(tv instanceof Product);
		
	}
}
