package april21;

public class LoopEx04 {
	public static void main(String[] args) {
		int cnt = 0;

		for (int i = 2; i <= 100; i++) {
			int j = 2;
			while (i % j != 0)
				++j;
			if (i == j) {
				System.out.printf("%4d", i);
				if (++cnt % 5 == 0)
					System.out.println();
			}
		}
	}
}