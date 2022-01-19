import java.io.*;
import java.util.*;

public class Main_15684_사다리조작_골드5_수정_시간빨라짐{
//Main
	static int row, col, stick, ans;
	static int map[][];
	static int stand;
	static boolean end;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		stick = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
		ans = Integer.MAX_VALUE;
		for(int i = 0; i < stick; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			
			map[r][c] = 1;
			map[r][c+1] = 2;
		}
		
		for(int i = 0; i <= 3; i++) {
			stand = i;
			dfs(0, 0);
		}
		
		ans = ans == Integer.MAX_VALUE ? -1 : ans;
		System.out.println(ans);
	}
	
	static void dfs(int start, int cnt) {
		if(cnt > stand || end)
			return;
		if(cnt == stand) {
			if(check()) {
				ans = Math.min(ans, stand);				
				end = true;

			}			
			return;
		}
		
		
		for(int i = start; i < row; i++) {
			for(int j = 0; j < col-1; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					map[i][j+1] = 2;
					dfs(i, cnt + 1);
					map[i][j] = 0;
					map[i][j+1] = 0;
					
				}
			}
		}
		
		
	}
	static boolean check() {
		
		for(int j = 0; j < col; j++) {
			int go = j;
			for(int i = 0; i < row; i++) {
//				System.out.println("debug: " + i + " " + go);
				if(map[i][go] == 1)
					go++;
				else if(map[i][go] == 2)
					go--;
				
			}
			if(go != j)
				return false;
		}
		
		return true;
	}
	
}
