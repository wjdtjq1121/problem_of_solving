package comb;
import java.util.Arrays;

public class CombinationTest {

	static int N=4,R=2; 
	static int[] input;
	static int[] numbers;
	
	public static void main(String[] args) {

		input = new int[]{1,4,7,8};
		numbers = new int[R];
	
		combination(0,0);
	}
	
	private static void combination(int cnt,int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i < N; i++) { 
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
		}
		
	}
	
	
	
	

}
