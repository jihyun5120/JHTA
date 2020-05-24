package h_api;

public class Key {
	public int number;
	
	public Key(int number) {
		this.number =  number;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if(obj instanceof Key) { //obj가 Key에 상속되어 있니?
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
