package chap7;

/* ��ü�� ������ �Ѱ��� �����ϱ� */
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
//		SingleObject obj = new SingleObject(); ������ ���� �Ұ�
		SingleObject obj = SingleObject.getObject();
//		SingleObject obj2 = SingleObject.obj; obj ��� ���� �Ұ�.
//		System.out.println(obj.value); //private�̱� ������ ���� �Ұ�.
		System.out.println(obj.getValue());
		obj.setValue(500);
		SingleObject obj2 = SingleObject.getObject();
		System.out.println(obj2.getValue());
	}

}
