package april21;

public class LoopEx08 {
	public static void main(String[] args) {
		for(String str : "재미없는 자바!!!".split("")) {
			System.out.println(str);
		}
		for(char str : "재미없는 자바!!!".toCharArray()) {
			System.out.println(str);
		}
		for(int str :new int[] {1,2,3,4,5,6,7,8,9,10}) {
			System.out.println(str);
		}
	}
}
