import java.io.*;
import java.util.*;

public class Main_cheese_2636_dfs {
//Main
	static int row, col;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int time = 0;
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input_chee"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					result++;
			}
		}
		
		int last_cheese = 0;

		while(true) {
			visited = new boolean[row][col];
			
			count_out(0, 0);
			last_cheese = result;
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					if(map[i][j] == 1 && melted(i, j)) {
						dfs(i, j);
					}
				}
			}
			
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j ++) {
					if(map[i][j] == 3 || map[i][j] == 2)
						map[i][j] = 0;
				}
			}
			

			
			time++;
			if(result == 0)
				break;
			
		}
		
		
		
		
		System.out.println(time);
		System.out.println(last_cheese);


		
		
	}
	
	static void count_out(int r, int c) {
		visited[r][c] = true;
		map[r][c] = 2;
		for(int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isInside(nr, nc)) {
				if(map[nr][nc] == 0 && !visited[nr][nc]) {
					count_out(nr, nc);
				}
			}
			
		}		
	}
	
	
	static boolean melted(int r, int c) {
		
		for(int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(map[nr][nc] == 2)
				return true;
		}
		return false;
	}
	static void dfs(int r, int c) {
		visited[r][c] = true;
		map[r][c] = 3; // just melted

		result--;
		
		for(int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isInside(nr, nc)) {
				if(map[nr][nc] == 1 && !visited[nr][nc] && melted(nr, nc)) {
					dfs(nr, nc);
				}
			}
			
		}
		
	}
	
	
	static boolean isInside(int r, int c) {
		return r >= 0 && r < row && c >= 0 && c < col;
	}
	
}
