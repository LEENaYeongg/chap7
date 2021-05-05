package chap7;

import chap7.test.Modifier2;

/* 접근제한자.
 * private < (default) < protected < public 
 * 
 * class : (default), public 
 * 변수, 상수 메서드 : private, (default), protected, public
 * 생성자 : private, (default), protected, public */
class Modifier {
	private int v1 = 100; // 동일한 클래스 내에서만 접근 허용
			int v2 = 200; // 동일한 패키지 내에서는 접근 허용(default)
	protected int v3 = v1;

	public void method() {
		System.out.println("chap7.ModifierEx1 클래스의 method()");
		System.out.println("v1=" +v1);
		System.out.println("v2=" +v2);
	}
}
class Modifier3 extends Modifier2 {
	public void method() {
//		System.out.println("v1="+v1); 
//		System.out.println("v2="+v2);
		System.out.println("v3="+v3);
		System.out.println("v4="+v4);
	}
}
public class ModifierEx1 {
	public static void main(String[] args) {
		Modifier m1 = new Modifier();
//		System.out.println(m1.v1); //v1 변수의 접근제한자가 private이기 때문에 -> v1에 접근 불가.
		System.out.println(m1.v2); // v2 변수에 접근 가능.
		System.out.println(m1.v3);
		m1.method();
		Modifier2 m2 = new Modifier2();
//		System.out.println(m2.v1); // modifier2에 있는 v1에 있는 접근제한자가 private이기 때문.
//		System.out.println(m2.v2); // default이기 때문. default의 영역은 동일 패키지만 가능.
//		System.out.println(m2.v3); ==> protected이기 때문. modifier2와 modifierex1 상속관계가 아니기 때문.
		System.out.println(m2.v4);
		System.out.println(m2);
		Modifier3 m3 = new Modifier3();
//		System.out.println(m3.v1);
//		System.out.println(m3.v2);
//		System.out.println(m3.v3);
		System.out.println(m3.v4); //=> v4 하나만 가능.
		//생성자의 접근 제어자가 private 이므로 객체 생성 불가
//		Math m = new Math();

	}

}
