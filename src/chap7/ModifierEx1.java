package chap7;

import chap7.test.Modifier2;

/* ����������.
 * private < (default) < protected < public 
 * 
 * class : (default), public 
 * ����, ��� �޼��� : private, (default), protected, public
 * ������ : private, (default), protected, public */
class Modifier {
	private int v1 = 100; // ������ Ŭ���� �������� ���� ���
			int v2 = 200; // ������ ��Ű�� �������� ���� ���(default)
	protected int v3 = v1;

	public void method() {
		System.out.println("chap7.ModifierEx1 Ŭ������ method()");
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
//		System.out.println(m1.v1); //v1 ������ ���������ڰ� private�̱� ������ -> v1�� ���� �Ұ�.
		System.out.println(m1.v2); // v2 ������ ���� ����.
		System.out.println(m1.v3);
		m1.method();
		Modifier2 m2 = new Modifier2();
//		System.out.println(m2.v1); // modifier2�� �ִ� v1�� �ִ� ���������ڰ� private�̱� ����.
//		System.out.println(m2.v2); // default�̱� ����. default�� ������ ���� ��Ű���� ����.
//		System.out.println(m2.v3); ==> protected�̱� ����. modifier2�� modifierex1 ��Ӱ��谡 �ƴϱ� ����.
		System.out.println(m2.v4);
		System.out.println(m2);
		Modifier3 m3 = new Modifier3();
//		System.out.println(m3.v1);
//		System.out.println(m3.v2);
//		System.out.println(m3.v3);
		System.out.println(m3.v4); //=> v4 �ϳ��� ����.
		//�������� ���� �����ڰ� private �̹Ƿ� ��ü ���� �Ұ�
//		Math m = new Math();

	}

}
