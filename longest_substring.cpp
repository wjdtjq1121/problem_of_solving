using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>

class CharacterReplacement {
 public:
  static int findLength(const string& str, int k) {
    int maxLength = 0;
    // TODO: Write your code here

    int s = 0;
    unordered_map<char, int> m;
    int max_repeat = 0;

    for(int e = 0; e < str.length(); e++) {

      char r = str[e];
      m[r]++;
      max_repeat = max(max_repeat, m[r]);

      if(e - s + 1 - max_repeat > k) {

        char l = str[s];
        m[s]--;
        s++;

      }

      maxLength = max(maxLength, e - s + 1);

      
    }






    return maxLength;
  }
};
