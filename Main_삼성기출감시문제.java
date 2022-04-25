import java.util.*;
import java.io.*;

public class Main_삼성기출감시문제 {
	
	static int r, c, cam_size;
	static int map[][];
	static int cmap[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0}; // east south west north
	static int ans;
	static int per[];
	static int temp;
	static ArrayList<cctv> cctvList;
	
	static class cctv {
		int row;
		int col;
		int num;
		
		public cctv(int row, int col, int num) {
			super();
			this.row = row;
			this.col = col;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input_watch"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		cam_size = 0;
		cctvList = new ArrayList<>();
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 6 && map[i][j] != 0) {
					cam_size++;
					cctvList.add(new cctv(i, j, map[i][j]));					
				}
			}
		}
		per = new int[cam_size];
		ans = Integer.MAX_VALUE;

		
		order(0);


		System.out.println(ans);			

		

	}
	
	static void order(int cnt) {
		if(cnt == cam_size) {
//			System.out.println(Arrays.toString(per));
			
			cmap = new int[r][c];
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					cmap[i][j] = map[i][j];
				}
			}
			
			for(int i = 0; i < cam_size; i++) {
				direction(cctvList.get(i), per[i]);
				
				
			}
			ans = ans > count() ? count() : ans;


			return;
		}
		
		for(int i = 0; i < 4; i++) {
			per[cnt] = i;
			order(cnt + 1);
		}
		
	}
	
	static void direction(cctv cam, int d) {
		int num = cam.num;
		
		if(num == 1) {
			if(d == 0) 
				check(cam, 0);
			if(d == 1) 
				check(cam, 1);
			if(d == 2) 
				check(cam, 2);
			if(d == 3) 
				check(cam, 3);
		} else if(num == 2) {
			if(d == 0 || d == 2) {
				check(cam, 0);
				check(cam, 2);
			} else {
				check(cam, 1);
				check(cam, 3);
			}
			
		} else if(num == 3) {
			if(d == 0) {
				check(cam, 0);
				check(cam, 1);
				
			} else if(d == 1) {
				check(cam, 1);
				check(cam, 2);		
				
			} else if(d == 2) {
				check(cam, 2);
				check(cam, 3);
				
			} else if(d == 3) {
				check(cam, 3);
				check(cam, 0);				
			}
			
			
		} else if(num == 4) {
			if(d == 0) {
				check(cam, 0);
				check(cam, 1);
				check(cam, 2);
				
			} else if(d == 1) {
				check(cam, 1);
				check(cam, 2);		
				check(cam, 3);

			} else if(d == 2) {
				check(cam, 2);
				check(cam, 3);
				check(cam, 0);

			} else if(d == 3) {
				check(cam, 3);
				check(cam, 0);				
				check(cam, 1);

			}
			
		} else if(num == 5) {
			check(cam, 3);
			check(cam, 0);				
			check(cam, 1);
			check(cam, 2);				

		} 
  		
		
		
	}
	
	static void check(cctv cam, int d) {
		int row = cam.row;
		int col = cam.col;
		
		cmap[row][col] = -1;
		
		int nrow = row + dr[d];
		int ncol = col + dc[d];
		
		while(isPossible(nrow, ncol)) {
			cmap[nrow][ncol] = -1;
			nrow+=dr[d];
			ncol+=dc[d];
		}
		
		
	}
	
	static boolean isPossible(int row, int col) {
		return row >= 0 && row < r && col >= 0 && col < c && map[row][col] != 6;		
	}
	
	static int count() {
		int num = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(cmap[i][j] == 0)
					num++;
			}
		}
//		System.out.println(num + "oioi");
		return num;
	}
	

}
