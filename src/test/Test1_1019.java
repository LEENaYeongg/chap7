package test;

/*1. SutdaDeck을 이용한 SutdaCard 게임을 한다고 할때. 
   게임할 인원수를 입력받아, 인원수만큼의 Gamer를 생성하고
   각각 총점을 기준으로 순위를 작성하는 프로그램을 구현하기
   단 인원수는 2 ~ 10명으로 한다. 이 범위를 벋어나는 경우 다시 입력받음. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SutdaCard {
	int number;
	boolean isKwang;

	SutdaCard(int number, boolean isKwang) {
		this.number = number;
		this.isKwang = isKwang;
	}

	SutdaCard() {
		this(1, true);
	}

	@Override
	public String toString() {
		return number + ((isKwang) ? "K" : "");
	}
}

/*
 * SutdaDeck 클래스 멤버변수 : List<SutdaCard> cards; static Map<String,Integer> jokbo;
 * 생성자 : 매개변수 없음 SutdaCard 20장을 cards List객체에 저장 1~10의 숫자를 가진 카드가 각각 2장씩 숫자값이
 * 1,3,8인 카드 중 한장은 isKwqng이 true임 메서드 : SutdaCard pick() 첫번째 카드를 제거하여 리턴 void
 * shuffle() cards 섞어주는 기능. Collections.shuffle메서드 이용
 * 
 */
class SutdaDeck {
	List<SutdaCard> cards;
	static Map<String, Integer> jokbo;
	static {// static 초기화블럭-static멤버의 초기화를 담당
		jokbo = new HashMap<>();// 객체 만들기
		jokbo.put("KK", 4000);
		for (int i = 1; i <= 10; i++) {
			jokbo.put("" + i + i, 3000 + (i * 10));
		}
		jokbo.put("12", 2060);
		jokbo.put("21", 2060);
		jokbo.put("14", 2050);
		jokbo.put("41", 2050);
		jokbo.put("19", 2040);
		jokbo.put("91", 2040);
		jokbo.put("110", 2030);
		jokbo.put("101", 2030);
		jokbo.put("410", 2020);
		jokbo.put("104", 2020);
		jokbo.put("46", 2010);
		jokbo.put("64", 2010);
	}

	SutdaDeck() {
		cards = new ArrayList<SutdaCard>();
		for (int i = 0; i < 20; i++) {
			cards.add(new SutdaCard(i % 10 + 1, ((i == 0 || i == 2 | i == 7) ? true : false)));
		}
		System.out.println(cards);
	}

	void shuffle() {
		Collections.shuffle(cards);
		System.out.println(cards);
	}

	SutdaCard pick() {
		return cards.remove(0);
	}
}

class Gamer {
	String name;
	SutdaCard c1, c2;

	Gamer(String name, SutdaCard c1, SutdaCard c2) {
		this.name = name;
		this.c1 = c1;
		this.c2 = c2;
	}

	int getScore() {
		Integer score = 0;
		if (c1.isKwang && c2.isKwang) {
			score = SutdaDeck.jokbo.get("KK");
		} else {
			score = SutdaDeck.jokbo.get("" + c1.number + c2.number);
			if (score == null) {
				score = (c1.number + c2.number) % 10;
			}
		}
		return score;
	}

	public String toString() {
		return name + "(" + c1 + "," + c2 + "):" + getScore();
	}
}

public class Test1_1019 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();// 20장을 가지고 있을거
		deck.shuffle();// 셔플될거
		List<Gamer> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("게임인원수 입력");
		int number = 0;
		while (true) {
			number = scan.nextInt();
			if (number >= 2 && number <= 10) { //범위안에 들어오면 빠져나감.
				break;
			} else //범위를 벗어났을 때 재입력 받기
				System.out.println("다시입력하세요.");
			continue;
		}

		for (int i = 1; i <= number; i++) { //받은 인원수대로 출력
			list.add(new Gamer(i+"번", deck.pick(), deck.pick())); //섞여진 카드 순서대로 뽑기.
		}
//		list.add(new Gamer("홍길동", deck.pick(), deck.pick()));
//		list.add(new Gamer("김삿갓", deck.pick(), deck.pick()));
//		list.add(new Gamer("이몽룡", deck.pick(), deck.pick()));
		for (Gamer g : list)
			System.out.println(g);
		System.out.println("deck에 남은 카드의 갯수:" + deck.cards.size());
		// Gamer 중 가장 높은 점수를 가진 Gamer의 이름을 출력하기
		// gamer.name + " 승리"
		// getTotal() 값의 내림차순으로 정렬
		Collections.sort(list, new Comparator<Gamer>() {

			@Override
			public int compare(Gamer o1, Gamer o2) {
				return o2.getScore() - o1.getScore(); //정렬
			}
		});
		if (list.get(0).getScore() == list.get(1).getScore())
			System.out.println("비김");
		else
			System.out.println(list.get(0).name + "승리!");
	}
}
