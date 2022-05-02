package april20;

public class MethodEx04 {
	public static void main(String[] args) {
		int sum1 = sum(5) + sum(4) + sum(10);
		System.out.println("sum = " + sum1);

		int sum2 = sum(1, 5) + sum(2, 4) + sum(5, 10);
		System.out.println("sum = " + sum2);

		int sum3 = sum(5, 1) + sum(2, 4) + sum(5, 10);
		System.out.println("sum = " + sum3);

	}

	public static int sum(int n) {
		int result = 0;
		for (int i = 0; i <= n; i++)
			result += i;
		return result;
	}

	public static int sum(int n, int m) {
		int result = 0;
		if (n <= m) {
			for (int i = n; i <= m; i++)
				result += i;
		} else {
			for (int i = m; i <= n; i++)
				result += i;
		}
		return result;

	}
}
