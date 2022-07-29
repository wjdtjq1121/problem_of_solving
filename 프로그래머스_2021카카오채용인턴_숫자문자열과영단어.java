import java.io.*;
import java.util.*;

class Solution {

    HashMap<String, Integer> hm = new HashMap<>();

    public int solution(String s) {
        int answer = 0;
        
        hm.put("zero", 0);
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);
        hm.put("four", 4);
        hm.put("five", 5);
        hm.put("six", 6);
        hm.put("seven", 7);
        hm.put("eight", 8);
        hm.put("nine", 9);
        
        String str = "";
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            

            
            
            if(num >= 0 && num <= 9) {
                ans += s.charAt(i);                
                str = "";
                continue;                
            }
            
            str += s.charAt(i);
            
            if(hm.get(str) != null) {
                int idx = hm.get(str);
                ans += String.valueOf(idx);                  
                str = "";
            }            
            
        }
        //System.out.println(ans);
        
        
        answer = Integer.parseInt(ans);
        

        

        
        
        return answer;
    }
}