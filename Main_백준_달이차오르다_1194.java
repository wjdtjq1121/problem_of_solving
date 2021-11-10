import java.io.*;
import java.util.*;

public class Main_백준_달이차오르다_1194 {

	static int row, col, startR, startC, key, ans;
	static char map[][];
	static boolean visited[][][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];
		visited = new boolean[row][col][64];
		for(int i = 0; i < row; i++) {
			String input = br.readLine();
			for(int j = 0; j < col; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == '0') {
					map[i][j] = '.';
					startR = i;
					startC = j;
				}
			}
		}
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {startR, startC, 0, 0});
		visited[startR][startC][0] = true;		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int r = cur[0];
			int c = cur[1];
			int key = cur[2];
			int cnt = cur[3];						
			if(map[r][c] == '1') {
				ans = cnt;
				break;
			}			
			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];				
				if(!isInside(nr, nc) || visited[nr][nc][key] || map[nr][nc] == '#')
					continue;			
				if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					int newKey = key | (1 << map[nr][nc] - 'a');
					if(!visited[nr][nc][newKey]) {
						q.offer(new int[] {nr, nc, newKey, cnt+1});
						visited[nr][nc][newKey] = true;
					}
				} else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					int judge = 1 << (map[nr][nc] - 'A');
					if((key & judge) > 0) {
						q.offer(new int[] {nr, nc, key, cnt+1});
						visited[nr][nc][key] = true;
					}				
				} else {
					q.offer(new int[] {nr, nc, key, cnt+1});
					visited[nr][nc][key] = true;
				}
			}			
		}
		ans = ans == 0 ? -1 : ans;		
		System.out.println(ans);
	}
	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r < row && c < col;
	}
}
