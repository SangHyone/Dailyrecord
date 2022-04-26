package april22;

public class ArrayEx04 {
	final static int MAX = 5;
	public static void main(String[] args) {
		int[][] ar = new int[MAX][MAX];
		int k = 0;
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j <= i; j++) {
				ar[i-j][j] = ++k;
			}
		}
		arrayPrint(ar);
		
		for (int i = 1; i < ar.length; i++) {
			for (int j = i; j < MAX; j++) {
				ar[MAX-1+i-j][j] = ++k;
			}
		}
		arrayPrint(ar);
	}
	
	public static void arrayPrint(int ar[][]) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.printf("%3d",ar[i][j]);
			}
			System.out.println();
		}
		System.out.println("-".repeat(20)+"\n");
	}
}
