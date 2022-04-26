package april21;

public class LoopEx05 {
	public static void main(String[] args) {
		int cnt = 0;

		for (int i = 2; i <= 100; i++) {
			boolean flag = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.printf("%4d", i);
				if (++cnt % 5 == 0)
					System.out.println();
			}
		}
	}
}