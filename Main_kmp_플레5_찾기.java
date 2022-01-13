import java.io.*;
import java.util.*;

public class Main_kmp다시풀어봄_쉅시간_플레5_찾기 {
//Main
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_t"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		//st = new StringTokenizer(br.readLine());
		char input[] = br.readLine().toCharArray();
		char pattern[] = br.readLine().toCharArray();
		int pi[] = new int[pattern.length];
		int i_size = input.length;
		int p_size = pattern.length;
		
		int cnt = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 1, j = 0; i < p_size; i++) {
			
			while(j > 0 && pattern[i] != pattern[j])
				j = pi[j-1];
			if(pattern[i] == pattern[j])
				pi[i] = ++j;
		}
		
		for(int i = 0, j = 0; i < i_size; i++) {
			
			while(j > 0 && input[i] != pattern[j])
				j = pi[j-1];
			
			if(input[i] == pattern[j]) {
				if(j == pattern.length-1) {
					cnt++;
					arr.add(i+1+1-pattern.length);
					j = pi[j];
				} else
					j++;
			}
			
		}
		

		

		
		
		System.out.println(cnt);
		if(cnt > 0) {
			for(int i = 0; i < cnt; i++) {
				System.out.println(arr.get(i));
			}
		}

	}
}
