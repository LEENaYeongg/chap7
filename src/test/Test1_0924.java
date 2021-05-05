package test;

class Food {
	int price;
	int point;

	Food(int price) {
		this.price = price;
		this.point = price / 10;
	}
}

class Fruit extends Food {
	double brix;

	Fruit(int price, double brix) {
		super(price);
		this.brix = brix;
	}
}

class Apple extends Fruit {
	Apple(int price, double brix) {
		super(price, brix);
	}

	public String toString() {
		return "사과";
	}
}

class Peach extends Fruit {
	Peach(int price, double brix) {
		super(price, brix);
	}

	public String toString() {
		return "복숭아";
	}
}

class Drink extends Food {
	int ml;

	Drink(int money, int ml) { //생성자
		super(money);
		this.ml = ml;
	}
}

class Coke extends Drink {
	Coke(int price, int ml) {
		super(price, ml);
	}

	public String toString() {
		return "콜라";
	}
}

class Sidar extends Drink {
	Sidar(int price, int ml) {
		super(price, ml);
	}

	public String toString() {
		return "사이다";
	}
}

class Snack extends Food {
	int gram;

	Snack(int money, int gram) {
		super(money);
		this.gram = gram;
	}
}

class Biscuit extends Snack {
	Biscuit(int price, int gram) {
		super(price, gram);
	}

	public String toString() {
		return "비스킷";
	}
}

class Cookie extends Snack {
	Cookie(int price, int gram) {
		super(price, gram);
	}

	public String toString() {
		return "쿠키";
	}
}

class Buyer2 {
	final int MONEY_MAX = 10000; //배열안에 숫자를 넣는 것보다 문자를 넣는것이 나음!
	final int ARRAY_MAX = 10;
	int price = MONEY_MAX, point;
	int cnt;
	Food[] cart = new Food[ARRAY_MAX];

	Food[] fruitArray = new Food[ARRAY_MAX];
	int fruitCount = 0; //과일의 갯수를 카운트 하기 위한 변수.
	int drinkCount = 0;
	int snackCount = 0;
	void buy(Food p) {
		if(p.price>this.price) {
			System.out.println(p+"잔액부족"); //잔액부족 출력.
		} else
		this.price -= p.price; //가격 : 나의 돈 - 물건 값.
		this.point += p.point; //포인트: 나의 포인트 + 물건이 가지고 있는 포인트 증가
		System.out.println(p + "를(을)"+p.price + "가격에 구입");
		// 과일인 경우 당도 출력, 음료인 경우 용량 출력, 과자인 경우 그램을 출력.
		cart[cnt++] = p;
		if(p instanceof Fruit) { //p 가 Fruit 객체임
			Fruit fr = (Fruit)p;
			System.out.println(fr.brix + "당도 상품 구매");
			
		}
		else if(p instanceof Drink) { //else 보다 else if 사용 권장. 
			//해당 객체 확인
			Drink dr = (Drink)p;
			System.out.println(dr.ml + "ml 상품 구매");
		}
		else if(p instanceof Snack) {
			//해당 객체 확인
			Snack sn = (Snack)p;
			System.out.println(sn.gram + "gram 상품 구매");
		}
		
		System.out.println(p + "를(을)"+p.price + "가격에 구입");
		//p: toString 메서드가 자동 물품이름 출력.
	}
/* ==> 선생님 코드
 * void summary() {
 * int total=0, ftot=0, dtot=0, stot=0;
 * String list="",flist="", dlist="",slist="";
 * for(int =i=0; i<cnt; i++){
 * total += cart[i].price;
 * list += cart[i] + ",";
 * 
 * 
 * */
	public void summary() { //summary는 매개변수 없음.

		for(int i=0; i<cnt; i++) {
			System.out.print(cart[i] + " ");

		}
		System.out.println();
//		for(fruitCount=0; fruitCount < 6; fruitCount++) ==> **물건 출력문 만들어보기!!!
//			System.out.println("과일 구매 금액 : " + fruitCount);
		
	}
}

public class Test1_0924 {

	public static void main(String[] args) {
		Apple apple = new Apple(1000, 10.5);// 가격, 당도(brix) 매개변수 받음.
		System.out.println("사과 가격:" + apple.price);
		System.out.println("사과 당도:" + apple.brix);
		Peach peach = new Peach(1000, 13.5);// 가격, 당도(brix)
		Coke cock = new Coke(500, 500); // 가격, 용량(ml)
		Sidar sidar = new Sidar(1500, 1000);// 가격, 용량(ml)
		Biscuit bis = new Biscuit(10000, 500);// 가격, 무게(gram)
		Cookie cookie = new Cookie(500, 5000);// 가격, 무게(gram)
		Buyer2 b = new Buyer2();

		b.buy(apple);
		b.buy(peach);
		b.buy(cock);
		b.buy(sidar);
		b.buy(bis);
		b.buy(cookie);
		System.out.println("고객 잔액:" + b.price);
		System.out.println("고객 포인트:" + b.point);
		b.summary();
	}
}
