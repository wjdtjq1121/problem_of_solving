import java.util.*;
import java.io.*;

public class Main_모노미노도미노2_골드2_삼성기출_성공 {
//Main
	static int num, answer, tile_left;
	static int map[][];
	static int input[][];
	static final int input_size = 3;
	static final int size = 10;
	
	static boolean isIn(int r, int c, int choice) {
		if(!isInside(r, c) || map[r][c] == 1)
			return false;
		if(choice == 2 && !isInside(r, c+1))
			return false;
		if(choice == 3 && !isInside(r+1, c))
			return false;
		if(choice == 2 && map[r][c+1] == 1)
			return false;
		if(choice == 3 && map[r+1][c] == 1)
			return false;
			
		
		
		return true;		
	}
	
	static void remove_blocks() {
		for(int i = 6; i < size; i++) {
			boolean canRemove = true;
			for(int j = 0; j < 4; j++) {
				if(map[i][j] == 0) {
					canRemove = false;
					break;
				}
			}
			if(canRemove) {
				answer++;
				
				for(int r = i; r >= 4; r--) {
					for(int j = 0; j < 4; j++) {
						map[r][j] = map[r-1][j];
					}					
				}
			}
		}
		
		
		
		
		
		
		
		for(int j = 6; j < size; j++) {
			boolean canRemove = true;
			for(int i = 0; i < 4; i++) {
				if(map[i][j] == 0) {
					canRemove = false;
					break;
				}
			}
			if(canRemove) {
				answer++;
				
				for(int c = j; c >= 4; c--) {
					for(int i = 0; i < 4; i++) {
						map[i][c] = map[i][c-1];
					}					
				}

			}
		}
	}
	
	static void special_block() {
		
		boolean isGreen = false;
		
		int cr = 5;
		for(int c = 0; c < 4; c++) {
			if(map[cr][c] == 1) {
				isGreen = true;
			}
		}
		if(isGreen) {
			for(int r = 9; r >= 4; r--) {
				for(int j = 0; j < 4; j++) {
					map[r][j] = map[r-1][j];
				}					
			}
		}
		isGreen = false;
		for(int c = 0; c < 4; c++) {
			if(map[cr][c] == 1) {
				isGreen = true;
			}
		}
		if(isGreen) {
			for(int r = 9; r >= 4; r--) {
				for(int j = 0; j < 4; j++) {
					map[r][j] = map[r-1][j];
				}					
			}
		}
		
		boolean isBlue = false;
		int cc = 5;
		for(int r = 0; r < 4; r++) {
			if(map[r][cc] == 1) {
				isBlue = true;
			}
		}
		if(isBlue) {
			for(int i = 0; i < 4; i++) {
				for(int c = 9; c >= 4; c--) {
					map[i][c] = map[i][c-1];
				}					
			}
		}
		isBlue = false;
		for(int r = 0; r < 4; r++) {
			if(map[r][cc] == 1) {
				isBlue = true;
			}
		}
		if(isBlue) {
			for(int i = 0; i < 4; i++) {
				for(int c = 9; c >= 4; c--) {
					map[i][c] = map[i][c-1];
				}					
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(br.readLine());
		input = new int[num][input_size];
		map = new int[10][10];
		answer = 0;
		tile_left = 0;

		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < input_size; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());;
			}
			int choice = input[i][0];
			int r = input[i][1];
			int c = input[i][2];
			
			while(isIn(r+1, c, choice)) {
				r++;
			}
			
			map[r][c] = 1;
			if(choice == 2) {
				map[r][c+1] = 1;
			}
			if(choice == 3) {
				map[r+1][c] = 1;
			}

			r = input[i][1];
			c = input[i][2];
			while(isIn(r, c+1, choice)) {
				c++;
			}
			map[r][c] = 1;
			if(choice == 2) {
				map[r][c+1] = 1;
			}
			if(choice == 3) {
				map[r+1][c] = 1;
			}
			
			remove_blocks();
			special_block();
			
			
		}
		
		
		
		
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(map[i][j] == 1)
					tile_left++;
			}
		}


		
		
		
		System.out.println(answer);
		System.out.println(tile_left);
	}
	static boolean isInside(int r, int c) {
		return r >= 0  && c >= 0 && r < size && c < size; 
	}
}
