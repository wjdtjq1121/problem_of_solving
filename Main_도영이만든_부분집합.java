import java.io.*;
import java.util.*;

public class Main_도영이만든_부분집합 {
//Main
	
	static ArrayList<Food> arr;
	static int T, answer;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		visited = new boolean[T];
		arr = new ArrayList<>();
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
//		for(int i = 0; i < T; i++) {
//			System.out.println(arr.get(i).sour + " " + arr.get(i).bitter);
//		}
		answer = Integer.MAX_VALUE;
		comb(0);

		System.out.println(answer);
		
//		System.out.println("success");
	}
	
	static void comb(int cnt) {
		if(cnt == T) {
			
			int flag = 0;
			for(int i = 0; i < T; i++) {
				if(visited[i])
					flag = 1;				
			}
			if(flag == 0)
				return;

			
			
			int sour_sum = 1, bitter_sum = 0;
			for(int i = 0; i < T; i++) {
				if(visited[i]) {
					//System.out.println("Debug" + arr.get(i).sour + " " + arr.get(i).bitter);
					sour_sum *= arr.get(i).sour;
					bitter_sum += arr.get(i).bitter;
					//System.out.println("Debug" + sour_sum + " " + bitter_sum);

				}
			}
			//System.out.println(sour_sum + " " + bitter_sum);
			
			int diff = Math.abs(sour_sum - bitter_sum);
			answer = Math.min(diff, answer);
			
			//System.out.println(answer + " asdfqerg");

			
			
			return;
		}
		
		visited[cnt] = true;
		comb(cnt + 1);
		
		visited[cnt] = false;
		comb(cnt + 1);


		
		
		
	}
	
	static class Food {
		int sour;
		int bitter;
		Food(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}
	}
}
