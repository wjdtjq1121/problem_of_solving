import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_SWEA_파리퇴치하기 {

	public static void main(String[] args) throws Exception, IOException {
		System.setIn(new FileInputStream("input_fly.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine());
//		int T = sc.nextInt();
//		T = 3;
		
		int delR[] = {0, 1, 1, 0, 1, 1, 0, -1, -1, -1, -1, 0};
		int delC[] = {1, 1, 0, -1, -1, 0, -1, -1, 0, 0, 1, 1};

		StringTokenizer st;		

		for(int test_case = 1; test_case < T; test_case++) {
			

			
			int N, kill;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			kill = Integer.parseInt(st.nextToken());
//			N = sc.nextInt();
//			kill = sc.nextInt();
			int board[][] = new int[N][N];
			int answer = 0;
			int cur_max = 0;

			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for(int j = 0; j < N; j++) {
//					board[i][j] = sc.nextInt();

					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0; i < N - kill + 1; i++) {
				for(int j = 0; j < N - kill + 1; j++) {
					cur_max = 0;
					for(int q = 0; q < kill; q++) {
						for(int w = 0; w < kill; w++) {
							cur_max += board[q+i][w+j];
						}
					}
					

					
					//System.out.println("debug: " + cur_max);
					answer = answer < cur_max ? cur_max : answer;
				




					
					
				}
			}
			
			System.out.println("#"+test_case + " " + answer);
			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(board[i][j] + " ");
//
//				}
//				System.out.println();
//			}			
			
			
			
		}
		



		
		br.close();
		
		
		
	}
}
