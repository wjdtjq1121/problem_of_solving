#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    int size = speeds.size();
    vector<int> cap;
    int sup;
    
    for(int i=0; i < size; i++) {
        sup = (100 - progresses[i]) % speeds[i];
        if(sup % speeds[i] == 0)
            cap.push_back((100 - progresses[i]) / speeds[i]);
        else
            cap.push_back((100 - progresses[i]) / speeds[i] + 1);
    }
    
    int index_size = 0;
    sup = cap[0];

    for(int i=0; i < size; i++) {
        
        if(sup < cap[i]) {
            answer.push_back(index_size);
            index_size = 1;
            sup = cap[i];
            
        } else {
            index_size++;
        }
        if(i == size-1) {
            answer.push_back(index_size);
        }
    
        
    }
    
    

    return answer;
}