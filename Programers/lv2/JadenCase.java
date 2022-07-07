package lv2;

public class JadenCase {
	public static void main(String[] args) {

	}

	public String solution(String sentence) {
		String answer = "";
		String[] arr = sentence.toLowerCase().split("");
		boolean check = true;

		for (String s : arr) {
			answer += check ? s.toUpperCase() : s;
			check = s.equals(" ") ? true : false;
		}
		return answer;
	}

}
