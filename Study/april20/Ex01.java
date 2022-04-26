package april20;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex01 {
	public static void main(String[] args) {
		String[] names = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌".split(",");
		System.out.println("인원 : " + names.length + "명");

		solution1(names);
		solution2(names);
		String[] names2 = solution3(names);
		System.out.println(names.length + "명 : " + Arrays.toString(names2));
		Arrays.sort(names2);
		System.out.println(names.length + "명 : " + Arrays.toString(names2));
	}

	private static void solution1(String[] names) {
		int kimc = 0, leec = 0;
		for (String name : names) {
			if (name.startsWith("김"))
				kimc++; // 문자열.startsWith(문자열) : 시작되느냐?
			if (name.startsWith("이"))
				leec++; // 문자열.endsWith(문자열) : 끝나느냐?
		}
		System.out.println("김씨 : " + kimc + "명");
		System.out.println("이씨 : " + leec + "명");
	}

	private static void solution2(String[] names) {
		int count = 0;
		for (String name : names) {
			if (name.equals("이재영"))
				count++; // 같냐?
		}
		System.out.println("이재영 : " + count + "명");
	}

	private static String[] solution3(String[] names) {
		Set<String> set = new HashSet<>(Arrays.asList(names)); // Set : 중복을 허용하지 않는 집합 자료구조
		String[] result = set.toArray(new String[0]);
		return result;
	}
}
