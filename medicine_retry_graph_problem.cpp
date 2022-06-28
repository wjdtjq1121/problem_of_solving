#include <iostream>
#include <vector>
#include <cstring>


using namespace std;

int par[10001], diff[10001];

int find(int u){
  if(par[u] == u)
    return u;
  return par[u] = find(par[u]);
}
int merge(int u, int v){
  if(u == -1 || v == -1)
    return max(u, v);
  u = find(u), v = find(v);
  par[u] = v;
  return v;
}
int main() {

  int n, m, u, v, x, y, ans = 0;
  scanf("%d %d", &n, &m);

  for(int i=1; i <= n; i++)
    par[i] = i;
  memset(diff, -1, sizeof(diff));

//par 은 1 2 3 4 
//diff은 -1 -1 -1 -1
  for(int i = 1; i <= m; i++) {
    scanf("%d %d", &u, &v);
    if(!ans) {
      u = find(u);
      v = find(v);
      if (u == v)
        ans= i;

      printf("i is: %d u is : %d v is %d \n", i, u, v);

      x = merge(u, diff[v]);
      y = merge(v, diff[u]);

      printf("i is: %d x is : %d y is %d \n", i, x, y);

      diff[x] = y;
      diff[y] = x;
      
      cout << "middle check : \n";
      for(int p=1; p<n+1; p++){
        cout << par[p] << " ";
      }
      cout << endl;
      for(int p=1; p<n+1; p++){
        cout << diff[p] << " ";
      }
      cout << endl << endl;

    }
  }



  printf("%d", ans);
  cout << endl;
}