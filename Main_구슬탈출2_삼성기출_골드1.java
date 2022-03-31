import java.io.*;
import java.util.*;

public class Main_±∏ΩΩ≈ª√‚2_ªÔº∫±‚√‚_∞ÒµÂ1 {
//Main
	static int row, col;
	static char map[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	static boolean visited[][][][];
	
	
	static int rr, rc, blr, blc, fr, fc;
	
	static class Ball {
		int rr, rc, br, bc, cnt;
		Ball(int rr, int rc, int br, int bc, int cnt) {
			this.rr = rr;
			this.rc = rc;
			this.br = br;
			this.bc = bc;
			this.cnt = cnt;
		}
	}
	
	static int bfs_ball() {

		visited[rr][rc][blr][blc] = true;
		Queue<Ball> q = new LinkedList<>();
		q.offer(new Ball(rr, rc, blr, blc, 1));
		
		while(!q.isEmpty()) {
			Ball cur = q.poll();
			int crr = cur.rr;
			int crc = cur.rc;
			int cbr = cur.br;
			int cbc = cur.bc;
			int cnt = cur.cnt;
			
			if(cnt > 10)
				return -1;
			
			
			for(int d = 0; d < dr.length; d++) {
				int nrr = crr;
				int nrc = crc;
				int nbr = cbr;
				int nbc = cbc;
			
				boolean red = false;
				boolean blue = false;
				
				while(map[nrr + dr[d]][nrc + dc[d]] != '#') {
					nrr += dr[d];
					nrc += dc[d];
					if(map[nrr][nrc] == 'O') {
						red = true;
						break;
					}
				}
				
				while(map[nbr + dr[d]][nbc + dc[d]] != '#') {
					nbr += dr[d];
					nbc += dc[d];
					if(map[nbr][nbc] == 'O') {
						blue = true;
						break;
					}
				}
				
				if(blue)
					continue;
				if(red) {
					return cnt;
				}
				
				
				if(nrr == nbr && nrc == nbc) {
					if(d == 0) {
						if(crc < cbc) 
							nrc -= dc[d];
						else 
							nbc -= dc[d];
					} else if(d == 1) {
						if(crr < cbr)
							nrr -= dr[d];
						else
							nbr -= dr[d];
						
						
					} else if(d == 2) {
						if(crc < cbc) 
							nbc -= dc[d];
						else 
							nrc -= dc[d];
						
					} else if(d == 3) {
						if(crr < cbr)
							nbr -= dr[d];
						else
							nrr -= dr[d];
					}
				}

				if(!visited[nrr][nrc][nbr][nbc]) {
					visited[nrr][nrc][nbr][nbc] = true;
					q.offer(new Ball(nrr, nrc, nbr, nbc, cnt+1));
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new char[row][col];
		visited = new boolean[row][col][row][col];
		
		for(int i = 0; i < row; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == 'R') {
					rr = i;
					rc = j;
				}
				if(map[i][j] == 'B') {
					blr = i;
					blc = j;
				}
				if(map[i][j] == 'O') {
					fr = i;
					fc = j;
				}					
			}
		}
		
		int result = bfs_ball();

		System.out.println(result);
	}
}
