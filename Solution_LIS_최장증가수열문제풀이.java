import java.io.*;
import java.util.*;

public class Solution_LIS_최장증가수열문제풀이 {
//Solution
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			int arr[] = new int[num+1]; // 
			int ls[] = new int[num+1]; // 해당 길이를 증가수열 중 맨 끝을 최소값으로 유지
			
			int ans = 0;
			st = new StringTokenizer(br.readLine());

			for(int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
//			int size = 0;
//			for(int i = 0; i < num; i++) {
//				// 중복값이 없어서 탐색 실패: 음수값 -> 삽입위치 환산
//				 int temp = Math.abs(Arrays.binarySearch(ls, 0, size, arr[i])) - 1;
//					//System.out.println(temp);
//
//				 ls[temp] = arr[i];
//				 
//				 
//				 // 추가된 위치가 맨뒤라면 사이즈 증가.
//				 if(temp == size)
//					 size++;
//			}
//			System.out.println("#" + tc + " " + size);			
			
			
			
			
			
			int infin = 0;
			ans = 1;
			int follow = 1;
			ls[0] = arr[0];
			for (int i = 1; i < num; i++) {

				int left = 0;
				int right = follow;
				int key = arr[i];
				
				//System.out.println(follow + " " + key + " " + ls[follow]);
				
				if(ls[follow-1] < key) {
					ls[follow] = key;
					follow++;
					continue;
				}
				
				while (left <= right) {
					int mid = left + (right - left)/2;

					if (ls[mid] < key) {
						left = mid + 1;
					} else if (ls[mid] > key) {
						right = mid - 1;
					} else {
						System.out.println("something wrong");
						break;
					}
//					System.out.println(ls[left] + " " + ls[right] + " " + key);

					if (++infin == 30)
						break;
				}
				
				ls[left] = key;
				
				


			}
			System.out.println("#" + tc + " " + follow);
			
			//System.out.println(Arrays.toString(ls));

		}
		
		
//		System.out.println("success");
	}
}
