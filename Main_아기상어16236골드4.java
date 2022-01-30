import java.io.*;
import java.util.*;

public class Main_아기상어16236골드4 {
//Main
	static int size, sr, sc, fish_size, shark_size, time;
	static int map[][];
	static ArrayList<int []> arr;
	static int dr[] = {-1, 0, 0, 1};
	static int dc[] = {0, -1, 1, 0};
	
	static class Fish implements Comparable<Fish>{
		int r, c, dist;
		
		Fish(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
		public int compareTo(Fish o) {
			if(Integer.compare(this.dist, o.dist) == 0) {
				if(Integer.compare(this.r, o.r) == 0) {
					return Integer.compare(this.c, o.c);
				} else {
					return Integer.compare(this.r, o.r);
				}
			} else {
				return Integer.compare(this.dist, o.dist);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sr = i;
					sc = j;
					map[i][j] = 0;
				} else if(map[i][j] > 0) {
					fish_size++;
//					arr.add(new int[] {i, j});
				}
					
			}
		}
		shark_size = 2;
		int eat_fish = 0;
		time = 0;
		int t = 0;
		while(fish_size != 0) {
			Queue<int []> q = new LinkedList<>();
			PriorityQueue<Fish> pq = new PriorityQueue<>();
			q.add(new int[] {sr, sc, 0});
			boolean visited[][] = new boolean[size][size];
			int end = fish_size;
			
			while(!q.isEmpty()) {
				int cur[] = q.poll();
				int r = cur[0];
				int c = cur[1];
				int cur_time = cur[2];
				

				if(!isInside(r, c) || visited[r][c]) 
					continue;
				if(map[r][c] > shark_size)
					continue;

//				System.out.println("extcuted");

				visited[r][c] = true;

				if(map[r][c] < shark_size && map[r][c] > 0) {
					pq.add(new Fish(r, c, cur_time));					
//					eat_fish++;
//					time += cur_time;
//					fish_size--;
//					sr = r;
//					sc = c;
//					map[r][c] = 0;
					
				}
				
				

				for(int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
//					System.out.println("extcuted");
					q.add(new int[] {nr, nc, cur_time + 1});
				}				
			}
			
			if(pq.size() == 0)
				break;
			
			Fish cur = pq.poll();
			time += cur.dist;
			map[cur.r][cur.c] = 0;
			eat_fish++;
 			if(eat_fish == shark_size) {
				eat_fish = 0;
				shark_size++;
			}
 			sr = cur.r;
 			sc = cur.c;

		}

		

		
		
		System.out.println(time);
	}
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size;
	}
}
