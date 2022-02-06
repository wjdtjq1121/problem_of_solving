import java.io.*;
import java.util.*;

public class Main_bj_2563_색종이_서울_12반_한정섭 {
//Solution
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(br.readLine());
		int board[][] = new int[100][100];
		int answer = 0;
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					if(board[j][k] == 1)
						continue;
					else {
						board[j][k] = 1;
						answer++;
					}
				}
			}
			

		}
		System.out.println(answer);
		
		
		
		//System.out.println("success");
	}
}
