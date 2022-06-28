#include <iostream>
#include <vector>
#include <map>
#include <utility>

#define N 50000

using namespace std;

int parent[N+1] = {0};
int opposite[N+1] = {0};
int height[N+1] = {0};
int gro[N+1] = {0};

int find(int u){
  if(parent[u] == u)
    return u;
  return parent[u] = find(parent[u]);
}
void unify(int u, int v){
  if(u==0 || v==0)
    return;
  
  u = find(u), v = find(v);
  if (height[u] > height[v]) {
    parent[v] = u;
    return;
  }
  if (height[u] == height[v]) {
    height[v]++;
  }
  parent[u] = v;
  return;
}

int main() 
{ 
    int num;
    scanf("%d", &num);

    for(int i=1; i <= num; i++)
        parent[i] = i;

    vector<pair<int, int> > P(N+1);
    map<pair<int, int>, int> MAP;

    for(int i=1; i <= num; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
        
        pair<int, int> P_i = make_pair(x,y);

        P[i] = P_i;
        MAP[P_i] = i;
    }

    for(int i=1; i <= num; i++) {
        for(int j=-5; j <= 5; j++) {
            for(int k=0; k <= 5; k++) {
                int distance = j*j + k*k;
                if (distance > 25 || distance == 0)
                    continue;

                pair<int, int> P_i = make_pair(P[i].first + j, P[i].second + k);
                if(MAP.find(P_i) == MAP.end()){
                    continue;
                }
                int u = find(i);
                int v = find(MAP[P_i]);
                
                if(u == v) {
                    cout << 0;
                    return 0;
                }
                unify(u, opposite[v]);
                unify(v, opposite[u]);

                u = find(u);
                v = find(v);

                opposite[u] = v;
                opposite[v] = u;
            }
        }
    }
    
    for(int i=1; i <= num; i++){
        gro[find(i)]++;
    }    

    int ans = 0 ;

    for(int i=1; i <= num; i++){
        if(gro[i] != 0){
            int j = opposite[i];
            ans += min(gro[i], gro[j]);

            gro[i] = 0;
            gro[j] = 0;
        }
    }

    cout << ans;
    return 0; 
}