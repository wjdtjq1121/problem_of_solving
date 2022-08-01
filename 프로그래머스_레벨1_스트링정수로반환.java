import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        //String s = Integer.toString(n);
        String s = String.valueOf(n);

        System.out.println(s);

        for(int i = 0; i < s.length(); i++) {
            answer += s.charAt(i) - '0'; 
        }


        return answer;
    }
}