import java.io.*;
import java.util.*;

public class Solution_농장 {
//Solution
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			int size = Integer.parseInt(br.readLine());
			int board[][] = new int[size][size];
			
			for(int i = 0; i < size; i++) {
//				st = new StringTokenizer(br.readLine());
				String s = br.readLine();
//				System.out.println(s);
				for(int j = 0; j < s.length(); j++) {
					board[i][j] = s.charAt(j) - '0';
//					System.out.print(board[i][j] + " ");
					//board[i][j] = Integer.parseInt(st.nextToken());
				}
	//			System.out.println();
			}
			
			//System.out.println(Arrays.deepToString(board));
			
			
			int answer = 0;
//			for(int i = size/2; i >= 0; i--) {
			for(int i = 0; i <= size/2; i++) {
				for(int j = size/2 - i; j <= size/2 + i; j++) {
//					System.out.println(i + " " + j);
					answer += board[i][j];
					//System.out.print(board[i][j] + " ");
					
				}				
				//System.out.println( );
			}
			
			for(int i = size/2-1; i >= 0; i--) {
				for(int j = size/2 - i; j <= size/2 + i; j++) {
					//System.out.println(size - i - 1 + " " + j);					
					answer += board[size - i - 1][j];
					//System.out.print(board[i][j] + " ");

				}
				//System.out.println( );

			}
			
			
			
			System.out.println("#" + tc + " " + answer);			
		}
		
		
		//System.out.println("success");
	}
}
