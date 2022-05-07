package chapter9;

import java.util.Scanner;

public class Q4 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				printStar(i, j);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void printStar(int i, int j) {
		while (true) {
			if (i == 0)
				break;
			if (i % 3 == 1 && j % 3 == 1) {
				sb.append(" ");
				return;
			}
			i /= 3;
			j /= 3;
		}
		sb.append("*");
	}
}
