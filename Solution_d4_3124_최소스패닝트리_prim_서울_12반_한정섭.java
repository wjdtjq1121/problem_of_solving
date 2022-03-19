import java.io.*;
import java.util.*;

public class Solution_d4_3124_최소스패닝트리_prim_서울_12반_한정섭 {
//Solution
	static int V, E;
	static int edges[][], parent[];
	static ArrayList<Info> arr;
	static ArrayList<Info> prim[];
	
	static class Info implements Comparable<Info>{
		int from, to, w;

		public Info(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		public int compareTo(Info o) {
			return Integer.compare(this.w, o.w);
		}		
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input_minspan"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			//ans = 0;
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edges = new int[E][3];
			parent = new int[V+1];
			arr = new ArrayList<>();
			prim = new ArrayList[V+1];

			for(int i = 1; i <= V; i++) {
				parent[i] = i;
				prim[i] = new ArrayList<>();
			}
//			System.out.println(V + " v");
			//System.out.println(Arrays.toString(parent));
			
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i][0] = Integer.parseInt(st.nextToken());
				edges[i][1] = Integer.parseInt(st.nextToken());
				edges[i][2] = Integer.parseInt(st.nextToken());
				//System.out.println(edges[i][0] + " " + edges[i][1] + " " + edges[i][2]);
				arr.add(new Info(edges[i][0], edges[i][1], edges[i][2]));
				
				prim[edges[i][0]].add(new Info(edges[i][0], edges[i][1], edges[i][2]));
				prim[edges[i][1]].add(new Info(edges[i][0], edges[i][1], edges[i][2]));
				
			}
			
			boolean visited[] = new boolean[V+1];

			long ans = 0;
			int cnt = 0;
			PriorityQueue<Info> pq = new PriorityQueue<>();
			pq.add(new Info(0, 1, 0));
//			visited[1] = true;
			
			while(!pq.isEmpty()) {
				Info cur = pq.poll();
				if(visited[cur.to])
					continue;
				visited[cur.to] = true;
				ans += cur.w;
				
				for(int i = 0; i < prim[cur.to].size(); i++) {
					
					if(visited[prim[cur.to].get(i).to]) {
						continue;
					}
					pq.add(new Info(0, prim[cur.to].get(i).to, prim[cur.to].get(i).w));
					
				}
				
			}


				
			
			
			
			
			System.out.println("#" + tc + " " + ans);			
		}
		
		
	}
	static int find(int a) {
		if(a == parent[a])
			return a;		
		return parent[a] = find(parent[a]);
	}
	static boolean union(int a, int b) {
		int root_a = find(a);
		int root_b = find(b);
		
		if(root_a == root_b)
			return false;
		
		parent[root_b] = root_a;
		return true;
	}
}
