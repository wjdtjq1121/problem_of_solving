package permu;
import java.util.Arrays;

public class PermutationTest2 {
	static int N=3,R=3; 
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;	
	public static void main(String[] args) {
		input = new int[]{1,4,7};
		numbers = new int[R];
		isSelected = new boolean[N];
		permutation(0);
	}	
	private static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) { 
			if(isSelected[i]) continue; 		
			numbers[cnt] = input[i];
			isSelected[i] = true;			
		
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}
}
