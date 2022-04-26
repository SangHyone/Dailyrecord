package lv1;

public class Lv1PassWord {
	public static void main(String[] args) {
		System.out.println(solution("A b C d E", 1));
	}

	public static String solution(String s, int n) {
		String answer = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ') {
				answer += ch;
				continue;
			}
			else if (ch >= 'a' && ch <= 'z') {
				if (ch + n > 'z') {
					answer += (char) (ch + n - 26);
				} else if (ch + n <= 'z') {
					answer += (char) (ch + n);
				}
			} 
			else if (ch >= 'A' && ch <= 'Z') {
				if (ch + n > 'Z') {
					answer += (char) (ch + n - 26);
				} else if (ch + n <= 'Z') {
					answer += (char) (ch + n);
				}
			}
		}
		return answer;
	}
}
