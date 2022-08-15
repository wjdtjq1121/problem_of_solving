import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        long left = 1, right = distance;
        Arrays.sort(rocks);
        while(left <= right) {
            long mid = (left + right) / 2;
            int prev = 0;
            int cnt = 0;
            
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }
            if(distance - rocks[rocks.length - 1] < mid)
                cnt++;
            if(cnt <= n) {
                left = mid + 1;
                answer = (int)mid;
            } else {
                right = mid - 1;
            }
            
        }
        
        return answer;
    }
}