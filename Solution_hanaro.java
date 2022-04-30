import java.util.*;
import java.io.*;

public class Solution_hanaro {

	static class graph implements Comparable<graph>{
		
		int no;
		long w;
		
		public graph(int no, long w) {
			super();
			this.no = no;
			this.w = w;
		}

		@Override
		public int compareTo(graph o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int size = Integer.parseInt(br.readLine());
			int inputr[] = new int[size];
			int inputc[] = new int[size];
			boolean visited[] = new boolean[size];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size; i++)
				inputr[i] = Integer.parseInt(st.nextToken());			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size; i++)
				inputc[i] = Integer.parseInt(st.nextToken());
			double cost = Double.parseDouble(br.readLine());

			ArrayList<graph> arr[] = new ArrayList[size];
			
			for(int i = 0; i < size; i++) {
				arr[i] = new ArrayList<>();					
				for(int j = 0; j < size; j++) {
					if(i == j)
						continue;			
					long x = inputr[i] - inputr[j]; 
					long y = inputc[i] - inputc[j]; 							
					arr[i].add(new graph(j, x*x + y*y));
				}
			}
			
			long ans = 0;
			int cnt = 0;
			PriorityQueue<graph> q = new PriorityQueue<>();
			q.add(new graph(0, 0));
			
			while(!q.isEmpty()) {
				graph now = q.poll();
				
				if(visited[now.no])
					continue;
				visited[now.no] = true;
				ans += now.w;
				
				if(++cnt == size)
					break;
				
				for(int i = 0; i < arr[now.no].size(); i++) {
//					int one = arr[now.no].get(i).no;
					graph cur = arr[now.no].get(i);
//					if(!visited[one]) {
//						q.add(new graph(one, arr[now.no].get(i).w));
//					}
					if(!visited[cur.no]) {
						q.add(cur);
					}
					
					
				}
				
				
				
			}
			
			
			
			

			System.out.println("#" + tc +  " " + Math.round(ans * cost));			
		}
		

		

	}

}
