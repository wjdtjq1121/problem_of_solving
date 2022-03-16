import java.io.*;
import java.util.*;

public class Solution_SWTest샘플문제_프로세서연결하기_서울_12반_한정섭 {
//Solution
	static int row, col;
	static int map[][];
	static int per_order[];
	static ArrayList<int []> arr;
	static int total_core;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int max_core = Integer.MIN_VALUE;
	static int min_len;

	static int temp = 0;
	

	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_process"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());


		
		for(int tc = 1; tc <= T; tc++) {
			
			row = Integer.parseInt(br.readLine());
			col = row;
			map = new int[row][col];
			arr = new ArrayList<>();
			for(int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1 && i > 0 && i < row-1 && j > 0 && j < col-1) {
						arr.add(new int[] {i, j});
					} 
				}
			}
			total_core = arr.size();
			max_core = Integer.MIN_VALUE;
			min_len = 0;
			
			dfs(0, 0, 0);  // arr index, core cnt, total len


			
			
			
			
			System.out.println("#" + tc + " " + min_len);			
		}
		
		
		//System.out.println("success");
	}
	
	static void dfs(int cnt, int core_cnt, int total_len) {

		if(cnt == total_core) {
			
			if(max_core < core_cnt) {
				max_core = core_cnt;
				min_len = total_len;
			} else if(max_core == core_cnt) {
				if(min_len > total_len)
					min_len = total_len;
			}
			
			return;
		}
		
		int cur_r = arr.get(cnt)[0];
		int cur_c = arr.get(cnt)[1];
		
		for(int d = 0; d < dr.length; d++) {
			
			int judge = measure_length(arr.get(cnt), d);
			cur_r = arr.get(cnt)[0];
			cur_c = arr.get(cnt)[1];
			if(judge != -1) {
				
				dfs(cnt+1, core_cnt+1, total_len + judge);

				for(int i = 0; i < judge; i++) {
					cur_r += dr[d];
					cur_c += dc[d];
					map[cur_r][cur_c] = 0;					
				}
				
			}
			
		}
		dfs(cnt + 1, core_cnt, total_len);
		
	}
	
	static int measure_length(int cur[], int d) {
		int r = cur[0] + dr[d];
		int c = cur[1] + dc[d];
		boolean check = false;
		int len = 0;		
		while(isInside(r, c) && map[r][c] == 0) {
			
			len++;
			
			if(r == 0 || c == 0 || r == row-1 || c == col-1) {
				check = true;
				break;
			}			
			
			
			r += dr[d];
			c += dc[d]; 

		}
//		for(int i = 0; i < row; i++) {			
//			System.out.println(Arrays.toString(map[i]));
//		}
		//System.out.println("len: " + len + " " + cur[0] + " " + cur[1] + " " + d);
		
		if(check) {
			r = cur[0];
			c = cur[1];
			
			for(int i = 0; i < len; i++) {
				r += dr[d];
				c += dc[d];

				map[r][c] = 2;
				
			}
			
			return len;
		}

		return -1;
	}


	
	
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < row && c < col;
	}
}
