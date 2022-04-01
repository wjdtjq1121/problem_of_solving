import java.io.*;
import java.util.*;

public class Main_마법사상어와블리자드_sucess_myversion_finally {
//Main
	static int size, M, ans;
	static int map[][];
	static int input[][];
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {-1, 0, 1, 0};
	static ArrayList<Integer> arr;
	static int drn[] = {0, -1, 1, 0, 0};
	static int dcn[] = {0, 0, 0, -1, 1};
	
	static private boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r<size && c<size;		
	}
	
	private static void divide(ArrayList<Integer> arr) {
		ArrayList<Integer> newarr = new ArrayList<>();
		int size = arr.size();
		int connectCnt = 1;
		for(int i = 0; i < size - 1; i++) {
			if(arr.get(i) == arr.get(i+1)) {
				connectCnt++;
			} else {
				newarr.add(connectCnt);
				newarr.add(arr.get(i));
				connectCnt = 1;
			}
		}
		if(size >= 1) {
			newarr.add(connectCnt);
			newarr.add(arr.get(size - 1));
		}
		int cnt = 0;
		size = 1;
		int corner = 0;
		int dir = 3;
		int nr = size/2;
		int nc = size/2;
		int time = newarr.size();
		int total = 0;
		while(time-- > 0) {
			cnt++;
			nr += drn[dir];
			nc += dcn[dir];
			
			if(nr == 0 && nc == -1)
				break;
			map[nr][nc] = newarr.get(total++);
			
			if(cnt == size) {
				corner++;
				dir = dirChange(dir);
				cnt = 0;
			}
			if(corner == 2) {
				corner = 0;
				size++;
			}
			
			
		}
		
		
		
	}
	private static int dirChange(int d) {
		if(d==3)
			return 2;
		else if(d == 2)
			return 4;
		else if(d == 4)
			return 1;
		else if(d == 1)
			return 3;
		return 0;
	}
	
	static public void create(ArrayList<Integer> arr) {
		int r = size/2;
		int c = size/2;
		int move = 1, dummy = 0;
		int d = 0;		
		map = new int[size][size];		
		int cnt = 0;
		int arr_size = arr.size();
		while(c != -1) {
			if(dummy == 2) {
				dummy = 0;
				move++;
			}
			if(d == 4)
				d = 0;
			for(int i = 0; i < move; i++) {	
				r += dr[d];
				c += dc[d];
				if(c == -1)
					break;				
				if(isInside(r, c) && cnt < arr.size())
					map[r][c] = arr.get(cnt);				
				cnt++;
				if(cnt == arr_size)
					return;
			}			
			d++;
			dummy++;
		}
	}
	
	
	
	
	static public void bomb(ArrayList<Integer> arr) {
//		for(int i=0; i < arr.size(); i++) {
//			System.out.print(arr.get(i));
//		}
		
		boolean loopEnd = true;
				
		while(loopEnd) {
			loopEnd = false;
			int arr_size = arr.size();		
			int color = -1;
			int connected = 1;
			for(int idx = arr_size-1; idx >= 0; idx--) {
				
				if(arr.get(idx) == color) {
					connected++;
				} else {
					if(connected >= 4) {
						loopEnd = true;
						ans += connected * color;
						
						for(int rm = 0; rm < connected; rm++) {
							if(idx+1 < arr.size())
								arr.remove(idx+1);
						}
					}
					
					connected = 1;
					color = arr.get(idx);
				}			
			}
			if(connected >= 4) {
				
				ans += connected * color;
				
				for(int rm = 0; rm < connected; rm++) {
					//if(0 <= arr.size())
					arr.remove(0);
				}
			}			
		}

		
		
			
	}
	
	
	static public void destroy(int d, int go) {
		int r = size/2;
		int c = size/2;
		
		if(d == 0)
			d = 3;
		else if(d == 2)
			d = 0;
		else if(d == 3)
			d = 2;
		
		for(int idx = 0; idx < go; idx++) {
			r += dr[d];
			c += dc[d];
			if(isInside(r, c))
				map[r][c] = 0;
		}
		
		
	}
	
	static public void paste(ArrayList<Integer> arr) {
		int r = size/2;
		int c = size/2;
		int move = 1, dummy = 0;
		int d = 0;
		int cnt = 0;
		
		map = new int[size][size];
		
		if(arr.size() == 0)
			return;

			

		while(c != -1) {
			if(dummy == 2) {
				dummy = 0;
				move++;
			}
			if(d == 4)
				d = 0;
			for(int i = 0; i < move; i++) {	
				r += dr[d];
				c += dc[d];
				if(c == -1)
					return;

				if(cnt < arr.size())
					map[r][c] = arr.get(cnt);
				
				cnt++;
				if(cnt == arr.size())
					return;

			}
			
			
			d++;
			dummy++;

			
		}		
		
		
	}
	
	
	static public ArrayList<Integer> getArr() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int r = size/2;
		int c = size/2;
		int move = 1, dummy = 0;
		int d = 0;


		while(c != -1) {
			if(dummy == 2) {
				dummy = 0;
				move++;
			}
			if(d == 4)
				d = 0;
			for(int i = 0; i < move; i++) {	
				r += dr[d];
				c += dc[d];
				if(c == -1)
					break;
				if(isInside(r, c) && map[r][c] != 0)
					arr.add(map[r][c]);
				

			}
			
			
			d++;
			dummy++;

			
		}
		

		
		
		return arr;		
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		input = new int[M][2];
		
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		

		

		
		
		for(int start = 0; start < M; start++) {
			int d = input[start][0];
			int go = input[start][1];
			d--;
			
			destroy(d, go);
			ArrayList<Integer> cur = getArr();
//			paste(cur);
//			cur.clear();
			cur = getArr();
			bomb(cur);
			
//			for(int i = 0; i < cur.size(); i++) {
//				System.out.print(cur.get(i) + " ");
//			}
//			System.out.println();
			
			ArrayList<Integer> last = new ArrayList<Integer>();
			int color = -1;
			int connected = 1;
			for(int i = 0; i < cur.size(); i++) {
				if(cur.get(i) != color) {
					if(color != -1) {
						last.add(connected);
						last.add(color);
					}
					
					color = cur.get(i);
					connected = 1;
				} else {
					connected++;
				}
				
			}
			if(cur.size() >= 1) {
				last.add(connected);
				last.add(color);				
			}

			create(last);
//			divide(last);
			

			
		}

		

		

		
		System.out.println(ans);

	}
}
