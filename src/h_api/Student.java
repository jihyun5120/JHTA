package h_api;

public class Student {
	static Student[] st;
	static int count;
	
	public int sno; //학번
	public String name; //이름
	public int score; //성적
	
	
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
		return sno + " - " + name + " - " + score; //캡슐화 : 특정기능을 숨기는 것.
	}
}
