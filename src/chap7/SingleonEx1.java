package chap7;

/* 객체의 갯수를 한개만 생성하기 */
class SingleObject {
	private static SingleObject obj = new SingleObject();
	private SingleObject() {}
	private int value = 100;
	public static SingleObject getObject() {
		return obj;
	}
	public int getValue() {return value;}
	public void setValue(int value) {this.value = value;}
}

public class SingleonEx1 {
	public static void main(String[] args) {
//		SingleObject obj = new SingleObject(); 생성자 접근 불가
		SingleObject obj = SingleObject.getObject();
//		SingleObject obj2 = SingleObject.obj; obj 멤버 접근 불가.
//		System.out.println(obj.value); //private이기 때문에 접근 불가.
		System.out.println(obj.getValue());
		obj.setValue(500);
		SingleObject obj2 = SingleObject.getObject();
		System.out.println(obj2.getValue());
	}

}
