import java.util.*;
import java.io.*;

public class MockContestP1 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("gymnastics.in"));
		PrintWriter w = new PrintWriter("gymnastics.out");
		
		int K = sc.nextInt();
		int N = sc.nextInt();
		int[][] order = new int[K+1][N+1];
		
		for (int i=1; i<K+1; i++) {
			for (int j=1; j<N+1; j++) {
				order[i][j] = sc.nextInt();
			}
		}
		
		
		sc.close();
		
		int count = 0;
		
		for (int i=1; i<N+1; i++) {
			for (int j=i+1; j<N+1; j++) {
				int firstCow = order[1][i];
				int secondCow = order[1][j];
				//System.out.printf("(%d, %d)\n", order[0][i], order[0][j]);
				//Second Cow is always greater index than First
				
				boolean consistent = true;
				for (int k=1; k<K+1; k++) {
					int firstCowPosition = -1;
					int secondCowPosition = -1;
					
					for (int l=1; l<N+1; l++) {
						if (order[k][l] == firstCow) {
							firstCowPosition = l;
						}
						
						else if (order[k][l] == secondCow) {
							secondCowPosition = l;
						}
					}
					
					if (firstCowPosition > secondCowPosition) {
						consistent = false;
					}
				}
				
				if (consistent) {
					System.out.printf("(%d, %d)\n", firstCow, secondCow);
					count++;
				}
			}
		}
		
		w.println(count);
		
		w.close();
	}

}
