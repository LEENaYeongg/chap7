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
		return "���";
	}
}

class Peach extends Fruit {
	Peach(int price, double brix) {
		super(price, brix);
	}

	public String toString() {
		return "������";
	}
}

class Drink extends Food {
	int ml;

	Drink(int money, int ml) { //������
		super(money);
		this.ml = ml;
	}
}

class Coke extends Drink {
	Coke(int price, int ml) {
		super(price, ml);
	}

	public String toString() {
		return "�ݶ�";
	}
}

class Sidar extends Drink {
	Sidar(int price, int ml) {
		super(price, ml);
	}

	public String toString() {
		return "���̴�";
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
		return "��Ŷ";
	}
}

class Cookie extends Snack {
	Cookie(int price, int gram) {
		super(price, gram);
	}

	public String toString() {
		return "��Ű";
	}
}

class Buyer2 {
	final int MONEY_MAX = 10000; //�迭�ȿ� ���ڸ� �ִ� �ͺ��� ���ڸ� �ִ°��� ����!
	final int ARRAY_MAX = 10;
	int price = MONEY_MAX, point;
	int cnt;
	Food[] cart = new Food[ARRAY_MAX];

	Food[] fruitArray = new Food[ARRAY_MAX];
	int fruitCount = 0; //������ ������ ī��Ʈ �ϱ� ���� ����.
	int drinkCount = 0;
	int snackCount = 0;
	void buy(Food p) {
		if(p.price>this.price) {
			System.out.println(p+"�ܾ׺���"); //�ܾ׺��� ���.
		} else
		this.price -= p.price; //���� : ���� �� - ���� ��.
		this.point += p.point; //����Ʈ: ���� ����Ʈ + ������ ������ �ִ� ����Ʈ ����
		System.out.println(p + "��(��)"+p.price + "���ݿ� ����");
		// ������ ��� �絵 ���, ������ ��� �뷮 ���, ������ ��� �׷��� ���.
		cart[cnt++] = p;
		if(p instanceof Fruit) { //p �� Fruit ��ü��
			Fruit fr = (Fruit)p;
			System.out.println(fr.brix + "�絵 ��ǰ ����");
			
		}
		else if(p instanceof Drink) { //else ���� else if ��� ����. 
			//�ش� ��ü Ȯ��
			Drink dr = (Drink)p;
			System.out.println(dr.ml + "ml ��ǰ ����");
		}
		else if(p instanceof Snack) {
			//�ش� ��ü Ȯ��
			Snack sn = (Snack)p;
			System.out.println(sn.gram + "gram ��ǰ ����");
		}
		
		System.out.println(p + "��(��)"+p.price + "���ݿ� ����");
		//p: toString �޼��尡 �ڵ� ��ǰ�̸� ���.
	}
/* ==> ������ �ڵ�
 * void summary() {
 * int total=0, ftot=0, dtot=0, stot=0;
 * String list="",flist="", dlist="",slist="";
 * for(int =i=0; i<cnt; i++){
 * total += cart[i].price;
 * list += cart[i] + ",";
 * 
 * 
 * */
	public void summary() { //summary�� �Ű����� ����.

		for(int i=0; i<cnt; i++) {
			System.out.print(cart[i] + " ");

		}
		System.out.println();
//		for(fruitCount=0; fruitCount < 6; fruitCount++) ==> **���� ��¹� ������!!!
//			System.out.println("���� ���� �ݾ� : " + fruitCount);
		
	}
}

public class Test1_0924 {

	public static void main(String[] args) {
		Apple apple = new Apple(1000, 10.5);// ����, �絵(brix) �Ű����� ����.
		System.out.println("��� ����:" + apple.price);
		System.out.println("��� �絵:" + apple.brix);
		Peach peach = new Peach(1000, 13.5);// ����, �絵(brix)
		Coke cock = new Coke(500, 500); // ����, �뷮(ml)
		Sidar sidar = new Sidar(1500, 1000);// ����, �뷮(ml)
		Biscuit bis = new Biscuit(10000, 500);// ����, ����(gram)
		Cookie cookie = new Cookie(500, 5000);// ����, ����(gram)
		Buyer2 b = new Buyer2();

		b.buy(apple);
		b.buy(peach);
		b.buy(cock);
		b.buy(sidar);
		b.buy(bis);
		b.buy(cookie);
		System.out.println("�� �ܾ�:" + b.price);
		System.out.println("�� ����Ʈ:" + b.point);
		b.summary();
	}
}
