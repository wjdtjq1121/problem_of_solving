#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>
#include <utility>
#include <unordered_map>
#include <iterator>

using namespace std;


bool compare(pair<int, int> left, pair<int, int> right) {
    
    if(left.first > right.first)
        return true;
    else if(left.first == right.first){
        if(left.second < right.second)
            return true;
    }
        
        
    return false;
    
}



vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    
    unordered_map<string, int> sum;
    unordered_map<string, vector<pair<int, int>>> count;
    
    for(int i=0; i < plays.size(); i++) {
        sum[genres[i]] += plays[i];
        count[genres[i]].push_back(make_pair(plays[i], i));        
    }
    
    vector<pair<int, string>> order;

    unordered_map<string, int>::iterator it;
    for(it = sum.begin(); it != sum.end(); it++) {
        order.push_back(make_pair(it->second, it->first));
    }
    sort(order.begin(), order.end());
    
    while(order.size() > 0) {
        
        pair<int, string> temp;
        temp = order.back();
        order.pop_back();
        
        vector<pair<int, int>> index = count[temp.second];
        
        sort(index.begin(), index.end(), compare);
        
        int fin = 2;
        if(index.size() < 2)
            fin = index.size();
        
        for(int i=0; i < fin; i++) {
            answer.push_back(index[i].second);
        }
        
        
        
    }
        
    
    

    return answer;
}