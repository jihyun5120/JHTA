package e_class;

public class ArrayParam {

	ArrayParam(int[] s){
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i]);
		}
	}
	
	//���޹��� �迭�� �հ踦 ���Ͽ� ��������.
	int arraySum(int[] s) {
		int sum = 0;
		for(int i=0; i<s.length; i++) {
			sum += s[i];
		}
		return sum;
	}
	
	//���޹��� �迭���� �ִ밪�� ���Ͽ� ��������.
	int arrayMax(int[] s) {
		int max = s[0];
		for(int i=1; i<s.length; i++) {
			if(max<s[i]) {
				max = s[i];
			}
		}
		return max;
	}
	
	//���޹��� �迭���� �ּҰ��� ���Ͽ� ��������.
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
	System.out.println("�հ� : " + hap);
	
	int m = ap1.arrayMax(abc);
	System.out.println("�ִ밪 : " + m);
	
	m = ap1.arrayMin(abc);
	System.out.println("�ּҰ� : " + m);
	
	int[] mm = ap1.maxMin(abc);
	System.out.println("--------------");
	System.out.println("�ִ밪 : " + mm[0]);
	System.out.println("�ּҰ� : " + mm[1]);
	}
	
}
