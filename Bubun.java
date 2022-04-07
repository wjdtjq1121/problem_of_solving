package comb;

import java.util.Arrays;

/**
 * @author THKim
 */
public class Bubun {
	
	static int N = 3;
	static int input[] = {1, 4, 7};
	static boolean selected[];
	static int ans[];

	public static void main(String[] args) {
		
		selected = new boolean[N];
		ans = new int[N];

		bu(0);
		System.out.println("bubun");
	}
	private static void bu(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				if(selected[i])
					System.out.print(input[i] + " ");
				
			}
			System.out.println();

			return;
		}
		
		
		selected[cnt] = true;
		bu(cnt + 1);
		selected[cnt] = false;
		bu(cnt + 1);
		
		
		
	}

}
