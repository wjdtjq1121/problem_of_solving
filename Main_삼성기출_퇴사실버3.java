import java.io.*;
import java.util.*;

public class Main_»ï¼º±âÃâ_Åð»ç½Ç¹ö3 {
//Main
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int size = Integer.parseInt(br.readLine());
		//int T = Integer.parseInt(br.readLine());
		int t[] = new int[size];
		int p[] = new int[size];
		int dp[] = new int[size+1];
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int ans = 0;
		
		for(int i = 0; i < size; i++) {
			
			if(i+t[i] <= size) {
				dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
		}

		

		
		
		System.out.println(dp[size]);
	}
}
