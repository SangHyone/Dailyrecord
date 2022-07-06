package lv2;

import java.util.Scanner;

public class NQueen {
	public static int[] arr;
	public static int N;
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		solution(0);
		System.out.println(count);
		sc.close();
	}

	public static void solution(int Q) {
		if (Q == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[Q] = i;
			if (checked(Q)) {
				solution(Q + 1);
			}
		}
	}

	public static boolean checked(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
