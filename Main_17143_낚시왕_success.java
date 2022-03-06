import java.io.*;
import java.util.*;

public class Main_17143_낚시왕_success {
//Main
	static int row, col, shark_num, shark_count, ans;
	static int map1[][], map2[][];
	static Queue<Info> q = new LinkedList<>();
	
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, -1, 0, 1};
	
	static class Info {
		int r, c, s, d, z;
		
//		public Info(int r, int c) {
//			this.r = r;
//			this.c = c;			
//		}
		

		public Info(int r, int c, int s, int d, int z) {
//			this(r, c);
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		shark_num = Integer.parseInt(st.nextToken());
		map1 = new int[row+1][col+2];
		map2 = new int[row+1][col+2];
		
		for(int i = 0; i < shark_num; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(d == 1)
				d = 0;
			else if(d == 4)
				d = 1;			
			q.offer(new Info(r, c, s, d, z));
			map1[r][c] = z;
		}
		
		for(int move = 1; move <= col; move++) {
			
			if(shark_num == 0 || shark_count == shark_num)
				break;
			
			
			if(move % 2 == 1) {
				// call fish hunt
				hunt(map1, move);
				// move shark
				swim(map1, map2);
				
				
			} else {
				hunt(map2, move);
				swim(map2, map1);

				// same thing but
			}
			//System.out.println(Arrays.deepToString(map1));
			//System.out.println(Arrays.deepToString(map2));
			//System.out.println();
			
		}


		System.out.println(ans);
	}
	
	static void swim(int m1[][], int m2[][]) {
		int t_size = q.size();
		for(int i = 0; i < t_size; i++) {
			Info cur = q.poll();
			if(m1[cur.r][cur.c] != cur.z)
				continue;
			
			change_map(cur, m2);
			
			m1[cur.r][cur.c] = 0;
		}
	}
	
	static void change_map(Info cur, int m[][]) {
		int r = cur.r, c = cur.c, s = cur.s, d = cur.d, z = cur.z;
		

		if(d == 0 || d == 2) {
			s = s % ((row-1) * 2);
		} else {
			s = s % ((col-1) * 2);
		}			
		
		for(int i = 0; i < s; i++) {
			
			if(r + dr[d] <= 0 || r + dr[d] > row || c + dc[d] <= 0 || c + dc[d] > col) {
				d = (d + 2) % 4;
			}
			r += dr[d];
			c += dc[d];
		}
		
		if(z < m[r][c])
			return;
		
		m[r][c] = z;
		q.add(new Info(r, c, s, d, z));
		
		
	}
	
	
	
	
	
	static void hunt(int m[][], int move) {
		for(int i = 1; i <= row; i++) {
			if(m[i][move] != 0) {
				//System.out.println("debug: " + i + " " + move + " " + m[i][move]);
				ans += m[i][move];
				m[i][move] = 0;
				shark_count++;
				break;			
			}				
		}		
	}
	
}
