#include <stdio.h>
#include <math.h>
# define N 52

int main(void) {

  int ans=0;

  int diskSize=7;
  int destRod=2;
  int howMany=0;
  int putNum=0;


  int original[3][N] = {0};
  int search[3][N] = {0};
  
  int stacked[N] = {0};


  scanf("%d %d", &diskSize, &destRod);

  for(int i=0;i<3;i++){
    scanf("%d", &howMany);
    for(int j=0; j<howMany;j++){
      scanf("%d", &putNum);

      original[i][diskSize-j] = putNum;
    }
  }

  for(int i=diskSize; i>0; i--){
    search[destRod-1][i] = i;
  }


  int targetDisk = 0;
  int targetDiskRod=0;
  int targetDiskNum=0;


  int rodFrom=0;
  int rodTo=0;
  int rodBy=0;

  int flag=0;
  int flagDecreasingTo=0;
  int flagDecreasingBy=0;

  int replaceNum=0;


  while(1){
    for(int i=0; i<3;i++){
      for(int j=diskSize; j>0; j--){
        if(search[i][j] == original[i][j])
          stacked[search[i][j]]=1;
      }
    }

    if(stacked[1] == 1)
      break;
    
    for(int i=diskSize; i>0; i--){
      if(stacked[i] == 0)
      {
        targetDisk=i;
        break;
      }
    }

    for(int i=0; i<3; i++){
      for(int j=diskSize; j>0; j--){
        if(original[i][j] == targetDisk){
          rodTo=i;
        }
      }
    }

    flag=0;
    for(int i=0; i<3; i++){
      for(int j=diskSize; j>0; j--){
        if(search[i][j] == targetDisk){

          if(search[i][j-1] == 0){
            flag=1;
          }
          rodFrom=i;
          targetDiskNum=j;
          targetDiskRod=i; 
        }
      }
    }
    rodBy=0;
    if(rodBy == rodFrom){
      rodBy=1;
      if(rodBy == rodTo)
        rodBy=2;
    }
    if(rodBy == rodTo){
      rodBy=1;
      if(rodBy == rodFrom)
        rodBy=2;
    }
    for(int j=diskSize; j>0; j--){
      if(search[rodTo][j] == 0){
        search[rodTo][j] = targetDisk;
        break;
      }
    }
    if(flag == 1){
      ans++;
      search[targetDiskRod][targetDiskNum] = 0;
    } else{
      ans+= (int)pow(2,targetDisk-1);
      flagDecreasingTo=0;
      flagDecreasingBy=0;
      replaceNum=targetDisk-1;
      for(int j=diskSize; j>0; j--){
        if(search[rodFrom][j] == targetDisk){
          flagDecreasingTo=1;
        }
        if(search[rodBy][j] == 0)
          flagDecreasingBy=1;
        if(flagDecreasingBy == 1 && replaceNum !=0)
        {
          search[rodBy][j]=replaceNum;
          replaceNum--;
        }
        if(flagDecreasingTo==1){
          search[rodFrom][j] = 0;
        }
      }
    }   
  }
  printf("%d", ans);
  return 0;
}



