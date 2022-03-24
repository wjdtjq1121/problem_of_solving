import java.io.*;
import java.util.*;

public class Main_정올1681헤밀턴문제 {
//Main
	static int size, ans;
	static int map[][];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[size];
		ans = Integer.MAX_VALUE;
		dfs(0, 0, 0);
		
		
		System.out.println(ans);
	}
	static void dfs(int stand, int index, int weight) {
		if(weight >= ans)
			return;
		
		if(index == size-1) {
			if(map[stand][0] != 0) {
				ans = Math.min(ans, weight + map[stand][0]);
				
			}
			return;
		}
		for(int i = 1; i < size; i++) {
			
			if(map[stand][i] != 0 && !visited[i]) {
				visited[i] = true;
				dfs(i, index+1, weight + map[stand][i]);
				visited[i] = false;
			}
			
			
		}
		
		
	}
}
