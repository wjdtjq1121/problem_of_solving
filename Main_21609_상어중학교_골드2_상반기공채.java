import java.io.*;
import java.util.*;

public class Main_21609_상어중학교_골드2_상반기공채어려운거 {
//Main
	
	static int size, color_num, ans;
	static int map[][];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static boolean visited[][];
	
	static PriorityQueue<Block> pq;	
	
	static class Block implements Comparable<Block>{
		int r, c, rainbow, block_size, block_color;
		
		Block(int r, int c, int rainbow, int block_size, int block_color) {
			this.r = r;
			this.c = c;
			this.rainbow = rainbow;
			this.block_size = block_size;
			this.block_color = block_color;
		}
		
		public int compareTo(Block o) {
			
			if(Integer.compare(this.block_size, o.block_size) == 0) {
				if(Integer.compare(this.rainbow, o.rainbow) == 0) {
					if(Integer.compare(this.r, o.r) == 0) {
						return -Integer.compare(this.c, o.c);
					} else {
						return -Integer.compare(this.r, o.r);
					}
				} else {
					return -Integer.compare(this.rainbow, o.rainbow);
				}				
			} else {
				return -Integer.compare(this.block_size, o.block_size);
			}			
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken());
		color_num = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		
		
		
		while(true) {
			pq = new PriorityQueue<>();
			visited = new boolean[size][size];
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) { 
					if(map[i][j] >= 1 && !visited[i][j]) {
						bfs_group(i, j);
					}				
				}
			}
						
			if(pq.size() == 0)
				break;
			visited = new boolean[size][size];
			Block b = pq.poll();
			int add_score = b.block_size;
			ans += (add_score * add_score);
			
			Queue<int []> q = new LinkedList<>();
			q.add(new int[] {b.r, b.c});
			int remove_color = map[b.r][b.c];
			while(!q.isEmpty()) {
				int temp[] = q.poll();
				int cur_r = temp[0];
				int cur_c = temp[1];
				
				if(!isInside(cur_r, cur_c) || visited[cur_r][cur_c] || map[cur_r][cur_c] < 0)
					continue;
				
				if(map[cur_r][cur_c] == remove_color || map[cur_r][cur_c] == 0) {
					visited[cur_r][cur_c] = true;
					map[cur_r][cur_c] = -2;

					for(int d = 0; d < dr.length; d++) {
						int nr = cur_r + dr[d];
						int nc = cur_c + dc[d];
						q.add(new int[] {nr, nc});
					}
				}
				
			}
			gravity();
			rotate();
			gravity();
			
		}

		System.out.println(ans);
	}
	
	static void rotate() {
		
		int cmap[][] = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cmap[size-1-j][i] = map[i][j];
			}
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				map[i][j] = cmap[i][j];				
			}
		}
		
	}
	
	
	static void gravity() {
		for(int j = 0; j < size; j++) {
			for(int i = size-1; i >= 0; i--) {
				
				if(map[i][j] >= 0) {
					int swit = map[i][j];
					int target_blank = i;
					
					while(isInside(target_blank+1, j) && map[target_blank+1][j] == -2) {
						target_blank++;
					}
					map[i][j] = map[target_blank][j];
					map[target_blank][j] = swit;

					
				}

			}
		}
	}
		
	static void bfs_group(int r, int c) {
		
		Queue<int []> q = new LinkedList<>();

		
		int cur_color = map[r][c];
		int rainbow_num = 0;
		int len = 0;
		q.add(new int[] {r, c});
				
		while(!q.isEmpty()) {
			int temp[] = q.poll();
			int cur_r = temp[0];
			int cur_c = temp[1];
			
			if(!isInside(cur_r, cur_c) || visited[cur_r][cur_c] || map[cur_r][cur_c] < 0)
				continue;
			
			if(map[cur_r][cur_c] == cur_color || map[cur_r][cur_c] == 0) {
				visited[cur_r][cur_c] = true;
				len++;
				if(map[cur_r][cur_c] == 0) {
					rainbow_num++;
				}
				
				
				for(int d = 0; d < dr.length; d++) {
					int nr = cur_r + dr[d];
					int nc = cur_c + dc[d];
					q.add(new int[] {nr, nc});
				}
			}
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(map[i][j] == 0)
					visited[i][j] = false;
			}
		}
		
		
		if(len >= 2) {
			pq.add(new Block(r, c, rainbow_num, len, map[r][c]));			
			//System.out.println(r + " " + c + " " + rainbow_num + " " + len + " " + map[r][c]);
		}
	}
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size;
	}
	
}
