import java.io.*;
import java.util.*;

public class Main_마법사상어복제_failed {
//Main
	static int num, magic, sr, sc, ans;
	static ArrayList<Pos> fish;
	static ArrayList<Pos> map[][];
	static int smell[][];
	static int board[][];
	static final int arena = 4;
	static ArrayList<Shark> shark_order;
	static boolean visited[][];
	
	static int fdr[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int fdc[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int sdr[] = {-1, 0, 1, 0};
	static int sdc[] = {0, -1, 0, 1};
	
	
	static class Pos {
		int r, c, d;

		public Pos(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	
	static class Shark implements Comparable<Shark>{
		int eat, fast, r, c;

		public Shark(int eat, int fast, int r, int c) {
			super();
			this.eat = eat;
			this.fast = fast;
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Shark o) {
			if(this.eat == o.eat) {
				return Integer.compare(this.fast, o.fast);
			} else {
				return -Integer.compare(this.eat, o.eat);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		magic = Integer.parseInt(st.nextToken());
		map = new ArrayList[arena][arena];
		fish = new ArrayList<>();
		board = new int[arena][arena];
		for(int i = 0; i < arena; i++) {
			for(int j = 0; j < arena; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			
			fish.add(new Pos(r, c, d));
			map[r][c].add(new Pos(r, c, d));
			board[r][c]++;
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;
		smell = new int[arena][arena];
		
		for(int m = 0; m < magic; m++) {
			ArrayList<Pos> copy = new ArrayList<>();
			for(int i = 0; i < fish.size(); i++) {
				copy.add(new Pos(fish.get(i).r, fish.get(i).c, fish.get(i).d));
			}
			
//			for(int i = 0; i < fish.size(); i++) {
//				System.out.println((i+1) + "번째 물고기 r " + (fish.get(i).r+1) + " c " + (fish.get(i).c+1) + " d " + fish.get(i).d);
//			}
//			System.out.println();
			
//			System.out.println(sr + " " + sc);
			
			fishmove();
			
//			for(int i = 0; i < fish.size(); i++) {
//				System.out.println((i+1) + "번째 물고기 r " + (fish.get(i).r+1) + " c " + (fish.get(i).c+1) + " d " + fish.get(i).d);
//			}
//			System.out.println();
			
			
			remove_smell();
			hunt();
			
			for(int i = 0; i < fish.size(); i++) {
				if(board[fish.get(i).r][fish.get(i).c] == 0) {
					fish.remove(i);
					i--;
				}
			}
			
//			System.out.println("size fish " + fish.size());
//			for(int i = 0; i < fish.size(); i++) {
//				System.out.println((i+1) + "번째 물고기 r " + (fish.get(i).r+1) + " c " + (fish.get(i).c+1) + " d " + fish.get(i).d);
//			}
//			System.out.println();
			
						
			for(int i = 0; i < copy.size(); i++) {
				fish.add(new Pos(copy.get(i).r, copy.get(i).c, copy.get(i).d));
				board[copy.get(i).r][copy.get(i).c]++;
			}			
			
//			System.out.println("smell board");
//			for(int i = 0; i < 4; i++) {
//				for(int j = 0; j < 4; j++) {
//					System.out.print(smell[i][j] + " ");
//				}
//				System.out.println();
//			}
			
//			System.out.println((sr+1) + " " + (sc+1));
//			for(int i = 0; i < fish.size(); i++) {
//				System.out.println((i+1) + "번째 물고기 r " + (fish.get(i).r+1) + " c " + (fish.get(i).c+1) + " d " + fish.get(i).d);
//			}
//			for(int i = 0; i < 4; i++) {
//				for(int j = 0; j < 4; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			

		}


		
		ans = 0;
		for(int i = 0; i < arena; i++) {
			for(int j = 0; j < arena; j++) {
				//ans += map[i][j].size();
				ans += board[i][j];
			}
		}

		
		
		System.out.println(ans);
	}
	
	static void hunt() {
		shark_order = new ArrayList<>();
		
		visited = new boolean[arena][arena];
//		visited[sr][sc] = true;
		
		System.out.println("shark: " + sr + " " + sc);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		dfs(0, 0, 0, sr, sc);
		Collections.sort(shark_order);
		int r = shark_order.get(0).r;
		int c = shark_order.get(0).c;
		int eat = shark_order.get(0).eat;
		int fast = shark_order.get(0).fast;
		
//		for(int i = 0; i < shark_order.size(); i++) {
//			System.out.println(shark_order.get(i).eat + " " + shark_order.get(i).fast + " " + shark_order.get(i).r + " " + shark_order.get(i).c);
//		}
//		System.out.println();
		
		sr = r;
		sc = c;		
//		System.out.println(fast);
		
		
//		123 - 3
//		12 - 2
//		1 - 1
		
		if(board[r][c] > 0) {
			smell[r][c] += 2;
		}
		board[r][c] = 0;
		for(int i = 0; i < 3; i++) {
			int divide = 0;
			divide = fast % 10;
			fast /= 10;
			divide--;
			int d = divide + 2;
			if(d > 3)
				d = d % 4;
			
			r += sdr[d];
			c += sdc[d];
			if(board[r][c] > 0) {
				smell[r][c] = 2;
			}
			board[r][c] = 0;


			
			
		}
		
		
	}
	
	static void dfs(int cnt, int order, int eat, int r, int c) {
		if(cnt == 3) {
			//System.out.println(eat + " " + order);
			shark_order.add(new Shark(eat, order, r, c));
			return;
		}
		
		for(int d = 0; d < sdr.length; d++) {
			int nr = r + sdr[d];
			int nc = c + sdc[d];
			
			if(isInside(nr, nc)) {
				int add_fish = 0;
				
				if(!visited[nr][nc])
					add_fish = board[nr][nc];
				visited[nr][nc] = true;
				int add = 0;
				if(cnt == 0) {
					add += 100 * (d+1);
				} else if(cnt == 1) {
					add += 10 * (d+1);
				} else if(cnt == 2) {
					add += (d+1);
				}

				System.out.println(eat + " " + cnt + " " + order + " " + (nr+1) + " " + (nc+1) + " " + board[nr][nc] + " " + visited[nr][nc] + " " + add_fish);
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						System.out.print(visited[i][j] + " ");
					}
					System.out.println();
				}
				dfs(cnt+1, order+add, eat + add_fish, nr, nc);
				visited[nr][nc] = false;
			}
				
			
		}
		
		
		
	}
	
	
	
	static void fishmove() {
		for(int i = 0; i < fish.size(); i++) {
			int r = fish.get(i).r;
			int c = fish.get(i).c;
			int d = fish.get(i).d;
			
			for(int ad = 0; ad < fdr.length; ad++) {
				
				int nr = r + fdr[d];
				int nc = c + fdc[d];
				
				if(isInside(nr, nc) && smell[nr][nc] == 0 && !isShark(nr, nc)) {
					fish.set(i, new Pos(nr, nc, d));
					board[r][c]--;
					board[nr][nc]++;
					break;
				}
				d--;
				if(d < 0)
					d = 7;
			}
		}
	}
	
	static void remove_smell() {
		
		for(int i = 0; i < arena; i++) {
			for(int j = 0; j < arena; j++) {
				if(smell[i][j] > 0)
					smell[i][j]--;
			}
		}
		
	}
	
	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r<arena && c<arena;		
	}
	static boolean isShark(int r, int c) {
		return r == sr && c == sc;
	}
	
}
