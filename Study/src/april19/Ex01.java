package april19;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(1000));
		}
	private static int  solution(int n) {
		int result =0;
		for(int i=1; i<n; i++ ){
			if(i%3==0 || i%5 ==0) {
				result+=i;
			}
		}
		return result;
	}
}
