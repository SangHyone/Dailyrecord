package april25;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println(getNum(77) ? "고집수" : "고집수아님");

	}

	public static boolean getNum(int n) {

		boolean flag = true;

		for (int i = 0; i < 4; i++) {

			n = (n / 10) * (n % 10);

			if (n == 0) {
				flag = false;
				break;
			}

		}

		return flag;

	}

	public static boolean getNum2(int n) {

		int cnt = 0;

		while (n > 10) {
			n = (n / 10) * (n % 10);
			cnt++;
		}
		return cnt > 3;
	}

	public static int get3(int n) {
		int cnt = 0;
		int t=0;
		for (int i = 100; i < n; i++) {
			t = (i / 100) * (i / 100) * (i / 100);
			t += (i / 10 % 10) * (i / 10 % 10) * (i / 10 % 10);
			t += (i % 10) * (i % 10) * (i % 10);
			if (i == n)
				cnt++;
		}
		return cnt;
	}

	public static int get4(int n) {
		int cnt = 0;
		int s = 0;
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				if (i % j == 0)
					s += j;
			}
			if (i == s) {
				cnt++;
			}
		}
		return cnt;

	}
}
