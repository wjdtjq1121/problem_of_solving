#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
#define N 100001

void qSort(int arr[N], int l, int r)
{
    int tempa;
    if (l >= r)
    {
        return;
    }
    int pivot = arr[r];
    int cnt = l;
    for (int i = l; i <= r; i++)
    {
        if (arr[i] <= pivot)
        {
            tempa = arr[cnt];
            arr[cnt] = arr[i];
            arr[i] = tempa;
            cnt++;
        }
    }
    qSort(arr, l, cnt-2); 
    qSort(arr, cnt, r);      
}

int main() {

  int putNum=0;
  int count=0;
  
  int leftCounter=0;
  int rightCounter=0;
  int carrier=0;
  
  int M=0; 
  int bag[N] = {0};
  scanf("%d", &M);

  while(cin >> putNum)
  {
    bag[count] = putNum;
    count++;
  }
  qSort(bag, 0, count-1);
  rightCounter=count-1;

  while(leftCounter <= rightCounter)
  {
      if(bag[rightCounter] > M)
      {
        rightCounter--;
      }
      else if(bag[rightCounter]==M)
      {
        rightCounter--;
        carrier++;
      }
      else if(bag[rightCounter] + bag[leftCounter] <= M)
      {
        rightCounter--;
        leftCounter++;
        carrier++;
      } else{
        rightCounter--;
        carrier++;
      }
  }
  printf("%d\n", carrier);
}