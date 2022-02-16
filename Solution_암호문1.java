import java.io.*;
import java.util.*;

public class Solution_암호문1 {
//Solution
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input_암호문1"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		int T = Integer.parseInt(br.readLine());
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int size = Integer.parseInt(br.readLine());
			LinkedList<Integer> link = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size; i++) {
				link.add(Integer.parseInt(st.nextToken()));
			}
			int num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < num; i++) {
				String dump = st.nextToken();
				int put = Integer.parseInt(st.nextToken());
				int iter = Integer.parseInt(st.nextToken());
				for(int j = 0; j < iter; j++) {
//					int temp = Integer.parseInt(st.nextToken());
//					System.out.println("debug: " + temp);
					link.add(put, Integer.parseInt(st.nextToken()));					
					put++;
				}
				
				
			}
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(link.poll() + " ");
			}
			System.out.println();
			
		}
		
		
		//System.out.println("success");
	}
}
