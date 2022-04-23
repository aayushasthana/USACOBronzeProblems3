import java.util.*;
import java.io.*;

public class Problem51ModernArt {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("art.in"));
		PrintWriter w = new PrintWriter("art.out");
		
		int N = sc.nextInt();
		int[][] picture = new int[N][N];
		
		for (int i=0; i<N; i++) {
			String input = sc.next();
			for (int j=0; j<N; j++) {
				picture[i][j] = (int) (input.charAt(j)) - 48;
			}
		}
		
		sc.close();
		
		/*
		 iterate through colors:
		 	for each color check if it has not been intercepted
		 
		 return # of not intercepted colors
		 */
		
		int count = 0;
		for (int a=1; a<=9; a++) {
			System.out.println(a+": "+checkIntercepted(a, N, picture));
			if (checkIntercepted(a, N, picture) == 0) {
				count++;
			}
		}
		
		
		
		w.println(count);
		
		w.close();
	}
	
	public static int checkIntercepted(int color, int myN, int[][] grid) {
		
		boolean inArray = false;
		for (int i=0; i<myN; i++) {
			for (int j=0; j<myN; j++) {
				if (grid[i][j] == color) {
					inArray = true;
				}
			}
		}
		
		if (inArray) {
			int totalCount = 0;
			int maxRowCount = 0;
			int maxColCount = 0;
			
			for (int i=0; i<myN; i++) {
				for (int j=0; j<myN; j++) {
					if (grid[i][j] == color) {
						totalCount++;
					}
				}
			}
			
			for (int i=0; i<myN; i++) {
				int currentRowCount = 0;
				
				for (int j=0; j<myN; j++) {
					if (grid[i][j] == color) {
						currentRowCount++;
					}
				}
				
				maxRowCount = Math.max(maxRowCount, currentRowCount);
			}
			
			for (int i=0; i<myN; i++) {
				int currentColCount = 0;
				
				for (int j=0; j<myN; j++) {
					if (grid[j][i] == color) {
						currentColCount++;
					}
				}
				
				maxColCount = Math.max(maxColCount, currentColCount);
			}
			
			
			if (maxRowCount*maxColCount > totalCount) {
				return 1;
			} else {
				return 0;
			}
		
		} 
		
		else {
			return -1;
		}
	}
}
