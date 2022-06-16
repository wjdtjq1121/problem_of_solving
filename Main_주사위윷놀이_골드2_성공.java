import java.util.*;
import java.io.*;

public class Main_주사위윷놀이_골드2_성공 {
//Main
	
	static int input[], permu[], chess[];
	static int ans;
	static Node map[];
	static boolean exitCheck[];
	static final int mal_num = 4;
	
	
	static class Node {
		int score, red, blue;
		boolean isBlue;
		
		public Node(int score, int red, int blue, boolean isBlue) {
			super();
			this.score = score;
			this.red = red;
			this.blue = blue;
			this.isBlue = isBlue;
		}
	}
	
	static void iper(int n, int k) {
		if(n==k) {
			System.out.println(Arrays.toString(permu));
			chess = new int[mal_num];
			exitCheck = new boolean[43];
			move();
			return;
		}
		for(int i = 0; i < 4; i++) {
			permu[k] = i;
			iper(n, k+1);
			permu[k] = -1;
		}
	}
	
	
	static void per(int cnt) {
		if(cnt == 10) {
			//System.out.println(Arrays.toString(permu));
			chess = new int[mal_num];
			exitCheck = new boolean[43];
			move();
			return;
		}
		
		for(int i = 0; i < mal_num; i++) {
			
			permu[cnt] = i;
			per(cnt+1);
			
		}
	}
	
	static void move() {
		int score = 0;
		for(int i = 0; i < 10; i++) {
			int end = horseAction(permu[i], input[i]);
			if(end == -1)
				return;
			chess[permu[i]] = end;
//			System.out.println(end);
			score += map[end].score;
			
			
		}
		ans = ans < score ? score : ans;
	}
	
	static int horseAction(int horse, int dice) {
		int cur = chess[horse];
		
		for(int i = 0; i < dice; i++) {
			if(i == 0 && map[cur].isBlue) {
				cur = map[cur].blue;
				continue;
			}
			//System.out.println(cur);
			cur = map[cur].red;			
		}
		
		if(cur <= 40 && exitCheck[cur]) {
			return -1;
		} else {
			exitCheck[chess[horse]] = false;
			exitCheck[cur] = true;					
			return cur;
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[10];
		permu = new int[10];
		map = new Node[43];
		for(int i = 0; i < 10; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <= 40; i+=2) {
			map[i] = new Node(i, i+2, 0, false);
		}
		
		map[10].isBlue = map[20].isBlue = map[30].isBlue = true;
		map[10].blue = 11;
		map[20].blue = 17;
		map[30].blue = 31;

		map[11] = new Node(13, 13, 0, false);
		map[13] = new Node(16, 15, 0, false);
		map[15] = new Node(19, 25, 0, false);

		map[17] = new Node(22, 19, 0, false);
		map[19] = new Node(24, 25, 0, false);

		map[25] = new Node(25, 37, 0, false);

		map[31] = new Node(28, 33, 0, false);
		map[33] = new Node(27, 35, 0, false);
		map[35] = new Node(26, 25, 0, false);

		map[37] = new Node(30, 39, 0, false);
		map[39] = new Node(35, 40, 0, false);
		map[42] = new Node(0, 42, 0, false);
		
		per(0);
		

		
		System.out.println(ans);
	}
	
	
	
}
