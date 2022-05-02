package april21;

public class LoopEx06 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis()
;		int cnt = 0;

		outter: for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0)
					continue outter;
			}

			System.out.printf("%4d", i);
			if (++cnt % 5 == 0)
				System.out.println();

		}
		System.out.println("경과시간 : " + (System.currentTimeMillis() - start)+"ms");
	}
}