import java.io.*;
import java.util.*;

public class Main_14890_경사로_골드3_firsttry {
//Main
	
	static int size, road_len, ans;
	static int map[][];
	
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken());
		road_len = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		ans = size * 2;
		ans = 0;
		
		for(int r = 0; r < size; r++) {
			int down_road_made = 0;
			int ready_for_upper = 1;			
			int c = 1;		
			while(isInside(r, c)) {
				if(Math.abs(map[r][c] - map[r][c-1]) > 1) {
					break;
				}
				if(down_road_made == 0) {
					if(map[r][c] == map[r][c-1]+1) {
						if(ready_for_upper < road_len) {
							break;
						}
						ready_for_upper = 1;						
					} else if(map[r][c]+1 == map[r][c-1]) {
						down_road_made = road_len-1;
						ready_for_upper = 0;

					} else if(map[r][c] == map[r][c-1]) {
						ready_for_upper++;
					}
				} else {
					if(map[r][c] == map[r][c-1]) {

						down_road_made--;						
					} else { 
						break;
					}

				}
				c++;
				if(c == size && down_road_made == 0) {
					ans++;					
				}

			}

		}
		
		
		
		for(int c = 0; c < size; c++) {
			
		
			int down_road_made = 0;
			int ready_for_upper = 1;
			
			int r = 1;
			
			while(isInside(r, c)) {
				

				
				
				if(Math.abs(map[r][c] - map[r-1][c]) > 1) {
					break;
				}
				

				if(c == 0) {
//					System.out.println("wolra " + r + " " + c + " " + ready_for_upper + " " + road_len);
//					System.out.println("wolra " + r + " " + c + " " + ready_for_upper + " " + road_len);
//					System.out.println("map " + map[r][c]+ " " + map[r-1][c]);
				}

				if(down_road_made == 0) {
					if(map[r][c] == map[r-1][c]+1) {
						if(ready_for_upper < road_len) {
							break;
						}
						ready_for_upper = 1;
						
					} else if(map[r][c]+1 == map[r-1][c]) {
						down_road_made = road_len-1;
						ready_for_upper = 0;
						
					} else if(map[r][c] == map[r-1][c]) {
						ready_for_upper++;
					}
				
					

				} else {
					if(map[r][c] == map[r-1][c]) {

						down_road_made--;						
					} else { 
						break;
					}

				}

				
				
				
				r++;
				if(r == size && down_road_made == 0) {
					ans++;
					//System.out.println(r + " " + c);
					
				}
				

				
			}
			

	
		}

		

		
		System.out.println(ans);

	}
	
	static boolean isInside(int r, int c) { 
		return r>=0 && c>=0 && r < size && c < size;
	}
}
