import java.io.*;
import java.util.*;

public class Main_원판돌리기 {
//Main
	static int N, M, T;
	static int disk[][];
	static int input[][];
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		disk = new int[N][M];
		input = new int[T][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int v = Integer.parseInt(st.nextToken());
				disk[i][j] = v;
			}
		}
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());			
			input[i][1] = d == 0 ? 1 : -1;
			input[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int m = 0; m < T; m++) {
			

			
			int start = input[m][0];
			int plus = start;
			while(start <= N) {
				
				for(int iter = 0; iter < input[m][2]; iter++) {
					if(input[m][1] == 1) {
						
						
						int temp = disk[start-1][M-1];
						for(int i = M-1; i >= 1; i--) {
							disk[start-1][i] = disk[start-1][i-1];
						}
						disk[start-1][0] = temp;
						
					} else {
						
						int temp = disk[start-1][0];
						for(int i = 0; i < M-1; i++) {
							disk[start-1][i] = disk[start-1][i+1];
						}
						disk[start-1][M-1] = temp;					
					}					
				}
				start += plus;
			}
			


			
			boolean visit[][] = new boolean[N][M];
			boolean change = false;
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					int left = (j-1) < 0 ? M-1 : j-1;
					int right = (j+1) >= M ? 0 : j+1;
					if(disk[i][j] != 0 && disk[i][left] == disk[i][j]) {
						visit[i][j] = true;
						visit[i][left] = true;
						change = true;						
					}
					if(disk[i][j] != 0 && disk[i][right] == disk[i][j]) {
						visit[i][j] = true;
						visit[i][right] = true;
						change = true;						
					}
					
				}
			}
			

			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {

					
					int left = (j-1) < 0 ? -1 : j-1;
					int right = (j+1) >= N ? -1 : j+1;

					
					if(disk[j][i] != 0 && left != -1 && disk[left][i] == disk[j][i]) {

						
						visit[j][i] = true;
						visit[left][i] = true;
						change = true;						
					}
					if(disk[j][i] != 0 && right != -1 && disk[right][i] == disk[j][i]) {


						visit[j][i] = true;
						visit[right][i] = true;
						change = true;						
					}
					
				}
			}
			
			
			
			
			
			if(change) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(visit[i][j])
							disk[i][j] = 0;
					}
				}
			} else {
				int sum = 0;
				int cnt = 0;
				double average = 0;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(disk[i][j] > 0) {
							sum += disk[i][j];
							cnt++;
						}

					}
				}
				average = (double)sum / cnt;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(disk[i][j] > 0) {
							if(disk[i][j] < average) {
								disk[i][j]++;
							} else if(disk[i][j] > average) {
								disk[i][j]--;
							}
							
						}
					}
				}
				
			}
			
			
			
			
		}
		
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(disk[i][j] > 0)
					ans+=disk[i][j];
			}
		}

		

		System.out.println(ans);		
	}
}
