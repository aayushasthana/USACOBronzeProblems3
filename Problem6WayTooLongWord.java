import java.util.*;

public class Problem6WayTooLongWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			String current = sc.next();
			
			if (current.length() > 10) {
				System.out.print(current.charAt(0));
				System.out.print(current.length()-2);
				System.out.print(current.charAt(current.length()-1));
				System.out.println();
			}
			
			else {
				System.out.print(current);
				System.out.println();
			}
		}
		
		sc.close();
	}

}
