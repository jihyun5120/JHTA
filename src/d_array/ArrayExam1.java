package d_array;

public class ArrayExam1 {
	ArrayExam1(){
		//배열을 선언하면서 초기값을 대입하는 방법.
		int[] scores = {11,12,13,14,15};
		System.out.println(scores[0]);
		System.out.println(scores[4]);
		
		//문자열형 배열을 선언하고 임의의 성명을 3개 저장
		String[] names = {"hong","kim","choi"};
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		names[0] = "홍";
		names[1] = "김";
		names[2] = "박";
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		//배열을 선언한 후 에 초기값을 설정할 때.
//		double height = new double[] {150.5, 160, 165.5}; 밑에와 같은 선언방법.
		
		double[] height = null;
		height = new double[] {150.5, 160, 165.5};
//		height = {150.5, 160, 165.5}; 에러발생.
		
		//10명의 몸무게를 저장할 수 있는 실수형 배열을 선언해보자.
		double[] w = new double[10];
		
		//랜덤함수를 사용하여 몸무게를 발생시켜 배열 w에 저장해보자
		for(int i=0;i<10;i++) {
			double d = Math.random()*100;
			w[i]=d;
		}
		
		for(int i=0;i<10;i++) {
			System.out.printf("%5.1f \n",w[i]); //%5.1 : 5자리에서 소수점 첫번째자리까지, f : 실수 
		}
		
		//몸무게의 합계와 평균을 계산하여라.
		double hap = 0;
		for(int i=0;i<w.length;i++) {
			hap += w[i];			
		}
		double avg = hap/w.length;
		
		System.out.printf("합계 = %7.2f \n", hap);
		System.out.printf("평균 = %6.2f \n", avg);
		}
	public static void main(String[] args) {
//		for(int i =0; i<args.length;i++) { Run configurations안 arguments에 쓴 치트기값이 나옴.
//			System.out.println(args[i]);
//		}
		new ArrayExam1();
	}  
}
