/*
 * 접근제한자 종류에 따른 접근 테스트
 * A.java , e_class.C.java
 */
package d_array;

public class B {
	B(){
		A a = new A();
		a.f1 = 1; //(o) public type.
		a.f2 = 1; //(o) default type.
		a.f3 = 1; //(x) private type.
	}
}
