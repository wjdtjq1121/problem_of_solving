import java.io.*;
import java.util.*;

public class Main_스타트와링크_삼성기출실버2 {
//Main
	static int size, ans;
	static int number[];
	static int number2[];
	static int map[][];
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;

		number = new int[size/2];
		number2 = new int[size/2];
		comb(0, 0);

		
		
		System.out.println(ans);
	}
	
	private static void comb(int idx, int start) {
		if(idx == size/2) {
			//System.out.println(Arrays.toString(number));
			boolean group2[] = new boolean[size];
			
			for(int i = 0; i < number.length; i++) {
				group2[number[i]] = true;
			}
			int cnt = 0;
			for(int i = 0; i < size; i++) {
				if(!group2[i]) 
					number2[cnt++] = i;
			}			
//			System.out.println(Arrays.toString(number2));
			int diff = 0;
			int team1 = 0;
			int team2 = 0;
			
			for(int i = 0; i < size/2; i++) {
				for(int j = 0; j < size/2; j++) {
					if(i == j)
						continue;
					
//					System.out.println(number[i] + " " + number[j] + " " + size);
					team1 += map[number[i]][number[j]];
					team2 += map[number2[i]][number2[j]];
					
					
				}
			}
			
			diff = Math.abs(team1 - team2);
			
			ans = Math.min(diff, ans);			
			return;
		}
		
		for(int i = start; i < size; i++) {
			number[idx] = i;
			comb(idx+1, i+1);
		}
		
		
	}
	
}
