import java.io.*;
import java.util.*;



public class Solution_5656_벽돌깨기_mine {
//Solution
	static int N, row, col, ans;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};

	private static class Point{
		int r,c,cnt; // 행,열,벽돌숫자
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input_brick"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());


		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			int map[][] = new int[row][col];
			for(int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = Integer.MAX_VALUE;
			dfs(0, map);
//			go(0, map);
			
			System.out.println("#" + tc + " " + ans);			
		}
		
		
		//System.out.println("success");
	}

	static void dfs(int cnt, int map[][]) {
		if(cnt == N) {
			int count = getBrick(map);			
			ans = Math.min(ans, count);
			return;
		}
		
		// map copy
		
		int cmap[][] = new int[map.length][map[0].length];
		
		
		
		for(int c = 0; c < col; c++) {
			
			// check if it meets any block 
			
			int r = 0;
			
			while(r < row && map[r][c] == 0) {
				r++;
			}
			
			if(r == row) {
				dfs(cnt+1, map);
			} else {
				mapcopy(cmap, map);

//				myboom(cmap, r, c);
				destroy(cmap, r, c);
				
				gravity(cmap);				
				dfs(cnt+1, cmap);
			
				
			}
			

			
		}
		
	}



	
	
	
	private static void destroy(int[][] map, int r, int c) {
		
		if(!isInside(r, c) || map[r][c] == 0)
			return;
		int size = map[r][c];
		map[r][c] = 0;
		
		for(int i = 1; i < size; i++) {
			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d]*i;
				int nc = c + dc[d]*i;
				destroy(map, nr, nc);
			}
			
		}
		

		
	}

	private static void myboom(int[][] cmap, int r, int c) {

		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {r, c, cmap[r][c]});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			int size = cur[2];
			
			if(size == 0)
				continue;
			cmap[cr][cc] = 0;
			
			for(int i = 1; i < size; i++) {
				
				for(int d = 0; d < dr.length; d++) {
					int nr = cr + dr[d]*i;
					int nc = cc + dc[d]*i;
					

					if(isInside(nr, nc)) {
						q.offer(new int[] {nr, nc, cmap[nr][nc]});
						cmap[nr][nc] = 0;
					}
				}
				
			}
			
			
			
		}

		
	}


	private static void gravity(int[][] cmap) {
		// TODO Auto-generated method stub
		
		for(int c = 0; c < col; c++) {
			ArrayList<Integer> n = new ArrayList<>();
			
			for(int r = (row-1); r>=0; r--) {
				if(cmap[r][c] != 0) {
					n.add(cmap[r][c]);
					cmap[r][c] = 0;
				}
			}
			
			int cnt = 0;
			for(int r = (row-1); r>=(row - n.size()); r--) {
				cmap[r][c] = n.get(cnt++);
			}
			
			
//			int r = row-1;
//			for(int i = 0; i < n.size(); i++) {
//				cmap[r--][c] = n.get(i);
//
//			}
			
		}
		
		
	}


	private static int getBrick(int[][] map) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}


	private static void mapcopy(int[][] cmap, int[][] map) {
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				cmap[i][j] = map[i][j];
			}
		}
		
	}
	
	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r < row && c < col;
	}
	
}
