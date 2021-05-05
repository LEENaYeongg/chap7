package chap7;
/*상속 예제
 * 1. 모든 클래스는 Object 클래스를 상속받는다.
 * 2. 자손 클래스의 객체 생성지 부모클래스의 객체를 먼저 생성한다.
 * 3. 클래스간의 상속은 단일 상속만 가능하다.
 * 4. 모든 클래스의 객체는 Object 객체를 포함한다.
 *    => 모든클래스의 객체는 Object 클래스의 멤버를 가진다.
 * */

class Phone extends Object{ //extends Object 안쓰면 컴파일러가 알아서 넣어줌.
	boolean power;
	int number;
	void power() {
		power =!power;
	}
	void send() {
		if(power) System.out.println("전화걸기");
	}
	void receive() {
		if(power) System.out.println("전화받기");
	}
}
class SmartPhone extends Phone{
	void setApp(String name) {
		System.out.println(name + "앱 설치함");
	}
}
public class PhoneEx1 {

	public static void main(String[] args) {
	SmartPhone sp = new SmartPhone();
	sp.power =true;
	sp.send();
	sp.receive();
	sp.setApp("네이버");

	}

}
