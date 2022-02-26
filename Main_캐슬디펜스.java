import java.io.*;
import java.util.*;

public class Main_캐슬디펜스 {
//Main
	static int H, W, D, range;
	static int board[][];
	static int numbers[];
	static int ans;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_케슬디펜스"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		range = 3;
		numbers = new int[range];
		board = new int[H][W];
		
		for(int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		
		comb(0, 0);

		System.out.println("success");
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == range) {
			//do someting
			
			//System.out.println(Arrays.toString(numbers));
			int sum = 0;
			int arc_y = H, arc_x = numbers[0];
			for(int i = H-1; i >= 0; i--) {
				
				
				for(int j = 0; j < 3; j++) {
					int y = i+1;
					int x = numbers[j];
					
					
					
					
				}

			}
			
			ans = Math.max(ans, sum);
			
			return;
		}
		
		for(int i = start; i < W; i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);			
		}
		
		
	}
	
}
