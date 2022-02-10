import java.io.*;
import java.util.*;

public class Solution_햄버거 {
	
	static int arr_fav[];
	static int arr_food[];
	static int answer, num, max_food;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_햄버거"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			max_food = Integer.parseInt(st.nextToken());
			arr_fav = new int[num];
			arr_food = new int[num];

			for(int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				arr_fav[i] = Integer.parseInt(st.nextToken());
				arr_food[i] = Integer.parseInt(st.nextToken());
			}
			
			
			answer = 0;
			dfs(0, 0, 0);
			
			
			
			System.out.println("#" + test_case + " " + answer);	
				
			
		}

		//System.out.println("suc");
		
	}	
	
	static void dfs(int count, int fav, int food) {
		
		if(food > max_food)
			return;

		if(count == num) {
			
			answer = Math.max(answer, fav);

			return;
		}
		
		
		dfs(count + 1, fav + arr_fav[count], food + arr_food[count]);
		dfs(count + 1, fav, food);

		
	}
	
	
	
}
