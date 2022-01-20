import java.io.*;
import java.util.*;

public class Main_4485_녹색옷젤다_다익스트라_골드4 {
//Main
	static int size, ans;
	static int map[][];
	static boolean visited[][];
	static int dist[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
			
	
	static class Loc implements Comparable<Loc>{
		int r, c, w;

		public Loc(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Loc o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		
		int tc = 1;

		while(true) {
			ans = Integer.MAX_VALUE;
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			if(size == 0)
				break;
			dist = new int[size][size];
			for(int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			
			bfs();

			
			System.out.println("Problem " + tc + ": " + ans);
			tc++;
		}

		
		

	}
	
	static void bfs() {
		
//		Queue<Loc> q = new LinkedList<>();
		PriorityQueue<Loc> q = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		
		q.offer(new Loc(0, 0, map[0][0]));
		
		while(!q.isEmpty()) {
			Loc loc = q.poll();
			int r = loc.r;
			int c = loc.c;
			int w = loc.w;
			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(isInside(nr, nc) && dist[nr][nc] > dist[r][c] + map[nr][nc]) {
					dist[nr][nc] = dist[r][c] + map[nr][nc];
					q.offer(new Loc(nr, nc, w + map[nr][nc]));
				}
				
			}
			
			
		}
		
		
		ans = dist[size-1][size-1];
	}
	
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size;
	}
	

	
}
