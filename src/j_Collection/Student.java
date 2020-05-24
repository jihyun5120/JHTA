package j_Collection;

import java.text.MessageFormat;

public class Student {
	public int sno; // �й�
	public String name; //�̸�

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
		int code = sno + name.hashCode(); //�ǹ������� �й��� ���� ��찡 ���⶧���� sno�� hashcode�� �ߺ��� �ȵǸ� ��.
		return code;
	}

	@Override
	public String toString() {
		String mf = MessageFormat.format("{0} --- {1}", sno, name);
		return mf;
	}

}
