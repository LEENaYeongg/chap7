package chap7;
/* final 제한자 : 변경 불가의 의미
 * final 클래스 : 상속 불가 클래스
 * 				다른 클래스의 부모 클래스가 될 수 없다.
 * 				다른 클래스의 부모 클래스가 될 수 없다.
 * 				String 클래스가 final 클래스임.
 * */

public class FinalClass {}
class SubClass extends FinalClass{}
