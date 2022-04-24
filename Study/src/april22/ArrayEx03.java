package april22;

public class ArrayEx03 {

	final static int MAX = 7;

	public static void main(String[] args) {
		int[][] ar = new int[MAX][MAX];

		int k = 0;
		for (int i = 0; i < MAX; i++) {
			if (i < MAX / 2)
				for (int j = i; j < MAX - i; j++) {
					ar[i][j] = ++k;

				}
			else {
				for (int j = MAX - i - 1; j <= i; j++) {
					ar[i][j] = ++k;

				}
			}
		}

		arrayPrint(ar);
	}

	public static void arrayPrint(int ar[][]) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				if (ar[i][j] != 0)
					System.out.printf("%3d", ar[i][j]);
				else
					System.out.print("   ");
			}
			System.out.println();
		}
		System.out.println("-".repeat(27) + "\n");
	}
}
