package lv1;

public class NumberOfDigits {
	public static void main(String[] args) {

	}

	public static int solution(int n) {
		int answer = 0;
		while(n>0) {
			answer+=n%10;
			n/=10;
		}
		return answer;
	}
}