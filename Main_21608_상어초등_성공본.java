import java.io.*;
import java.util.*;

public class Main_21608_상어초등_성공본 {
//Main
	
	static int row, col, size;
	static int map[][];
	static int student_fav[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	static int plus[] = {0, 1, 10, 100, 1000};
	static int fav_count[];
	
	static class Student implements Comparable<Student>{
		int fav;
		int empty;
		int r;
		int c;
		
		Student(int fav, int empty, int r, int c) {
			this.fav = fav;
			this.empty = empty;
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Student o) {
						
			if(Integer.compare(this.fav, o.fav) == 0) {
				if(Integer.compare(this.empty, o.empty) == 0) {
					if(Integer.compare(this.r, o.r) == 0) {
						return Integer.compare(this.c, o.c);
					} else {
						return Integer.compare(this.r, o.r);
					}					
				} else {
					return -Integer.compare(this.empty, o.empty);									
				}				
			} else {
				return -Integer.compare(this.fav, o.fav);
			}			
		}
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input_ele"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int size = T * T;
		col = row = T;
		
		map = new int[T][T];
		student_fav = new int[size+1][5];
		fav_count = new int[size+1];
		
	
		
		for(int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());			
			for(int j = 0; j < 5; j++) {
				student_fav[i][j] = Integer.parseInt(st.nextToken());				
			}			
		}
		
		for(int n = 1; n <= size; n++) {
			PriorityQueue<Student> q = new PriorityQueue<>();			
			for(int i = 0; i < T; i++) {
				for(int j = 0; j < T; j++) {
					if(map[i][j] != 0)
						continue;					
					int empty = 0;
					int fav = 0;
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(isInside(nr, nc)) {
							if(map[nr][nc] == 0)
								empty++;
							else {
								for(int k = 1; k < 5; k++) {								
									if(map[nr][nc] == student_fav[n][k]) {
										fav++;
										break;
									}								
								}													
							}
						}						
					}
					q.add(new Student(fav, empty, i, j));					
				}
			}
			Student first = q.poll();
			map[first.r][first.c] = student_fav[n][0];
			//fav_count[n] = first.fav;
		}
	//	System.out.println(Arrays.deepToString(map));
			
		int ans = 0;
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < T; j++) {				
				int target = 0;
				for(int fix = 1; fix <= size; fix++) {
					if(student_fav[fix][0] == map[i][j]) {
						target = fix;
						break;
					}
				}
				int fav = 0;
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(isInside(nr, nc)) {						
						for(int k = 1; k < 5; k++) {				
							if(map[nr][nc] == student_fav[target][k]) 
								fav++;
						}
					}
				}
				ans+=plus[fav];
			}
		}
		System.out.println(ans);
	}
	
	static boolean isInside(int r, int c) {
		return r >= 0 && r < row && c >= 0 && c < col;
	}
}
