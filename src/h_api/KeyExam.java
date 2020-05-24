package h_api;

import java.util.HashMap;

public class KeyExam {
	public static void main(String[] args) {
		//Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성.
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		
		//식별키 "new Key(1)" 로 "홍길동"을 저장함.
		hashMap.put(new Key(1), "홍길동"); //put을 하면 1칸씩늘어나 값이 들어감.(put은 무한대로 가능)
		hashMap.put(new Key(2), "최지현");
		hashMap.put(new Key(1), "일지매"); //위 new Key(1) 와 중복되어 "일지매"로 값이 바뀜.
		
		//식별키 "new Key(1)로 "홍길동"을 읽어옴.
		String value = hashMap.get(new Key(1));
		System.out.println(value);
	}
}
