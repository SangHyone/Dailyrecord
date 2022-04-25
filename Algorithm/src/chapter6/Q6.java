package chapter6;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.nextLine();

		sc.close();

		S = S.trim();

		String ans[] = S.split(" ");

		if (ans.length == 1 && ans[0].equals("")) {
			
			System.out.println(0);
			
		} else {
			
			System.out.println(ans.length);
			
		}
	}
}
