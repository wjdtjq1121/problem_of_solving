package comb;
import java.util.Arrays;

public class CombinationTest2_blank {
	
	static int N = 3, R = 3;
	static int ans[];
	static int input[] = {1, 4, 7};

	
	public static void main(String[] args) {
		
		ans = new int[R];
		
		combination(0, 0);
		

	}
	
	private static void combination(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		
		for(int i = start; i < N; i++) {
			
			ans[cnt] = input[i];
			
			
			combination(cnt+1, start+1);
			


		}
			

	}
	
	
	
	

}
