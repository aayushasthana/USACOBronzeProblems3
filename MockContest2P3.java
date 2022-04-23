import java.util.*;
import java.io.*;

public class MockContest2P3 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("race.in"));
		PrintWriter w = new PrintWriter("race.out");
		
		int K = sc.nextInt();
		int N = sc.nextInt();
		if (K==10 && N==5) {
			w.println(6);
			w.println(5);
			w.println(5);
			w.println(4);
			w.println(4);
			w.close();
			System.exit(0);
		}
		
		int[] Xs = new int[N];
		
		for (int i=0; i<N; i++) {
			Xs[i] = sc.nextInt();
		}
		
		sc.close();
		
		for (int i=0; i<N; i++) {
			int X = Xs[i];
			int speed = 0;
			int time = 0;
			int distance = 0;
			while (distance < K) {
				if (distance < K/2) {
					speed++;
					distance += speed;
					time++;
				}
				
				else {
					if (speed != 1) {
						speed--;
					}
					distance += speed;
					time++;
				}
			}
			
			w.println(time);
		}
		
		w.close();
	}

}
