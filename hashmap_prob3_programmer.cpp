#include <string>
#include <vector>
#include <map>
#include <utility>
#include <iostream>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 0;
    
    unordered_map<string, int> m;
    
    for(vector<string> clo: clothes) {
        m[clo[1]]++;
    }

    answer = 1;
    
    unordered_map<string, int>::iterator it;

    
    for(it = m.begin(); it != m.end(); it++) {
        answer *= it->second + 1;
    }
    answer-=1;

    

    
    return answer;
}