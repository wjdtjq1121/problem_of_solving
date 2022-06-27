#include <iostream>
#include <vector>

using namespace  std;

typedef struct _point{
  int x;
  long long y;
} point;

int main() {

  int _f, _g;

  scanf("%d", &_f);
  vector<point> f (++(++_f));
  f[0].x = INT_MIN;
  f[0].y = 0;
  for(int k=1; k<_f-1; k++)
    scanf("%d %lld", &f[k].x, &f[k].y);
  f[_f-1].x = INT_MAX;
  f[_f-1].y = f[_f-2].y;

// _f is 5
//  cout << " _f value: " << _f << endl;  

  scanf("%d", &_g);
  vector<point> g (++(++_g));
  g[0].x = INT_MIN;
  g[0].y = 0;
  for(int k=1; k<_g-1; k++)
    scanf("%d %lld", &g[k].x, &g[k].y);
  g[_g-1].x = INT_MAX;
  g[_g-1].y = g[_g-2].y;

  int p, q;
  scanf("%d %d", &p, &q);

  // for(int i=0; i<5; i++) {
  //   cout << f[i].x << " " << f[i].y << " | ";
  // }
  // cout << endl;
  // for(int i=0; i<5; i++) {
  //   cout << g[i].x << " " << g[i].y << " | ";
  // }
  // cout << endl;

  int i=0, j=0;
  while(i+1 < _f && f[i+1].x < p) i++;
  while(j+1 < _g && g[j+1].x < p) j++;
  
  cout << "initial i and j value: " << i << " " << j << endl;

  long long result = 0;
  int from = p;
  while(from <= q){

      int to;
      long long fValue = f[i].y, gValue = g[j].y;
      if( ( f[(i+1 < _f) ? i+1 : i].x) < (g[(j+1 < _g) ? j+1 : j].x ) )
        to = ( f[(i + 1 < _f) ? ++i : i].x) - 1;
      else
        to = ( g[(j+1 < _g) ? ++j : j].x ) - 1;
      cout << " i and j value to value: " << i << " " << j << " " << to << endl;

      result += ( ( ((to > q) ? q : to) - from + 1) * max(fValue, gValue));
      from = to+1;
  }

  cout << "debug i j" << i << " " << j << endl;

  printf("%lld\n", result % 10007);

}