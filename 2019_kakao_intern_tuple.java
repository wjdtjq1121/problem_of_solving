import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String token[] = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        
        Arrays.sort(token, (a, b)->{
            return a.length() - b.length();
        });        
        int answer[] = new int[token.length];
        
        int index = 0;
        for(String s1: token) {
            for(String s2: s1.split(",")) {
                if(set.add(s2))
                    answer[index++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}