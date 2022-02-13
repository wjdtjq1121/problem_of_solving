import java.io.*;
import java.util.*;
 
public class Solution_정사각형방_내꺼 {
     
    static int board[][];
    static int dp[][];
    static int N;
    static int delR[] = {0, 1, 0, -1};
    static int delC[] = {1, 0, -1, 0};
 
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("정사각형방"));
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
 
         
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            dp = new int[N][N];
 
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            int answer_max = -1;
            int answer_index = Integer.MAX_VALUE;
                     
 
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(dp[i][j] == 0 )
                        dfs(i, j);
                         
                    if(answer_max < dp[i][j]) {
                        answer_max = dp[i][j];
                        answer_index = board[i][j];
                    } else if(answer_max == dp[i][j]) {
                        answer_index = answer_index > board[i][j] ? board[i][j] : answer_index; 
                    }
                         
                     
                }                   
            }
             
            System.out.println("#" + test_case + " " + answer_index + " " + answer_max);
 
             
             
        }
 
 
        //System.out.println("success");
    }
     
    static void dfs(int r, int c) {
        dp[r][c] = 1;
         
        for(int d = 0; d < 4; d++) {
             
            int new_r = r + delR[d];
            int new_c = c + delC[d];
             
            if(new_r < 0 || new_r >= N || new_c < 0 || new_c >= N)
                continue;
             
            if(board[r][c] == board[new_r][new_c] - 1) {
                 
                if(dp[new_r][new_c] == 0) {
                    dfs(new_r, new_c);
                }
                 
                if(dp[r][c] < dp[new_r][new_c] + 1) {
                    dp[r][c] = dp[new_r][new_c] + 1;                    
                }
                 
                 
                 
            }
        }
         
         
    }   
}