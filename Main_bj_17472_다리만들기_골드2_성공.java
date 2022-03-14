import java.io.*;
import java.util.*;

public class Main_bj_17472_다리만들기_골드2_성공 {
//Main
	static int row, col, island_num, ans;
	static int map[][], parent[];
	static boolean visited[][];
	static ArrayList<graph> arr;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};

	
	static class graph implements Comparable<graph>{
		int from, to, w;
		
		graph(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}		
		public int compareTo(graph o) {
			return Integer.compare(this.w, o.w);
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
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		island_num = 0;
		// bfs, make island group and give them number, respectively.
		visited = new boolean[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					island_num++;
					dfs(i, j);				
					
				}
			}
		}
		
//		for(int i = 0; i < row; i++) {
//			System.out.println(Arrays.toString(map[i]));			
//		}

		
		
		
		// make bridge..

		arr = new ArrayList<>();
		
		visited = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				
				if(map[i][j] != 0) {
					make_bridge(i, j, map[i][j]);
				}

				
				
			}
		}
		
//		for(int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).from + " " + arr.get(i).to + " " + arr.get(i).w);
//		}
		

		// kruscal based on bridge, it has class,   vertex, island num, from, to, dist,   compareto 
		// if kruscal doesnt make sysout -1
		
		parent = new int[island_num + 1];
		for(int i = 1; i <= island_num; i++) {
			parent[i] = i;
		}
		Collections.sort(arr);

		int all_connected = 0;
		int ans = 0;

		for(int i = 0; i < arr.size(); i++) {
			
			int iand1 = arr.get(i).from;
			int iand2 = arr.get(i).to;
			int w = arr.get(i).w;
			
			iand1 = find(iand1);
			iand2 = find(iand2);
			
			if(union(iand1, iand2))  {
				all_connected++;
				ans += w;
			}
			
			if(all_connected == island_num-1 ) {				
				break;
			}
		}
		
		ans = all_connected == island_num-1 ? ans : -1;
		

		

		
		
		System.out.println(ans);
	}
	
	static int find(int a) {
		if(parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}
	static boolean union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		
		if(roota == rootb)
			return false;
		parent[rootb] = roota;
		return true;		
	}
	
	// if it finds the same island number, skip it.
	// finds map number 0 go,,
	// other number found   --  check if the length is >= 2. same or greater than 2
	
	// check 4 side 
	// while(isInside, map[] - 0)
	// ++ len   -- if(finds other num?)  same num? .. done
	// length = 0  sx? = st. sy = st. init
	static void make_bridge(int r, int c, int from) {
		
		
		for(int d = 0; d < dr.length; d++) {
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			int len = 0;
			
			
			while(isInside(nr, nc) && map[nr][nc] != from) {
				len++;
				
//				if(r == 1 && c == 6 && d == 2) {
//					System.out.println(len + " " + nr + " " + nc + " " + map[nr][nc] + " " + from);
//				}

				
				if(map[nr][nc] != 0) {
					if(len >= 3) {

						arr.add(new graph(from, map[nr][nc], len-1));

						
						//System.out.println("from to len, start map r c d: " + from + " " + map[nr][nc] + " " + len + " " + r + " " + c + " " + d);

						
					}
					break;
				}
				nr += dr[d];
				nc += dc[d];
			}
		}
		
		
	}
	
	
	static void dfs(int r, int c) {
		if(visited[r][c])
			return;
		visited[r][c] = true;
		map[r][c] = island_num;
		for(int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isInside(nr, nc) && map[nr][nc] != 0) {
				dfs(nr, nc);
			}
			
		}
		
		

		

		
	}
	
	
	
	
	
	
	
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < row && c < col;
	}
	
	
}
