/*[�ǽ�]
* 1. ���� �����ӿ� �޴� �߰�(MemberMain)
*    �������� - �Է�, ��ȸ
* 2. JInternalFrame : ScoreInput(�Է�), ScoreSearch(��ȸ)
* 3. ScoreVo
*    ���ڿ� : �й�(sno), ����(mName), ��������(exam)
*    ������ : �г�(grade), ����(kor), ����(eng), ����(mat), ����(tot), ���(avg : double)
*  - �����ڸ� ���� �ʵ尪 ����
*  - setter/getter �߰�
*  - �й��� ������ ������ ��ü(hashCode(), equals() ������)
* 4. ScoreDao(���������� ���� �ڵ�)
*  - insert(ScoreVo vo)
*  - update (String sno, ScoreVo vo)
*  - delecte (String sno)
*  - list (String findStr)
*/
package j_Collection;

public class ScoreVo {
	String sno; // �й�
	String mName; // �̸�
	String exam; // ��������
	int grade; // �г�
	int kor; // ����
	int eng; // ����
	int mat; // ����
	int tot; // ����
	double avg; // ���
	
	public ScoreVo(){}
	
	public ScoreVo(String sno, String mName, String exam, int grade, int kor, int eng, int mat) {
		this.sno = sno;
		this.mName = mName;
		this.exam = exam;
		this.grade = grade;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = (kor + eng + mat);
		this.avg = (double)tot/3;
	}

	@Override
	public boolean equals(Object obj) { // equals�� �ñ״�ó�� �޶����� equals�� ����� ��ǵ�.
		boolean b = false;
		if(obj instanceof ScoreVo) {
			ScoreVo sVo = (ScoreVo)obj;
			if(sno.equals(sVo.sno)) {
				b = true;
			}
		}
		return b;
	}

	@Override
	public int hashCode() {
		
		return this.sno.hashCode();
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}


}
