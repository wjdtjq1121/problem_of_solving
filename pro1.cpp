using namespace std;

#include <iostream>
#include <vector>

class PairWithTargetSum {
 public:
  static pair<int, int> search(const vector<int>& arr, int targetSum) {
   

    int start = 0, end = arr.size() - 1;

    while(start < end) {
      int sum = arr[start] + arr[end];

      if(sum == targetSum)
        break;
      else if(sum > targetSum)
        end--;
      else
        start++;
    }
      

    


    return make_pair(start, end);
  }
};
