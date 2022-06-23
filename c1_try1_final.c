#include <stdio.h>

int main(void) {

  int num, k, f;
  int tempa, tempb;
  int count=0;
  int maxCount=0;
  int changeArray = 0;
  int countLess = 0;

  scanf("%d %d %d", &num, &k, &f);

  int arrFriend[num][num];
  int arrCountLess[num];

// 배열 초기화
  for(int i=0; i<num; i++)
  {
    for(int j=0; j<num; j++)
    {
      arrFriend[i][j] = 0;
    }
    arrCountLess[i] = 0;
  }

// 인적한 배열값 넣기
   for(int i=0; i<f; i++)
  {
    
    scanf("%d %d", &tempa, &tempb);
    arrFriend[tempa-1][tempb-1] = 1;
    arrFriend[tempb-1][tempa-1] = 1;
 
//    printf("tmpea and tempb value: %d %d\n", tempa, tempb);

  }


// add countless arr and valuecount

  for(int i=0; i<num; i++)
  {
    count =0;
    for(int j=0; j<num; j++)
    {
      if(arrFriend[i][j] == 1)
        count++; 
    }
    if(count < k)
    {
      arrCountLess[countLess] = i;
      countLess++;
    }
  }

//erase what it needs 
  for(int i=0; i<countLess; i++)
  {
    for(int erase=0; erase<num; erase++)
    {
      arrFriend[arrCountLess[i]][erase] = 0;
      arrFriend[erase][arrCountLess[i]] = 0;        
    }
  }

// debugging
  // printf("size of countless: %d \n", countLess);
  // for(int i=0; i<countLess; i++)
  // {
  //   printf("array num: %d \n", arrCountLess[i]);
  // }

//count maxthingy
  for(int i=0; i<num; i++)
  {
    count = 0;
    for(int j=0; j<num; j++)
    {
      if(arrFriend[i][j] == 1)
        count++; 
    }
    if(count > 0)
    {
      maxCount++;
    }
  }




// 최종 배열값 상태 확인
  // for(int i=0; i<num; i++)
  // {
  //   for(int j=0; j<num; j++)
  //   {
  //     //printf("%d %d = %d \n", i, j, arrFriend[i][j]);
  //     printf("%d ", arrFriend[i][j]);
  //   }
  //   printf("\n");
  // }

  if(maxCount <= k)
    maxCount = 0;
  
  printf("%d \n", maxCount);

  
  return 0;
}