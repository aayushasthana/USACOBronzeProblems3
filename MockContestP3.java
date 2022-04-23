import java.util.*;
import java.io.*;

public class MockContestP3 {

	public static void main(String[] args) throws Exception {
		
		lineup l = new lineup();
		l.permute("ABCDEFGH",0,7);
		ArrayList<String> permutations = l.get_permutation();
		
		System.out.println(permutations.size());
		
		HashMap<String, Character> lookup = new HashMap<String, Character>();
		lookup.put("Beatrice", 'A');
		lookup.put("Belinda", 'B');
		lookup.put("Bella", 'C');
		lookup.put("Bessie", 'D');
		lookup.put("Betsy", 'E');
		lookup.put("Blue", 'F');
		lookup.put("Buttercup", 'G');
		lookup.put("Sue", 'H');
		
		HashMap<Character, String> rlookup = new HashMap<Character, String>();
		rlookup.put('A', "Beatrice");
		rlookup.put('B', "Belinda");
		rlookup.put( 'C',"Bella");
		rlookup.put('D',"Bessie");
		rlookup.put('E',"Betsy");
		rlookup.put('F',"Blue");
		rlookup.put('G',"Buttercup");
		rlookup.put('H',"Sue");
		
		Scanner sc = new Scanner(new File("lineup.in"));
		PrintWriter w = new PrintWriter("lineup.out");
		
		int N = sc.nextInt();
		char[][] rules = new char[N][2];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<6; j++) {
				if (j==0) {
					rules[i][0] = lookup.get(sc.next());
				}
				
				else if (j==5) {
					rules[i][1] = lookup.get(sc.next());
				}
				
				else {
					sc.next();
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.println(rules[i][0]+" "+rules[i][1]);
		}
		
		sc.close();
		
		//Check rules
		ArrayList<String> possibleAnswers = new ArrayList<String>();
		for (int i=0; i<permutations.size(); i++) {
			String curr = permutations.get(i);
			boolean possible = true;
			
			for (int j=0; j<N; j++) {
				char cow1 = rules[j][0];
				char cow2 = rules[j][1];
				int cow1Index = -1;
				int cow2Index = -1;
				
				for (int k=0; k<curr.length(); k++) {
					if (cow1 == curr.charAt(k)) {
						cow1Index = k;
					}
					
					if (cow2 == curr.charAt(k)) {
						cow2Index = k;
					}
				}
				
				if (Math.abs(cow1Index-cow2Index) != 1) {
					possible = false;
				}
			}
			
			if (possible) {
				possibleAnswers.add(curr);
			}
		}
		
		Collections.sort(possibleAnswers);
		String answer = possibleAnswers.get(0);
		for (int i=0; i<answer.length(); i++) {
			w.println(rlookup.get(answer.charAt(i)));
		}
		
		w.close();
	}
	
}

class lineup {
	public ArrayList<String> permutations = new ArrayList<String>();
   
	
	lineup() {
		
	}
	
	public ArrayList<String> get_permutation() {
		return permutations;
	}
	
	public void permute(String str, int l, int r) {
		
        if (l == r) {
        	//System.out.println(str);
        	permutations.add(str);
        }
            
        else {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
	
	 public String swap(String a, int i, int j)
	    {
	        char temp;
	        char[] charArray = a.toCharArray();
	        temp = charArray[i] ;
	        charArray[i] = charArray[j];
	        charArray[j] = temp;
	        return String.valueOf(charArray);
	    }
}
