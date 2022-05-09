package chapter10;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] ar = new int[N][2];

		for (int i = 0; i < N; i++) {
			ar[i][0] = sc.nextInt();
			ar[i][1] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int rank = 1;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (ar[i][0] < ar[j][0] && ar[i][1] < ar[j][1]) {
					rank++;
				}
			}
			System.out.println(rank + " ");
		}
		sc.close();
	}
}
