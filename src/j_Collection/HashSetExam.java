package j_Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam { //String ��ü�� �ߺ� ���� �����ϴ� Hashset.
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		//�ߺ��� ��ҹ��� �����ϴ� �� ����.
		set.add("�ڹ�");
		set.add("ABC");
		set.add("�ڹ�");
		set.add("jdbc");
		set.add("abc");
		set.add("mybatis");
		
		int size = set.size(); // set�� ����� ��ü ��.
		System.out.println("�� ��ü�� : " + size);
		
		//Iterator�� �̿��Ͽ� set�� �ִ� ��ü ���.
		Iterator<String> iterator = set.iterator(); //String�� �����ϴ� �ݺ��� ���.
		while(iterator.hasNext()) { //��ü �� ��ŭ ����.
			String temp = iterator.next(); //�Ѱ��� ��ü�� ������.
			System.out.println("\t" + temp);
		}
		
		System.out.println("-----------------------");
		
		//��ü ����.
		set.remove("ABC");
		set.remove("jdbc");
		
		System.out.println("������ �� ��ü��  : " + set.size());
		
		//���� for������ set�� �ִ� ��ü ���.
		for(String temp : set) {
			System.out.println("\t" + temp);
		}
		
		System.out.println("-----------------------");
		
		set.clear(); //��� ��ü�� ����.
		if(set.isEmpty()) { //����ִ� �� Ȯ��.
			System.out.println("��� ��ü�� �����Ǿ����ϴ�.");
		}
		//���� ������ �ϰ������ remove()�� �����ϰ� �ٽ� add()�ؾ���.
	
		System.out.println("");
		System.out.println("--------MemberVo�� �������̵�---------------");
		
		//----------MemberVoŬ������ HashSet�� hashcode�� equals �������̵���.---------
		Set<MemberVo> memberset = new HashSet<MemberVo>(); //MemberVo�� �����ϴ� HashSetȣ��.
		memberset.add(new MemberVo("a001", "1111", "hong", "010-1234"));
		memberset.add(new MemberVo("a002", "1111", "hong", "010-1234"));
		memberset.add(new MemberVo("a002", "1111", "hong", "010-0000"));
		
		memberset.add(new MemberVo("a002", "2222", "kim", "010-1234"));
		memberset.add(new MemberVo("a002", "1111", "hong", "010-0000"));
		
		System.out.println("membersize : " + memberset.size());
		
		Iterator<MemberVo> iterator2 = memberset.iterator(); //MemberVo�� �����ϴ� �ݺ��� ȣ��.
		while(iterator2.hasNext()){
			MemberVo vo = iterator2.next();
			System.out.println(vo);
		}
		
		MemberVo delvo = new MemberVo("a002", "1111", "hong", "010-0000");
		memberset.remove(delvo);
		
		System.out.println("---------������ �� ���� for��--------------");
		
		for(MemberVo vo : memberset) {
			System.out.println(vo);
		}
		
		
		
	}
	
}
