package chap7;
/*final �ż��� : ������ �Ұ� �޼���. ���ٶ��̵� �Ұ� �޼���
 * 
 * */
public class FinalMethod {
public void method() { //������ �Ұ� �޼���
	System.out.println("FinalMethod Ŭ������ method");
		
	}
}
class SubMethod extends FinalMethod {
	public void method() {
		System.out.println("SubMethod  Ŭ������ method ");
	}
}
