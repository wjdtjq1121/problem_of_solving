import java.io.*;
import java.util.*;

public class Main_1149_rgb {
//Main
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int size = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		
		int map[][] = new int[size+1][3];
		int dp[][] = new int[size+1][3];
		
		for(int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= size; i++) {			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + map[i][2];
			
		}
		
		int ans = Math.min(dp[size][1], dp[size][2]);
		ans = Math.min(dp[size][0], ans);
		
		//System.out.println(Arrays.deepToString(dp));
		
		System.out.println(ans);
	}
}
