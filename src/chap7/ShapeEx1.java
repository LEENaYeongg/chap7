package chap7;

/* �߻�Ŭ���� ����
 * 
 * �߻�Ŭ����
 * 1. �߻�޼��带 ���� �� �ִ� Ŭ����. abstract ���� �̿��Ͽ� ������.
 * 2. ��üȭ �Ұ� => ����� ���ؼ� �ڼ�Ŭ������ ��üȭ�� ���� ��üȭ�� ������.
 * 3. �׿ܴ� �Ϲ� Ŭ������ ����(������, �������, ����޼���, �ʱ�ȭ����, ��� ..)
 * 4. ����� ǥ��ȭ
 * 
 * �߻�޼��� : �޼����� ����θ� �����ϴ� �޼���. �����ΰ� ����.
 *   => �ڼ�Ŭ�������� �ݵ�� �������̵��� �ʿ�.
 * 
 * */
abstract class Shape { // �߻�Ŭ����
	String type;

	Shape(String type) {
		this.type = type;
	}

	abstract double area(); // �߻�޼���

	abstract double length(); // �߻�޼���
}

class Circle extends Shape { // Circle �����߻� ���� : 1. �����ڰ� ���� ���� ��
										     //   2. Shape �̶�� �߻�Ŭ���� �ȿ� area(), length() ���� ���ؼ�.
	int r;

	Circle(int r) {
		super("��");
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
		return type + ":" + "������:" +r +", ����"+area() +", �ѷ�" +length();
	}
}

class Rectangle extends Shape {
	int width, height;

	Rectangle(int width, int height) {
		super("�ﰢ��");
		this.width = width;
		this.height = height;
	}
	@Override //�ڼ�Ŭ���� �������̵� �ʼ�!
	double area() { //int area()�� �ٲٸ� �������� ����: �������̵� �����߿� ���ϰ��� �θ�Ŭ������ �޼���� ���ƾ� �ϱ� ����.
		//int area(int i) : ���� �ȳ��� ����==> ���� �ε��� ����ο� ���ϰ��� ���� �ʾƵ� �ȴ�.
		return width * height;
	}
	@Override
	double length() {
		return (width + height) * 2;
	}
	public String toString() {
		return type + ":" + "����:" +width +", ����:"+height + ",����:"+area()+",�ѷ�:"+length();
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