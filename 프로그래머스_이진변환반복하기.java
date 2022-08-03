class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];                
        int total_two = 0;
        int total_zero = 0;
        while(!s.equals("1")) {
            total_two++;
            int one_len = 0;
            int zero_len = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    zero_len++;
                } else {
                    one_len++;
                }
            }
            total_zero += zero_len;
            s = Integer.toBinaryString(one_len);
        }
        answer[0] = total_two;
        answer[1] = total_zero;        
        return answer;
    }
}