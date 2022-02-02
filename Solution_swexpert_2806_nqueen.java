import java.io.*;
import java.util.*;

public class Solution_swexpert_2806_nqueen {
//Solution
	static int ans, size;
	static int map[][];
	static int row[];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			size = Integer.parseInt(br.readLine());
			ans = 0;
			map = new int[size][size];
			row = new int[size];
			
			for(int r = 0; r < size; r++) {
				map[0][r] = 1;
				dfs(1);
				map[0][r] = 0;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	static void dfs(int dep) {
		if(dep == size) {
			ans++;
//			for(int i = 0; i < size; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			return;
		}
		
		for(int c = 0; c < size; c++) {
			map[dep][c] = 1;
			if(isPossible(dep, c)) {
				dfs(dep+1);				
			}
			map[dep][c] = 0;
		}
	}
	static boolean isPossible(int r, int c) {
		
		for(int i = 0; i < r; i++) {
			if(map[i][c] == 1)
				return false;
			if(isRange(r-i-1, c-i-1) && map[r-i-1][c-i-1] == 1)
				return false;
			if(isRange(r-i-1, c+i+1) && map[r-i-1][c+i+1] == 1)
				return false;

		}
		
		
		
		return true;
	}
	static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size;
	}
}
