import java.io.*;
import java.util.*;

public class Main_15685_드래곤커브_골드4 {
//Main
	static int N;
	static int dr[] = {0, -1, 0, 1};
	static int dc[] = {1, 0, -1, 0};
	static int map[][];
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		ArrayList<Integer> arr;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());

			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			arr = new ArrayList<>();
			arr.add(d);
			for(int i = 0; i < g; i++) {
				int size = arr.size();
				
				for(int j = size-1; j >= 0; j--) {
					d = (arr.get(j)+1) % 4;
					arr.add(d);
				}
				
			}


			map[r][c] = 1;
			for(int i = 0; i < arr.size(); i++) {
				r += dr[arr.get(i)];
				c += dc[arr.get(i)];
				map[r][c] = 1;

			}
			
		}
		int ans = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100 ; j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1)
					ans++;
			}
		}
		
		
//		for(int i = 0; i < 10; i++) {
//		System.out.println(Arrays.toString(map[i]));
//	}
//	System.out.println();
//	System.out.println();

		
		


		

		
		
		System.out.println(ans);
	}
}
