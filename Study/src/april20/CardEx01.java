package april20;
import java.util.Random;

public class CardEx01 {
	public static void main(String[] args) {
		int[] cards = new int[52];
		print(cards);
		
		Random rnd = new Random();
		int t;
		for(int i=0; i<cards.length; i++) {
			do {
				t = rnd.nextInt(cards.length);
			}while(cards[t]!=0);
			cards[t]=i;
		}
		print(cards);
		
		String[] kind = "◆♠♥♣".split("");
		String[] num = "1,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
		
		for(int i=0; i<cards.length;i++) {
			System.out.printf("%s%s ", kind[cards[i]/13],num[cards[i]%13]);
			if((i+1)%13==0) System.out.println();
		}
		
	}
	
	private static void print(int[] ar) {
		for(int i=0; i<ar.length; i++) {
			System.out.printf("%3d", ar[i]);
			if((i+1)%13==0) System.out.println();
		}
		System.out.println("-".repeat(40));
	}
}
