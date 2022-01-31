import java.io.*;
import java.util.*;

public class Solution_bj2458_키패스 {
//Solution
	static int V, E;
	static ArrayList<Integer> big[];
	static ArrayList<Integer> small[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(br.readLine());
			E = Integer.parseInt(br.readLine());

			big = new ArrayList[V+1];
			small = new ArrayList[V+1];
			for(int v = 1; v <= V; v++) {
				big[v] = new ArrayList<>();
				small[v] = new ArrayList<>();				
			}

			for(int e = 1; e <= E; e++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				big[from].add(to);
				small[to].add(from);				
			}
			
//			for(int i: big[4])
//				System.out.println(i);
			
			int ans = 0;
			for(int v = 1; v <= V; v++) {
				
				int cnt = bfs(v);
//				if(v == 4)
//					System.out.println(cnt);
				if(cnt == V-1)
					ans++;

			}
			
			
			
			
			
			System.out.println("#" + tc + " " + ans);			
		}
		
		

	}
	static int bfs(int cur) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[V+1];
		q.offer(cur);
		visited[cur] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(cur == 1)
				System.out.println(now);
			for(int num: big[now]) {
				if(visited[num]) 
					continue;
				q.offer(num);
				visited[num] = true;

				cnt++;
				
			}					
		}
		q.offer(cur);

		while(!q.isEmpty()) {
			int now = q.poll();
			if(cur == 1)
				System.out.println(now);
			for(int num: small[now]) {
				if(visited[num]) 
					continue;
				q.offer(num);
				visited[num] = true;

				cnt++;
			}					
		}
		
		return cnt;

	}
}
