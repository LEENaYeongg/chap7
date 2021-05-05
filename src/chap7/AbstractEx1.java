package chap7;
/* 추상 클래스간의 상속도 가능함.
 * 부모 추상클래스의 추상 메서드를 자손추상클래스 내부에서 오버라이딩 안해도 됨. 
 * 
 * */

abstract class Abs1 {
	int a=10;
	abstract int getA();
}
abstract class Abs2 extends Abs1{
	int b=20;
	abstract int getB();
}
class Normal extends Abs2{ //Normal

	@Override
	int getB() {
		return b;
	}

	@Override
	int getA() {
		return a;
	}
	
}
public class AbstractEx1 {
	public static void main(String[] args) {
		Normal n = new Normal(); //전부 가능.
		System.out.println(n.a);
		System.out.println(n.getA());
		System.out.println(n.b);
		System.out.println(n.getB());
		Abs2 a2 = n; //a2가 a1을 하고잇으므로 가능.
		System.out.println(a2.a);
		System.out.println(a2.getA());
		System.out.println(a2.b);
		System.out.println(a2.getB());
		Abs1 a1 = a2; // a만 가능.
		System.out.println(a1.a);
		System.out.println(a1.getA());
//		System.out.println(a1.b);
//		System.out.println(a1.getB());
		Object obj = a1;
//		System.out.println(obj.a); 
//		System.out.println(obj.getA());
//		System.out.println(obj.b);
//		System.out.println(obj.getB());
		// ==> 4개 오류 이유: 객체는 Normal 1개인데 자료형이 다른 참조형으로 참조하기 때문에 참조갯수가 다른것임.
	}

}
