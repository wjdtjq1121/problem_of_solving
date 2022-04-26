 public:
  static void sort(vector<int> &arr) {

    int low = 0, high = arr.size() - 1;
    for (int i = 0; i <= high;) {
      if (arr[i] == 0) {
        swap(arr, i, low);
        i++;
        low++;
      } else if (arr[i] == 1) {
        i++;
      } else {  // the case for arr[i] == 2
        swap(arr, i, high);
        // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
        high--;
      }
    }




    
  }