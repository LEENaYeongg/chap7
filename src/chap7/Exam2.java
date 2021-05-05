package chap7;
/* SutdaCard Ŭ����
 * ������� : int number, boolean, isKwang
 * ������ : ����Ŭ������ �µ��� ����
 * ��� �޼��� : toString�� ����� �µ��� �������̵� �ϱ�
 * SutdaDeck Ŭ���� �����ϱ�
 * ������� : cards : SutdaCard 20���� ������ �迭
 * ������ : SutdaCard 20���� �����Ͽ� cards �迭�� ����
 * �޼��� : toString() ���ٶ��̵��Ͽ� ����� �����ǵ��� ����
 * 		  shuffle() : cards 20���� ī�带 ����
 * 		  SutdaCard pick(int index) : index�� �ش��ϴ� ī�� ���� ����
 * 		  SutdaCard pick() : ������ ī�� ���� ����
 * 
 *  [���]
 *  1k,2,3k,4,5,6,7,8k,9,10,1,2,3,4,5,6,7,8,9,10,
 *  7,3k,8,4,6,10,7,5,10,6,9,3,9,5,1k,8k,1,
 *  ù��° ī�� : 7
 *  ���� ���� ī�� : 5
 * */

class SutdaCard {
	int number;
	boolean isKwang;

	SutdaCard(int number, boolean isKwang) { // ���ٶ�� ��ü�� ����� ���� ������ ����
		this.number = number;
		this.isKwang = isKwang;
	}

	@Override
	public String toString() {
		return number + ((isKwang) ? "K" : "");
	}
}

class SutdaDeck {
	SutdaCard[] cards = new SutdaCard[20];

	SutdaDeck() {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new SutdaCard((i % 10 + 1), ((i == 0 || i == 2 || i == 7) ? true : false));
			// i�� 10�̸� �ٽ� 1�� ���� ���� %10
		    // 3���� �ϱ� ����.
		}
	}

	@Override
	public String toString() {
		String result = "";
		for (SutdaCard s : cards)
			result += s + ",";
		return result;
	}

	void shuffle() {
		for (int i = 0; i <= 1000; i++) {
			int f = (int) (Math.random() * cards.length);
			int t = (int) (Math.random() * cards.length);
			SutdaCard tmp = cards[f];
			cards[f] = cards[t];
			cards[t] = tmp;

		}
	}

	public SutdaCard pick(int i) {
		return cards[i];
	}

	public SutdaCard pick() {
		return cards[(int) (Math.random() * cards.length)];
	}
}

public class Exam2 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		System.out.println("ù��° ī��: " + deck.pick(0));
		System.out.println("�ι�° ī��: " + deck.pick());

	}
}
