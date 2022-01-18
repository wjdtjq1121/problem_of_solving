import java.io.*;
import java.util.*;

public class Main_bj_3025_stone_2try {
//Main
	static int R, C;
	static char map[][];
	static Stone stone[];
	
	static class Stone {
		int col[];
		int r;
		Stone() {
			super();
			this.col = new int[R];
			this.r = 1;
		}
		
		public void trim() {
			while(true) {
				int cur = col[r-1];
				
				if(r > 1 && map[r-1][cur] != '.') {
					r--;
				} else if(r == R || map[r][cur] == 'X') {
					break;
				} else if(map[r][cur] == '.'){
					col[r++] = cur;
				} else {
					if(cur > 0 && map[r][cur-1] == '.' && map[r-1][cur-1] == '.') {
						col[r++] = cur - 1;
					} else if(cur < C-1 && map[r][cur+1] == '.' && map[r-1][cur+1] == '.') {
						col[r++] = cur + 1;
					} else {
						break;
					}
				}
			}
		}		
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		stone = new Stone[C];
		
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		for(int c = 0; c < C; c++) {
			stone[c] = new Stone();
			stone[c].col[0] = c;
			stone[c].trim();			
		}
		
		int oper = Integer.parseInt(br.readLine());
		for(int go = 0; go < oper; go++) {
			int flow = Integer.parseInt(br.readLine()) - 1;
			
			map[stone[flow].r-1][stone[flow].col[stone[flow].r-1]] = 'O';
			
			for(int c = 0; c < C; c++) {
				stone[c].trim();
			}
			
		}
	    for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
	}
}
