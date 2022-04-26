package lv1;


public class FindKimSolution {
	public static void main(String[] args) {
		System.out.println();
	}

	public static String solution(String[] seoul) {
		String answer = "";
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) {
				answer = "김서방은 " + i + "에 있다";
				break;
			}
		}
		return answer;
	}
}
