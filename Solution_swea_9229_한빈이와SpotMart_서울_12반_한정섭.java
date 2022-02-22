import java.io.*;
import java.util.*;

public class Solution_swea_9229_한빈이와SpotMart_서울_12반_한정섭 {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("한빈이마트"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		st = new StringTokenizer(br.readLine());		

		int T = Integer.parseInt(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			int bags[] = new int[num];
			st = new StringTokenizer(br.readLine());

			for(int i = 0; i < num; i++) {
				bags[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(bags);
			int left = 0, right = bags.length - 1, answer = -1;
			while(left < right) {
				
				int sum = bags[left] + bags[right];
				
				if(sum == weight) {
					answer = sum;
					break;
				} else if(sum < weight) {
					if(answer < sum)
						answer = sum;
					left++;
				} else {
					right--;
				}				
			}
			
			System.out.println("#" + tc + " " + answer);
			

//			for(int i: bags)
//				System.out.print(i + " ");
//			System.out.println();
			
			
			

		}

		
		//System.out.println("suc");
		
		
	}
}
