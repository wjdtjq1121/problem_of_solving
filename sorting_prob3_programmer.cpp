#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    
    int total_weight=0;
    int front_truck=0;
    int pass_truck=0;
    int time=0;
    queue<int> q;
    int size = truck_weights.size();
    
    while(front_truck != truck_weights.size()){
        
        if(!q.empty() && (time - q.front() == bridge_length)) {
            total_weight-=truck_weights[front_truck];
            front_truck++;
            q.pop();
        }
        
        if(pass_truck != size && truck_weights[pass_truck] + total_weight <= weight) {
            total_weight += truck_weights[pass_truck];
            pass_truck++;
            q.push(time);

        }
        time++;
        
    }
    
    answer = time;

    
    
    
    
    
    
    return answer;
}
