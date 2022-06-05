#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

int max_p(vector<int> &des, int find) {
    
    while((find != 1) && des[find] == 0) {            
        find--;
    }   
    return find;
}


int solution(vector<int> priorities, int location) {
    int answer = 0;
    int size = priorities.size();
    int search=9;
    queue<int> q;
    
    vector<int> des(11, 0);
        
    for(int i=0; i < size; i++) {
        des[priorities[i]]++;
        q.push(i);
    }
    
    
    search = max_p(des, 10);
    
    int printed=0;
    int not_print=0;
    int count=0;
    int flag = 0;
    
    while(true) {
        

        if(priorities[q.front()] == search ) {
            

            if(q.front() == location){
                answer = printed+1;
                break;
            }
                
            
            q.pop();
            printed++;
            
            des[search]--;
            search = max_p(des, search);
            
  
        } else {
            not_print = q.front();
            q.pop();
            q.push(not_print);            
        }
    }
    
    
    
    
    return answer;
}