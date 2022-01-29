import java.io.*;
import java.util.*;
import java.awt.Point;

public class Solution_파핑파핑지뢰찾기_성공 {
//Solution
	
	static int size, ans;
	static char map[][];
	static int mine_num[][];
	
	static boolean visited[][];
	static int dr[] = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int dc[] = {0, 1, 0, -1, -1, 1, 1, -1};
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());

		
//		T = 1;
		
		for(int tc = 1; tc <= T; tc++) {
			size = Integer.parseInt(br.readLine());
			map = new char[size][size];
			for(int i = 0; i < size; i++) {
				map[i] = br.readLine().toCharArray();
			}
			ans = 0;
			visited = new boolean[size][size];
			mine_num = new int[size][size];
			
			putMine();
			

			
			for(int i = 0; i < size; i++) {

				for(int j = 0; j < size; j++) {
					if(mine_num[i][j] == 0 && map[i][j] != '*') {
						ans++;					
						mine_bfs(i, j);
//						click(i, j);
					}
				}
			}
				
//			for(int i = 0; i < size; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(mine_num[i][j] > 0 && map[i][j] != '*') {
						ans++;
					}
				}
			}
			

			System.out.println("#" + tc + " " + ans);			
		}
		
		
	}





	
	
	static void mine_bfs(int r, int c) {		
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		mine_num[r][c] = -1;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
//			if(!isInside(cr, cc) || map[cr][cc] == '*') {
//				continue;
//			}
//			mine_num[cr][cc] = -1;
			
			for(int d = 0; d < dr.length; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				
//				if(isInside(nr, nc) && map[nr][nc] != '*' && mine_num[nr][nc] == 0)
//					q.offer(new int[] {nr, nc});
				//System.out.println(nr + " " + nc);
				if(!isInside(nr, nc) || map[nr][nc] == '*' || mine_num[nr][nc] == -1)
					continue;
				
				if(mine_num[nr][nc] == 0)
					q.offer(new int[] {nr, nc});
				mine_num[nr][nc] = -1;

				
			}
			
			
		}
	}
	
	static void putMine() {		
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				if(map[r][c] == '*')
					continue;
				
				int cnt = 0;
				for(int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];					
					if(isInside(nr, nc) && map[nr][nc] == '*') {
						cnt++;
					}					
				}
				mine_num[r][c] = cnt;
			}
 		}		
	}
	
	
	
	static void bfs(int r, int c) {
		
		//sSystem.out.println("exeucu" + r + " " + c);
		
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		ans++;
		

		while(!q.isEmpty()) {
			//System.out.println("aa ");

			int cur[] = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			boolean check = true;
			if(visited[cr][cc])
				continue;
			if(!isInside(cr, cc) || map[cr][cc] == '*')
				continue;
			visited[cr][cc] = true;
//			ans++;
			
			//System.out.println("aa ");

			//System.out.println("aa " + check);

			for(int d = 0; d < dr.length; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(isInside(nr, nc) && map[nr][nc] == '*') {
					check = false;
				}				
			}
			//System.out.println("aa " + check);
			
			if(check) {
//				System.out.println("spread " + cr + " " + cc);
				for(int d = 0; d < dr.length; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if(isInside(nr, nc) && map[nr][nc] == '.') {
						map[nr][nc] = '1';
						visited[nr][nc] = true;

					}				
				}
				map[cr][cc] = '1';
			}
			
			
		}
		
		
	}
	
	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r < size && c < size;
	}
}
