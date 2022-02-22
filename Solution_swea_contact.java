import java.io.*;
import java.util.*;

public class Solution_swea_contact {
//Solution
	
	static int size, start_vertex, ans;
	static int depth[];
	static List<Integer> adjList[];
	
	static class graph {
		int vertex;
		int cnt;
			public graph(int vertex, int cnt) {
				this.vertex = vertex;
				this.cnt = cnt;
			}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_contact"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			start_vertex = Integer.parseInt(st.nextToken());
			
			depth = new int[101];
			adjList = new ArrayList[101];			

			ans = 1;
			
			for(int i = 1; i <= 100; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}
			depth[start_vertex] = 1;
			
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(start_vertex);
			int max_value = 1;
			
			while(!q.isEmpty()) {
				int index = q.poll();
				
				for(int i = 0; i < adjList[index].size(); i++) {
					int vertex = adjList[index].get(i);
					if(depth[vertex] != 0)
						continue;
					
					depth[vertex] = depth[index] + 1;
					q.offer(vertex);					
				}
				max_value = depth[index];
			}
			for(int i = 1; i < 101; i++) {
				if(max_value != depth[i])
					continue;				
				ans = (ans < i) ? i : ans;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		
		
	}
}
