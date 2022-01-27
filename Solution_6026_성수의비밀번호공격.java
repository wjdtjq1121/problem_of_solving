import java.io.*;
import java.util.*;

public class Solution_6026_성수의비밀번호공격 {
//Main
	
	static long power(long x, long y, long p) {
		long res = 1L;
		x = x%p;
		
		while(y > 0) {
			if(y%2==1)
				res = (res*x)%p;
			y = y >> 1;
			x = (x*x) % p;
		}
		return res % p;
	}
	
	static long nCr(int n, int r, long p) {
		if(r == 0)
			return 1L;
		long fac[] = new long[n+1];
		fac[0] = 1;
		for(int i = 1; i <= n; i++)
			fac[i] = fac[i-1]*i%p;
		
		return (fac[n]*power(fac[r], p-2, p)%p * power(fac[n-r], p-2, p)%p)%p;
	}
	
	static long surjection(int m, int n, long p) {
		long tot = 0L;
		for(int i = 0; i < m; i++) {
			long t1 = (i%2==0) ? 1 : -1;
			long t2 = nCr(m, i, p)%p;
			long t3 = power(m-i, n, p)%p;
			tot = (tot+(t1*t2*t3)%p)%p;
		}
		return tot%p;
	}
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int P = 1_000_000_007;
			long result = surjection(M, N, P);
			System.out.println("#" + tc + " " + (result >= 0 ? result : (result+P)));			
		}
		
		sc.close();

		
	}
}
