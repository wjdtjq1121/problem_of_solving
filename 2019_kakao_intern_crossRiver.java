import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;
        
        while(min <= max) {
            int mid = (min + max) / 2;
            
            if(canCross(stones, k, mid)) {
                min = mid + 1;
                answer = Math.max(mid, answer);
            } else {
                max = mid - 1;
            }            
        }
        return answer;
    }
    boolean canCross(int stones[], int k, int mid) {
        
        int jump = 0;
        for(int stone: stones) {
            
            if(stone - mid < 0) {
                jump++;
            } else {
                jump = 0;
            }
            if(jump == k)
                return false;
            
        }
        return true;
        
    }
    
}