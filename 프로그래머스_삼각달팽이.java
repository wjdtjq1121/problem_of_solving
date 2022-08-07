삼각 달팽이 프로그래머

class Solution {
    public int[] solution(int n) {
        int size = 0;
        for(int i = 1; i <= n; i++) {
            size += i;
        }
        int[] answer = new int[size];
        int map[][] = new int[n][n];
        int d = 0;
        int r = -1;
        int c = 0;
        int idx = 1;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) {
                    r++;
                } else if(i % 3 == 1) {
                    c++;
                } else if(i % 3 == 2) {
                    r--;
                    c--;                    
                }
                map[r][c] = idx;
                idx++;
            }
        }
        int v = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0)
                    break;
                answer[v] = map[i][j];
                v++;
            }
        }
        
    
        return answer;
    }
}