import java.io.*;
import java.util.*;

public class Main_ÁÖ»çÀ§±¼¸®±â2_»ï¼º°ñµå3_¼º°ø {
//Main
	static int row, col, K, ans;
	static int map[][];
	static int dice[];
	static int dr[] = {0, 1, 0, -1}; // east south west north
	static int dc[] = {1, 0, -1, 0};
	
	
	static void init() {
		dice[0] = 2;
		dice[1] = 4;
		dice[2] = 1;
		dice[3] = 3;
		dice[4] = 5;
		dice[5] = 6;
	}
	
	static void east() {
		int temp = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[3];
		dice[3] = dice[2];
		dice[2] = temp;		
	}
	
	static void west() {
		int temp = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[3];
		dice[3] = dice[5];
		dice[5] = temp;		
	}
	
	static void south() {
		int temp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[4];
		dice[4] = dice[2];
		dice[2] = temp;		
	}
	
	static void north() {
		int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[4];
		dice[4] = dice[5];
		dice[5] = temp;		
	}
	
	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r < row && c < col;
	}
	


	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		dice = new int[6];
		init();
		
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int d = 0, r = 0, c = 0;
		
		for(int move = 0; move < K; move++) {
			
			if(isInside(r+dr[d], c+dc[d])) {
				r = r + dr[d];
				c = c + dc[d];
			} else {
				d+=2;
				if(d >= 4)
					d = d % 4;
				r = r + dr[d];
				c = c + dc[d];
			}
			if(d == 0) {
				east();
			} else if(d == 1)
				south();
			else if(d == 2)
				west();
			else if(d == 3)
				north();
			
			
			int cur_score = map[r][c];
			
			if(dice[5] > cur_score) {
				d++;
				if(d>=4)
					d = 0;
			} else if(dice[5] < cur_score) {
				d--;
				if(d < 0)
					d = 3;
			}
			
			boolean visited[][] = new boolean[row][col];
			int cnt = 1;
			visited[r][c] = true;
			Queue<int []> q = new LinkedList<>();
			q.offer(new int[] {r, c});
			
			while(!q.isEmpty()) {
				int cur[] = q.poll();
				int cr = cur[0];
				int cc = cur[1];
				
				for(int cd = 0; cd < dr.length; cd++) {
					int nr = cr + dr[cd];
					int nc = cc + dc[cd];
					
					if(isInside(nr, nc) && !visited[nr][nc] && map[nr][nc] == cur_score) {
						visited[nr][nc] = true;
						cnt++;
						q.offer(new int[] {nr, nc});						
					}
					
				}
			}
			
			ans += cur_score * cnt;

			
			
		}

		


		

		
		
		System.out.println(ans);
	}
}
