package april25;

public class Revers3 {
	public static void main(String[] args) {
		System.out.println(solution(45));
	}

	

	public static int solution(int n) {
		int result = 0;
		String t = new StringBuffer(conversion(n, 3)).reverse().toString();
		result = Integer.parseInt(t, 3);
		System.out.println(n + " : " + t + " : " + result);
		return result;

	}
	
	// n을 base진법으로 변환하는 함수
		public static String conversion(int n, int base) {
			String result = "";
			while (n > 0) {
				if (n % base < 10)
					result = n % base + result;
				else
					result = (char) ((n % base - 10) + 'A') + result;

				n /= base;
			}
			return result;
		}
}
