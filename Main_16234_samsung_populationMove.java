import java.io.*;
import java.util.*;

public class Main_16234_samsung_populationMove {
//Main
	static int size, left, right;
	static int map[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	static ArrayList<pos> arr;
	static boolean visited[][];
	static int group, flag;
	
	
	static class pos {
		int r;
		int c;
		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		left = Integer.parseInt(st.nextToken());
		right = Integer.parseInt(st.nextToken());
		map = new int[size][size];

		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		int temp = 0;

		while(true) {
			visited = new boolean[size][size];

			//dfs, add arraylist 
			// if arraylist is null then break out
			int f = 0;
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(visited[i][j])
						continue;
					arr = new ArrayList<>();
					group = map[i][j];
					flag = 0;
					dfs(i, j);
					if(arr.size() != 0) {
						//System.out.println(arr.size() + " " + group);
						f = 1;
						int put = group / (arr.size() + 1);
						map[i][j] = put;
						for(int k = 0; k < arr.size(); k++) {
							//System.out.println(arr.get(k).r + " " + arr.get(k).c);
							map[arr.get(k).r][arr.get(k).c] = put;
						}
						
					}
					
				}
			}

			if(f == 0)
				break;
			
			ans++;
			
			
			//System.out.println(Arrays.deepToString(map));
		}

		

		
		
		System.out.println(ans);
	}
	
	static void dfs(int row, int col) {
		
		if(visited[row][col])
			return;
		
		visited[row][col] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if(isInside(nr, nc)) {
				int get = Math.abs(map[nr][nc] - map[row][col]);
				
				if(!visited[nr][nc] && get >= left && get <= right) {
					flag = 1;
					group += map[nr][nc];
					
//					System.out.println(nr + " " + nc);
					arr.add(new pos(nr, nc));
					
					dfs(nr, nc);
				}
				
				
				
			}
			
			
		}
		
	}
	static boolean isInside(int r, int c) {
		return r >= 0 && r < size && c >= 0 && c < size;
	}
	
}
