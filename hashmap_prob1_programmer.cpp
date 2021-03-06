#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    
    unordered_map<string, int> m;
    
    
    for(string name: participant) {
        m[name]++;
    }
     
    for(string name: completion) {
        m[name]--;
    }
    
    
    for(auto pair: m) {
        if(pair.second > 0)
            answer = pair.first;
    }
    
    
    

    

    
    
    return answer;
}