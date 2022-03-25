import java.io.*;
import java.util.*;

public class Main_bj_회전초밥_15961 {
//Main
	static int N, d, k, c;
	
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int dish[] = new int[N];
		int kind[] = new int[d+1];
		
		for(int i = 0; i < N; i++)
			dish[i] = Integer.parseInt(br.readLine());
		
		int ans = 0;
		int cnt = 0;
		
		for(int i = 0; i < (N+k); i++) {
			//System.out.println(Arrays.toString(kind));

			if(i < k) {
				kind[dish[i%N]]++;
				if(kind[dish[i%N]] == 1)
					cnt++;
				continue;

			}
			int minus = i-k;
			
			if(kind[dish[minus%N]] > 0) {
				kind[dish[minus%N]]--;
				if(kind[dish[minus%N]] == 0)
					cnt--;
			}
			kind[dish[i%N]]++;
			if(kind[dish[i%N]] == 1)
				cnt++;
			
			if(kind[c] == 0) {
				ans = Math.max(ans, cnt+1);
			} else {
				ans = Math.max(ans, cnt);
			}
//			System.out.println(minus + " " + i);
//			System.out.println(dish[minus%N] + " " + dish[i%N]);
//			System.out.println(Arrays.toString(kind));

			
			
		}
		
		System.out.println(ans);

		

		
		
		//System.out.println("success");
	}
}
