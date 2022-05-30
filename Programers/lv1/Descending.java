package lv1;

import java.util.Arrays;

public class Descending {
	public static void main(String[] args) {
		
	}
	
	public static long solution(long n) {
		String[] ar = String.valueOf(n).split("");
		Arrays.sort(ar);

		StringBuilder sb = new StringBuilder();
		for (int i = ar.length - 1; i >= 0; i--) sb.append(ar[i]);

		return Long.parseLong(sb.toString());
	}
}
