import java.io.*;
import java.util.*;

public class Main_벽부수고이동하기2_오래걸림 {
//Main
	static int row, col, K;
	static int map[][];
	static int dist[][][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	
	static class pos {
		int r, c, k;
		
		pos(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
	}
		
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		dist = new int[row][col][K+1];
		
		for(int i = 0; i < row; i++) {
			String s = br.readLine();
			char input[] = s.toCharArray();
			for(int j = 0; j < col; j++) {
				map[i][j] = input[j] - '0';
			}			
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				for(int k = 0; k <= K; k++) {
					dist[i][j][k] = -1;
				}				
			}
		}
		
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(0, 0, 0));
		dist[0][0][0] = 1;
		
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			int r = p.r;
			int c = p.c;
			int k = p.k;
			
//			if(dist[r][c][k] == -1)
//				dist[r][c][k] = 0;
			
			
			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// map을 본후에 1이면 k 증가시키고 dist 값 1 증가 시킴.
				
				// 그리고 continue
				
				// map이 0 이면   업뎃을 k개 시킴?
				
				if(isInside(nr, nc) &&  map[nr][nc] == 0 && dist[nr][nc][k] == -1) {					
					dist[nr][nc][k] = dist[r][c][k] + 1;
					q.offer(new pos(nr, nc, k));
					
				} 
				
				if(k == K)
					continue;
				if(isInside(nr, nc) &&  map[nr][nc] == 1 && dist[nr][nc][k+1] == -1) {
					dist[nr][nc][k+1] = dist[r][c][k] + 1;
					q.offer(new pos(nr, nc, k+1));
				}
				
				
				
				
			}
		}
		
		
//		for(int i = 0; i < row; i++) {
//			for(int j = 0; j < col; j++) {
//				System.out.print(dist[i][j][0]);				
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i = 0; i < row; i++) {
//			for(int j = 0; j < col; j++) {
//				System.out.print(dist[i][j][1]);				
//			}
//			System.out.println();
//		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i <= K; i++) {
			if(dist[row-1][col-1][i] != -1) {
				ans = Math.min(ans, dist[row-1][col-1][i]);
			}
		}
 		
		ans = ans == Integer.MAX_VALUE ? -1 : ans;
		

		

		
		
		//System.out.println("success");
		System.out.println(ans);
	}
	static boolean isInside(int r, int c) {
		return r < row && r >= 0 && c < col && c >= 0;
	}
}
