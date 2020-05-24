package h_api;

public class Key {
	public int number;
	
	public Key(int number) {
		this.number =  number;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if(obj instanceof Key) { //obj�� Key�� ��ӵǾ� �ִ�?
			Key comparekey = (Key)obj;
			if(this.number == comparekey.number) {
				b = true;
			}
		}
		return b;
	}
	
	@Override
	public int hashCode() {
		return this.number;
	}
}
