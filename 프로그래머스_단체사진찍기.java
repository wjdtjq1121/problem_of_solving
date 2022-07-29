class Solution {    
    static char friend[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean used[];
    static String input[];
    static char combo[];
    static int answer;    
    static void permu(int cnt) {
        if(cnt == 8) {
            String str = "";
            for(int i = 0; i < combo.length; i++) {
                str += combo[i];
            }            
            for(int i = 0; i < input.length; i++) {
                int start = str.indexOf(input[i].charAt(0));
                int end = str.indexOf(input[i].charAt(2));
                int space = input[i].charAt(4) - '0';
                char op = input[i].charAt(3);
                int diff = Math.abs(start - end);
                if(op == '=') {
                    if(diff != space + 1)
                        return;
                } else if(op == '>') {
                    if(diff <= space + 1)
                        return;                  
                } else if(op == '<') {
                    if(diff >= space + 1)
                        return;                  
                }
            }
            answer++;            
            return;
        }        
        for(int i = 0; i < friend.length; i++) {           
            if(!used[i]) {
                used[i] = true;
                combo[cnt] = friend[i];            
                permu(cnt+1);
                used[i] = false;
            }
        }        
    }
    
    public int solution(int n, String[] data) {
        answer = 0;        
        input = data;
        used = new boolean[friend.length];
        combo = new char[friend.length];       
        permu(0);        
        return answer;
    }
}