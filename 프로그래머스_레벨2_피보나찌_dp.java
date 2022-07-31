import java.io.*;
import java.util.*;

class Solution {
    
    static public int Fibo(int n) {
        
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        
        return Fibo(n - 1) + Fibo(n - 2);
        
    }
    
    public int solution(int n) {
        int answer = 0;
        
        // answer = Fibo(n);        
        // answer = answer % 1234567;
        
        int dp[] = new int[n+1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        
        
        return dp[n];
    }
}