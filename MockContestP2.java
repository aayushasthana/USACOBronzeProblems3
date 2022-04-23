import java.util.*;
import java.io.*;

public class MockContestP2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("whereami.in"));
		PrintWriter w = new PrintWriter("whereami.out");
		
		int N = sc.nextInt();
		String input = sc.next();
		
		sc.close();
		
		HashSet<String> possible = new HashSet<String>();
		int finalK = -1;
		for (int K = 1; K < N+1; K++) {
			boolean kWorks = true;
			
			for (int i = 0; i < N-K+1; i++) {
				String curr = input.substring(i, i+K);
				if (possible.contains(curr)) {
					kWorks = false;
				} 
				
				else {
					possible.add(curr);
				}
			}
			
			if (kWorks) {
				finalK = K;
				break;
			}
		}
		
		w.println(finalK);
		w.close();
	}
	
}
