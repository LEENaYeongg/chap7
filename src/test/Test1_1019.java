package test;

/*1. SutdaDeck�� �̿��� SutdaCard ������ �Ѵٰ� �Ҷ�. 
   ������ �ο����� �Է¹޾�, �ο�����ŭ�� Gamer�� �����ϰ�
   ���� ������ �������� ������ �ۼ��ϴ� ���α׷��� �����ϱ�
   �� �ο����� 2 ~ 10������ �Ѵ�. �� ������ ����� ��� �ٽ� �Է¹���. */

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
 * SutdaDeck Ŭ���� ������� : List<SutdaCard> cards; static Map<String,Integer> jokbo;
 * ������ : �Ű����� ���� SutdaCard 20���� cards List��ü�� ���� 1~10�� ���ڸ� ���� ī�尡 ���� 2�徿 ���ڰ���
 * 1,3,8�� ī�� �� ������ isKwqng�� true�� �޼��� : SutdaCard pick() ù��° ī�带 �����Ͽ� ���� void
 * shuffle() cards �����ִ� ���. Collections.shuffle�޼��� �̿�
 * 
 */
class SutdaDeck {
	List<SutdaCard> cards;
	static Map<String, Integer> jokbo;
	static {// static �ʱ�ȭ��-static����� �ʱ�ȭ�� ���
		jokbo = new HashMap<>();// ��ü �����
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
		SutdaDeck deck = new SutdaDeck();// 20���� ������ ������
		deck.shuffle();// ���õɰ�
		List<Gamer> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("�����ο��� �Է�");
		int number = 0;
		while (true) {
			number = scan.nextInt();
			if (number >= 2 && number <= 10) { //�����ȿ� ������ ��������.
				break;
			} else //������ ����� �� ���Է� �ޱ�
				System.out.println("�ٽ��Է��ϼ���.");
			continue;
		}

		for (int i = 1; i <= number; i++) { //���� �ο������ ���
			list.add(new Gamer(i+"��", deck.pick(), deck.pick())); //������ ī�� ������� �̱�.
		}
//		list.add(new Gamer("ȫ�浿", deck.pick(), deck.pick()));
//		list.add(new Gamer("���", deck.pick(), deck.pick()));
//		list.add(new Gamer("�̸���", deck.pick(), deck.pick()));
		for (Gamer g : list)
			System.out.println(g);
		System.out.println("deck�� ���� ī���� ����:" + deck.cards.size());
		// Gamer �� ���� ���� ������ ���� Gamer�� �̸��� ����ϱ�
		// gamer.name + " �¸�"
		// getTotal() ���� ������������ ����
		Collections.sort(list, new Comparator<Gamer>() {

			@Override
			public int compare(Gamer o1, Gamer o2) {
				return o2.getScore() - o1.getScore(); //����
			}
		});
		if (list.get(0).getScore() == list.get(1).getScore())
			System.out.println("���");
		else
			System.out.println(list.get(0).name + "�¸�!");
	}
}
