package april21;


public class ArrayEx {
	public static void main(String[] args) {

		int[][] ar = new int[3][9];
		int t = 1;

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				ar[i][j] = t++;
				System.out.print(ar[i][j] + " ");
				if ((j + 1) % 3 == 0)
					System.out.println();
			}
		}// 1~9값 생성후 기본틀 찍기
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[ar.length-j-1][i] + " ");
				if ((j + 1) % 3 == 0)
					System.out.println();
			}
		} //90도 회전
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				ar[i][j]= i*ar.length+j+1;
			}
		} //초기화
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j] + " ");
				if ((j + 1) % 3 == 0)
					System.out.println();
			}
		}
		
	}
}
