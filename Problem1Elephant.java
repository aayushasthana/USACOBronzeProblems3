import java.util.*;

public class Problem1Elephant {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		sc.close();
		
		if (input%5 == 0) {
			System.out.println(input/5);
		}
		
		else {
			System.out.println(input/5 + 1);
		}
	}

}
