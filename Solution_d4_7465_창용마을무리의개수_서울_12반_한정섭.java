import java.io.*;
import java.util.*;

public class Solution_d4_7465_창용마을무리의개수_서울_12반_한정섭 {
//Solution
	static int size, edges;
	static int parent[];
	static int result[];
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			edges = Integer.parseInt(st.nextToken());
			
			parent = new int[size + 1];
			result = new int[size + 1];
			for(int i = 1; i <= size; i++) {
				parent[i] = i;
			}
			
			for(int i = 0; i < edges; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(x, y);				
			}
//			System.out.println(Arrays.toString(parent));
			
			int answer = 0;
			int judge = find(parent[1]);
			for(int i = 1; i <= size; i++) {
				if(result[find(parent[i])] == 0) {
					result[find(parent[i])] = 1;
					answer++;
				}

			}
			


			
			
			System.out.println("#" + tc + " " + answer);			
		}
		
		

	}
	static void union(int x, int y) {
		int parent_x = find(x);
		int parent_y = find(y);
		
		if(parent_x == parent_y)
			return;
		
		parent[parent_y] = parent_x;
		
	}
	
	
	static int find(int a) {
		if(parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}
}
