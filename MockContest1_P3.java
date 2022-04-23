import java.util.*;
import java.io.*;

public class MockContest1_P3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] directions = new String[N];
		int[] initialX = new int[N];
		int[] initialY = new int[N];
		int[] currentX = new int[N];
		int[] currentY = new int[N];
		
		for (int i=0; i<N; i++) {
			directions[i] = sc.next();
			initialX[i] = sc.nextInt();
			initialY[i] = sc.nextInt();
			currentX[i] = initialX[i];
			currentY[i] = initialY[i];
		}
		
		sc.close();
		
		//for (int i=0; i<N; i++) {
			//System.out.println(initialX[i]+" "+initialY[i]);
		//}
		
		/*
		 in grid:
		 	-1 = eaten
		 	0 = not eaten
		 	1 = currently occupied
		 
		 iterate time 1...N:
		 	simulate each cow's movement
		 */
		int[] grassEaten = new int[N];
		int[][] grid = new int[101][101];
		for (int i=0; i<N; i++) {
			grid[initialX[i]][initialY[i]] = -1;
		}
		
		boolean[] canMove = new boolean[N];
		for (int i=0; i<N; i++) {
			canMove[i] = true;
		}
		int[] prevX = new int[N];
		int[] prevY = new int[N];
		
		for (int time=1; time<=100; time++) {
			for (int i=0; i<N; i++) {
				//Infinity
				if (currentX[i] == 100 || currentY[i] == 100) {
					grassEaten[i] = -1;
				} 
				
				else if (directions[i].equals("N") && canMove[i]) {
					if (grid[currentX[i]][currentY[i]+1] != -1) {
						
						prevX[i] = currentX[i];
						prevY[i] = currentY[i];
						grid[prevX[i]][prevY[i]] = -1;
						
						currentY[i]++;
						//grid[currentX[i]][currentY[i]] = 1;
						grassEaten[i]++;
					} 
					
					else {
						grid[currentX[i]][currentY[i]] = -1;
						grassEaten[i]++;
						canMove[i] = false;
					}
				}
				
				else if (directions[i].equals("E") && canMove[i]) {
					if (grid[currentX[i]+1][currentY[i]] == 0) {
						prevX[i] = currentX[i];
						prevY[i] = currentY[i];
						grid[prevX[i]][prevY[i]] = -1;
						
						currentX[i]++;
						//grid[currentX[i]][currentY[i]] = 1;
						grassEaten[i]++;
					} 
					
					if (grid[currentX[i]+1][currentY[i]] == 1) {
						
					}
					
					else {
						grid[currentX[i]][currentY[i]] = -1;
						grassEaten[i]++;
						canMove[i] = false;
					}
				}
				
				else if (directions[i].equals("S") && canMove[i]) {
					if (grid[currentX[i]][currentY[i]-1] != -1) {
						prevX[i] = currentX[i];
						prevY[i] = currentY[i];
						grid[prevX[i]][prevY[i]] = -1;
						
						currentY[i]--;
						//grid[currentX[i]][currentY[i]] = 1;
						grassEaten[i]++;
					} 
					
					else {
						grid[currentX[i]][currentY[i]] = -1;
						grassEaten[i]++;
						canMove[i] = false;
					}
				}
				
				else if (directions[i].equals("W") && canMove[i]) {
					if (grid[currentX[i]-1][currentY[i]] != -1) {
						prevX[i] = currentX[i];
						prevY[i] = currentY[i];
						grid[prevX[i]][prevY[i]] = -1;
						
						currentX[i]--;
						//grid[currentX[i]][currentY[i]] = 1;
						grassEaten[i]++;
					} 
					
					else {
						grid[currentX[i]][currentY[i]] = -1;
						grassEaten[i]++;
						canMove[i] = false;
					}
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			if (grassEaten[i] == -1) {
				System.out.println("Infinity");
			}
			
			else {
				System.out.println(grassEaten[i]);
			}
		}
	}

}
