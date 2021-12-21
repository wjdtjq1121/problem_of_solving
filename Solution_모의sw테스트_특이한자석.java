import java.io.*;
import java.util.*;

public class Solution_모의sw테스트_특이한자석 {

	
	static int rotate_num, clock_direction, ans;
	static final int ob_total = 4;
	static final int ob_direction = 8;
	static int result[] = {1, 2, 4, 8};
	static int map[][];
	
	public static void main(String[] args) throws Exception{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			rotate_num = Integer.parseInt(br.readLine());
			map = new int[ob_total][ob_direction];
			
			
			for(int i = 0; i < ob_total; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < ob_direction; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}				
			}

			

			
			for(int i = 0; i < rotate_num; i++) {
				st = new StringTokenizer(br.readLine());
				int move_object = Integer.parseInt(st.nextToken()) - 1;
				int direction = Integer.parseInt(st.nextToken());
								
				Queue<int []> q = new LinkedList<>();
				q.offer(new int[] {move_object, direction});
				int temp_r = map[move_object][2];
				int temp_d = direction;
 
				while(!q.isEmpty()) {
					int cur[] = q.poll();
					int cur_num = cur[0];
					int cur_d = cur[1];
					int target_num = cur_num - 1;
					
					if(cur_num == -1)
						continue;
					if(target_num != -1 && map[cur_num][6] != map[target_num][2])
						q.offer(new int[] {cur_num-1, cur_d*-1});
					rotate(cur_num, cur_d);

				}
				
				for(int goes = move_object+1; goes < ob_total; goes++) {
					if(temp_r != map[goes][6]) {
						temp_d *= -1;
						temp_r = map[goes][2];

						rotate(goes, temp_d);
						
						
					} else {
						break;
					}
				}

			}


			
			ans = 0;
			
			for(int i = 0; i < ob_total; i++) {
				
				if(map[i][0] == 1) {
					ans += result[i];
					
				}
			}
			
			
			System.out.println("#" + tc + " " + ans);			
		}
		
		
	}
	static void rotate(int num, int change) {
		
		if(change == 1) {
			int temp = map[num][ob_direction-1];
			
			for(int i = ob_direction-1; i > 0; i--) {
				map[num][i] = map[num][i-1];
			}
			map[num][0] = temp;

		} else if(change == -1) {
			int temp = map[num][0];
			
			for(int i = 0; i < ob_direction-1; i++) {
				map[num][i] = map[num][i+1];
			}
			map[num][ob_direction-1] = temp;
			
		}
		
		
		
		
	}
	
}
