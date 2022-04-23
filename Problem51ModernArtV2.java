import java.util.*;
import java.io.*;

public class Problem51ModernArtV2 {
	
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
			int furthestRow = 0;
			int furthestCol = 0;
			int closestRow = 1000;
			int closestCol = 1000;
			
			for (int i=0; i<myN; i++) {
				for (int j=0; j<myN; j++) {
					if (grid[i][j] == color) {
						furthestRow = Math.max(furthestRow, i);
						furthestCol = Math.max(furthestCol, j);
						closestRow = Math.min(closestRow, i);
						closestCol = Math.min(closestCol, j);
					} 
				}
			}
			
			//System.out.println(color+": ("+closestRow+", "+closestCol+") , ("+furthestRow+", "+furthestCol+")");
			
			boolean intercepted = false;
			for (int i=closestRow; i<=furthestRow; i++) {
				for (int j=closestCol; j<=furthestCol; j++) {
					if (grid[i][j] != color) {
						intercepted = true;
					}
				}
			}
			
			if (intercepted) {
				return 1;
			}
			
			else {
				return 0;
			}
		} 
		
		else {
			return -1;
		}
	}
}
