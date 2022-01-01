import java.io.*;
import java.util.*;

public class Main_14502_연구소_골드5 {
//Main
	static int row, col, ans;
	static int map[][];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		ans = 0;
		dfs(0);

		

		
		
		System.out.println(ans);
	}
	
	static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();			
			return;
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;					
				}
			}
		}
		
		
	}
	
	static void bfs() {
		
		int n_map[][] = new int[row][col];
		Queue<int []> q = new LinkedList<>();
		int cur[];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				n_map[i][j] = map[i][j];
				if(n_map[i][j] == 2) {
					q.add(new int[] {i, j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for(int d = 0; d < dr.length; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(isInside(nr, nc) && n_map[nr][nc] == 0) {
					n_map[nr][nc] = 2;
					q.add(new int[] {nr, nc});
				}
				
			}
			
			
		}
		
		
		
		count_safe(n_map);
	}
	static void count_safe(int m[][]) {
		int count = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(m[i][j] == 0)
					count++;
			}
		}
		ans = Math.max(count, ans);
			
			
	}
	
	
	
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < row && c < col;
	}
}
