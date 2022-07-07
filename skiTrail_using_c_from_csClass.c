#include <stdio.h> 
  
// Maze size 
#define N 501

  
bool solveMazeUtil( 
    int maze[N][N], int path[N][N], int x, 
    int y, int result[1], int track, int size); 
  

void printSolution(int sol[N][N]) 
{ 
    for (int i = 0; i < N; i++) { 
        for (int j = 0; j < N; j++) 
            printf(" %d ", sol[i][j]); 
        printf("\n"); 
    } 
} 
  


bool solveMaze(int maze[N][N], int size) 
{ 
    // int x, y;
    // x = 0;
    // y = 2;

    // int sol[N][N] = { { 1, 6, 10, 3 }, 
    //                    { 5, 5, 6, 1 }, 
    //                    { 5, 7, 2, 3 }, 
    //                    { 11, 5, 7, 4 } };

    // int sol[N][N] = { { 10, 0, 0, 0 }, 
    //                    { 0, 0, 0, 0 }, 
    //                    { 0, 0, 0, 0 },
    //                    { 0, 0, 0, 0 } }; 

    //int solution = maze[x][y];

    int path[N][N];



    int result[N] = {0};
    
    int maxOutput=0;



    for(int i=0; i < size; i++)
    {
      for(int j=0; j < size; j++)
      {
        for(int i=0; i < size; i++)
        {
          for(int j=0; j < size; j++)
          {
            path[i][j] = 0;
          }
        }
        
        path[i][j] = 1;

        result[0] = maze[i][j];
        int track= maze[i][j];
        if (solveMazeUtil(maze, path, i, j, result, track, size) == false)
        { 
        printf("Solution doesn't exist"); 
        return false; 
        } 
        // printf("%d th result value: %d\n", i*j+1, result[0]);
        // printf("%d th result value: %d\n", i*j+1, maze[i][j] - result[0]);

        if(maze[i][j] - result[0]> maxOutput)
          maxOutput = maze[i][j] - result[0];
          
      }
      //printf("\n");
    }

    //printf("maxoutput: %d \n", maxOutput);
    printf("%d \n", maxOutput);

    //printSolution(sol);


    return true; 
} 



bool solveMazeUtil( 
    int maze[N][N], int path[N][N], int x, 
    int y, int result[N], int track, int size) 
{
  //printf("x: %d y: %d maze[x][y]: %d result: %d track: %d\n", x, y, maze[x][y], result[x], track);


  if(x<0 || y<0 || x>=size || y>=size)
    return true; 

  //east side
  if (y+1 < size && maze[x][y] > maze[x][y+1] && path[x][y+1] == 0)
  {

    path[x][y+1] = 1;

    track = maze[x][y+1];
    if(track < result[0])
      result[0] = track;

    solveMazeUtil(maze, path, x, y+1, result, track, size); 
  } 
    //south side
  if (x+1 < size && maze[x][y] > maze[x+1][y] && path[x+1][y] == 0)
  {
    path[x+1][y] = 1;

    track = maze[x+1][y];
    if(track < result[0])
      result[0] = track;

    solveMazeUtil(maze, path, x + 1, y, result, track, size); 
  }
    //west side
  if (y-1 >= 0 && maze[x][y] > maze[x][y-1] && path[x][y-1] == 0)
  {
    path[x][y-1] = 1;

    track = maze[x][y-1];
    if(track < result[0])
      result[0] = track;

    solveMazeUtil(maze, path, x, y-1, result, track, size); 
  }
    //north side
  if (x-1 >= 0 && maze[x][y] > maze[x-1][y] && path[x-1][y] == 0)
  {
    path[x-1][y] = 1;

    track = maze[x-1][y];
    if(track < result[0])
      result[0] = track;

    solveMazeUtil(maze, path, x - 1, y, result, track, size); 
  }
    
  return true;
} 
  
// driver program to test above function 
int main() 
{ 
    //int N=5;
    int track[N][N] = { { 1, 6, 10, 3 }, 
                       { 5, 5, 6, 1 }, 
                       { 5, 7, 2, 3 }, 
                       { 11, 5, 7, 4 } }; 

    // int maze[N][N] = { { 1, 6, 10, 3 }, 
    //                    { 5, 5, 6, 1 }, 
    //                    { 5, 7, 2, 3 }, 
    //                    { 11, 5, 7, 4 } };


 
  int num;

  int putNum;

  scanf("%d", &num);

 
  int maze[N][N];
 
   for(int i=0; i<num; i++)
  {
    for(int j=0; j<num; j++)
    {
      scanf("%d", &putNum);
      maze[i][j] = putNum;
   
    }

  }

    
    solveMaze(maze, num); 
    return 0; 
} 