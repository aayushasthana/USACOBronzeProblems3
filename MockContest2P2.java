import java.util.*;
import java.io.*;

public class MockContest2P2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("photo.in"));
		PrintWriter w = new PrintWriter("photo.out");
		
		int N = sc.nextInt();
		int[] original = new int[N-1];
		
		for (int i=0; i<N-1; i++) {
			original[i] = sc.nextInt();
		}
		
		sc.close();
		
		
		ArrayList<int[]> possible = new ArrayList<int[]>();
		
		for (int i=1; i<original[0]; i++) {
			int[] retval = new int[N];
			retval[0] = original[0]-i;
			for (int j=0; j<N-1; j++) {
				retval[j+1] = original[j] - retval[j];
			}
			possible.add(retval);
		}
		
		ArrayList<int[]> possible2 = new ArrayList<int[]>();
		for (int i=0; i<possible.size(); i++) {
			HashSet<Integer> nums = new HashSet<Integer>();
			boolean works = true;
			
			for (int j=0; j<N-1; j++) {
				if (nums.contains(possible.get(i)[j]) || possible.get(i)[j] <= 0) {
					works = false;
				}
				
				else {
					nums.add(possible.get(i)[j]);
				}
			}
			
			if (works) {
				possible2.add(possible.get(i));
			}
		}
		
		int ansIndex = 0;
		int min = possible.get(0)[0];
		for (int i=0; i<possible2.size(); i++) {
			if (min > possible2.get(i)[0]) {
				min = possible2.get(i)[0];
				ansIndex = i;
			}
		}
		
		int[] answer = possible2.get(ansIndex);
		for (int i=0; i<N; i++) {
			if (i==N-1) {
				w.print(answer[i]);
			}
			
			else {
				w.print(answer[i]+" ");
			}
		}
		
		/*
		for (int i=0; i<possible.size(); i++) {
			for (int j=0; j<N; j++) {
				System.out.print(possible.get(i)[j]+" ");
			}
			System.out.println();
		}
		*/
		w.println();
		
		w.close();
	}

}
