import java.io.*;
import java.util.*;

public class Main_17471_게리멘더링골드4 {
//Main
	static int n, part, ans, connected;
	static int map[];
	static int per[];
	static ArrayList<Integer> adjList[];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[n];
		map = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());			
			int size = Integer.parseInt(st.nextToken());
			for(int j = 0; j < size; j++) {
				int put = Integer.parseInt(st.nextToken()) - 1;
				adjList[i].add(put);
				adjList[put].add(i);

			}
		}
		ans = Integer.MAX_VALUE;
		for(int i = 1; i <= (n/2); i++) {
			part = i;
			per = new int[i];
			comb(0, 0);
//			System.out.println();
		}
		
		

		if(ans == Integer.MAX_VALUE)
			ans = -1;		
		System.out.println(ans);

	}
	
	static void check(ArrayList<Integer> arr, int idx) {
		if(visited[idx])
			return;
		if(!arr.contains(idx))
			return;
		
		visited[idx] = true;
		connected++;

		for(int i: adjList[idx]) {
			check(arr, i);
		}
		
		

	}

	private static void comb(int cnt, int start) {
		
		if(cnt == part) {
			//System.out.println(Arrays.toString(per));
			
			
			ArrayList<Integer> a = new ArrayList<>();
			ArrayList<Integer> b = new ArrayList<>();
			
//			for(int i = 0; i < n; i++) {
//				if(per[i] == i)
//					a.add(i);
//				else
//					b.add(i);				
//			}
			for(int i = 0; i < per.length; i++)
				a.add(per[i]);
			for(int i = 0; i < n; i++) {
				if(!a.contains(i)) {
					b.add(i);
				}
			}

			visited = new boolean[n];			
			connected = 0;

			check(a, a.get(0));

			check(b, b.get(0));
			
			int cur_ans = 0;
			
			if(connected == n) {
//				System.out.println();
				
				//System.out.println("lets get this party started");

				int ppl_a = 0;
				for(int area_a: a) {
					//System.out.print(area_a + " ");
					
					ppl_a += map[area_a];
				}	
				//System.out.println();
				int ppl_b = 0;
				for(int area_b: b) {
					//System.out.print(area_b + " ");

					ppl_b += map[area_b];
				}
				//System.out.println();
				cur_ans = Math.abs(ppl_a - ppl_b);
				
				//System.out.println("cur_ans " + cur_ans + " ans: " + ans);
				ans = Math.min(ans, cur_ans);

			}
			

			
			return;
		}
		
		for(int i = start; i < n; i++) {
			per[cnt] = i;
			
			comb(cnt+1, i+1);
		}

		
	}
}
