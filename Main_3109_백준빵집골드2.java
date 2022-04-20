import java.util.*;
import java.io.*;

public class Main {
//Main
	static int row, col, ans;
	static char map[][];
	static boolean visited[][];
	static boolean check;
	static int dr[] = {-1, 0, 1};
	static int dc[] = {1, 1, 1};


	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("./input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new char[row][col];

		for(int i = 0; i < row; i++) {
			map[i] = br.readLine().toCharArray();
		}
//		System.out.println(Arrays.deepToString(map));			
		visited = new boolean[row][col];

//		dfs(0, 0, 0);
		ans = 0;
		for(int i = 0; i < row; i++) {
			check = false;
			dfs(i, 0);
		}


		System.out.println(ans);			
		
	}
	static void dfs(int r, int c) {
		
		if(c == col-1) {
			check = true;
			ans++;
			return;
		}

		for(int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isInside(nr, nc) && map[nr][nc] == '.') {
				map[nr][nc] = 'x';
				dfs(nr, nc);
			}
			if(check)
				return;

		}

		
	}
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < row && c < col;
	}
}
