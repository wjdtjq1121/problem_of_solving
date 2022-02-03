import java.io.*;
import java.util.*;

public class Main_7576_토마토실버1백준 {
//Main
	static int row, col, grown, raw, time;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col];
		raw = 0;
		Queue<int []> q = new LinkedList<>();
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());				
				if(map[i][j] == 0)
					raw++;
				if(map[i][j] == 1)
					q.offer(new int[] {i, j, 0});
			}
		}
		time = 0;
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			if(!isInside(r, c) || visited[r][c] || map[r][c] == -1)
				continue;
			
			visited[r][c] = true;
			if(map[r][c] == 0)
				raw--;
			time = cnt;

			for(int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				q.offer(new int[] {nr, nc, cnt+1});
			}
			
		}

		

		
		time = raw == 0 ? time : -1;
		System.out.println(time);

	}
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < row && c < col;
	}
}
