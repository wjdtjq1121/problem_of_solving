





using namespace std;



#include <iostream>

#include <string>

#include <unordered_map>

#include <algorithm>



class StringPermutation {

 public:

  static bool findPermutation(const string &str, const string &pattern) {

​    

​    unordered_map<char, int> m;

​    int s = 0;

​    int match = 0;



​    for(auto letter: pattern){

​      m[letter]++;

​    }



//    cout << "map size: " << m.size() << endl;

 

​    for(int e = 0; e < str.length(); e++) {

​      char r = str[e];





​      if(m.find(r) != m.end()) {

​        m[r]--;



​        if(m[r] == 0){         

​          match++;

​        }

​      }



​      if(match == (int)pattern.size()){

​        return true;

​      }

​      

​      if(e >= pattern.length() - 1) {

​        char l = str[s++];



​        if(m.find(l) != m.end()) {

​          if(m[l] == 0)

​            match--;

          m[l]++;
​        }

​        
​      }

​    }

​    return false;

  }

};