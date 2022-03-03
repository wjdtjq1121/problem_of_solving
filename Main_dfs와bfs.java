import java.io.*;
import java.util.*;

public class Main_dfs와bfs {
//Main
	static int n, m, start;
	static ArrayList<Integer> arr[];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);			
			arr[to].add(from);			
		}
		for(int i = 1; i <= n; i++) {
			Collections.sort(arr[i]);		
		}
		
		visited = new boolean[n+1];
		dfs(start);
		System.out.println();

		visited = new boolean[n+1];
		bfs(start);
		


	}
	
	static void dfs(int num) {
		if(visited[num])
			return;
		visited[num] = true;
		System.out.print(num + " ");
		
		for(int x: arr[num]) {
			if(!visited[x])
				dfs(x);			
		}
		
//		for(int i = 0; i < arr[num].size(); i++) {
//			if(!visited[arr[num].get(i)])
//				dfs(arr[num].get(i));
//		}
		
	}
	static void bfs(int num) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			int get = q.poll();
			System.out.print(get + " ");
			
			for(int x: arr[get]) {
				if(!visited[x]) {
					visited[x] = true;

					q.offer(x);

					
				}
			}

			
			
			
		}
		
	}
	
}
