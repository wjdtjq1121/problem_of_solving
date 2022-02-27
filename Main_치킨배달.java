import java.io.*;
import java.util.*;

public class Main_치킨배달 {
//Main
	static int board[][];
	static ArrayList<House> home;
	static ArrayList<House> chicken;
	static int N, M, answer;
	static int number[];

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input_치킨배달"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[M];
		answer = Integer.MAX_VALUE;
		board = new int[N][N];
		home = new ArrayList<House>();
		chicken = new ArrayList<House>();

		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1)
					home.add(new House(i, j));
				if(board[i][j] == 2)
					chicken.add(new House(i, j));					
			}
		}
		
		
		comb(0, 0);
		
		
		
//		int a = 1, b = 2;
//		arr = new ArrayList<House>();
//		arr.add(new House(3, 4));
//		arr.add(new House(2, 5));		
//		for(int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).x);
//		}
		
		System.out.println(answer);
		

		//System.out.println("success");
	}

	private static void comb(int cnt, int start) {
		if(cnt == M) {
			//System.out.println(Arrays.toString(number) + " " + number.length);
			
			int sum = 0;
			for(int j = 0; j < home.size(); j++) {
				int cur_sum = Integer.MAX_VALUE;
				for(int i = 0; i < number.length; i++) {				
					int dist = Math.abs((home.get(j).x - chicken.get(number[i]).x)) + Math.abs((home.get(j).y - chicken.get(number[i]).y));
					cur_sum = Math.min(cur_sum, dist);					
				}
				sum+=cur_sum;
			}
			
			answer = Math.min(sum, answer);
			//System.out.println(answer);
			
			
			
			
			
			
			
			return;
		}
		
		
		for(int i = start; i < chicken.size(); i++) {
			
			number[cnt] = i;
			
			comb(cnt + 1, i + 1);
			
		}
		
		
		
	}
	
	
	static class House {
		int x;
		int y;
		House(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
