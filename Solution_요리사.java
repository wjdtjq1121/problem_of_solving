import java.io.*;
import java.util.*;

public class Solution_요리사 {
//Solution
	static int board[][];
	static int number[];
	static int N, answer;
	static ArrayList<Integer> arr;
	
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_요리사"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			board = new int[N][N];
			number = new int[2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			arr = new ArrayList<>();
			
			comb(0, 0);
			//Collections.sort(arr);


			for(int i = 0; i < arr.size(); i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
			System.out.println("#" + tc + " " + answer);			
		}
		
		
		System.out.println("success");
	}
	static void comb(int cnt, int start) {
		if(cnt == 2) {
			//System.out.println(Arrays.toString(number));
			
			int sum = board[number[0]][number[1]] + board[number[1]][number[0]];
			arr.add(sum);
			
			
			
			
			return;
		}
		for(int i = start; i < N; i++) {
			
			number[cnt] = i;
			
			comb(cnt + 1, i + 1);
			
		}
		
	}
}
