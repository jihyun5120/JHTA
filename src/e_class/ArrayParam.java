package e_class;

public class ArrayParam {

	ArrayParam(int[] s){
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i]);
		}
	}
	
	//전달받은 배열의 합계를 구하여 리턴하자.
	int arraySum(int[] s) {
		int sum = 0;
		for(int i=0; i<s.length; i++) {
			sum += s[i];
		}
		return sum;
	}
	
	//전달받은 배열에서 최대값을 구하여 리턴하자.
	int arrayMax(int[] s) {
		int max = s[0];
		for(int i=1; i<s.length; i++) {
			if(max<s[i]) {
				max = s[i];
			}
		}
		return max;
	}
	
	//전달받은 배열에서 최소값을 구하여 리턴하자.
	int arrayMin(int[] s) {
		int min = s[0];
		for(int i=1; i<s.length; i++) {
			if(min>s[i]) {
				min = s[i];
			}
		}
		return min;
	}
	
	int[] maxMin(int[] s) {
		int[] m = new int[2];
		m[0] = s[0]; //max
		m[1] = s[0]; //min
		for(int i=1; i<s.length; i++) {
			if(m[0]<s[i]) {
				m[0] = s[i];
			} else if(m[1]>s[i]) {
				m[1] = s[i];
			}
		}
		
		return m;
	}
	
	public static void main(String[] args) {
	int[] abc = {-4,2,0,4,5,633,7,8,9,133};
	ArrayParam ap1 = new ArrayParam(abc);
	
	int hap = ap1.arraySum(abc);
	System.out.println("합계 : " + hap);
	
	int m = ap1.arrayMax(abc);
	System.out.println("최대값 : " + m);
	
	m = ap1.arrayMin(abc);
	System.out.println("최소값 : " + m);
	
	int[] mm = ap1.maxMin(abc);
	System.out.println("--------------");
	System.out.println("최대값 : " + mm[0]);
	System.out.println("최소값 : " + mm[1]);
	}
	
}
