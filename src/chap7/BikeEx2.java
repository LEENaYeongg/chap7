package chap7;

/*다형성 예제
 * 
 * 자손타입의 객체는 부모타입의 참조변수로 참조가 가능하다.
 * 부모타입의 참조변수로 자손 객체 참조시, 부모타입의 멤버들만 참조가 가능하다.
 * 모든클래스의 객체는 Object 타입의 참조변수로 참조가 가능하다.
 * 단 Object 클래스의 멤버만 접근이 가능하다.
 * */
class Bike2 {
	int wheel;

	Bike2(int wheel) {
		this.wheel = wheel;
	}

	void drive() {
		System.out.println("페달을 밟는다");
	}

	void stop() {
		System.out.println("브레이크를 잡는다");
	}
}

class AutoBike2 extends Bike2 {
	boolean power;

	AutoBike2(int wheel) {
		super(wheel);
	}

	void power() {
		power = !power;
		if (power)
			System.out.println("전원이 켜졌습니다.");
		else
			System.out.println("전원이 꺼졌습니다.");
	}
}

public class BikeEx2 {
	public static void main(String[] args) {
		AutoBike2 ab= new AutoBike2(2); //객체화 되는건 하나.
		Bike2 b;
		ab.power();
		ab.drive();
		System.out.println("바퀴 "+ab.wheel +"개가 굴러간다");
		ab.stop();
		b =ab;
// b.power(); 오류나는이유==>개체는 변하지 않았는데 참조변수 타입이 달라지면서 
					//==>power() 메서드는 Bike2 클래스의 멤버가 아니므로 Bike2형 참조변수로 호출불가
	Object obj =b;
	//obj.wheel =4; 오류나는이유==> obj객체 만큼만 사용해야되는데 obj객체 안에는 wheel 존재하지 않아 사용 불가능.
	//==> wheel멤버변수는 Object 클래스의 멤버가 아니므로, Object 형 참조변수로 사용 불가.
	}

}
