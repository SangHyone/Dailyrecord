package april21;

import java.util.Random;

public class RankEx03 {
	public static void main(String[] args) {
		Random rnd = new Random();
		
		int score[][] = new int[11][12];
		arraysPrint(score);
		System.out.println("-".repeat(92));
		
		for(int i=0; i<score.length-1; i++) {
			for(int j=0;j<score[i].length-2;j++) {
				score[i][j] = rnd.nextInt(31)+70;
			}
		}
		arraysPrint(score);
		System.out.println("-".repeat(92));
		
		for(int i=0;i<score.length-1;i++) {
			for(int j=0;j<score[i].length-2;j++) {
				score[i][10] += score[i][j];
				score[10][j] += score[i][j];
				
			}
		}
		arraysPrint(score);
		System.out.println("-".repeat(92));
		
		for(int i=0; i<score.length-1;i++) score[i][11]=1;
		
		for(int i=0; i<score.length-1;i++) {
			for(int j = i+1;j<score.length-1;j++) {
				if(score[i][10]<score[j][10]) {
					score[i][11]++;
				}else if(score[i][10]>score[j][10]) {
					score[j][11]++;
				}
			}
		}
		arraysPrint(score);
		System.out.println("-".repeat(92));
	}
	
	private static void arraysPrint(int[][] ar) {
		for(int i=0;i<ar.length-1;i++) {
			for(int j=0; j<ar[i].length;j++) {
				System.out.printf("%7d", ar[i][j]);
				if(j==10) {
					System.out.printf("%7.2f", ar[i][10]/10.0);
				}
			}
			System.out.println();
		}
		for(int j=0;j<ar[0].length-2;j++) {
			System.out.printf("%7.2f", ar[10][j]/10.0);
		}
		System.out.println();
	}
}