package chap7;
/* �߻� Ŭ�������� ��ӵ� ������.
 * �θ� �߻�Ŭ������ �߻� �޼��带 �ڼ��߻�Ŭ���� ���ο��� �������̵� ���ص� ��. 
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
		Normal n = new Normal(); //���� ����.
		System.out.println(n.a);
		System.out.println(n.getA());
		System.out.println(n.b);
		System.out.println(n.getB());
		Abs2 a2 = n; //a2�� a1�� �ϰ������Ƿ� ����.
		System.out.println(a2.a);
		System.out.println(a2.getA());
		System.out.println(a2.b);
		System.out.println(a2.getB());
		Abs1 a1 = a2; // a�� ����.
		System.out.println(a1.a);
		System.out.println(a1.getA());
//		System.out.println(a1.b);
//		System.out.println(a1.getB());
		Object obj = a1;
//		System.out.println(obj.a); 
//		System.out.println(obj.getA());
//		System.out.println(obj.b);
//		System.out.println(obj.getB());
		// ==> 4�� ���� ����: ��ü�� Normal 1���ε� �ڷ����� �ٸ� ���������� �����ϱ� ������ ���������� �ٸ�����.
	}

}
