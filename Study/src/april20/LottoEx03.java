package april20;
import java.util.Random;

public class LottoEx03 {
	public static void main(String[] args) {
		int[] lotto = new int[45];

		Random random = new Random();

		
		int temp;
		for(int i =0; i<6; i++) {
			do {
				temp = random.nextInt(lotto.length);
			}while(lotto[temp]!=0);
			lotto[temp] = 1;
		}
		
		for(int i=0; i<lotto.length; i++) {
			if(lotto[i]!=0) System.out.printf("%3d", i+1);
		}
		System.out.println();
	}
}
