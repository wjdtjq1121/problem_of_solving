import java.io.*;
import java.util.*;

public class Main_bj_15683_surveilance {
//Main
	static int row, col, cam_num;
	static int map[][];
	static int cmap[][];
	static int per[];
	static int ans;
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};  // e s w n
	
	static ArrayList<info> arr;
	
	static class info {
		int r;
		int c;
		int num;
		info(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
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
		map = new int[row][col];
		arr = new ArrayList<>();
		cam_num = 0;
		ans = Integer.MAX_VALUE;
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					arr.add(new info(i, j, map[i][j]));
					cam_num++;
				}
			}
		}
		per = new int[cam_num];
		
		permu(0);
		
		

		
		System.out.println(ans);
	}
	
	static void permu(int cnt) {
		if(cnt == cam_num) {
			
			cmap = new int[row][col];
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					cmap[i][j] = map[i][j];
				}
			}
			
			
			for(int i = 0; i < cam_num; i++) {
				direction(i, per[i]);
			}			
			ans = ans > blind() ? blind() : ans;

			return;
		}
		
		for(int i = 0; i < 4; i++) {
			
			per[cnt] = i;
			permu(cnt + 1);
		}
		
	}
	
	static void direction(int n, int d) {
		int cam = arr.get(n).num;
		
		if(cam == 1) {
			if(d == 0)
				draw(n, 0);
			if(d == 1)
				draw(n, 1);
			if(d == 2)
				draw(n, 2);
			if(d == 3)
				draw(n, 3);
			
		} else if(cam == 2) {
			if(d == 0 || d == 2) {
				draw(n, 0);
				draw(n, 2);
			} else {
				draw(n, 1);
				draw(n, 3);
			}
		} else if(cam == 3) {
			if(d == 0) {
				draw(n, 0);
				draw(n, 1);				
			}
			if(d == 1) {
				draw(n, 2);
				draw(n, 1);				
			}
			if(d == 2) {
				draw(n, 2);
				draw(n, 3);				
			}
			if(d == 3) {
				draw(n, 3);
				draw(n, 0);				
			}


		} else if(cam == 4) {
			if(d == 0) {
				draw(n, 0);
				draw(n, 1);		
				draw(n, 2);				

			}
			if(d == 1) {
				draw(n, 2);
				draw(n, 1);
				draw(n, 3);				

			}
			if(d == 2) {
				draw(n, 2);
				draw(n, 3);				
				draw(n, 0);				

			}
			if(d == 3) {
				draw(n, 3);
				draw(n, 0);
				draw(n, 1);				

			}
		} else if(cam == 5) {
			draw(n, 0);
			draw(n, 2);
			draw(n, 1);
			draw(n, 3);
		}
		
	}
	
	static void draw(int n, int d) {
		int r = arr.get(n).r;
		int c = arr.get(n).c;
//		cmap[r][c] = -1;
		
		while(isPossible(r, c)) {			
//			System.out.println("executed");
			cmap[r][c] = -1;
			r+=dr[d];
			c+=dc[d];			
		}
		
		
	}
	
	static boolean isPossible(int r, int c) {
		return r >= 0 && r < row && c >= 0 && c < col && map[r][c] != 6;
	}
	static int blind() {
		int num = 0;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(cmap[i][j] == 0)
					num++;
			}
		}

		
		return num;		
	}
	
}
