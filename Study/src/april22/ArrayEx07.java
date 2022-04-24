package april22;

public class ArrayEx07 {
	public static void main(String[] args) {
		int [][] ar= new int [5][];
		
		for(int i=0;i<ar.length;i++) {
			ar[i] =new int[(i+1)*2];
		}
		
		arrayPrint(ar);
	}
	
	public static void arrayPrint(int ar[][]) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.printf("%3d", ar[i][j]);
			}
			System.out.println();
		}
		System.out.println("-".repeat(20) + "\n");
	}
}
