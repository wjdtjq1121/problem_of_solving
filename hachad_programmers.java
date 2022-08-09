하샤드 수 완탐
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String s = String.valueOf(x);
        int divide = 0;
        for(int i = 0; i < s.length(); i++) {
            divide += s.charAt(i) - '0';
        }
        if(x % divide != 0)
            answer = false;
        

        
        return answer;
    }
}