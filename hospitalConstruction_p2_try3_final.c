#include <stdio.h>

void qSort(int arr[][2], int l, int r)
{
    int tempa, tempb;

    if (l >= r)
    {
        return;
    }
    

    int pivot = arr[r][1];

    int cnt = l;


    for (int i = l; i <= r; i++)
    {

        if (arr[i][1] <= pivot)
        {


            tempa = arr[cnt][0];
            tempb = arr[cnt][1];

            arr[cnt][0] = arr[i][0];
            arr[cnt][1] = arr[i][1];

            arr[i][0] = tempa;
            arr[i][1] = tempb;


            cnt++;
        }
    }

  // printf("debug \n");
  // for(int i=0; i<4; i++){
  //   printf("%d %d\n", arr[i][0], arr[i][1]);
  // }
    

    qSort(arr, l, cnt-2); 
    
    qSort(arr, cnt, r);  
    
}



int main(void) {


  int tempa, tempb;  
  int i,j;
  int maxCount=0;
  int result=0;
  int tempCount=0;
  int left_index=0;
  int right_index=1;

 
  int numBuilding, walkingDistance;

  int getPeople, getDistnace;

  scanf("%d %d", &numBuilding, &walkingDistance);



 
  int BuildingArray[numBuilding][2];
 
   for(int i=0; i<numBuilding; i++)
  {
    
    scanf("%d %d", &getPeople, &getDistnace);
    BuildingArray[i][0] = getPeople;
    BuildingArray[i][1] = getDistnace;
  }



    

  qSort(BuildingArray, 0, numBuilding-1);
//    temp(BuildingArray);

  // printf("final   debug \n");
  // for(int i=0; i<numBuilding; i++){
  //   printf("%d %d\n", BuildingArray[i][0], BuildingArray[i][1]);
  // }



  // for(int i=0; i<numBuilding; i++)
  // {

  //   maxCount=0;
  //   tempCount=i;

  //   while(BuildingArray[tempCount][1] < BuildingArray[i][1]+walkingDistance*2+1 && tempCount < numBuilding)
  //   {
  //     maxCount+=BuildingArray[tempCount][0];
  //     tempCount++;

  //     // printf("array: %d tempcount: %d \n", BuildingArray[tempCount][1], tempCount);
  //     // printf(":: %d \n", BuildingArray[i][1]+walkingDistance*2+1);
  //   }

  //   //printf("i: %d, maxCount: %d \n", i, maxCount);

  //   if(maxCount > result)
  //     result = maxCount;
  // }
  if(numBuilding >= 1)
  {
    result = BuildingArray[0][0];
    maxCount = result;
  }

 
  while(numBuilding!=1)
  {
    if (left_index == right_index) {
      maxCount+=BuildingArray[left_index][0];
      right_index++;
    }
    
    if(maxCount > result)
      result = maxCount;
    
    if(right_index>numBuilding-1)
      break;
    
    if(BuildingArray[right_index][1]-BuildingArray[left_index][1] <= walkingDistance*2)
    {
      maxCount+=BuildingArray[right_index][0]; 
      right_index++;
    } else{
      maxCount-=BuildingArray[left_index][0];
      left_index++;
    }

    //printf("left: %d right: %d max: %d\n", left_index, right_index, maxCount);


  }


  
  printf("%d \n", result);




  // printf("hello\n");


  return 0;
}