package april20;
import java.util.Arrays;
import java.util.Random;

public class LottoEx02 {
	public static void main(String[] args) {
		int[] lotto = new int[6];

		Random random = new Random();

		System.out.println(lotto.length + "개 : " + Arrays.toString(lotto));
		
		for(int i =0; i<lotto.length; i++) {
			lotto[i] = random.nextInt(45)+1;
			for(int j=0; j<i;j++) {
				if(lotto[i]==lotto[j]) {
					--i;
					break;
				}
			}
		}
		System.out.println(lotto.length + "개 : " + Arrays.toString(lotto));
		Arrays.sort(lotto);
		System.out.println(lotto.length + "개 : " + Arrays.toString(lotto));
	}
}
