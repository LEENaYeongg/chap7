package chap7;

/*�θ�Ŭ������ ����� �ڼ�Ŭ������ ����� ������ ��� ����
 *  ������� : ���������� �ڷ����� ������.
 *  ����޼��� : �ش� ��ü�� ���� �������̵� �� �޼��尡 ȣ��ȴ�.
 *  
 *  ������ java.lang.ClassCastException :
 *  	��ü�� �������� �ڷ����� �����ִ� ��� �߻���.
 * 
 * */
class Parent3 {
	int x = 10;

	void method() {
		System.out.println("Parent3 Ŭ������ method");
	}
}

class Child3 extends Parent3 {
	int x = 20;
	@Override
	void method() {
		System.out.println("Child3 Ŭ������ method");
		System.out.println("x=" +x);
		System.out.println("this.x="+ this.x);
		System.out.println("super.x="+super.x);
	}
}

public class BindingEx1 {
	public static void main(String[] args) {
		Parent3 p = new Parent3(); //���� ����:ParentŸ���� Child�� ����ȯ �׷��� �������� OK but Child Ÿ������ ������ �� �ִ� ������ ���� ����.
		Child3 c = (Child3) p;
		System.out.println(p.x);
		System.out.println(c.x);
		p.method();
		c.method();
	}

}
