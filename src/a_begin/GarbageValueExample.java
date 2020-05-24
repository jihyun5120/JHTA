package a_begin;

public class GarbageValueExample {
	public static void main(String[] args) {
		byte var1 = 125;
		int var2 = 125;
		for(int i=0;i<5;i++) { //i++ --> i = i+1 누적연산자
			var1++; //byte값을 초과하면 최솟값으로 시작함
			var2++;
			System.out.println("var1: "+var1+"\t"+"var2: "+var2);
		}
	}
}
