package lv1;

public class Hasard {
	public static void main(String[] args) {

	}

	public static boolean solution(int x) {
		boolean answer = true;
		int sum = 0;
		int a = x;
		while (a >= 1) {
			sum += a % 10;
			a /= 10;
		}
		if (x % sum == 0) {
			;
		} else {
			answer = false;
		}
		return answer;
	}

}
