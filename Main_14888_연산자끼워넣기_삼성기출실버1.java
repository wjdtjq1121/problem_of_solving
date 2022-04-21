import java.util.*;
import java.io.*;

public class Main {
//Main

	static int size;
	static long max_ans, min_ans;
	static int permu_size;
	static int permu[];
	static boolean permu_check[];
	static long num[];
	static int oper[];
	static int input[];
	static final int oper_size = 4;


	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.java"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		size = Integer.parseInt(br.readLine());		
		num = new long[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		oper = new int[oper_size];
		permu_size = size-1;
		input = new int[permu_size];

		max_ans = Integer.MIN_VALUE;
		min_ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < size; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());

		int cnt = 0;
		for(int i = 0; i < oper_size; i++) {
			oper[i] = Integer.parseInt(st.nextToken());

			for(int j = 0; j < oper[i]; j++) {
				input[cnt++] = i;
			}


		}
		permu = new int[permu_size];
		permu_check = new boolean[permu_size];

		
		
		get_permu(0);
		

		
			
		System.out.println(max_ans);			
		System.out.println(min_ans);			
		
	}

	static void get_permu(int idx) {
		if(idx == permu_size) {
//			System.out.println(Arrays.toString(permu));

			long val = num[0];

			for(int i = 0; i < permu_size; i++) {
				val = cal(val, num[i+1], permu[i]);
			}
			max_ans = Math.max(max_ans, val);
			min_ans = Math.min(min_ans, val);



		}


		for(int i = 0; i < permu_size; i++) {
			if(permu_check[i])
				continue;
			permu_check[i] = true;
			permu[idx] = input[i];
			get_permu(idx+1);
			permu_check[i] = false;


		}



	}

	static long cal(long a, long b, int op) {
		long result = 0;

		if(op == 0) {
			result = a + b;
		} else if(op == 1) {
			result = a - b;
		} else if(op == 2) {
			result = a * b;
		} else if(op == 3) {
			result = a / b;
		}
		return result;
	}

	

}
