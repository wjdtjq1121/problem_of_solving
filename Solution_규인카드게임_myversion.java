import java.io.*;
import java.util.*;

public class Solution_규인카드게임_myversion {
//Solution
	static int N = 9;
	static int y_deck[] = new int[N];
	static int m_deck[] = new int[N];
	static int sum[] = new int[1];
	static int numbers[] = new int[N]; 
	static boolean[] isSelected = new boolean[N];
	static int answer_win, answer_lose, mut;
	static int total;
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input_규인카드게임"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			
			
			int temp[] = new int[19];
			for(int i = 0; i < N; i++) {
				y_deck[i] = Integer.parseInt(st.nextToken());
				temp[y_deck[i]]++;
			}
			//calculate and put numbers u know what i mean
			int put = 0;
			for(int i = 1; i <= N*2; i++) {				
				if(temp[i] == 0) {
					m_deck[put++] = i;
				}

			}
			answer_win = 0;
			answer_lose = 0;
			mut = 0;
			total = 0;
			per(0);
			
//			for(int i = 0; i < 9; i++) {
//				System.out.print(y_deck[i] + " ");
//			}
//			System.out.println();
//			for(int i = 0; i < 9; i++) {
//				System.out.print(m_deck[i] + " ");
//			}
//			System.out.println();
//			System.out.println();
			
			
//			System.out.println("ans: " + answer_win + " " + answer_lose);
			System.out.println("#" + tc + " " + answer_win + " " + answer_lose);
			


		}

		//System.out.println("success");


	}


	
	
	static void per(int cnt) {
		
		if(cnt == N) {
//			if(sum[0] > 0)
//				answer_win++;
//			if(sum[0] < 0)
//				answer_lose++;
//			System.out.println(Arrays.toString(numbers));

			int temp1 = 0, temp2 = 0;
			for(int i = 0; i < N; i++) {
				
				if(y_deck[i] > m_deck[numbers[i]])
					temp1+=y_deck[i]+m_deck[numbers[i]];
				else if(y_deck[i] < m_deck[numbers[i]]) 
					temp2+=y_deck[i]+m_deck[numbers[i]];
//				if(y_deck[i] > m_deck[numbers[i]])
//					answer_win++;				
//				if(y_deck[i] < m_deck[numbers[i]])
//					answer_lose++;
			}
			if(temp1 > temp2)
				answer_win++;
			if(temp1 < temp2)
				answer_lose++;
			
			
			
			
			
			return;
		}
		for(int i = 0; i < N; i++) {
			if(isSelected[i])
				continue;
			
//			numbers[cnt] = m_deck[i];
			numbers[cnt] = i;

			isSelected[i] = true;
			
			per(cnt + 1);
			isSelected[i] = false;			
			
		}
	}

	
	
}
