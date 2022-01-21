import java.io.*;
import java.util.*;

public class Main_2239_백준_스도쿠성공 {
//Main
	static final int size = 9;
	static int map[][] = new int[size][size];
	static ArrayList<Dot> dot = new ArrayList<>();
	static boolean flag;
	static class Dot {
		int r, c;
		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
	
		for(int i = 0; i < size; i++) {
			String s = br.readLine();
			for(int j = 0; j < size; j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 0)
					dot.add(new Dot(i, j));
			}
		}
		flag = false;
		dfs(0);

		
//		for(int i = 0; i < size; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

//		System.out.println("success");
	}
	

	
	static void dfs(int idx) {
		if(flag)
			return;
		if(idx == dot.size()) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);


//			for(int i = 0; i < size; i++) {
//				for(int j = 0; j < size; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			flag = true;
//			System.exit(0);			
			return;
		}
//		for(int i = 0; i < size; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		int r = dot.get(idx).r;
		int c = dot.get(idx).c;
		
		for(int i = 1; i <= 9; i++) {
			
			if(possible(r, c, i)) {

				map[r][c] = i;
				dfs(idx+1);
				map[r][c] = 0;				
			}
			
		}
		
		
		
	}
	static boolean damn(int x, int y, int n) {

//		for(int i=0;i<9;i++) {
//			if(map[x][i] == n) {
//				return false;
//			}
//			if(map[i][y] == n) {
//				return false;
//			}
//		}
        
		for(int i = 0; i < size; i++) {
			if(map[x][i] == n || map[i][y] == n)
				return false;
		}
		
		

		
		int start_r = (x / 3)*3;
		int start_c = (y / 3)*3;
		
		for(int i = start_r; i < start_r+3; i++) {
			for(int j = start_c; j < start_c+3; j++) {
				if(map[i][j] == n)
					return false;
			}			
		}

		
        // 모든 유망성 검사가 통과되면 true를 반환한다.
		return true;
	}

	static boolean possible(int r, int c, int num) {
		
		//System.out.println("Exe");
		
		for(int i = 0; i < size; i++) {
			if(map[r][i] == num || map[i][c] == num)
				return false;
		}
		
		int start_r = (r / 3)*3;
		int start_c = (c / 3)*3;
		
		for(int i = start_r; i < start_r+3; i++) {
			for(int j = start_c; j < start_c+3; j++) {
				if(map[i][j] == num)
					return false;
			}			
		}

		
		

		return true;
	}
	
	
	
}
