package april22;

public class ParamEx {
	public static void main(String... args) { // main메서드의 인수도 가변 인수로 표현 가능하다.
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
		System.out.println(sum(1,2,3,4));
		System.out.println(sum(1,2,3,4,5));
		
		System.out.println(mySum(1,2));
		System.out.println(mySum(1,2,3));
		System.out.println(mySum(1,2,3,4));
		System.out.println(mySum(1,2,3,4,5));
	}
	
	// ...가변인수 : 인수의 개수가 정해져있지 않다. 배열로 받아준다.
	//               다른 인수를 쓸 수는 있지만 앞에 써야 한다.
	
	private static int mySum(int...args) {
		int sum =0;
		for(int i : args) sum +=i;
		return sum;
	}
	private static int sum(int a, int b) {
		return a+b;
	}
	private static int sum(int a, int b, int c) {
		return a+b+c;
	}
	private static int sum(int a, int b, int c,int d) {
		return a+b+c+d;
	}
	private static int sum(int a, int b, int c,int d, int e) {
		return a+b+c+d+e;
	}
}
