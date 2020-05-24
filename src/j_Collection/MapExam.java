package j_Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
	
	//<String, Integer>
	public void test1() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("hong", 90);
		map.put("lee", 80);
		map.put("park", 50);
		map.put("kim", 70);
		map.put("choi", 40);
		
		System.out.println("size : " + map.size());
		
		//키값으로 value출력
		System.out.println(map.get("lee")); //80이 나와야됨.
		
		Set<String> set = map.keySet(); //키값은 <>형이다. --> 여기서 키값은 String형. / set구조
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			int value = map.get(key); //map에서 key에 해당하는 value값을 가져와라.
			
			System.out.println(key + " : " + value); //set구조이기 때문에 입력순서와 출력순서가 같지X.
		}
		
		System.out.println("------------");
		
		//Map.Entry
		Set<Map.Entry<String, Integer>> set2 = map.entrySet(); //set구조 Map.Entry타입.
		Iterator<Map.Entry<String, Integer>> iter2 = set2.iterator(); 
		while(iter2.hasNext()) {
			Map.Entry<String, Integer> entry = iter2.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		map.put("choi", 99);
		System.out.println("choi 수정 : " + map.get("choi"));
		
		map.remove("choi");
		
		System.out.println("----keySet----");
		
		//how 1 (keySet)
		Set<String> set3 = map.keySet();
		Iterator<String> iter3 = set3.iterator();
		while(iter3.hasNext()) {
			String key = iter3.next();
			int value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		System.out.println("---Map.Entry---");
		
		//how 2 (Map.Entry)
		Set<Map.Entry<String, Integer>> set4 =  map.entrySet();
		Iterator<Map.Entry<String, Integer>> iter4 = set4.iterator();
		while(iter4.hasNext()) {
			Map.Entry<String, Integer> entry2 = iter4.next();
			System.out.println(entry2.getKey() + " : " + entry2.getValue());			
		}
		
		System.out.println("---향상된for문---");
		
		//how3 (for)
		for(Map.Entry<String, Integer> f : set4) {
			System.out.println(f.getKey() + " : " + f.getValue());
		}
	}
	
	//key값의 유형이 Student type인 경우 / key값이 동일하면 중복저장X
	public void test2() { 
		
		System.out.println("---key값이 Student type---");
	
		Map<Student, String> map = new HashMap<Student, String>();
		
		//추가
		map.put(new Student(100, "hong"), "010-1111-1111");
		map.put(new Student(200, "kim"), "010-2222-2222");
		map.put(new Student(300, "kang"), "011-123-1234");
		prn(map);
		
		System.out.println("----수정 후----");
		
		map.put(new Student(300, "kang"), "010-3333-3333"); //수정
		prn(map);
		
		System.out.println("----삭제후----");
		
		map.remove(new Student(300, "kang"));//삭제
		prn(map);
	}
	
	public void prn(Map<Student, String> map) { // keySet 출력 메소드
		Set<Student> set = map.keySet();
		Iterator<Student> iter = set.iterator();
		while(iter.hasNext()) {
			Student key = iter.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
	}
	
	//value값이 Student type인 경우
	public void test3() { //value값이 동일하면 중복저장X
		System.out.println("------value값이 sale type------");
		
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		
		//추가
		map.put(201901001, new Student(201901001, "홍씨"));
		map.put(201901002, new Student(201901002, "박씨"));
		map.put(201901003, new Student(201901003, "김씨"));
		map.put(201901004, new Student(201901004, "최씨"));
		
		prn2(map);
		
		System.out.println("-------------수정 후-------------");
		
		map.put(201901002, new Student(201901002,"김씨")); //박씨의 이름을 김씨로 수정
		
		map.remove(201901001); //홍씨를 삭제
		
		prn2(map); //최종결과를 출력
	}
	
	public void prn2(Map<Integer, Student> map) { // Map.Entry 출력 메소드.
		Set<Map.Entry<Integer,Student>> set = map.entrySet();
		Iterator<Map.Entry<Integer, Student>> iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, Student> entry = iter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		MapExam exam = new MapExam();
		exam.test1();
		exam.test2();
		exam.test3();
	}
}
