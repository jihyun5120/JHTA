package d_array;

public class ArrayExam1 {
	ArrayExam1(){
		//�迭�� �����ϸ鼭 �ʱⰪ�� �����ϴ� ���.
		int[] scores = {11,12,13,14,15};
		System.out.println(scores[0]);
		System.out.println(scores[4]);
		
		//���ڿ��� �迭�� �����ϰ� ������ ������ 3�� ����
		String[] names = {"hong","kim","choi"};
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		names[0] = "ȫ";
		names[1] = "��";
		names[2] = "��";
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		//�迭�� ������ �� �� �ʱⰪ�� ������ ��.
//		double height = new double[] {150.5, 160, 165.5}; �ؿ��� ���� ������.
		
		double[] height = null;
		height = new double[] {150.5, 160, 165.5};
//		height = {150.5, 160, 165.5}; �����߻�.
		
		//10���� �����Ը� ������ �� �ִ� �Ǽ��� �迭�� �����غ���.
		double[] w = new double[10];
		
		//�����Լ��� ����Ͽ� �����Ը� �߻����� �迭 w�� �����غ���
		for(int i=0;i<10;i++) {
			double d = Math.random()*100;
			w[i]=d;
		}
		
		for(int i=0;i<10;i++) {
			System.out.printf("%5.1f \n",w[i]); //%5.1 : 5�ڸ����� �Ҽ��� ù��°�ڸ�����, f : �Ǽ� 
		}
		
		//�������� �հ�� ����� ����Ͽ���.
		double hap = 0;
		for(int i=0;i<w.length;i++) {
			hap += w[i];			
		}
		double avg = hap/w.length;
		
		System.out.printf("�հ� = %7.2f \n", hap);
		System.out.printf("��� = %6.2f \n", avg);
		}
	public static void main(String[] args) {
//		for(int i =0; i<args.length;i++) { Run configurations�� arguments�� �� ġƮ�Ⱚ�� ����.
//			System.out.println(args[i]);
//		}
		new ArrayExam1();
	}  
}
