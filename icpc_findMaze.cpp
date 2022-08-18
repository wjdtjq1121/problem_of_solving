#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

#define N 1002


void calculateMap(int map[N][N],int sol[N][N], int min[1],int exist[1],int answer[1], int x, int y, int sizeX, int sizeY, int count){

  
  if(x > 0 && y > 0 && x<sizeX+1 && y<sizeY+1 && map[x][y] != -1){

    answer[0]+=map[x][y];
    path[x][y] = -1;


    if(x == sizeX && y == sizeY){
      if(count == 1)
        min[0] = answer[0];
      if(min[0] < answer[0])
        min[0] = answer[0];
      count++;
    }

    if(x+1 <= sizeX){
      calculateMap(map, sol, min, exist, answer, x+1, y, sizeX, sizeY, count);

    }
    if(y+1 <= sizeY){
      calculateMap(map, sol, min, exist, answer, x, y+1, sizeX, sizeY, count);

    }
    if(x-1 > 0){

      calculateMap(map, sol, min, exist, answer, x-1, y, sizeX, sizeY, count);

    }
    if(y-1 > 0){
      calculateMap(map, sol, min, exist, answer, x, y-1, sizeX, sizeY, count);

    }

    answer-=map[x][y];
  }

  exist[0] = 5;
  return;

}


int main() {

  
  int answer[1] = {0};
  int exist[1] = {0};
  int min[1] = {0};
  int count=1;


  int map[N][N] = {0};
  int sol[N][N] = {0};
  int mapX, mapY, putNum;

  scanf("%d %d", &mapX, &mapY);



  for(int i=1;i<=mapX; i++){
    for(int j=1; j<=mapY; j++){
      scanf("%d", &putNum);
      map[i][j] = putNum;
    }
  }

  
  calculateMap(map, sol, min, exist, answer, 1, 1, mapX, mapY, count);





  // for(int i=1;i<=mapX; i++){
  //   for(int j=1; j<=mapY; j++){
  //     printf("%d ", map[i][j]);
  //   }
  //   printf("\n");
  // }
  // for(int i=1;i<=mapX; i++){
  //   for(int j=1; j<=mapY; j++){
  //     printf("%d ", sol[i][j]);
  //   }
  //       printf("\n");

  // }


//  printf("\n");
printf("answer %d\n", answer[0]);
printf("min %d\n", min[0]);

}