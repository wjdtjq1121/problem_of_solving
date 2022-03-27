import java.io.*;
import java.util.*;

public class Main_21610_삼성기출골드5_마법사상어와비바라기 {
//Main
	static int size, input, ans;
	static int map[][], oper[][];
	static boolean cloud[][];
	
	static int dr[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int dc[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int rainR[] = {-1, -1, 1, 1};
	static int rainC[] = {-1, 1, 1, -1};
	
	
	
	static boolean isInside(int r, int c) {
		return r>=0 && r<size && c>=0 && c<size;
	}
	
	static boolean isR(int r) {
		if(r >= 0 && r < size)
			return true;		
		return false;
	}

	static boolean isC(int c) {
		if(c >= 0 && c < size)
			return true;		
		return false;
	}

	
	static int setR(int r) {
		if(r < 0)
			return size-1;
		if(r >= size)
			return 0;		
		return r;
	}
	static int setC(int c) {
		if(c < 0)
			return size-1;
		if(c >= size)
			return 0;		
		return c;
	}
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken());
		input = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		oper = new int[input][2];
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());			
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < input; i++) {
			st = new StringTokenizer(br.readLine());
			oper[i][0] = Integer.parseInt(st.nextToken());
			oper[i][1] = Integer.parseInt(st.nextToken());
		}
		cloud = new boolean[size][size];
		

		Queue<int []> q = new LinkedList<int[]>();
		q.offer(new int[] {size-1, 0});
		q.offer(new int[] {size-1, 1});
		q.offer(new int[] {size-2, 0});
		q.offer(new int[] {size-2, 1});
		
		ArrayList<int []> arr = new ArrayList<>();
		arr.add(new int[] {size-1, 0});
		arr.add(new int[] {size-1, 1});
		arr.add(new int[] {size-2, 0});
		arr.add(new int[] {size-2, 1});
		
		for(int i = 0; i < input; i++) {
			int dir = oper[i][0] - 1;
			int move = oper[i][1];
						
			// move input
			for(int j = 0; j < arr.size(); j++) {
				int r = arr.get(j)[0];
				int c = arr.get(j)[1];
				

				for(int go = 0; go < move; go++) {
					r += dr[dir];
					c += dc[dir];
					if(!isR(r)) {
						r = setR(r);
					}
					if(!isC(c)) {
						c = setC(c);
					}
				}
				
				arr.set(j, new int[] {r, c});
				map[r][c]++;
				cloud[r][c] = true;
				//System.out.println("aaa r: " + r + " c " + c);
				
			}
			
			
			// get rain 
			for(int j = 0; j < arr.size(); j++) {
				int r = arr.get(j)[0];
				int c = arr.get(j)[1];
				int plus = 0; 
				
				for(int rain = 0; rain < rainR.length; rain++) {
					int nr = r + rainR[rain];
					int nc = c + rainC[rain];
					
					if(isInside(nr, nc) && map[nr][nc] > 0) {
						plus++;
					}										
				}
				map[r][c] += plus;
			}
			
//			for(int r = 0; r < size; r++) {
//				for(int c = 0; c < size; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			arr.clear();
			
			for(int r = 0; r < size; r++) {
				for(int c = 0; c < size; c++) {
					if(!cloud[r][c] && map[r][c] >= 2) {
						map[r][c]-=2;
						arr.add(new int[] {r, c});
					}
				}
			}
			
			cloud = new boolean[size][size];
			
//			for(int r = 0; r < size; r++) {
//				for(int c = 0; c < size; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println();
//			System.out.println();

			
		}
		
		
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				ans += map[r][c];
			}
		}

		
		
		System.out.println(ans);
	}
}
