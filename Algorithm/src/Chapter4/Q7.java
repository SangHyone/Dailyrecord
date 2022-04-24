package Chapter4;

import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] ar;

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			int n = sc.nextInt();
			ar = new int[n];

			double sum = 0;

			for (int j = 0; j < n; j++) {
				int score = sc.nextInt();
				ar[j] = score;
				sum += score;
			}

			double avg = sum / n;
			double cnt = 0;

			for (int j = 0; j < n; j++) {
				if (ar[j] > avg) {
					cnt++;
				}
			}

			System.out.printf("%.3f%%\n", (cnt / n) * 100);
		}
		sc.close();
	}
}
