import java.io.*;
import java.util.*;

public class Main_16235_나무재태크_성공 {
//Main
	
	static int size, num, year, tree_num;
	static int map[][];
	static int grow[][];
	static ArrayList<Info> hola[][];
	static ArrayList<Integer> arr[][];
	static int dr[] = {0, 1, 0, -1, -1, 1, 1, -1};
	static int dc[] = {1, 0, -1, 0, 1, 1, -1, -1};
	
	static class Info implements Comparable<Info>{
		int r;
		int c;
		int age;
		
		Info(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}
		public int compareTo(Info o) {
			
			return this.age - o.age;
//			return Integer.compare(this.age, o.age);
		}
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());
		
		map = new int[size][size];
		grow = new int[size][size];
		arr = new ArrayList[size][size];

		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				grow[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
				arr[i][j] = new ArrayList<>();				
			}
		}
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			r--;
			c--;
			
			arr[r][c].add(y);
		}
		tree_num = num;
		for(int pass = 0; pass < year; pass++) {
			
			// spring if size is more than 0, sort, and decrease it, if no yangboon kill them all 
			//at the same time give yangboon plus
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {					
					if(arr[i][j].size() > 0) {
						Collections.sort(arr[i][j]);
						int remain = 0;
						for(int k = 0; k < arr[i][j].size(); k++) {
							if(map[i][j] >= arr[i][j].get(k)) {
								map[i][j] -= arr[i][j].get(k);
								arr[i][j].set(k, arr[i][j].get(k) + 1);
							} else {


								remain += arr[i][j].get(k) / 2;
								arr[i][j].remove(k);
								k--;
								tree_num--;
							}							
						}
						map[i][j] += remain;
					}
					
				}
			}		
//			if(pass == 5) {
//				System.out.println(arr[2][0].size());
//				
//			}
			
			//System.out.println(tree_num);
			// fall if mod age is 5 then increase add,
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {		
					if(arr[i][j].size() > 0) {
						for(int k = 0; k < arr[i][j].size(); k++) {

							if(arr[i][j].get(k) % 5 == 0) {
								
								//System.out.println(arr[i][j].get(k) + " " + i + " " + j);

								for(int d = 0; d < dr.length; d++) {
									int nr = i + dr[d];
									int nc = j + dc[d];
									if(isInside(nr, nc)) {
										//System.out.println(nr + " " + nc);
										arr[nr][nc].add(1);
										tree_num++;
									}
									
								}
								
							}
							
						}
					}
				}
			}
			// winter
			// if tree num is zero end program
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					map[i][j] += grow[i][j];
					
				}
			}
			
			//System.out.println(Arrays.deepToString(map));
			
			if(tree_num == 0)
				break;
			
		}

		

		System.out.println(tree_num);
	}
	
	
	static boolean isInside(int r, int c) {
		return r >= 0 && r < size && c >= 0 && c < size;
	}
}
