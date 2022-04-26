package chapter6;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();
		
		sc.close();
		
		int[] arr = new int[26];

		for (int i = 0; i < S.length(); i++) {
			if ('A' <= S.charAt(i) && S.charAt(i) <= 'Z') {
				arr[S.charAt(i) - 'A']++;
			}

			else {
				arr[S.charAt(i) - 'a']++;
			}
		}

		int max = 0;
		char answer = '?';
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				answer = (char) (i + 'A');
			} else if (max == arr[i]) {
				answer = '?';
			}
		}
		System.out.println(answer);
	}
}
