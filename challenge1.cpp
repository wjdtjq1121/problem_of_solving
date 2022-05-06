using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>
#include <algorithm>

class StringPermutation {
 public:
  static bool findPermutation(const string &str, const string &pattern) {

    int window_start = 0;
    unordered_map<char, int> m;

    unordered_map<char, int> cp;

    for(int i = 0; i < pattern.length(); i++)
      m[pattern[i]]++;

    cp = m;
    
    for(int window_end = 0; window_end < str.length(); window_end++) {
      char right_char = str[window_end];

      if(m.find(right_char) != m.end()) {
        m[right_char]--;
        if(m[right_char] == 0)
          m.erase(right_char);        
        if(m.empty())
          return true;
      } else {
        window_start = window_end + 1;
        m.clear();
        m = cp;



      }
    }

    return false;
  }
};
