import java.io.*;
import java.util.*;

public class Main_마법상어복제_시간초과 {
//Main
	
	
	static class Shark_Info implements Comparable<Shark_Info> {
		
		int r, c, fishCnt;
		String move;
		

		public Shark_Info(int r, int c, int fishCnt, String move) {
			super();
			this.r = r;
			this.c = c;
			this.fishCnt = fishCnt;
			this.move = move;
		}

		@Override
		public int compareTo(Shark_Info o) {
			if(this.fishCnt == o.fishCnt) {
				return this.move.compareTo(o.move);
			} else {
				return o.fishCnt - this.fishCnt;
			}
		}
		
	}
	
	
	static int M, S, sr, sc;
	static int fdr[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int fdc[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int sdr[] = {-1, 0, 1, 0};
	static int sdc[] = {0, -1, 0, 1};
	
	static ArrayList<Shark_Info> shark;
	static int smell[][];
	static ArrayList<Integer> fish[][];
	static ArrayList<int []> copy;
	static int map[][];
	static boolean visit[][];
	
	static final int size = 4;
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		fish = new ArrayList[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				fish[i][j] = new ArrayList<>();
			}
		}
		smell = new int[size][size];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			fish[r][c].add(d);
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;
		
		for(int t = 1; t <= S; t++) {
			copyFish();
			moveFish();
			visit = new boolean[size][size];
			shark = new ArrayList<>();
			moveShark(sr, sc, 0, 0, "");
			makeSmell(t);
			removeSmell(t);
			addFish();
			
		}
		
		
		int ans = 0;
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				ans += fish[r][c].size();
			}
		}
		

		

		
		
		System.out.println(ans);
	}


	private static void copyFish() {
		// TODO Auto-generated method stub
		copy = new ArrayList<>();
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				for(int i = 0; i < fish[r][c].size(); i++) {
					copy.add(new int[] {r, c, fish[r][c].get(i)});
				}
			}
		}
		
	}


	private static void addFish() {
		// TODO Auto-generated method stub
		for(int i = 0; i < copy.size(); i++) {
			fish[copy.get(i)[0]][copy.get(i)[1]].add(copy.get(i)[2]);			
		}
		
	}






	private static void moveFish() {
		// TODO Auto-generated method stub
		map = new int [size][size];
		
		out: for(int f = 0; f < copy.size(); f++) {
			int r = copy.get(f)[0];
			int c = copy.get(f)[1];
			int d = copy.get(f)[2];
			int od = d;
			for(int ad = 0; ad < fdr.length; ad++) {
				
				int nr = r + fdr[d];
				int nc = c + fdc[d];
				
				if(isInside(nr, nc) && smell[nr][nc] == 0 && !isShark(nr, nc)) {
//					fish.set(i, new Pos(nr, nc, d));
					fish[r][c].remove((Integer)od);
					fish[nr][nc].add(d);
					
					map[nr][nc]++;
					continue out;
				}
				d--;
				if(d < 0)
					d = 7;
			}
			map[r][c]++;
		}
		
		

		
		
	}








	private static void moveShark(int r, int c, int cnt, int fishCnt, String s) {
		if(cnt == 3) {
			shark.add(new Shark_Info(r, c, fishCnt, s));
			return;
		}
		
		for(int d = 0; d < sdr.length; d++) {
			int nr = r + sdr[d];
			int nc = c + sdc[d];
			if(!isInside(nr, nc))
				continue;
			if(!visit[nr][nc]) {
				visit[nr][nc] = true;
				moveShark(nr, nc, cnt+1, fishCnt + map[nr][nc], s + Integer.toString(d));
				visit[nr][nc] = false;
			} else {
				moveShark(nr, nc, cnt+1, fishCnt, s + Integer.toString(d));

			}
			
		}

		
	}






	private static void makeSmell(int t) {
		// TODO Auto-generated method stub
		Collections.sort(shark);
		
		int nr = sr;
		int nc = sc;
		String s = shark.get(0).move;
		
		for(int i = 0; i < 3; i++) {
			int d = s.charAt(i) - '0';
			nr += sdr[d];
			nc += sdc[d];
			if(fish[nr][nc].size() > 0) {
				smell[nr][nc] = t + 2;
				fish[nr][nc].clear();
			}
			
			
		}
		sr = shark.get(0).r;
		sc = shark.get(0).c;

		
	}


	private static void removeSmell(int t) {
		// TODO Auto-generated method stub
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(smell[i][j] == t) {
					smell[i][j] = 0;
				}
			}
		}
		
	}

	static boolean isInside(int r, int c) {
		return r>=0 && c>=0 && r<size && c<size;		
	}
	static boolean isShark(int r, int c) {
		return r == sr && c == sc;
	}

}
