package h_api;

import java.util.Arrays;
import java.util.Objects;

public class SortExam {
	
//������ �迭���� ������������ ����.
	public void numberSort() {
		int[] n = {312,434,1,3,23,4,34,1,34,13,254,31,};
		int temp = 0; //���Ǽ�
		
		System.out.println("������");
		System.out.println(Arrays.toString(n));
		
		for(int i=0; i<n.length-1; i++) { // �񱳱���.(�� ������ ���� �ڿ� ���� ����� �����ϱ� length-1)
			for(int j=i+1; j<n.length; j++) { // �񱳴��.
				if(n[i]>n[j]) { //swap (�ε�ȣ�� �ٲٸ� ��������)
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if of end
			} // for j of end
		} // for i of end
		
		System.out.println("������");
		System.out.println(Arrays.toString(n));	
	}
	
//���ڿ��� �迭���� ������������ ����.
	public void strSort() {
		String[] n = new String[] {"���ڹ�", "ȫ�浿", "�ö���", "abc", "������", "2", "fdikd3j", "1dskfj"};
		String temp = "";
		
		System.out.println("������");
		System.out.println(Arrays.toString(n));
		
		for(int i=0; i<n.length-1; i++) {
			for(int j=i+1; j<n.length; j++) {
				if(n[i].compareTo(n[j])>0) { //n[i]�� n[j]���� ũ�� ����� ���ͼ� �ڸ��� �ٲ�ߵ� --> 0���� ū�� ��.
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if of end
			} // for j of end
		} // for i of end
		
		System.out.println("������");
		System.out.println(Arrays.toString(n));	
	}
	
	//�л� �й�, ���� ��������
	public void objSort() {
		Student[] n = new Student[] {
				new Student(10, "hong", 60 ),
				new Student(1, "kim", 90),
				new Student(3, "park", 40),
				new Student(8, "lee", 99),
				new Student(2, "hong", 66)
		};
		Student temp = null;
		for(int i=0; i<n.length-1; i++) {
			for(int j=i+1; j<n.length; j++) {
				int result = Objects.compare(n[i],n[j], new StudentComp('s'));
				if(result>0) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				} // if of end
			} // for j of end
		} // for i of end
		
		for(int i=0; i<n.length; i++) {
			System.out.println(n[i]); //�й��������� ���.
		}
				
	}
	
	public static void main(String[] args) {
		SortExam se = new SortExam();
//		se.numberSort();
//		se.strSort();
		se.objSort();
	}
}
