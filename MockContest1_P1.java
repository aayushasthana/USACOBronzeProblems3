import java.util.*;

public class MockContest1_P1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[7];
		
		for (int i=0; i<7; i++) {
			nums[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(nums);
		int A = nums[0];
		int B = nums[1];
		
		int C = nums[6] - A - B;
		
		System.out.println(A+" "+B+" "+C);
	}

}
