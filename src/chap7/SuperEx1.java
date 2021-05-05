package chap7;

/*super 예약어
 * 
 * super() 생성자 : 부모클래스의 생성자 호출
 * 				   부모클래스의 생성자의 매개변수에 맞도록 자손클래스에서 호출해야함.
 * 			            단 부모 클래스에 매개변수가 없는 생성자가 있다면 생략 가능함.
 * super 참조변수 : 부모클래스의 객체를 참조하는 변수
 * 
 * */
class Parent {
	int x = 10;

	Parent(int x) { //생성자 ==> 기본생성자 제공 // 생성자 없는 객체생성은 불가능.
		this.x = x; //자기참조변수. 내 값이 없어도 부모값을 가져다 씀.
	}
}

class Child extends Parent {
	int x = 20;
	Child() {
		super(10);
	}
	void method() {
		int x = 30;
		System.out.println("x=" + x); 
		System.out.println("this.x=" + this.x); 
		System.out.println("super.x=" + super.x); //내 안에 있는 부모값을 가져옴. 반드시 부모한테 있어야함.
	}
}

public class SuperEx1 {
	public static void main(String[] args) {
		Child c = new Child();
		c.method();

	}
}
