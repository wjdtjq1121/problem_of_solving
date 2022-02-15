import java.io.*;
import java.util.*;

public class Solution_암호생성기_queue {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {			
			int dump = Integer.parseInt(br.readLine());
			
			Queue<int []> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 8; i++) {
				q.offer(new int[] {Integer.parseInt(st.nextToken())});
//				System.out.print(q.peek()[0] + " ");
//				q.poll();
			}

			int cycle = 1, temp = 0, flag = 1;
			while(q.peek()[0] > 0) {
				if(cycle % 6 == 0)
					cycle = 1;
				
				temp = q.peek()[0] - cycle++;
				//System.out.println("debug: " + temp);
				if(temp < 0)
					temp = 0;

				if(temp == 0)
					flag = 0;
				q.poll();
				q.offer(new int[] {temp});
				if(flag == 0)
					break;
				//cycle++;

			}
			
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(q.peek()[0] + " ");
				q.poll();
			}			
			System.out.println();
			
		}

	}

}
