import java.io.*;
import java.util.*;

public class Solution_하나로_프림 {
//Solution
	
	static int size;
	static int inputr[];
	static int inputc[];
	static int parent[];
	static ArrayList<graph> arr;
	
	static class graph implements Comparable<graph>{
		int from;
		int to;
		long weight;
		
		graph(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(graph o) {
			return Long.compare(this.weight, o.weight);

		}



		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input_하나로"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		

		
		for(int tc = 1; tc <= T; tc++) {
			
			size = Integer.parseInt(br.readLine());
			inputr = new int[size];
			inputc = new int[size];

			parent = new int[size + 1];
			for(int i = 1; i <= size; i++)
				parent[i] = i;
			st = new StringTokenizer(br.readLine());

			for(int i = 0; i < size; i++)
				inputr[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size; i++)
				inputc[i] = Integer.parseInt(st.nextToken());
			double ad = Double.parseDouble(br.readLine());
			
			arr = new ArrayList<graph>();
			
			for(int i = 0; i < size; i++) {
				for(int j = i+1; j < size; j++) {
					long a = inputr[j] - inputr[i];
					long b = inputc[j] - inputc[i];					
					arr.add(new graph(i, j, (a*a + b*b)));					
				}
			}
			arr.sort(null);
			
			long ans = 0;
			int cnt = 0;
			for(int i = 0; i < arr.size(); i++) {
				
				if(union(arr.get(i).from, arr.get(i).to)) {
					ans+=arr.get(i).weight;
					if(size-1 == ++cnt)
						break;

				}
				
				
			}
			
			ans = Math.round(ans * ad);
				
			System.out.println("#" + tc + " " + ans);


		}
		
		

	}
	
	static int find(int a) {
		if(a == parent[a])
			return a;
		return parent[a] = find(parent[a]);		
	}
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px == py)
			return false;
		parent[py] = px;
		return true;
	}
	
}
