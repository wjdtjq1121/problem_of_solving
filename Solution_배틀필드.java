import java.io.*;
import java.util.*;

public class Solution_배틀필드 {
//Solution
	static char board[][];
	static int H, W;
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input_배틀필드"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(br.readLine());
		//T = 1;
		
		int delR[] = {-1, 1, 0, 0};
		int delC[] = {0, 0, -1, 1};
		
		for(int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());			
//			char board[][] = new char[H][W];
			board = new char[H][W];
			int d = 0, row = 0, col = 0;
			for(int i = 0; i < H; i++) {
				String input = br.readLine();
				//board[i] = input.toCharArray();
				for(int j = 0; j < W; j++) {
					board[i][j] = input.charAt(j);
					if(board[i][j] == '^' || board[i][j] == 'v' || board[i][j] == '<' || board[i][j] == '>') {
						if(board[i][j] == '^')
							d = 0;
						else if(board[i][j] == 'v')
							d = 1;
						else if(board[i][j] == '<')
							d = 2;
						else if(board[i][j] == '>')
							d = 3;
						row = i;
						col = j;
					}
				}
			}
						
			int order_num = Integer.parseInt(br.readLine());
			String ord = br.readLine();
			for(int i = 0; i < order_num; i++) {
				char command = ord.charAt(i);
//				System.out.print(command + " ");
				int new_row = 0, new_col = 0;
				
				if(command == 'U' || command == 'D' || command == 'L' || command == 'R') {
					if(command == 'U') {
						d = 0;
						board[row][col] = '^';
					} else if(command == 'D') {
						d = 1;
						board[row][col] = 'v';
					}  else if(command == 'L') {
						d = 2;
						board[row][col] = '<';
					}  else if(command == 'R') {
						d = 3;
						board[row][col] = '>';
					}
					
					new_row = row + delR[d];
					new_col = col + delC[d];
					
					if(isInside(new_row, new_col)) {
						if(board[new_row][new_col] == '.') {
							board[new_row][new_col] = board[row][col];
							board[row][col] = '.';
							row = new_row;
							col = new_col;
						}
					}
				} else if(command == 'S') {
					
					new_row = row + delR[d];
					new_col = col + delC[d];
					
					//System.out.println("goingon");
					
					while(isInside(new_row, new_col)) {
					
						if(board[new_row][new_col] == '#') {
							break;
						} else if(board[new_row][new_col] == '*') {
							board[new_row][new_col] = '.';
							break;
						}
						new_row += delR[d];
						new_col += delC[d];	
					}
					
					//System.out.println("done?");

					
				} 

				
				
				
				
				
				
				

			}
			
			
			
			
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}		
			//System.out.println();
			
			
			
		}
		
		
		
		//System.out.println("success");
	}
	public static boolean isInside(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W; 
//		return false;		
	}
}
