package g_exception;

public class ProductExam {
	public static void main(String[] args) {
		Radio radio = new Radio();
		Video video = new Video();
		Tv tv = new Tv();
		Product product = null;
		
		//2. �ڽ� Ŭ���������� getProductName()�� Override�Ͽ� �ڽ��� �̸��� ���.
		System.out.println("---------2��");
		System.out.println(radio.getProductName());
		System.out.println(video.getProductName());
		System.out.println(tv.getProductName());
		
		//3.1 Radio Ŭ������ Video Ŭ������ ����ȯ�� �ȵ��� ����.
		System.out.println("---------3.1�� ");
//		System.out.println(radio instanceof Video); //���� : ����ȯ�Ұ�.
//		System.out.println(video instanceof Radio); //���� : ����ȯ�Ұ�.
		
		//3.2 Radio, Video, TV Ŭ������ Product Ŭ������ ����ȯ�� �ɼ� ������ ����.
		System.out.println("---------3.2�� ");
		System.out.println(radio instanceof Product);
		System.out.println(video instanceof Product);
		System.out.println(tv instanceof Product);
		
	}
}
