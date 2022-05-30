#include <string>
#include <vector>
#include <set>
#include <iterator>

using namespace std;

vector<int> solution(vector<string> arguments) {
    vector<int> answer;
    
    multiset<int> s;
    multiset<int>::iterator it;
    string judge;
    
    for(string input: arguments) {
        judge = input.substr(0, 2);
        
        if(judge == "I ") {
            s.insert(stoi(input.substr(2, input.length()-2)));
        } else if(input.substr(2, 1) == "1" && s.size() > 0) {
            s.erase(--s.end());
        } else if(s.size() > 0) {
            s.erase(s.begin());
        }
    }
    
    if(s.size() == 0){
        answer.push_back(0);
        answer.push_back(0);
    } else{
        it = --s.end();
        answer.push_back(*it);
        it = s.begin();
        answer.push_back(*it);

        
    }
        
    
    

    

    return answer;
}