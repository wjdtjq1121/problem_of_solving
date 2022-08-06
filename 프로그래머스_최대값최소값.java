class Solution {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String str[] = s.split(" ");
        
        for(int i = 0; i < str.length; i++) {
            int v = Integer.parseInt(str[i]);
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        answer += min;
        answer += " ";
        answer += max;
        
        
        
        
        return answer;
    }
}