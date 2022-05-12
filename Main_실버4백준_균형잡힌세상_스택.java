import java.util.*;
import java.io.*;

public class Main_실버4백준_균형잡힌세상_스택 {
//Main
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str = br.readLine();				
		while(!str.equals(".")) {
			
			Stack<Character> s = new Stack<>();
			boolean flag = true;
			for(int i = 0; i < str.length(); i++) {
				
				if(str.charAt(i) == '[' || str.charAt(i) == '(') {
					s.push(str.charAt(i));
				}
				if(str.charAt(i) == ']' || str.charAt(i) == ')') {
					
					if(s.isEmpty()) {
						s.push(str.charAt(i));
						flag = false;
						break;
					}
					
					if(s.peek() == '[' && str.charAt(i) != ']') {
						s.push(str.charAt(i));

						flag = false;
						break;
					}
					if(s.peek() == '(' && str.charAt(i) != ')') {
						s.push(str.charAt(i));

						flag = false;
						break;
					}
					s.pop();
				}

				
				
			}
			
			if(s.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
			
			
			str = br.readLine();
		}
	}
}
