package j_Collection;

import java.text.MessageFormat;

public class Student {
	public int sno; // 학번
	public String name; //이름

	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if(obj instanceof Student) {
			Student std = (Student)obj;
			if(sno == std.sno && name.equals(std.name)) {
				b = true;				
			} else {
				b = false;	
			} 		
		}
		return b;
	}

	@Override
	public int hashCode() {
		int code = sno + name.hashCode(); //실무에서는 학번이 같을 경우가 없기때문에 sno의 hashcode만 중복이 안되면 됨.
		return code;
	}

	@Override
	public String toString() {
		String mf = MessageFormat.format("{0} --- {1}", sno, name);
		return mf;
	}

}
