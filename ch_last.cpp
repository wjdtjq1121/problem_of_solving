using namespace std;

#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

class StringAnagrams {
 public:
  static vector<int> findStringAnagrams(const string &str, const string &pattern) {
    vector<int> resultIndices;
    // TODO: Write your code here

    int s = 0, matched = 0;
    unordered_map<char, int> m;

    for(auto letter: pattern)
      m[letter]++;
    
    for(int e = 0; e < str.length(); e++) {
      char r = str[e];

      if(m.find(r) != m.end()) {
        m[r]--;

        if(m[r] == 0)
          matched++;
      }
      if(matched == (int)pattern.length()) 
        resultIndices.push_back(s);
      
      if(e >= (int)pattern.length() - 1) {
        char l = str[s++];

        if(m.find(l) != m.end()) {

          if(m[l] == 0)
            matched--;


          m[l]++;

        }

      }




    }

  







    return resultIndices;
  }
};
