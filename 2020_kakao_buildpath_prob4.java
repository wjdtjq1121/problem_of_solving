import java.io.*;
import java.util.*;


class Solution {
    
    int row, col;
    
    
    class Pos {
        int r, c, k, cost;
        
        Pos(int r, int c, int k, int cost) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.cost = cost;
        }
    }
    
    public boolean isInside(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};
        row = board.length;
        col = board[0].length;
        int dist[][][] = new int[row][col][4];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                for(int p = 0; p < dr.length; p++) {
                    dist[i][j][p] = Integer.MAX_VALUE;
                }
            }
        }
        dist[0][0][0] = 0;
        Queue<Pos> q = new LinkedList<>();
        
        q.offer(new Pos(0, 0, 0, 0));
        q.offer(new Pos(0, 0, 1, 0));
        
        while(!q.isEmpty()) {
            Pos p = q.poll();
            int r = p.r;
            int c = p.c;
            int k = p.k;
            int cost = p.cost;
            
            for(int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                int add = k == d ? 100 : 600;                
                int ncost = cost + add;
                
                if(isInside(nr, nc) && board[nr][nc] == 0 && ncost < dist[nr][nc][d]) {
                    dist[nr][nc][d] = ncost;
                    q.offer(new Pos(nr, nc, d, ncost));
                }
                
            }
            
            
            
        }
        
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < dr.length; i++) {
            answer = Math.min(answer, dist[row-1][col-1][i]);
        }
        
        
        
        
        
        return answer;
    }
}