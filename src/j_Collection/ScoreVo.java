/*[실습]
* 1. 메인 프레임에 메뉴 추가(MemberMain)
*    성적관리 - 입력, 조회
* 2. JInternalFrame : ScoreInput(입력), ScoreSearch(조회)
* 3. ScoreVo
*    문자열 : 학번(sno), 성명(mName), 시험종류(exam)
*    숫자형 : 학년(grade), 국어(kor), 영어(eng), 수학(mat), 총점(tot), 평균(avg : double)
*  - 생성자를 통한 필드값 설정
*  - setter/getter 추가
*  - 학번이 같으면 동일한 객체(hashCode(), equals() 재정의)
* 4. ScoreDao(성적관리를 위한 코드)
*  - insert(ScoreVo vo)
*  - update (String sno, ScoreVo vo)
*  - delecte (String sno)
*  - list (String findStr)
*/
package j_Collection;

public class ScoreVo {
	String sno; // 학번
	String mName; // 이름
	String exam; // 시험종류
	int grade; // 학년
	int kor; // 국어
	int eng; // 영어
	int mat; // 수학
	int tot; // 총점
	double avg; // 평균
	
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
	public boolean equals(Object obj) { // equals의 시그니처가 달라지면 equals의 기능이 상실됨.
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
