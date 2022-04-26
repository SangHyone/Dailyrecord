package april22;

public class ArrayEx05 {
	final static int MAX = 5;
	
	public static void main(String[] args) {
		int[][] ar = new int[MAX][MAX];
		int k = 0; // 증가변수
		int sw = 1 , row = 0, col = -1, count = MAX; // 반전, 행, 열, 갯수

		while(true) {
			//열 증감
			for(int i=0; i<count;i++) {
				col += sw;
				ar[row][col] = ++k;
			}
			if(--count==0) break; // 갯수 감소 0이면 종료
			//행증감
			for(int i= 0; i<count;i++) {
				row+=sw;
				ar[row][col] = ++k;
			}
			sw *= -1;
			
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
