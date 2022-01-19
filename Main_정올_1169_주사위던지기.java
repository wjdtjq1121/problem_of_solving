import java.io.*;
import java.util.*;

public class Main_정올_1169_주사위던지기 {
//Main
	static int n, m;
	static int per[], used[];
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		per = new int[n];
		used = new int[7];
		if(m == 1) {
			do1(0);
			
		}
		if(m == 2) {
			do2(0, 1);
			
		}
		if(m == 3) {
			do3(0);
			
		}

		

		

	}

	private static void do3(int lv) {
		if(lv == n) {
			for(int i: per) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			
			if(used[i] == 0) {
				per[lv] = i;
				used[i] = 1;
				do3(lv+1);
				used[i] = 0;
				
			}
			
		}
		
	}

	private static void do2(int lv, int start) {
		if(lv == n) {
			for(int i: per) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		
		for(int i = start; i <= 6; i++) {
			
			per[lv] = i;
			do2(lv+1, i);
			
			
		}

		
	}

	private static void do1(int lv) {
		// TODO Auto-generated method stub
		if(lv == n) {
			for(int i: per) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			per[lv] = i;
			do1(lv+1);
		}
		
	}
}
