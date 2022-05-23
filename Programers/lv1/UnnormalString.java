package lv1;

public class UnnormalString {
	public static void main(String[] args) {

	}

	public static String solution(String s) {

		String answer = "";
		int cnt = 0;
		String[] array = s.split("");

		for (String ss : array) {
			cnt = ss.contains(" ") ? 0 : cnt + 1;
			answer += cnt % 2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
		}
		return answer;
	}
}
