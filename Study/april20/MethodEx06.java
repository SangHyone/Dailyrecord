package april20;

public class MethodEx06 {
	public static void main(String[] args) {
		System.out.println("5! = " + factorial1(5));
		System.out.println("5! = " + factorial2(5));
		System.out.println("6번쨰 피보나치 수열" + fibo1(6));
		System.out.println("6번쨰 피보나치 수열" + fibo2(6));
		System.out.println();
		
//		System.out.println("50번쨰 피보나치 수열" + fibo1(50));
//		System.out.println("50번쨰 피보나치 수열" + fibo2(50));
		show(5);
		System.out.println();
		show(8);
		System.out.println();
	}
	
	private static void show(int n) {
		System.out.printf("%5d" , n);
		if(n==1) return;
		show(n-1);
		System.out.printf("%5d" , n);
	}

	private static long factorial1(int n) {
		long result = 1;
		for (int i = 1; i <= n; i++)
			result *= i;
		return result;
	}

	private static long factorial2(int n) {
		return n <= 1 ? 1 : n * factorial2(n - 1);
	}

	private static long fibo1(int n) {
		long f = 0, s = 1;
		for (int i = 0; i < n; i++) {
			s += f;
			f = s - f;
		}
		return f;
	}

	private static long fibo2(int n) {

		return n == 1 || n == 2 ? 1 : fibo2(n - 2) + fibo2(n - 1);
	}
}
