import java.io.*;
import java.util.*;

class Solution {
    
    static int dr[] = {0, 1, 0, -1};
    static int dc[] = {1, 0, -1, 0};
    static String input[][];
    static final int room = 5;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < 5; i++)
            answer[i] = 1;
        
        input = places;
        
        for(int i = 0; i < places.length; i++) {
            boolean safe = false;
            out: for(int j = 0; j < room; j++) {
                for(int k = 0; k < room; k++) {
                    if(input[i][j].charAt(k) == 'P') {
                        Queue<int []> q = new LinkedList<>();
                        boolean visit[][] = new boolean[room][room];
                        visit[j][k] = true;
                        q.offer(new int[]{j, k, 0});
                        while(!q.isEmpty()) {
                            int cur[] = q.poll();
                            int r = cur[0];
                            int c = cur[1];
                            int cnt = cur[2];
                            
                            for(int d = 0; d < dr.length; d++) {
                                int nr = r + dr[d];
                                int nc = c + dc[d];
                                
                                if(isInside(nr, nc) && !visit[nr][nc] && cnt != 2) {
                                    visit[nr][nc] = true;
                                                                                                           
                                    if(input[i][nr].charAt(nc) == 'P') {
                                        safe = true;
                                        break out;
                                    }
                                    
                                    if(input[i][nr].charAt(nc) == 'X')
                                        continue;
                                    
                                    q.offer(new int[]{nr, nc, cnt+1});
                                }

                            }
                            
                            
                        }
                        
                    }
                    
                }
            }
            if(safe) {
                answer[i] = 0;
            }
        }
        
        
        
        
        return answer;
    }
    static public boolean isInside(int r, int c) {
        return r >= 0 && c >= 0 && r < room && c < room;
    }
}