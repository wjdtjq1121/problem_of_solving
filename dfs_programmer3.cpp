#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int answer = 100;
string tar;

bool check[51];

void dfs(string begin, vector<string> words, int result) {
    
    if(begin == tar){
        answer = min(answer, result);
        return;
    }
    
    int count = 0;
    
    for(int i=0; i < words.size(); i++) {
        count = 0;
        for(int j=0; j < words[i].size(); j++) {
            
            if(begin[j] != words[i][j]) count++;
            if(count == 2) break;
            
        }
        if(count == 1) {
            
            if(check[i] == false) {
                check[i] == true;
                
                dfs(words[i], words, result + 1);
                
                check[i] == false;
                
                
            }        
        }
        
    }
        
    
}




int solution(string begin, string target, vector<string> words) {
    //int answer = 0;
    
    tar = target;
    
    dfs(begin, words, 0);
    
    if(answer = 100)
        answer = 0;
    

    return answer;
}