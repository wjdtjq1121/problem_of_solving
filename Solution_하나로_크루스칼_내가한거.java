import java.io.*;
import java.util.*;

public class Solution_하나로_크루스칼_내가한거 {
//Solution
	
	static int input_r[];
	static int input_c[];
	static int size;
	static ArrayList<graph> edgeList;
	static int parent[];
	static long answer;
	
	static class graph implements Comparable<graph>{		
		int from;
		int to;
		long weight;
		public graph(int from, int to, long weight) {
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
			input_r = new int[size];
			input_c = new int[size];
			parent = new int[size + 1];
			for(int i = 1; i <= size; i++) {
				parent[i] = i;
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size; i++) {
				input_r[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size; i++) {
				input_c[i] = Integer.parseInt(st.nextToken());
			}
			double cost = Double.parseDouble(br.readLine());
			
			edgeList = new ArrayList<>();
			
			for(int i = 0; i < size-1; i++) {
				for(int j = i + 1; j < size; j++) {
					long x = input_r[j] - input_r[i];
					long y = input_c[j] - input_c[i];
					
					edgeList.add(new graph(i, j, (x*x + y*y)));
				}
			}
			
			//나중에 null 없애보기
			//edgeList.sort(null);
			Collections.sort(edgeList);		

			
			answer = 0;
			int cnt = 0;
			for(int i = 0; i < edgeList.size(); i++) {
				
				if(union(edgeList.get(i).from, edgeList.get(i).to)) {
					answer += edgeList.get(i).weight;
					if(++cnt == size - 1)
						break;
					
//					cnt++;
//					if(cnt == size)
//						break;
				}
				
			}



			answer = Math.round(answer * cost);

			System.out.println("#" + tc + " " + answer);			
		}
		
		
		//System.out.println("success");
	}
	
	static int find(int a) {
		if(parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int x, int y) {
		
		int p_x = find(x);
		int p_y = find(y);
		
		if(p_x == p_y)
			return false;		
		parent[p_y] = p_x;		
		return true;
	}
	
	
	
	
	
}
