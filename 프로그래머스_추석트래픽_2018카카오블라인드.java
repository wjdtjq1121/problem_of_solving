import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        ArrayList<int []> arr = new ArrayList<>();
        for(int i = 0; i < lines.length; i++) {
            int start = 0;
            int end = 0;
            
            int h = Integer.parseInt(lines[i].substring(11, 13)) * 3600 * 1000;
            int m = Integer.parseInt(lines[i].substring(14, 16)) * 60 * 1000;
            double s = Double.parseDouble(lines[i].substring(17, 23)) * 1000;            
            end = h + m + (int)s;
            
            double plus = Double.parseDouble(lines[i].substring(24, lines[i].length() - 1)) * 1000;
            int add = (int) plus;
            start = end - add + 1;
            arr.add(new int[]{start, end});
            
            
        }
        int max = 0;
        
        for(int i = 0; i < arr.size(); i++) {
            int cnt = 1;
            for(int j = i+1; j < arr.size(); j++) {
                if(arr.get(i)[1] + 1000 > arr.get(j)[0]) {
                    cnt++;
                }

            }
            max = Math.max(max, cnt);
        }
        

        
        return max;
    }
}