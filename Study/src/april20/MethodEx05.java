package april20;

public class MethodEx05 {
	public static void main(String[] args) {
		int n = (int) (Math.random() * 100);
		System.out.println(n + "은 " + (isEven1(n) ? "짝" : "홀") + "수입니다.");
		System.out.println(n + "은 " + (isEven2(n) ? "짝" : "홀") + "수입니다.");
		System.out.println(n + "은 " + (isEven3(n) ? "짝" : "홀") + "수입니다.");

		System.out.println("5! = " + factorial(5));
		System.out.println("20! = " + factorial(20));

		System.out.println(fibo1(5));
		System.out.println(fibo2(5));

	}

	public static boolean isEven1(int n) {
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEven2(int n) {
		boolean result = false;
		if (n % 2 == 0)
			result = true;
		return result;
	}

	public static boolean isEven3(int n) {
		return n % 2 == 0;
	}

	private static long factorial(int n) {
		long result = 1;
		for (int i = 1; i <= n; i++)
			result *= i;
		return result;
	}

	private static int fibo1(int n) {
		int f=0 , s = 1;
		for (int i = 0; i < n; i++) {
			s += f;
			f = s - f;
		}
		return s;
	}
	private static int fibo2(int n) {
		
		return n==1 || n==2 ? 1 : fibo2(n-2) + fibo2(n-1);
	}
}