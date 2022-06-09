import java.util.*;
import java.io.*;

public class Main_청소년상어_골드2_dfs_성공 {
//Main
	
	static class Fish implements Comparable<Fish> {
		int r, c, d, num;
		boolean isAlive;
		public Fish(int r, int c, int d, int num, boolean isAlive) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.num = num;
			this.isAlive = isAlive;
		}
		@Override
		public int compareTo(Fish o) {
			return Integer.compare(this.num, o.num);
		}
	}
	static class Shark {
		int r, c, d, eat;
		
		Shark(){}

		public Shark(int r, int c, int d, int eat) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.eat = eat;
		}
	}

	static final int size = 4;
	static int ans;
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, -1, -1, -1, 0, 1, 1, 1};
	
	static void moveFish(Fish fish, int map[][], List<Fish> fishes) {
		if(!fish.isAlive)
			return;
		
		for(int i = 0; i < dr.length; i++) {
			int nr = fish.r + dr[i];
			int nc = fish.c + dc[i];
			int nd = (fish.d + i) % 8;
			if(isInside(nr, nc) && map[nr][nc] > -1) {
				map[fish.r][fish.c] = 0;
				if(map[nr][nc] == 0) {
					map[nr][nc] = fish.num;					
				} else {
					Fish swap_fish = fishes.get(map[nr][nc]);
					map[fish.r][fish.c] = swap_fish.num;
					swap_fish.r = fish.r;
					swap_fish.c = fish.c;
					
					fish.r = nr;
					fish.c = nc;
				}
				map[nr][nc] = fish.num;					
				fish.d = nd;
				return;
			}			
		}
		
	}
	
	
	static void dfs(int map[][], Shark shark, List<Fish> fish) {
		
		ans = ans < shark.eat ? shark.eat : ans;
		
		for(int j = 1; j < fish.size(); j++) {
			Fish cur_fish = fish.get(j);
//			moveFish(fish.get(i), map, fish);
			
//			System.out.println(j + "번째");
//			for(int i = 1; i < fish.size(); i++) {
//				System.out.println(fish.get(i).r + " " + fish.get(i).c + " " + fish.get(i).num + " " + fish.get(i).d);
//			}
			
			if(!cur_fish.isAlive)
				continue;
			
			for(int i = 0; i < dr.length; i++) {
				int nd = (cur_fish.d + i) % 8;
				int nr = cur_fish.r + dr[nd];
				int nc = cur_fish.c + dc[nd];
				if(isInside(nr, nc) && map[nr][nc] > -1) {
					map[cur_fish.r][cur_fish.c] = 0;
					if(map[nr][nc] == 0) {
						cur_fish.r = nr;					
						cur_fish.c = nc;					
					} else {
						Fish swap_fish = fish.get(map[nr][nc]);
						map[cur_fish.r][cur_fish.c] = swap_fish.num;
						swap_fish.r = cur_fish.r;
						swap_fish.c = cur_fish.c;
						
						cur_fish.r = nr;
						cur_fish.c = nc;
					}
					map[nr][nc] = cur_fish.num;					
					cur_fish.d = nd;
					break;
				}			
			}

		}
		

//		for(int i = 1; i < fish.size(); i++) {
//			System.out.println(fish.get(i).r + " " + fish.get(i).c + " " + fish.get(i).num + " " + fish.get(i).d);
//		}
		
		int nr = shark.r;
		int nc = shark.c;
		while(isInside(nr + dr[shark.d], nc + dc[shark.d])) {
			nr += dr[shark.d];
			nc += dc[shark.d];
			if(map[nr][nc] > 0) {
				// 물고기 있을경우 처리
				int cmap[][] = copyArr(map);
				List<Fish> clist = copyList(fish);
				Shark cur_shark = new Shark(nr, nc, fish.get(map[nr][nc]).d, shark.eat + fish.get(map[nr][nc]).num);
				cmap[shark.r][shark.c] = 0;
				cmap[nr][nc] = -1;
				clist.get(map[nr][nc]).isAlive = false;
				dfs(cmap, cur_shark, clist);
				
				
			}
		}
		
		


		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st;		
		//st = new StringTokenizer(br.readLine());
		List<Fish> fish = new ArrayList<>();
		
		fish.add(new Fish(0, 0, 0, 0, false));
		int map[][] = new int[size][size];
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int v = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = v;
				fish.add(new Fish(i, j, dir, v, true));				
			}
		}
		ans = 0;
		Shark shark = new Shark(0, 0, fish.get(1).d, fish.get(1).num);
		fish.get(1).isAlive = false;
		Collections.sort(fish);
		map[0][0] = -1;
		dfs(map, shark, fish);


		System.out.println(ans);			
	}
	static boolean isInside(int r, int c) {
		return r >= 0 && c >= 0 && r < size && c < size;
	}
	static int[][] copyArr(int m[][]) {
		int cmap[][] = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cmap[i][j] = m[i][j];
			}
		}			
		return cmap;
	}
	static List<Fish> copyList(List<Fish> fish) {
		List<Fish> cfish = new ArrayList<>();
		for(int i = 0; i < fish.size(); i++) {
			cfish.add(new Fish(fish.get(i).r, fish.get(i).c, fish.get(i).d, fish.get(i).num, fish.get(i).isAlive));
		}
		
		return cfish;
	}
	
}
