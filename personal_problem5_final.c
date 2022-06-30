#include <stdio.h>
#define N 1000001

int adder(int arr[N][2], int index, int howMany){

  int getAdder=0;

  getAdder = arr[index][1]*howMany;

  return getAdder;
}


int main(void) {


  int function_f[4][2] = {{-3, 2}, {3, 3}, {5,6}};
  int function_g[2][2] = {4, 5};
  int f_size=3;
  int g_size=1;
  int p=1;
  int q=5;
  int answer=0;

  int flag_f_over_qvalue=0;
  int flag_g_over_qvalue=0;
  int flag_ending=0;

  int target_function=0;


  int going_f_index=0;
  int going_g_index=0;

  if(function_f[0][0] > function_g[0][0])
    target_function=1;

  while(1){

    if(going_f_index == f_size)
      flag_f_over_qvalue=1;
    if(going_g_index == g_size)
      flag_g_over_qvalue=1;




      










    break;
  }

  // answer += adder(function_f,1,3);
  printf("answer: %d\n", answer);




  return 0;
}



  // for(int i=0;i<f_size;i++){
  //   for(int j=0;j<2;j++){
  //     printf("%d ", function_f[i][j]);
  //   }
  //   printf("\n");
  // }

  // for(int i=0;i<g_size;i++){
  //   for(int j=0;j<2;j++){
  //     printf("%d ", function_g[i][j]);
  //   }
  //   printf("\n");
  // }