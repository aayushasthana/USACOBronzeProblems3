import java.util.*;

public class Problem17CharacterPatternsA2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);	
		
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			
			for (int j=0; j<rows; j++) {
				for (int k=0; k<cols; k++) {
					if (k==0 || j==0 || k==cols-1 || j==rows-1) {
						System.out.print("*");
					}
					else {
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		
		sc.close();
	}

}
