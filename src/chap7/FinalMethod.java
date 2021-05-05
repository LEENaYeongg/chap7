package chap7;
/*final 매서드 : 재정의 불가 메서드. 오바라이딩 불가 메서드
 * 
 * */
public class FinalMethod {
public void method() { //재정의 불가 메서드
	System.out.println("FinalMethod 클래스의 method");
		
	}
}
class SubMethod extends FinalMethod {
	public void method() {
		System.out.println("SubMethod  클래스의 method ");
	}
}
