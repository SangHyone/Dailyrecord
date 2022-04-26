package april21;
import java.util.Arrays;
import java.util.Random;

public class RankEx02 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int ar[][] = new int[2][10];
		Arrays.fill(ar[1], 1);
		for (int i = 0; i < ar[0].length; i++)
			ar[0][i] = rnd.nextInt(101);
		System.out.println("점수 : " + Arrays.deepToString(ar));
		System.out.println();

		arraysPrint(ar);

		for (int i = 0; i < ar[0].length - 1; i++) {
			for (int j = i + 1; j < ar[0].length; j++) {
				if (ar[0][i] < ar[0][j]) {
					ar[1][i]++;
				} else if (ar[0][i] > ar[0][j]) {
					ar[1][j]++;
				}
			}
		}
		
		arraysPrint(ar);
	}
	
	private static void arraysPrint(int[][] ar) {
		for(int i=0;i<ar.length;i++) {
			System.out.print(i==0 ? "점수 : " : "석차 : ");
			for(int j=0; j<ar[i].length;j++) {
				System.out.printf("%4d", ar[i][j]);
			}
			System.out.println();
		}
	}
}