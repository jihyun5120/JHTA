package j_Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam { //String 객체를 중복 없이 저장하는 Hashset.
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		//중복과 대소문자 구분하는 지 검증.
		set.add("자바");
		set.add("ABC");
		set.add("자바");
		set.add("jdbc");
		set.add("abc");
		set.add("mybatis");
		
		int size = set.size(); // set에 저장된 객체 수.
		System.out.println("총 객체수 : " + size);
		
		//Iterator을 이용하여 set에 있는 객체 출력.
		Iterator<String> iterator = set.iterator(); //String만 참조하는 반복자 얻기.
		while(iterator.hasNext()) { //객체 수 만큼 루핑.
			String temp = iterator.next(); //한개의 객체를 가져옴.
			System.out.println("\t" + temp);
		}
		
		System.out.println("-----------------------");
		
		//객체 삭제.
		set.remove("ABC");
		set.remove("jdbc");
		
		System.out.println("삭제후 총 객체수  : " + set.size());
		
		//향상된 for문으로 set에 있는 객체 출력.
		for(String temp : set) {
			System.out.println("\t" + temp);
		}
		
		System.out.println("-----------------------");
		
		set.clear(); //모든 객체를 삭제.
		if(set.isEmpty()) { //비어있는 지 확인.
			System.out.println("모든 객체가 삭제되었습니다.");
		}
		//만약 수정을 하고싶으면 remove()를 먼저하고 다시 add()해야함.
	
		System.out.println("");
		System.out.println("--------MemberVo의 오버라이딩---------------");
		
		//----------MemberVo클래스에 HashSet의 hashcode와 equals 오버라이드함.---------
		Set<MemberVo> memberset = new HashSet<MemberVo>(); //MemberVo만 참고하는 HashSet호출.
		memberset.add(new MemberVo("a001", "1111", "hong", "010-1234"));
		memberset.add(new MemberVo("a002", "1111", "hong", "010-1234"));
		memberset.add(new MemberVo("a002", "1111", "hong", "010-0000"));
		
		memberset.add(new MemberVo("a002", "2222", "kim", "010-1234"));
		memberset.add(new MemberVo("a002", "1111", "hong", "010-0000"));
		
		System.out.println("membersize : " + memberset.size());
		
		Iterator<MemberVo> iterator2 = memberset.iterator(); //MemberVo만 참조하는 반복자 호출.
		while(iterator2.hasNext()){
			MemberVo vo = iterator2.next();
			System.out.println(vo);
		}
		
		MemberVo delvo = new MemberVo("a002", "1111", "hong", "010-0000");
		memberset.remove(delvo);
		
		System.out.println("---------삭제한 후 향상된 for문--------------");
		
		for(MemberVo vo : memberset) {
			System.out.println(vo);
		}
		
		
		
	}
	
}
