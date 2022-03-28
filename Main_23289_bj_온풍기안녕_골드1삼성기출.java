import java.io.*;
import java.util.*;

public class Main_23289_bj_¿ÂÇ³±â¾È³ç_°ñµå1»ï¼º±âÃâ {
//Main
	
	static int row, col, K, wall_count;
	static int map[][];
	static boolean wall[][][];
	static int temp[][];

	static int dr[] = {-1, 0, 1, 0}; // north east south west
	static int dc[] = {0, 1, 0, -1};
	
	static ArrayList<int []> check_K;
	static ArrayList<Dot> heater;
	
	
	static class Dot {
		int r, c, d;
		Dot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}		
	}
	

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		wall = new boolean[row][col][dr.length];
		temp = new int[row][col];
		
		check_K = new ArrayList<>();
		heater = new ArrayList<>();
		

		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 5) {
					check_K.add(new int[] {i, j});
				} else if(map[i][j] >= 1 && map[i][j] < 5) {
					int d = map[i][j];
					if(d == 2) {
						d = 3;
					} else if(d == 3)
						d = 0;
					else if(d == 4)
						d = 2;
										
					heater.add(new Dot(i, j, d));
				}
				
				
			}
		}
		wall_count = Integer.parseInt(br.readLine());
		for(int i = 0; i < wall_count; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			wall[r-1][c-1][d] = true;
			
			if(d == 0) {
				if(isInside(r-2, c-1)) {
					d+=2;
					wall[r-2][c-1][d] = true;
				}
				
			} else if(d == 1) {
				if(isInside(r-1, c)) {
					d+=2;
					wall[r-1][c][d] = true;
				}				
			}			
		}
		
		int ans = 0;
		
		while(ans != 101) {
			ans++;
			
			int copyMap[][] = new int[row][col];
			
			for(int heat = 0; heat < heater.size(); heat++) {
//				int r = heater.get(heat).r;
//				int c = heater.get(heat).c;
//				int d = heater.get(heat).d;
//				r += dr[d];
//				c += dc[d];
				int dir = heater.get(heat).d;
				Queue<int []> q = new LinkedList<>();
				q.offer(new int[] {heater.get(heat).r + dr[dir], heater.get(heat).c + dc[dir], dir, 5});
//				copyMap[r][c] += 5;
				boolean visited[][] = new boolean[row][col];
				
				while(!q.isEmpty()) {
					int cur_point[] = q.poll();
					int r = cur_point[0];
					int c = cur_point[1];
					int d = cur_point[2];
					int power = cur_point[3];
					
					if(power <= 0)
						continue;
					
					copyMap[r][c] += power;
					
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(isInside(nr, nc) && !visited[nr][nc] && !wall[r][c][d]) {
						visited[nr][nc] = true;
						q.offer(new int[] {nr, nc, d, power-1});
					}
					int d1 = d - 1;
					int d2 = d + 1;
					if(d1 < 0)
						d1 = 3;
					if(d2 >= 4)
						d2 = 0;
					
					int nr1 = r + dr[d1];
					int nc1 = c + dc[d1];
					int nr2 = nr1 + dr[d];
					int nc2 = nc1 + dc[d];					
					if(!wall[r][c][d1] && isInside(nr1, nc1) && !wall[nr1][nc1][d] && isInside(nr2, nc2) && !visited[nr2][nc2]) {
						visited[nr2][nc2] = true;
						q.offer(new int[] {nr2, nc2, d, power-1});
					}
				
					nr1 = r + dr[d2];
					nc1 = c + dc[d2];
					nr2 = nr1 + dr[d];
					nc2 = nc1 + dc[d];					
					if(!wall[r][c][d2] && isInside(nr1, nc1) && !wall[nr1][nc1][d] && isInside(nr2, nc2) && !visited[nr2][nc2]) {
						visited[nr2][nc2] = true;
						q.offer(new int[] {nr2, nc2, d, power-1});
					}

					
					
					
					
				}
				
				
			}
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					temp[i][j] += copyMap[i][j];
				}
			}
			
			
//			for(int i = 0; i < row; i++) {
//				for(int j = 0; j < col; j++) {
//					System.out.print(temp[i][j]);
//				}
//				System.out.println();
//			}
			
			int copyMap2[][] = new int[row][col];
			boolean visitedCp2[][] = new boolean[row][col];
			for(int r = 0; r < row; r++) {
				for(int c = 0; c < col; c++) {					
					for(int d = 0; d < dr.length; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(isInside(nr, nc) && temp[r][c] > temp[nr][nc] && !wall[r][c][d]) {
							
							
							int val = Math.abs(temp[nr][nc] - temp[r][c])/4;
							if(val > 0) {
								
								copyMap2[nr][nc] += val;
								copyMap2[r][c] -= val;
								
//								System.out.println();
//								System.out.println(nr + " " + nc + " " + r + " " + c + " " + val);
								


							}
						}
					}
//					System.out.println();
//					System.out.println("r " + r + " c " + c);
//					for(int i = 0; i < row; i++) {
//						for(int j = 0; j < col; j++) {
//							System.out.print(copyMap2[i][j]);
//						}
//						System.out.println();
//					}
					
					visitedCp2[r][c] = true;
				}
			}
			
//			System.out.println();
//			for(int i = 0; i < row; i++) {
//				for(int j = 0; j < col; j++) {
//					System.out.print(copyMap2[i][j]);
//				}
//				System.out.println();
//			}
			
			
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					temp[i][j] += copyMap2[i][j];
				}
			}	
			
//			for(int i = 0; i < row; i++) {
//				for(int j = 0; j < col; j++) {
//					System.out.print(temp[i][j]);
//				}
//				System.out.println();
//			}
			
			int d = 0;
			int r = row-1;
			int c = 0;
			while(d != 4) {
				if(temp[r][c] > 0)
					temp[r][c]--;
				if(isInside(r + dr[d], c + dc[d])) {
					r += dr[d];
					c += dc[d];
				} else {
					d++;
					r += dr[d];
					c += dc[d];					
				}
				if(r == row -1 && c == 0)
					break;
			}
			
//			System.out.println();
//			for(int i = 0; i < row; i++) {
//				for(int j = 0; j < col; j++) {
//					System.out.print(temp[i][j]);
//				}
//				System.out.println();
//			}
//			
//			System.out.println();
//			for(int i = 0; i < row; i++) {
//				for(int j = 0; j < col; j++) {
//					System.out.print(copyMap2[i][j]);
//				}
//				System.out.println();
//			}
			
			
			boolean end = true;
			for(int i = 0; i < check_K.size(); i++) {
				int cr = check_K.get(i)[0];
				int cc = check_K.get(i)[1];
				
				if(temp[cr][cc] < K) {
					end = false;
					break;					
				}
			}
			if(end)
				break;
		
			
			
		}



		

		
		System.out.println(ans);
	}
	
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < row && c < col;
	}
}
