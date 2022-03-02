import java.io.*;
import java.util.*;

public class Main_jo_1828_냉장고_서울_12반_한정섭 {
//Main
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		ArrayList<chem> arr = new ArrayList<>();
		
		
		chem[] che = new chem[T];
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
//			arr.add(new chem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			che[i] = new chem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(che);
		
//		for(int i = 0; i < T; i++) {
//			System.out.println(che[i].low + " " + che[i].high);
//		}
		
//		Arrays.sort(arr);
//
//		for(int i = 0; i < T; i++) {
//			System.out.println(arr.get(i).low + " " + arr.get(i).high);
//		}

		int end = che[0].high;
		int ans = 1;
		for(int i = 1; i < T; i++) {
			
			if(end < che[i].low) {
				end = che[i].high;
				ans++;
			}
			
			
		}

		
		System.out.println(ans);
		
		//System.out.println("success");
	}
	
//	static ArrayList<chem> getSchedule(chem[] che) {
//		ArrayList<chem> list = new ArrayList<chem>();
//		
//		Arrays.sort(che);
		
//		for(int i = 0; i < )
//		list.add(che[0]);		
//		for(int i = 1, size = che.length; i < size; i++) {
//			if(list.get(index))
//		}
		
//	}
	
	
	static class chem implements Comparable<chem>{
		int low;
		int high;
		chem(int low, int high) {
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(chem o) {
			
			if(this.high == o.high)
				return Integer.compare(this.low, o.low);
			
			return Integer.compare(this.high, o.high);


		}
	}
}
