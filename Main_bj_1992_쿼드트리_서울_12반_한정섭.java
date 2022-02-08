import java.io.*;
import java.util.*;

public class Main_bj_1992_쿼드트리_서울_12반_한정섭 {
//Main
	static int board[][];

	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
//		System.out.println(Arrays.deepToString(board));
		
		Quad(0, 0, N);
		

//		((110(0101))(0010)1(0001))
		//System.out.println("success");
	}
	
	static void Quad(int row, int col, int size) {
		
		if(isPossible(row, col, size)) {
			System.out.print(board[row][col]);
			return;
		} 
			
		
		int new_size = size / 2;
		System.out.print("(");

		Quad(row, col, new_size);
		Quad(row , col+ new_size, new_size);
		Quad(row+ new_size, col , new_size);
		Quad(row + new_size, col + new_size, new_size);
		
		
		
		
		System.out.print(")");
			
		
		
	}
	
	static boolean isPossible(int row, int col, int size) {
		
		int val = board[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(board[i][j] != val) {
					return false;
				}
			}
		}
		
		
		return true;
	}

	
}
