import java.io.*;
import java.util.*;

public class Main_1463_dp기초문제 {
//Main
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int x = Integer.parseInt(br.readLine());
		int ans = 0;
		int dp[] = new int[x+1];
		dp[1] = 0;
		
		for(int i = 2; i <= x; i++) {
			int min = Integer.MAX_VALUE;
			
			if(i % 2 == 0) {
				min = Math.min(min, dp[i/2] + 1);
			} 
			if(i % 3 == 0) {
				min = Math.min(min, dp[i/3] + 1);
			} 
			
			min = Math.min(min, dp[i-1] + 1);
			
			dp[i] = min;
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[x]);
	}
}
