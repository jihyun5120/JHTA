package c_control;

public class Lotto {
	private int n[] = new int[6]; //���� 1���� ���� ���� �������� �迭�� ���. new�� ����� ���� �⺻��x ������o
	int count = 0; //���������ڸ� ������� �ʾ����Ƿ� ���� ��Ű�� �ȿ��� count��밡��.
	
	void process() {
	    boolean b = false; //�ߺ������ʾҴ�.
		this.n[count] = (int)(Math.random()*45)+1;	//����� ������ �տ� this. �� ����.
	   
		for(int i=0 ;i<count;i++) {
			if(n[i]==n[count]) {
				b = true; //�ߺ��Ǿ���.
			}
		}
	    
	    if(!b) { //�ߺ������ʾҴٸ�	    	
	    	count++;
	    	prn(); // ���� Ŭ������ �־ k.�� �ȵ�.
	    }
	}
	
	void prn() {
		System.out.println(n[count-1]); // [count]�� ������ ������ ī��Ʈ�� �����Ǿ� ���ī��尪�̶� �޶� ������ ����.
	}                                   // [count-1]�� count������ -1 �� �����Ѱ�, [count--]�� count��ü�� ���� 1�����.  
	
	public static void main(String[] args) { //static�������� ����� ���� ��� static��.
		Lotto k = new Lotto();
		int a = 6;
		for(;k.count<a;) { // static�������� count�տ� k. �̴ϱ� ������� --> ������������� ���캸��!
			k.process();
		}
		
// �ߵ��Ǵ� ���ڰ� ���� �� ����.
//		k.process(); k.prn();
//		k.process(); k.prn();
//		k.process(); k.prn();
//		k.process(); k.prn();
//		k.process(); k.prn();
//		k.process(); k.prn();
	}
}
