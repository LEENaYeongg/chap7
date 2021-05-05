package chap7;

/* 추상클래스 예제
 * 
 * 추상클래스
 * 1. 추상메서드를 가질 수 있는 클래스. abstract 예약어를 이용하여 구현함.
 * 2. 객체화 불가 => 상속을 통해서 자손클래스의 객체화를 통해 객체화가 가능함.
 * 3. 그외는 일반 클래스와 동일(생성자, 멤버변수, 멤버메서드, 초기화블럭, 상속 ..)
 * 4. 기능의 표준화
 * 
 * 추상메서드 : 메서드의 선언부만 존재하는 메서드. 구현부가 없다.
 *   => 자손클래스에서 반드시 오버라이딩이 필요.
 * 
 * */
abstract class Shape { // 추상클래스
	String type;

	Shape(String type) {
		this.type = type;
	}

	abstract double area(); // 추상메서드

	abstract double length(); // 추상메서드
}

class Circle extends Shape { // Circle 오류발생 원인 : 1. 생성자가 맞지 않을 때
										     //   2. Shape 이라는 추상클래스 안에 area(), length() 선언 안해서.
	int r;

	Circle(int r) {
		super("원");
		this.r = r;
	}
	@Override
	double area() {
		return r * r * Math.PI;
	}
	@Override
	double length() {
		return 2 * r * Math.PI;
	}
	public String toString() {
		return type + ":" + "반지름:" +r +", 넓이"+area() +", 둘레" +length();
	}
}

class Rectangle extends Shape {
	int width, height;

	Rectangle(int width, int height) {
		super("삼각형");
		this.width = width;
		this.height = height;
	}
	@Override //자손클래스 오버라이딩 필수!
	double area() { //int area()로 바꾸면 에러나는 이유: 오버라이딩 조건중에 리턴값은 부모클래스의 메서드와 같아야 하기 때문.
		//int area(int i) : 에러 안나는 이유==> 오버 로딩은 선언부와 리턴값이 같지 않아도 된다.
		return width * height;
	}
	@Override
	double length() {
		return (width + height) * 2;
	}
	public String toString() {
		return type + ":" + "가로:" +width +", 세로:"+height + ",넓이:"+area()+",둘레:"+length();
	}
}

public class ShapeEx1 {

	public static void main(String[] args) {
		Shape[] arr = new Shape[2];
		arr[0] = new Circle(10);
		arr[1] = new Rectangle(10,10);
		for(Shape s : arr)
			System.out.println(s);
	}

}
