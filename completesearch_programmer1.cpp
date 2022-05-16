#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    vector<int> n(3, 0);
    
    int n1=0;
    int n2=0;
    int n3=0;

    
    for(int i=0; i < answers.size(); i++) {
        
        
        if((i+1) % 5 == 0) {
            if(answers[i] == 5)
                n[0]++;
        }else {
            if(answers[i] == (i+1) % 5)
                n[0]++;
        }
        
        if((i+1) % 2 == 1){
            if(answers[i] == 2)
                n[1]++;
        } else {
            if(n2 == 0){
                if(answers[i] == 1)
                    n[1]++;
            } else if(n2 == 1){
                if(answers[i] == 3)
                    n[1]++;
            } else if(n2 == 2){
                if(answers[i] == 4)
                    n[1]++;
            } else if(n2 == 3){
                if(answers[i] == 5)
                    n[1]++;
                n2 = 0;
            } 
            n2++;
        }
        
        
        if(i % 10 == 0 || i % 10 == 1) {
            if(answers[i] == 3)
                n[2]++;
        } else if(i % 10 == 2 || i % 10 == 3) {
            if(answers[i] == 1)
                n[2]++;
        } else if(i % 10 == 4 || i % 10 == 5) {
            if(answers[i] == 2)
                n[2]++;
        } else if(i % 10 == 6 || i % 10 == 7) {
            if(answers[i] == 4)
                n[2]++;
        } else if(i % 10 == 8 || i % 10 == 9) {
            if(answers[i] == 5)
                n[2]++;
        } 
     
    }
    
    vector<int> cp;
    cp = n;
    
    sort(cp.begin(), cp.end());
    for(int i=0; i < n.size(); i++) 
        cout << cp[i] << " ";

    if(cp[2] != cp[1]) {
        for(int i=0; i < n.size(); i++) 
            if(cp[2] == n[i])
                answer.push_back(i+1);
    } else if(cp[1] != cp[0]) {
        for(int i=0; i < n.size(); i++) 
            if(cp[1] == n[i])
                answer.push_back(i+1);
        
    } else{
        answer.push_back(1);
        answer.push_back(2);
        answer.push_back(3);
    }
    

    
    
    
    
    return answer;
}