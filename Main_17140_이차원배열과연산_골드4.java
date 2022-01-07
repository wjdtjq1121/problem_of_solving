import java.io.*;
import java.util.*;

public class Main_17140_이차원배열과연산_골드4 {
//Main
	
	static int target_r, target_c, target_num, row_num, col_num, time;
	static int map[][];
	static ArrayList<Info> arr;
	
	static class Info implements Comparable<Info>{
		int num, count;

		public Info(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(Info o) {
			if(Integer.compare(this.count, o.count) == 0) {
				return Integer.compare(this.num, o.num);
			} else {
				return Integer.compare(this.count, o.count);
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		target_r = Integer.parseInt(st.nextToken());
		target_c = Integer.parseInt(st.nextToken());
		target_num = Integer.parseInt(st.nextToken());
		target_r--;
		target_c--;
		
		int initial_map_size = 3;
		map = new int[initial_map_size][initial_map_size];
		row_num = initial_map_size;
		col_num = initial_map_size;
		for(int i = 0; i < initial_map_size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < initial_map_size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		time = 0;
		
		while(time <= 100) {
			if(target_r < map.length && target_c < map[0].length) {
				//System.out.println(target_r + " " + map.length + " " + target_c + " " + map[0].length);
				if(map[target_r][target_c] == target_num)
					break;
			}
			
			if(row_num >= col_num) {
				case_r();
				
			} else {
				case_c();
			}
			
//			for(int i = 0; i < map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			
			time++;
		}

		if(time > 100)
			time = -1;
		
		System.out.println(time);
	}
	
	static void case_r() {
		
		int cmap[][] = new int[101][101];
		int count_num[];
		int max = -1;

		for(int i = 0; i < row_num; i++) {
			count_num = new int[101];
			arr = new ArrayList<>();
			for(int j = 0; j < col_num; j++) {
				count_num[map[i][j]]++;
			}
			for(int j = 1; j < 101; j++) {
				if(count_num[j] != 0) {
					arr.add(new Info(j, count_num[j]));
				}
			}
			Collections.sort(arr);
			
			int put = 0;
			for(int j = 0; j < arr.size(); j++) {
				//여기 고쳐야될수도
				cmap[i][put++] = arr.get(j).num;
				cmap[i][put++] = arr.get(j).count;
			}
			max = max < put ? put : max;
						
		}
		if(max > 100)
			max = 100;
		
		col_num = max;
		map = new int[row_num][col_num];
		
		for(int i = 0; i < row_num; i++) {
			for(int j = 0; j < col_num; j++) {
				map[i][j] = cmap[i][j];
			}
		}
	}
	
	static void case_c() {
		
		int cmap[][] = new int[101][101];
		int count_num[];
		int max = -1;

		for(int i = 0; i < col_num; i++) {
			count_num = new int[101];
			arr = new ArrayList<>();
			for(int j = 0; j < row_num; j++) {
				count_num[map[j][i]]++;
			}
			for(int j = 1; j < 101; j++) {
				if(count_num[j] != 0) {
					arr.add(new Info(j, count_num[j]));
				}
			}
			Collections.sort(arr);
			
			int put = 0;
			for(int j = 0; j < arr.size(); j++) {
				//여기 고쳐야될수도
				cmap[put++][i] = arr.get(j).num;
				cmap[put++][i] = arr.get(j).count;
			}
			max = max < put ? put : max;
						
		}
		if(max > 100)
			max = 100;
		
		row_num = max;
		map = new int[row_num][col_num];
		
		for(int i = 0; i < row_num; i++) {
			for(int j = 0; j < col_num; j++) {
				map[i][j] = cmap[i][j];
			}
		}
		
		
	}
	
}
