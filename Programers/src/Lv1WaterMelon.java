
public class Lv1WaterMelon {
	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	public static String solution(int n) {
		String answer = "";

		for (int i = 0; i < n; i++) answer += "수박".charAt(i%2);
		return answer;
	}
}
