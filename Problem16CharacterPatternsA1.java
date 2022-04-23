import java.util.*;

public class Problem16CharacterPatternsA1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			int rows = sc.nextInt();
			int cols = sc.nextInt();
			
			for (int k=0; k<rows; k++) {
				for (int j=0; j<cols; j++) {
					if (k%2 == 0) {
						if (j%2 == 0) {
							System.out.print("*");
						}
						else {
							System.out.print(".");
						}
					}
					
					else {
						if (j%2 == 0) {
							System.out.print(".");
						}
						else {
							System.out.print("*");
						}
					}
				}
				System.out.println();
			}
			
			System.out.println();
		}
		
		sc.close();
	}

}
