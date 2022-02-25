import java.io.*;
import java.util.*;

public class Solution_d4_1223_계산기2_서울_12반_한정섭 {
//Solution
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		int T = 10;

		//st = new StringTokenizer(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			int size = Integer.parseInt(br.readLine());
			String s = br.readLine();
			String form = "";
			Stack<Character> op = new Stack<>();
			Stack<Integer> number = new Stack<>();


			for(int i = 0; i < s.length(); i++) {
				char idx = s.charAt(i);
				
				if((idx - '0') >= 0 && (idx - '0') <= 9) {
					form += idx;
				} else {
					
					if(idx == '*')
						op.push(idx);
					else {
						while(!op.isEmpty()) {
							form += op.pop();
						}
						op.push(idx);
						
						
					}
					
					
				}
				
				
			}
			while(!op.empty())
				form += op.pop();
			
			for(int i = 0; i < form.length(); i++) {
				char idx = form.charAt(i);
				
				if((idx - '0') >= 0 && (idx - '0') <= 9) {
					number.push(idx - '0');
				} else {
					int num1 = number.pop();
					int num2 = number.pop();
					
					if(idx == '*')
						number.push(num1*num2);
					if(idx == '+')
						number.push(num1 + num2);

					
				}
			}
//			System.out.println();



			
			
			
			System.out.println("#" + tc + " " + number.pop());			
		}
		
		
		//System.out.println("success");
	}
}
