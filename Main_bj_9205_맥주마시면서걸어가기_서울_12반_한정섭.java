import java.io.*;
import java.util.*;

public class Main_bj_9205_맥주마시면서걸어가기_서울_12반_한정섭 {
//Main
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int dist[][] = new int[n+2][n+2];
			boolean d[][] = new boolean[n+2][n+2];
			List<int []> point = new ArrayList<>();
			for(int i = 0; i <= n+1; i++) {
				st = new StringTokenizer(br.readLine());				
				point.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});				
			}
			
			for(int i = 0; i <= n+1; i++) {
				for(int j = 0; j <= n+1; j++) {
					int[] p1 = point.get(i);
					int[] p2 = point.get(j);
					dist[i][j] = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
					
					if(dist[i][j] <= 1000)
						d[i][j] = true;					
				}
			}
			for(int k = 0; k <= n+1; k++) {
				for(int i = 0; i <= n+1; i++) {
					for(int j = 0; j <= n+1; j++) {
						if(d[i][k] & d[k][j])
							d[i][j] = true;
					}
				}
			}
			
			
			
			
			System.out.println(d[0][n+1] ? "happy" : "sad");
		}

		

		
		
	}
}
