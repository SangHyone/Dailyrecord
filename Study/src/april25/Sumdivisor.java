package april25;

public class Sumdivisor {
	public static void main(String[] args) {

	}

	public int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				answer += i;
			}
		}
		return answer;
	}
}
