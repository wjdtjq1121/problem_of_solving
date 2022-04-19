import java.io.*;
import java.util.*;

public class Main_πÈ¡ÿ3190ªÔº∫±‚√‚∞ÒµÂ5πÏ {
//Main
	
	static int n, k, l;
	static boolean snake[][];
	static boolean apple[][];
	static int move[][];
	static ArrayList<int []> arr;
	
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		snake = new boolean[n][n];
		apple = new boolean[n][n];
		arr = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			apple[r][c] = true;
		}
		l = Integer.parseInt(br.readLine());
		move = new int[l][2];
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			move[i][0] = cnt;

			if(s.equals("L")) {
				move[i][1] = 0;
				//System.out.println("left");
			}
			if(s.equals("D")) {
				move[i][1] = 1;
				//System.out.println("right");
			}
			
		}
		
//		for(int i = 0; i < l; i++) {
//			System.out.println(move[i][1]);
//		}
		
		
		arr = new ArrayList<>();
		arr.add(new int[] {0, 0});
		snake[0][0] = true;
		int r = 0;
		int c = 0;
		int d = 0;
		int time = 0;
		int turn = 0;
		
		if(move[0][0] == 0) {
			d = move[0][1] == 0 ? 3 : 1;
		}
		
		
//		for(int i = 0; i < l; i++) {
//		System.out.println(move[i][1]);
//	}
		
		while(true) {
			
			r += dr[d];
			c += dc[d];
			time++;			
			if(!isInside(r, c) || snake[r][c]) {				
				break;
			}
			
			if(turn < l && move[turn][0] == time) {
//				for(int i = 0; i < l; i++) {
//					System.out.println(move[i][1]);
//				}
				//System.out.println(move[turn][1] + " " + turn);
				if(move[turn][1] == 0) {
					d = (d-1) < 0 ? 3 : d-1;
				} else {
					d = (d+1) > 3 ? 0 : d+1;					
				}
				turn++;
			}
			
			arr.add(new int[] {r, c});			
			if(apple[r][c]) {
				snake[r][c] = true;
				apple[r][c] = false;
			} else {
				snake[r][c] = true;
				snake[arr.get(0)[0]][arr.get(0)[1]] = false;
				arr.remove(0);
			}
			
			
//			System.out.println(time);
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					if(snake[i][j])
//						System.out.print("1 ");
//					else
//						System.out.print("0" + " ");
//				}
//				System.out.println();
//			}
			
			
//			System.out.println();			
			
		}


		

		
		
		//System.out.println("success");
		System.out.println(time);
	}
	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r<n && c<n;
	}
}
