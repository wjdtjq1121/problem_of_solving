#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for(vector<int> com: commands) {
        vector<int> arr;
        
        for(int i = com[0] - 1; i < com[1]; i++) {
            arr.push_back(array[i]);
        }
        sort(arr.begin(), arr.end());
        

        answer.push_back(arr[com[2] - 1]);

    }
    
    
    return answer;
}