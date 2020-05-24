/*
 * 접근제한자 종류에 따른 접근 테스트
 * d_class.A.java , d_class.B.java
 */
package e_class;

import d_array.A;

public class C {
	C(){
		A a = new A();
		a.f1 = 1; //(o)
		a.f2 = 1; //(x) default type
		a.f3 = 1; //(x) private type
	}
}
