import java.io.*;
import java.util.*;
/*
4
0 2 0 15
0 0 10 4
3 0 0 0
0 0 7 0
==>
0    2    12    6    
13    0    10    4    
3    5    0    9    
10    12    7    0
*/
public class Floyedwarshall_class {
    static final int INF=987654321;//Integer.MAX_VALUE/2;
    static int N,D[][];
    
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        D=new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                D[i][j]=sc.nextInt();
                if(i!=j && D[i][j]==0) D[i][j]=INF;
            }
        }
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    //if(D[i][j]>D[i][k]+D[k][j]){
                    //   D[i][j]=D[i][k]+D[k][j];
                    //}
                    D[i][j]=Math.min(D[i][j],D[i][k]+D[k][j]);
                }
            }
        }
        for(int[] a:D) System.out.println(Arrays.toString(a));
        sc.close();
    }
}


