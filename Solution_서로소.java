import java.io.*;
import java.util.*;

public class Solution_서로소 {
	
	static int vertex, edges;
	static int parent[];

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			edges = Integer.parseInt(st.nextToken());
			parent = new int[vertex+1];
			
			for(int i = 1; i <= vertex; i++) {
				parent[i] = i;
			}
			System.out.print("#" + tc + " ");			

			for(int i = 0; i < edges; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(op == 0) {
					union(x, y);
				} else {
					int a = find(x); 
					int b = find(y); 
					if(a == b)
						System.out.print(1);
					else
						System.out.print(0);
					
				}
				
				

			}
			System.out.println();
			

		}		
	}
	static int find(int a) {
		if(parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int x, int y) {
		int parent_x = find(x);
		int parent_y = find(y);

		if(parent_x == parent_y)
			return;
		parent[parent_y] = parent_x;

	}
	
	
}
