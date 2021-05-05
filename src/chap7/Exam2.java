package chap7;
/* SutdaCard 클래스
 * 멤버변수 : int number, boolean, isKwang
 * 생성자 : 구동클래스에 맞도록 구현
 * 멤버 메서드 : toString을 결과에 맞도록 오버라이딩 하기
 * SutdaDeck 클래스 구현하기
 * 멤버변수 : cards : SutdaCard 20장을 저장할 배열
 * 생성자 : SutdaCard 20장을 생성하여 cards 배열에 저장
 * 메서드 : toString() 오바라이딩하여 결과가 출현되도록 구현
 * 		  shuffle() : cards 20장의 카드를 섞기
 * 		  SutdaCard pick(int index) : index에 해당하는 카드 한장 리턴
 * 		  SutdaCard pick() : 임의의 카드 한장 리턴
 * 
 *  [결과]
 *  1k,2,3k,4,5,6,7,8k,9,10,1,2,3,4,5,6,7,8,9,10,
 *  7,3k,8,4,6,10,7,5,10,6,9,3,9,5,1k,8k,1,
 *  첫번째 카드 : 7
 *  랜덤 선택 카드 : 5
 * */

class SutdaCard {
	int number;
	boolean isKwang;

	SutdaCard(int number, boolean isKwang) { // 섰다라는 객체를 만들기 위해 생성자 생성
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
			// i가 10이면 다시 1로 들어가기 위해 %10
		    // 3개씩 하기 위해.
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
		System.out.println("첫번째 카드: " + deck.pick(0));
		System.out.println("두번째 카드: " + deck.pick());

	}
}
