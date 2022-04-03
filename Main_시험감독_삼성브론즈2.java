import java.io.*;
import java.util.*;

public class Main_시험감독_삼성브론즈2 {
//Main
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int size = Integer.parseInt(br.readLine());
		int room[] = new int[size];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		
		long answer = 0;

		for(int i = 0; i < size; i++) {
			int add = 0;
			int guys = room[i];
		
			add++;
			guys -= main;
			if(guys > 0) {
				add += guys / sub;
				if(guys % sub > 0)
					add++;
			}
			answer+=add;
		}

		
		
		System.out.println(answer);
	}
}
