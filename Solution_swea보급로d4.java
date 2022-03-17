import java.io.*;
import java.util.*;

public class Solution_swea보급로d4 {
//Solution
	
	static int size, ans;
	static int map[][];
	static int dist[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	
	static class Road implements Comparable<Road>{
		int r, c, w;

		public Road(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Road o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			dist = new int[size][size];
//			System.out.println(size);
			for(int i = 0; i < size; i++) {
				//System.out.println(br.readLine());
//				st = new StringTokenizer(br.readLine());
				//System.out.println("executed");
				char ch[] = br.readLine().toCharArray();
//				String str = br.readLine();
				for(int j = 0; j < size; j++) {
//					System.out.println(Integer.parseInt(st.nextToken()));
//					map[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] = ch[j] - '0';

					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<Road> q = new PriorityQueue<>();
			q.add(new Road(0, 0, map[0][0]));
			dist[0][0] = map[0][0];
			while(!q.isEmpty()) {
				Road road = q.poll();
				int r = road.r;
				int c = road.c;
				int w = road.w;
				
				for(int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(isInside(nr, nc) && dist[nr][nc] > dist[r][c] + map[nr][nc]) {
						dist[nr][nc] = dist[r][c] + map[nr][nc];
						q.add(new Road(nr, nc, w + map[nr][nc]));
						
					}
					
				}
				
			}
			
			
			
			
			
			System.out.println("#" + tc + " " + dist[size-1][size-1]);			
		}
		
		

	}
	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r < size && c < size;
	}
}
