package h_api;

import java.util.HashMap;

public class KeyExam {
	public static void main(String[] args) {
		//Key ��ü�� �ĺ�Ű�� ����ؼ� String ���� �����ϴ� HashMap ��ü ����.
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		
		//�ĺ�Ű "new Key(1)" �� "ȫ�浿"�� ������.
		hashMap.put(new Key(1), "ȫ�浿"); //put�� �ϸ� 1ĭ���þ ���� ��.(put�� ���Ѵ�� ����)
		hashMap.put(new Key(2), "������");
		hashMap.put(new Key(1), "������"); //�� new Key(1) �� �ߺ��Ǿ� "������"�� ���� �ٲ�.
		
		//�ĺ�Ű "new Key(1)�� "ȫ�浿"�� �о��.
		String value = hashMap.get(new Key(1));
		System.out.println(value);
	}
}
