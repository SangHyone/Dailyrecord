package kr.human.MavenEx;

public class DeckTest {
	public static void main(String[] args) {
		Deck deck = new Deck(); // 카드 1묶음이 섞여서 만들어진다.

		for (int i = 0; i < 10; i++) // 10장만 가져와보자
			System.out.print(deck.nextCard() + " ");
		System.out.println();
		for (int i = 0; i < 10; i++) // 10장만 가져와보자
			System.out.print(deck.nextCard() + " ");
		System.out.println();
		for (int i = 0; i < 10; i++) // 10장만 가져와보자
			System.out.print(deck.nextCard() + " ");
		System.out.println();
		for (int i = 0; i < 10; i++) // 10장만 가져와보자
			System.out.print(deck.nextCard() + " ");
		System.out.println();
		for (int i = 0; i < 10; i++) // 10장만 가져와보자
			System.out.print(deck.nextCard() + " ");
		System.out.println();
		for (int i = 0; i < 10; i++) {// 10장만 가져와보자
			CardVO cardVO = deck.nextCard();
			if (cardVO != null) {
				System.out.print(cardVO + " ");
			}

			else {
				System.out.println("더 이상 카드가 없습니다.");
				break;
			}
		}
		System.out.println();

	}
}
