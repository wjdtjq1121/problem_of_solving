import java.io.*;
import java.util.*;


public class Solution2_swea_contact_using_Node {
//Solution
	static int size, start, ans;
	static int depth[];
	static ArrayList<Integer> arr[];
	static Node[] adjList;
	
	static class Node {
		int vertex;
		Node link;
			public Node(int vertex, Node link) {
				this.vertex = vertex;
				this.link = link;
			}
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;	

		System.out.println("hola");

		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			adjList = new Node[101];

			arr = new ArrayList[101];
			depth = new int[101];
			for(int i = 0; i < 101; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());

			System.out.println("hola");
			
			for(int i = 0; i < size/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from].add(to);
				adjList[from] = new Node(to,adjList[from]);

			}
			depth[start] = 1;
			
			Queue<Integer> q = new LinkedList<>();
			q.offer(start);
			ans = 1;
			int maxCnt = 1;
			
			while(!q.isEmpty()) {
				System.out.println("");
				int vertex = q.poll();
				for(int i = 0; i < arr[vertex].size(); i++) {
					if(depth[arr[vertex].get(i)] != 0)
						continue;
					
					q.offer(arr[vertex].get(i));
					depth[arr[vertex].get(i)] = depth[vertex] + 1;
				}
				maxCnt = depth[vertex];				
			}
			
			for(int i = 0; i < 101; i++) {
				if(maxCnt != depth[i]) 
					continue;
				
				ans = ans < i ? i : ans;

				
			}
			

			
			
			
			
		
			
			System.out.println("#" + tc + " " + ans);			
		}
		
		
	}
}
