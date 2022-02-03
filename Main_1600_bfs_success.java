import java.io.*;
import java.util.*;

public class Main_1600_bfs_success {
//Main
	static int row, col, k, ans;
	static int map[][];
	static boolean visited[][][];

	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	static int hr[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int hc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static Queue<Info> q;

	static class Info {
		int r, c, k, cnt;

		public Info(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		ans = -1;

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[row][col][k + 1];
		visited[0][0][0] = true;
		q = new LinkedList<>();
		q.add(new Info(0, 0, k, 0));

//		while (!q.isEmpty()) {
//			Info cur = q.poll();
//			int cur_r = cur.r;
//			int cur_c = cur.c;
//			int cur_k = cur.k;
//			int cur_cnt = cur.cnt;
//
//			if (cur_r == row - 1 && cur_c == col - 1) {
//
//
//				ans = cur_cnt;
//				break;
//			}
//			
//			if(NotisInside(cur_r, cur_c))
//				continue;
//			
//			//System.out.println(cur_r + " " + cur_c);
//
//			if (map[cur_r][cur_c] == 1) {
//				continue;
//			}
//			if (visited[cur_r][cur_c][cur_k]) {
//				continue;
//			}
//			
//			visited[cur_r][cur_c][cur_k] = true;
//
//			for (int d = 0; d < dr.length; d++) {
//				int nr = cur_r + dr[d];
//				int nc = cur_c + dc[d];
//
//				q.add(new Info(nr, nc, cur_k, cur_cnt + 1));
//				
//
//			}
//
//			if (cur_k == 0)
//				continue;
//
//			for (int d = 0; d < hr.length; d++) {
//				int nr = cur_r + hr[d];
//				int nc = cur_c + hc[d];
//
//				q.add(new Info(nr, nc, cur_k - 1, cur_cnt + 1));
//				
//
//			}
//
//		}

		while(!q.isEmpty()) {
			Info cur = q.poll();
			int cur_r = cur.r;
			int cur_c = cur.c;
			int cur_k = cur.k;
			int cur_cnt = cur.cnt;

			if(cur_r == row-1 && cur_c == col-1) {
				ans = cur_cnt;
				break;
			}

			
			if(visited[cur_r][cur_c][cur_k] || map[cur_r][cur_c] == 1) {
				continue;
			}
			visited[cur_r][cur_c][cur_k] = true;
			
			System.out.println(cur_r + " " + cur_c + " " + cur_cnt);
			
			for(int d = 0; d < dr.length; d++) {
				int nr = cur_r + dr[d];
				int nc = cur_c + dc[d];
				
				if(isInside(nr, nc) && !visited[nr][nc][cur_k]) {
					q.add(new Info(nr, nc, cur_k, cur_cnt+1));
				}
				
			}
			
			
			if(cur_k == 0)
				continue;
			
			for(int d = 0; d < hr.length; d++) {
				int nr = cur_r + hr[d];
				int nc = cur_c + hc[d];
				
				if(isInside(nr, nc) && !visited[nr][nc][cur_k]) {
					q.add(new Info(nr, nc, cur_k-1, cur_cnt+1));
				}
				
			}			
			
			
			
		}

		System.out.println(ans);
	}

	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < row && c < col;
	}
	static boolean NotisInside(int r, int c) {
		return r < 0 || c < 0 || r >= row || c >= col;
	}
}
