import java.io.*;
import java.util.*;

public class Main_소수구하기_백준 {
//Main
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		for(int i = s; i <= e; i++) {
			
			boolean check = getPrime(i);
			if(check)
				System.out.println(i);
		}
		//System.out.println("success");
		

		

		
	}
	
	static boolean getPrime(int num) {
		
		if(num <= 1)
			return false;
		if(num == 2)
			return true;
		

		for(int i = 2; i <= Math.sqrt(num); i++) {
			
			
			if(num % i == 0)
				return false;
		}

		return true;
	}
}
