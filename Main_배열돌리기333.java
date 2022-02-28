import java.io.*;
import java.util.*;

public class Main_배열돌리기333 {
//Solution
	static int board[][];
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input_배열돌리기3"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int oper_num = Integer.parseInt(st.nextToken());
		board = new int[H][W];
//		int temp[][] = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
	//			temp[i][j] = board[i][j];
			}
		}

		st = new StringTokenizer(br.readLine());
		
		int get = 0;
				
//		int result[][] = new int[board[0].length][board.length];
//		System.out.println();
//		board[0][0] = -1;



		for(int oper = 0; oper < oper_num; oper++) {
			int order = Integer.parseInt(st.nextToken());
			

			//order = 6;

			
			if(order == 1) {

				for(int i = 0; i < board.length/2; i++) {
					for(int j = 0; j < board[0].length; j++) {
						get = board[board.length-i-1][j];
						board[board.length-i-1][j] = board[i][j];
						board[i][j] = get;
					}						
				}
			} else if(order == 2) {


				for(int i = 0; i < board.length; i++) {
					for(int j = 0; j < board[0].length/2; j++) {
						get = board[i][board[0].length-j-1];
						board[i][board[0].length-j-1] = board[i][j];
						board[i][j] = get;
//						System.out.println(get);
					}						
				}
				
				
			} else if(order == 3) {
				int result[][] = new int[board[0].length][board.length];

				
				for(int i = 0; i < board.length; i++) {
					for(int j = 0; j < board[0].length; j++) {
						result[j][board.length - i - 1] = board[i][j];
						
					}
				}
				
				board = result;
				
			} else if(order == 4) {
				
				int result[][] = new int[board[0].length][board.length];
				
				for(int i = 0; i < board.length; i++) {
					for(int j = 0; j < board[0].length; j++) {
						
						result[result.length - j - 1][i] = board[i][j];
					}
				}
				
				board = result;
				
				
			} else if(order == 5) {
				
				int result[][] = new int[board.length][board[0].length];
				int rs = board.length / 2;
				int cs = board[0].length / 2;
				
				for(int i = 0; i < board.length/2; i ++) {
					for(int j = 0; j < board[0].length/2; j++) {
						result[i][j + cs] = board[i][j];
						result[i + rs][j + cs] = board[i][j + cs];
						result[i + rs][j] = board[i + rs][j + cs];
						result[i][j] = board[i + rs][j];
					}
				}
				board = result;
				
				
				
				
				
			} else if(order == 6) {
				
				int result[][] = new int[board.length][board[0].length];
				int rs = board.length / 2;
				int cs = board[0].length / 2;
				
				for(int i = 0; i < board.length/2; i ++) {
					for(int j = 0; j < board[0].length/2; j++) {
						result[i + rs][j] = board[i][j];
						result[i + rs][j + cs] = board[i + rs][j];
						result[i][j + cs] = board[i + rs][j + cs];
						result[i][j] = board[i][j + cs];
					}
				}
				board = result;

			} 


			
			

			
		}
		


		//System.out.println("final version: ");
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
		//System.out.println("success");
	}
}
