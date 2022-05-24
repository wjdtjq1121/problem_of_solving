#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int check[10];

string solution(string number, int k) {
    string answer = "";
    
    int sub = k - 1;
    int max;
    int max_index=0;
    
    
    
    for(int i=0; i < number.length(); i++) {
        max = 0;
        for(int j=0; j < number.length() - sub; j++) {
            if(check[j] == 0 && stoi(number[j]) >= 0) {
                
                max = stoi(number[j]);
                max_index = j;
                
            }
        }
        check[max_index] = 1;
        sub++;
        answer += number[max_index];
    }
    

    
    
    
    return answer;
}