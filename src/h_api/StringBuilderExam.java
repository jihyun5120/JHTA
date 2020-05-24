package h_api;

//String의 속도와 StringBuilder의 속도비교
public class StringBuilderExam {
	public StringBuilderExam() {
		//String 속도
		long sTime = 0, eTime = 0;
		String str = "";
		
		sTime = System.nanoTime();
		for(int i = 0; i<50000; i++) {
			str += "a";
		}
		eTime = System.nanoTime();
		System.out.println("String의 처리 시간 : " + (eTime - sTime));
		
		//StringBuilder 속도
		StringBuilder sb = new StringBuilder();
		sTime = System.nanoTime();
		for(int i = 0; i<50000; i++) {
			sb.append("a");
		}
		eTime = System.nanoTime();
		
		System.out.println("StringBuilder의 처리 시간 : " + (eTime - sTime));
	}
	
	public static void main(String[] args) {
		new StringBuilderExam();
	}	

}
