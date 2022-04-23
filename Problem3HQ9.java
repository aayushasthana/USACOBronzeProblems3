import java.util.*;
public class Problem3HQ9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		sc.close();
		boolean yes = false;
		for (int i=0; i<input.length(); i++) {
			if (input.charAt(i) == 'H' || input.charAt(i) == 'Q' || input.charAt(i) == '9') {
				yes = true;
			}
		}
		
		if (yes) {
			System.out.println("YES");
		}
		
		else {
			System.out.println("NO");
		}

	}

}
