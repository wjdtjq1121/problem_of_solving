import java.util.*;
import java.io.*;

public class Main_20058_마법사상어파이어스톰_골드4_성공 {
//Main
	static int size, Q;
	static int map[][];
	static int input[];
	static int copyMap[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	
	
	static void operate(int sr, int sc, int er, int ec) {
		for(int r = sr, temp = 0; r < er; r++, temp++) {
			for(int c = sc, cnt = 0; c < ec; c++, cnt++) {
				map[sr+cnt][ec-1-temp] = copyMap[r][c];
			}
		}
		
		
	}
	
	static void rotate(int cur) {
		int point = (int)Math.pow(2, cur);
		
		copyMap = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for(int r = 0; r < size; r+=point) {
			for(int c = 0; c < size; c+=point) {
				int sr = r;
				int sc = c;
				int er = r+point;
				int ec = c+point;
				operate(sr, sc, er, ec);
				
			}			
		}
		


		
		
		
		
	}
	
	static void melt() {
		//copyMap = new int[size][size];
		boolean isMelt[][] = new boolean[size][size];
		
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				int cnt = 0;
				
				for(int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(isInside(nr, nc) && map[nr][nc] > 0) {
						cnt++;
					}
				}
				if(cnt <= 2) {
					isMelt[r][c] = true;
				}
				
			}
		}
		
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				if(isMelt[r][c] && map[r][c] > 0) {
					map[r][c]--;
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		int init = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		size = (int)Math.pow(2, init);
		map = new int[size][size];
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		input = new int[Q];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 0; i < Q; i++) {
			rotate(input[i]);
			melt();			
		}
		
		int ans = 0;
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				ans += map[r][c];
			}
		}
		int chunk = 0;
		
		boolean visit[][] = new boolean[size][size];
		
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				
				if(!visit[r][c] && map[r][c] > 0) {
					int cur_size = 1;
					visit[r][c] = true;
					Queue<int []> q = new LinkedList<>();
					q.offer(new int[] {r, c});
					
					while(!q.isEmpty()) {
						int cur[] = q.poll();
						int cr = cur[0];
						int cc = cur[1];
						
						for(int d = 0; d < dr.length; d++) {
							int nr = cr + dr[d];
							int nc = cc + dc[d];
							if(isInside(nr, nc) && map[nr][nc] > 0 && !visit[nr][nc]) {
								visit[nr][nc] = true;
								q.offer(new int[] {nr, nc});
								cur_size++;
							}
							
						}
						
					}
					chunk = chunk < cur_size ? cur_size : chunk;
					
				}
			}
		}
		

		
//		for(int r = 0; r < size; r++) {
//			for(int c = 0; c < size; c++) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(ans);
		System.out.println(chunk);

		

	}
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < size & c < size;
	}
}
