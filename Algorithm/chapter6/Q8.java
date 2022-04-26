package chapter6;

import java.io.IOException;

public class Q8 {
	public static void main(String[] args) throws IOException {
		int[] ar = new int[] { 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10 };
		int count = 0;

		while (true) {
			int ch = System.in.read();

			if (ch < 65)
				break;

			count += ar[ch - 65];
		}

		System.out.println(count);
	}
}
