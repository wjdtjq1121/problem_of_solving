import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        HashSet<String> hs = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int start = 0;
        int len = Integer.MAX_VALUE;
        int left = 0;
        
        for(String s: gems) {
            hs.add(s);
        }
        for(String s: gems) {
            hm.put(s, hm.getOrDefault(s, 0)+1);
            q.offer(s);
            
            while(true) {
                if(hm.get(q.peek()) > 1) {
                    hm.put(q.peek(), hm.get(q.peek())-1);
                    q.poll();
                    left++;
                } else {
                    break;
                }
            }
            
            if(hs.size() == hm.size() && len > q.size()) {
                len = q.size();
                start = left;
            }
            
            
            
        }
        

        return new int[]{start+1, start+len};
    }
}