package april22;

public class ArrayEx01 {

	final static int MAX = 3;

	public static void main(String[] args) {

		int[][] ar = new int[MAX][MAX];

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				ar[i][j] = (i%2==0) ? i * MAX + j +1 : (i+1)*MAX-j;
			}
		}
		arrayPrint(ar);
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				ar[j][i] = (i%2==0) ? i * MAX + j +1 : (i+1)*MAX-j;
			}
		}
		arrayPrint(ar);
	}
	
	public static void arrayPrint(int ar[][]) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-".repeat(20)+"\n");
	}
}
