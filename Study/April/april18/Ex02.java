package april18;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println(Return(0,1));
		System.out.println(Return(1,1));
		System.out.println(Return(2,1));
		System.out.println(Return(1,10));
		System.out.println(Return(10,10));
		System.out.println(Return(11,10));
	}



public static int Return(int m,int n) {
	return (m-1)/n + 1;
}

}