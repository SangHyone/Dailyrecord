package april20;

public class MethodEx03 {
	public static void main(String[] args) {
		System.out.println("재미없는 자바!!");
		line(15);

		System.out.println("정말 재미없는 자바!!");
		line('~');
		line("^_",10);

		System.out.println("진짜진짜 재미없는 자바!!");
		line();
	}

	private static void line() {
		for (int i = 0; i < 80; i++)
			System.out.print("-");
		System.out.println();
	}

	private static void line(int count) {
		for (int i = 0; i < count; i++)
			System.out.print("-");
		System.out.println();
	}

	private static void line(char ch) {
		for (int i = 0; i < 80; i++)
			System.out.print(ch);
		System.out.println();
	}
	private static void line(String str, int count) {
		for (int i = 0; i < count; i++)
			System.out.print(str);
		System.out.println();
	}
}
