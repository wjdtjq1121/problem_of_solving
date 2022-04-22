import java.io.*;
import java.util.*;

public class Main_테트로미노_골드5삼성기출성공_DFS백트래킹 {
//Main
	
	static int row, col, ans;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	
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
		visited = new boolean[row][col];
		
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
//				bfs(i, j);
				visited[i][j] = true;
				dfs(i, j, 0, map[i][j]);
				visited[i][j] = false;
				except(i, j);
			}
		}

		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int cnt, int sum) {
		if(cnt == 3) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!isInside(nr, nc) || visited[nr][nc])
				continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, cnt+1, sum + map[nr][nc]);
			visited[nr][nc] = false;

			
			
			
		}
		
		
	}
	
	

	
	
	static void bfs(int i, int j) {
		
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {i, j, map[i][j], 0});
		boolean visit[][] = new boolean[row][col];
		visit[i][j] = true;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int r = cur[0];
			int c = cur[1];
			int sum = cur[2];
			int cnt = cur[3];
			
			if(cnt == 3) {
				ans = Math.max(ans, sum);
				continue;
			}
			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!isInside(nr, nc) || visit[nr][nc])
					continue;
				
				visit[nr][nc] = true;
				q.offer(new int[] {nr, nc, sum + map[nr][nc], cnt+1});
				

				
				
				
			}
			
			
			
		}
		
		
	}
	
	static void except(int r, int c) {
		
		for(int d = 0; d < dr.length; d++) {
			// 앞으로 1나 앞으로 2, 앞 왼, 앞오.
			
			int d1 = (d-1) < 0 ? 3 : d-1;
			int d2 = (d+1) > 3 ? 0 : d+1;			
			int sum = 0;
			if(isInside(r + dr[d], c+ dc[d]) && isInside(r + dr[d] + dr[d], c + dc[d] + dc[d]) 
					&& isInside(r + dr[d] + dr[d1], c + dc[d] + dc[d1])) {
				sum = map[r][c] + map[r+ dr[d]][c+ dc[d]] + map[r+ dr[d] + dr[d]][c+ dc[d] + dc[d]]
						+ map[r+ dr[d] + dr[d1]][c+ dc[d] + dc[d1]];
				ans = Math.max(ans, sum);
			}
			if(isInside(r + dr[d], c+ dc[d]) && isInside(r + dr[d] + dr[d], c + dc[d] + dc[d]) 
					&& isInside(r + dr[d] + dr[d2], c + dc[d] + dc[d2])) {
				sum = map[r][c] + map[r+ dr[d]][c+ dc[d]] + map[r+ dr[d] + dr[d]][c+ dc[d] + dc[d]]
						+ map[r+ dr[d] + dr[d2]][c+ dc[d] + dc[d2]];
				ans = Math.max(ans, sum);
			}	
				
		}
		
	}
	
	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r<row && c<col;
	}
}
