package permu;

import java.util.Arrays;

public class PermutationTest_my {

	static int N=8,R=8; 
	static int[] numbers;
	static boolean[] isSelected;
	static int gogo;
	
	public static void main(String[] args) {

		numbers = new int[R];
		isSelected = new boolean[N+1];
	
		permutation(0);
		
		System.out.println("total c: " + gogo);
		
	}
	
	private static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			gogo++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
	
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	
	
	

}
