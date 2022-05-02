package april21;
import java.util.Arrays;
import java.util.Random;

public class RankEx01 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int ar[] = new int[10];
		int rank[] = new int[10];
		Arrays.fill(rank, 1);
		for (int i = 0; i < ar.length; i++)
			ar[i] = rnd.nextInt(101);
		System.out.println("점수 : " + Arrays.toString(ar));
		//System.out.println("순위 : " + Arrays.toString(rank));
		
		for(int i = 0 ; i<ar.length; i++) {
			for(int j=0; j<ar.length;j++) {
				if(ar[i]>ar[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println("순위 : " + Arrays.toString(rank));
		
		Arrays.fill(rank, 1);
		
		for(int i = 0 ; i<ar.length-1; i++) {
			for(int j=i+1; j<ar.length;j++) {
				if(ar[i]>ar[j]) {
					rank[i]++;
				}else if (ar[i]>ar[j]) {
					rank[j]++;
				}
			}
		}
		System.out.println("순위 : " + Arrays.toString(rank));
	}
}
