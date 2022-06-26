#include <iostream>
#include <algorithm>

using namespace std;

int dp[501][501];
int prefix_sum[501];

int main() {
  int num;
  int input;
  int answer;

  scanf("%d", &num);

  for(int i=1; i <= num; i++) {
    scanf("%d", &input);
    prefix_sum[i] = prefix_sum[i - 1] + input;
  }

  for (int i = 1; i < num; i++) {
    for (int row = 1; row + i <= num; row++) {
      int column = row + i;
      dp[row][column] = dp[row][row] + dp[row + 1][column] + prefix_sum[column] - prefix_sum[row - 1];
      for (int dp_index = row; dp_index < column; dp_index++) {
        dp[row][column] = min(dp[row][column], dp[row][dp_index] + dp[dp_index + 1][column] + prefix_sum[column] - prefix_sum[row - 1]);
      }
    }
  }

answer = dp[1][num];
cout << answer << endl;


 return 0; 
}