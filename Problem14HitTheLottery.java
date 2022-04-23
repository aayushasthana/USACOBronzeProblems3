import java.util.*;

public class Problem14HitTheLottery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		int bills100 = N/100;
		N -= bills100 * 100;
		int bills20 = N/20;
		N -= bills20 * 20;
		int bills10 = N/10;
		N -= bills10 * 10;
		int bills5 = N/5;
		N -= bills5 * 5;
		int bills1 = N;
		
		System.out.println(bills100 + bills20 + bills10 + bills5 + bills1);
	}

}
