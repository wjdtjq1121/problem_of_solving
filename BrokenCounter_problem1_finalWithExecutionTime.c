#include <stdio.h>
#include <time.h>

int main(void) {

  clock_t start, end;
    
  double cpu_time_used;
  int input = 0;
  int resultCount = 0;
  int multiplier = 1;
  int tenMultiplier = 10;
  int modValue = 0;


     
     
     
  start = clock();


  scanf("%d", &input);

  resultCount = input;
  modValue = input%10;

  if(modValue > 4)
    resultCount--;

  input = input / 10;
  modValue = input%10;
  
  while(input !=0)
  {
    if(modValue > 4)
    {  
      resultCount-=(modValue)*multiplier;
      resultCount+=multiplier;
      resultCount-=tenMultiplier;
    } else{
      resultCount-=(modValue)*multiplier;
    }
    input = input / 10;
    modValue = input%10;
    multiplier = 9*multiplier + tenMultiplier;
    tenMultiplier = tenMultiplier * 10;
  }
  printf("%d\n", resultCount);

  end = clock();
  cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
  printf("time used: %f", cpu_time_used);

  return 0;
}