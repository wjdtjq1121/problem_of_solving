#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> prices) {
       
    vector<int> answer(prices.size(), 0);
    int i, j;

    for(i=0; i < prices.size(); i++) {
        
        for(j=i+1; j < prices.size(); j++) {
            if(prices[i] > prices[j] || j == prices.size()-1) {
                answer[i] = j - i;
                break;
            }
            
        }

    }

    
    return answer;
}