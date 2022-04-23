import java.util.*;

public class MockContest1_P2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		sc.close();
		
		/*
		 iterate i 0...N:
		 	iterate j i...N:
		 		check if it is an average flower photo
		 */
		
		int count = 0;
		for (int i=0; i<N; i++) {
			for (int j=i; j<N; j++) {
				if (checkAverageFlower(nums, i, j)) {
					//System.out.println("COUNT INCREASED i: "+i+" j: "+j);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	public static boolean checkAverageFlower(int[] petalCounts, int f1, int f2) {
		boolean retval = false;
		float totalCount = 0;
		float totalFlowers = f2-f1+1;
		
		for (int a=f1; a<=f2; a++) {
			totalCount += (float)(petalCounts[a]);
		}
		
		float avgPetals = totalCount/totalFlowers;
		//System.out.println("i: "+f1+", j: "+f2+", avg: " + avgPetals);
		for (int a=f1; a<=f2; a++) {
			if ((float)(petalCounts[a]) == avgPetals) {
				retval = true;
			}
		}
		
		return retval;
	}
}
