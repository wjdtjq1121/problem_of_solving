import java.util.*;
import java.io.*;

public class Main_πÈ¡ÿ2048_ªÔº∫±‚√‚∞ÒµÂ2_º∫∞¯ {
//Main
	static int size, ans;
	static int map[][];
	static int rotate[];
	static final int rotate_num = 5;
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	static int input[][];


	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		input = new int[size][size];
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 2;
		rotate = new int[rotate_num];
		do_rotate(0);

//		 rotate[0] = 1;
//		 rotate[1] = 2;
//		 rotate[2] = 3;
//		 rotate[3] = 0;
//		 rotate[4] = 0;

		
//		map = new int[size][size];
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++) {
//				map[i][j] = input[i][j];
//			}
//		}
//		simul();
//		for (int r = 0; r < size; r++) {
//			for (int c = 0; c < size; c++) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();


		System.out.println(ans);			
		
	}

	static void do_rotate(int idx) {
		if(idx == rotate_num) {
			//System.out.println(Arrays.toString(rotate));

			map = new int[size][size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					map[i][j] = input[i][j];
				}
			}

			simul();


			// for(int r = 0; r < size; r++) {
			// 	for(int c = 0; c < size; c++) {
			// 		System.out.print(map[r][c] + " ");
			// 	}
			// 	System.out.println();
			// }
			// System.out.println();

//			for(int i = 0; i < size; i++) {
//				for(int j = 0; j < size; j++) {
//					ans = Math.max(ans, map[i][j]);
//
//				}
//			}





			return;
		}
		for(int i = 0; i < dr.length; i++) {
			rotate[idx] = i;
			do_rotate(idx+1);
		}



	}

	static void simul() {

		for(int i = 0; i < rotate.length; i++) {
			if(rotate[i] == 0) {

				for(int r = 0; r < size; r++) {
					ArrayList<Integer> arr = new ArrayList<>();
					int dir = rotate[i];
					int target= -1;
					
					for(int c = 0; c < size; c++) {
						if(map[r][c] == 0)
							continue;
						if(target == -1) {
							target = map[r][c];
							map[r][c] = 0;
						} else if(target == map[r][c]) {
							arr.add(map[r][c] + map[r][c]);
							map[r][c] = 0;
							target = -1;
						} else {
							arr.add(target);							
							target = map[r][c];
							map[r][c] = 0;
						}
					}
					if(target != -1) {
						arr.add(target);
					}
					

//					for(int c = 0; c < size-1; c++) {
//
//						if(map[r][c] != 0 && map[r][c+1] == map[r][c]) {
//							arr.add(map[r][c] + map[r][c]);
//							map[r][c] = 0;
//							map[r][c+1] = 0;
//						} else if(map[r][c] != 0) {
//							arr.add(map[r][c]);
//							map[r][c] = 0;
//						}
//					}
//					if(map[r][size-1] != 0) {
//						arr.add(map[r][size-1]);
//						map[r][size-1] = 0;
//					}



					if(arr.size() > 0) {
						int cnt = 0;
						for(int c = 0; c < size; c++) {
							//System.out.println("debug " + " " + arr.get(cnt) + " " + r);
							
							ans = Math.max(ans, arr.get(cnt));
							map[r][c] = arr.get(cnt);
							cnt++;
							if(cnt == arr.size())
								break;
						}
					}
				}

			} else if(rotate[i] == 1) {
				for(int c = 0; c < size; c++) {
					ArrayList<Integer> arr = new ArrayList<>();

					int dir = rotate[i];
					int target= -1;
					
					for(int r = 0; r < size; r++) {
						if(map[r][c] == 0)
							continue;
						if(target == -1) {
							target = map[r][c];
							map[r][c] = 0;
						} else if(target == map[r][c]) {
							arr.add(map[r][c] + map[r][c]);
							map[r][c] = 0;
							target = -1;
						} else {
							arr.add(target);							
							target = map[r][c];
							map[r][c] = 0;
						}
					}
					if(target != -1) {
						arr.add(target);
					}
					
//					for(int r = 0; r < size-1; r++) {
//
//						if(map[r][c] != 0 && map[r+1][c] == map[r][c]) {
//							arr.add(map[r][c] + map[r][c]);
//							map[r][c] = 0;
//							map[r+1][c] = 0;
//						} else if(map[r][c] != 0) {
//							arr.add(map[r][c]);
//							map[r][c] = 0;
//						}
//					}
//					if(map[size-1][c] != 0) {
//						arr.add(map[size-1][c] );
//						map[size-1][c] = 0;
//					}
					
//					System.out.println("start");
//					 for(int a = 0; a < size; a++) {
//						 	for(int b = 0; b < size; b++) {
//						 		System.out.print(map[a][b] + " ");
//						 	}
//						 	System.out.println();
//					  }
//					System.out.println();
//				    System.out.println("end");
				    
					
					if(arr.size() > 0) {
						int cnt = 0;
						for(int r = 0; r < size; r++) {

							ans = Math.max(ans, arr.get(cnt));
							map[r][c] = arr.get(cnt);
							cnt++;
							if(cnt == arr.size())
								break;
						}
					}
				}

			} else if(rotate[i] == 2) {
				for(int r = 0; r < size; r++) {
					ArrayList<Integer> arr = new ArrayList<>();
					int dir = rotate[i];
					int target= -1;
					
					for(int c = size-1; c >= 0; c--) {
						if(map[r][c] == 0)
							continue;
						if(target == -1) {
							target = map[r][c];
							map[r][c] = 0;
						} else if(target == map[r][c]) {
							arr.add(map[r][c] + map[r][c]);
							map[r][c] = 0;
							target = -1;
						} else {
							arr.add(target);							
							target = map[r][c];
							map[r][c] = 0;
						}
					}
					if(target != -1) {
						arr.add(target);
					}
					
//					for(int c = size-1; c >= 1; c--) {
//
//						if(map[r][c] != 0 && map[r][c-1] == map[r][c]) {
//							arr.add(map[r][c] + map[r][c]);
//							map[r][c] = 0;
//							map[r][c-1] = 0;
//						} else if(map[r][c] != 0) {
//							arr.add(map[r][c]);
//							map[r][c] = 0;
//						}
//					}
//					if(map[r][0] != 0) {
//						arr.add(map[r][0]);
//						map[r][0] = 0;
//					}



					if(arr.size() > 0) {
						int cnt = 0;
						for(int c = size-1; c >= 0; c--) {
							ans = Math.max(ans, arr.get(cnt));
							map[r][c] = arr.get(cnt);
							cnt++;
							if(cnt == arr.size())
								break;
						}
					}
				}
			} else if(rotate[i] == 3) {
				for(int c = 0; c < size; c++) {
					ArrayList<Integer> arr = new ArrayList<>();
					int dir = rotate[i];
					int target= -1;
					
					for(int r = size-1; r >= 0; r--) {
						if(map[r][c] == 0)
							continue;
						if(target == -1) {
							target = map[r][c];
							map[r][c] = 0;
						} else if(target == map[r][c]) {
							arr.add(map[r][c] + map[r][c]);
							map[r][c] = 0;
							target = -1;
						} else {
							arr.add(target);							
							target = map[r][c];
							map[r][c] = 0;
						}
					}
					if(target != -1) {
						arr.add(target);
					}
					
//					for(int r = size-1; r >= 1; r--) {
//
//						if(map[r][c] != 0 && map[r-1][c] == map[r][c]) {
//							arr.add(map[r][c] + map[r][c]);
//							map[r][c] = 0;
//							map[r-1][c] = 0;
//						} else if(map[r][c] != 0) {
//							arr.add(map[r][c]);
//							map[r][c] = 0;
//						}
//					}
//					if(map[0][c] != 0) {
//						arr.add(map[0][c]);
//						map[0][c] = 0;
//					}

					if(arr.size() > 0) {
						int cnt = 0;
						for(int r = size-1; r >= 0; r--) {
							ans = Math.max(ans, arr.get(cnt));
							map[r][c] = arr.get(cnt);
							cnt++;
							if(cnt == arr.size())
								break;
						}
					}
				}				
			}

//			System.out.println(i + "try ");
//			 for(int r = 0; r < size; r++) {
//			 	for(int c = 0; c < size; c++) {
//			 		System.out.print(map[r][c] + " ");
//			 	}
//			 	System.out.println();
//			 }
//			 System.out.println();

		}


	}


}
