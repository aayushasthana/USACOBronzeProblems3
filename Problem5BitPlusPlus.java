import java.util.*;

public class Problem5BitPlusPlus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		
		for(int i=0; i<N; i++) {
			String input = sc.next();
			
			if (input.equals("++X") || input.equals("X++")) {
				count++;
			}
			
			else {
				count--;
			}
		}
		
		sc.close();
		
		System.out.println(count);
	}

}
