package e_class;

public class AnnoExam {
	
	@Override //오류가 있는 지 없는 지 볼 수 있음.
	public String toString() {
		return "최지현";
	}
	
	public static void main(String[] args) {
		AnnoExam a = new AnnoExam();
		
		System.out.println(a);
		
	}
}
