class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int size = land.length;
        int dp[][] = new int[land.length + 1][4];

        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int max = 0;
                for(int k = 0; k < 4; k++) {
                    if(j == k)
                        continue;
                    //dp[i+1][j] = Math.max();
                    max = Math.max(max, dp[i][k]);
                }                
                dp[i+1][j] = land[i][j] + max;

            }
        }
        
        for(int i = 0; i < 4; i++)
            answer = Math.max(answer, dp[size][i]);

        return answer;
    }
}