#include <stdio.h>

int summa(int n)
{
  if(n==0)
    return 0;
  else if(n==1)
    return 1;
  else if(n==2)
    return 1;
  else if(n==3)
    return 2;
  else if(n==4)
    return 3;
  else if(n==5)
    return 6;
  else if(n>5)
    return summa(n-1) + summa(n-3) + summa(n-4);
}
int main(void) {
  
  int result, n;

  scanf("%d", &n);

  result = summa(n);

  printf("answer: %d\n", result);



  return 0;
}