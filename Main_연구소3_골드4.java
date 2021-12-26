import java.util.*;
import java.io.*;

public class Main_17142_연구소3_골드4 {
//Main
	static int size, virus_num, virus_total, edge_case, ans;
	static int map[][];
	static int per_order[];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};

	static ArrayList<int []> arr;
	



	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken()); 
		virus_num = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		arr = new ArrayList<>();
		
		edge_case = size * size;

		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					arr.add(new int[]{i, j});
				}
				if(map[i][j] != 0)
					edge_case--;
			}
		}
		
		if(edge_case == 0) {
			System.out.println(0);
			return;
		}
			

		// System.out.println(Arrays.deepToString(map));

		// for(int i = 0; i < arr.size(); i++) {
		// 	System.out.println(arr.get(i)[0] + " " + arr.get(i)[1]);
		// }
		ans = Integer.MAX_VALUE;
		virus_total = arr.size();

		per_order = new int[virus_num];



		comb(0, 0);



		//System.out.println();
		ans = ans == Integer.MAX_VALUE ? -1 : ans;

		System.out.println(ans);			
	}

	static void bfs(int empty) {

		int cmap[][] = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cmap[i][j] = map[i][j];
			}
		}
		boolean visited[][] = new boolean[size][size];
		Queue<int []> q = new LinkedList<>();
		for(int i = 0; i < per_order.length; i++) {
			q.add(new int[]{arr.get(per_order[i])[0], arr.get(per_order[i])[1], 1});
//			System.out.println("debug " + arr.get(per_order[i])[0] + " " + arr.get(per_order[i])[1]);
			visited[arr.get(per_order[i])[0]][arr.get(per_order[i])[1]] = true;
		}

		int max_virus = 0;

		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			

			
			for(int d = 0; d < dr.length; d++) {
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				
				if(!isInside(nr, nc))
					continue;
				if(cmap[nr][nc] == 1 || visited[nr][nc])
					continue;
				if(cmap[nr][nc] == 0)
					empty--;
				if(empty == 0) {
					ans = Math.min(ans, cnt);
					return;
				}
				visited[nr][nc] = true;
				
				q.add(new int[] {nr, nc, cnt + 1});
				
			}
			
			
			
			
		}
		
//		while(!q.isEmpty()) {
//			int cur[] = q.poll();
//			int r = cur[0];
//			int c = cur[1];
//			int cnt = cur[2];
//
//			if(visited[r][c] || map[r][c] == 1)
//				continue;
//			visited[r][c] = true;
//			
//			if(cmap[r][c] == 0)
//				empty--;
//			
//			if(empty == 0) {
//				ans = Math.min(cnt, ans);
//				return;
//			}
//				
//			cmap[r][c] = cnt;
//
//			for(int d = 0; d < dr.length; d++) {
//				int nr = r + dr[d];
//				int nc = c + dc[d];
//				if(isInside(nr, nc) && !visited[nr][nc]) {
//
//
//
//					max_virus = cnt;
//					q.add(new int[]{nr, nc, cnt+1});
//				}
//			}
//
//
//		}






//		if(safe(cmap)) {
//			ans = ans > max_virus ? max_virus : ans;
//		}







	}

	static boolean safe(int cmap[][]) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(cmap[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static void comb(int cnt, int start) {
		if(cnt == virus_num) {
			//System.out.println(Arrays.toString(per_order));

			bfs(edge_case);

			




			return;
		}
		
		for(int i = start; i < virus_total; i++) {

			per_order[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size;
	}
}
