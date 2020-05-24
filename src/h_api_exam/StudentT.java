package h_api_exam;

public class StudentT {
	static StudentT[] st;
	static int count;
	
	public int sno;
	public String name;
	public int score;
	
	
	public StudentT(int sno){
		this.sno = sno;
	}
	
	StudentT(int sno, String name, int score){
		this.sno = sno;
		this.name = name;
		this.score = score;
	}	
	
	@Override
	public String toString() {
		return sno + " \t " + name + " \t " + score; //Ä¸½¶È­ : Æ¯Á¤±â´ÉÀ» ¼û±â´Â °Í.
	}
}
