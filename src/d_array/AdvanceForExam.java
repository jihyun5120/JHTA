package d_array;

public class AdvanceForExam {
	AdvanceForExam(){
		int[] s = {1,3,434,54,53,434,33,54};
		int sum = 0;
		double avg = 0;
		
		for(int k : s) {
			sum += k;
		}
		avg = (double)sum/s.length;
		
		System.out.println("ÇÕ°è : " + sum);
		System.out.println("Æò±Õ : " + avg);
	}
	
	public static void main(String[] args) {
		new AdvanceForExam();
	}
}
