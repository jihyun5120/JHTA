package h_api;

public class Student {
	static Student[] st;
	static int count;
	
	public int sno; //�й�
	public String name; //�̸�
	public int score; //����
	
	
	Student(int sno){
		this.sno = sno;
	}
	
	Student(int sno, String name, int score){
		this.sno = sno;
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return sno + " - " + name + " - " + score; //ĸ��ȭ : Ư������� ����� ��.
	}
}
