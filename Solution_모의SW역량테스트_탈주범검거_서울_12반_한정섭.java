import java.io.*;
import java.util.*;

public class Solution_모의SW역량테스트_탈주범검거_서울_12반_한정섭 {
//Solution
	static int row, col, pr, pc, time, ans;
	static int map[][];
	static boolean visited[][];
	static Queue<int []> q;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		
		
		
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			pr = Integer.parseInt(st.nextToken());
			pc = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			map = new int[row][col];
			visited = new boolean[row][col];
			
			for(int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < col; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			q = new LinkedList<>();
			q.offer(new int[] {pr, pc, 0});
			ans = 0;
//			System.out.println("debug: " + pr + " " + pc);
			while(!q.isEmpty()) {
				int cur[] = q.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];
				
				if(visited[r][c])
					continue;
				visited[r][c] = true;
				ans++;
				
				
				if(cnt+1 == time)
					continue;
				
				if(map[r][c] > 0)
					manhol(r, c, cnt, map[r][c]);


				
				
				
			}
			
			
			System.out.println("#" + tc + " " + ans);			
		}
	}
	
	
	static int[] spread(int type) {
		
		int num[] = new int[4];
		
		if(type == 1) {
			return new int[] {0, 1, 2, 3};
//			num = new int[4];
//			num[0] = 0;
//			num[1] = 1;
//			num[2] = 2;
//			num[3] = 3;
		} else if(type == 2) {
			return new int[] {0, 2};

//			num = new int[2];
//			num[0] = 0;
//			num[1] = 2;
		} else if(type == 3) {
			return new int[] {1, 3};

//			num = new int[2];
//			num[0] = 1;
//			num[1] = 3;
		} else if(type == 4) {
			return new int[] {1, 0};

//			num = new int[2];
//			num[0] = 0;
//			num[1] = 1;


		} else if(type == 5) {
			return new int[] {1, 2};

//			num = new int[2];
//			num[0] = 1;
//			num[1] = 2;
		} else if(type == 6) {
			return new int[] {2, 3};

//			num = new int[2];
//			num[0] = 2;
//			num[1] = 3;

		} else if(type == 7) {
			return new int[] {0, 3};

//			num = new int[2];
//			num[0] = 0;
//			num[1] = 3;
		}
		

		return new int[] {};
	}
	
	static void manhol(int r, int c, int cnt, int type) {
		
		
		if(type == 1) {
			direction(r, c, cnt, 0);
			direction(r, c, cnt, 1);
			direction(r, c, cnt, 2);
			direction(r, c, cnt, 3);
			
			
		} else if(type == 2) {
			direction(r, c, cnt, 0);
			direction(r, c, cnt, 2);
			
		} else if(type == 3) {
			direction(r, c, cnt, 1);
			direction(r, c, cnt, 3);

		} else if(type == 4) {
			direction(r, c, cnt, 0);
			direction(r, c, cnt, 1);

		} else if(type == 5) {
			direction(r, c, cnt, 1);
			direction(r, c, cnt, 2);

		} else if(type == 6) {
			direction(r, c, cnt, 2);
			direction(r, c, cnt, 3);

		} else if(type == 7) {
			direction(r, c, cnt, 0);
			direction(r, c, cnt, 3);

		}
		
		
		
	}
	
	static void direction(int r, int c, int cnt, int d) {
		
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		if(isInside(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0) {
			int loop[] = spread(map[nr][nc]);
			boolean check = false;
			for(int i = 0; i < loop.length; i++) {
				int reverse = (loop[i] + 2) % 4;
				if(reverse == d) {
					check = true;
					break;
				}
				
			}
			//System.out.println("what happend?");

			if(check)
				q.offer(new int[] {nr, nc, cnt + 1});
		}
	}
	
	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r < row && c < col;
	}
}
