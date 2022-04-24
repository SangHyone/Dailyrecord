package Chapter3;

import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println("Case #" +i + ": " + (A+B));
		}
		sc.close();
	}
}
