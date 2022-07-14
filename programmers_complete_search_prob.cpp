#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <set>
#define MAX 9999999999
using namespace std;

int isPrime(int num) {
    
    if(num == 1)
        return 0;
    if(num == 2)
        return 1;
    if(num % 2 == 0)
        return 0;
    
    for(int i=2; i <= sqrt(num); i++) {
        if(num % i == 0)
            return 0;
    }
    return 1;
}

bool compare(char a, char b) {
    return a > b;
}

int solution(string numbers) {
    int answer = 0;
    
    string s;
    s = numbers;
    sort(s.begin(), s.end(), compare);
    //cout << s;
    
    vector<int> storage(stoi(s) + 1);
    storage[0] = 0;
    for(int i=1; i <= storage.size(); i++) {
        storage[i] = isPrime(i);
        //cout << storage[i] << " ";    
    }
    
    string show, sub;
    show = numbers;
    sort(show.begin(), show.end());
    set<int> fin;
    
    do {
        for(int i=1; i <= show.size(); i++) {
            
            sub = show.substr(0, i);
            if(storage[stoi(sub)]) {
                fin.insert(stoi(sub));
            }
        }
        
    } while(next_permutation(show.begin(), show.end()));
    
    
    answer = fin.size();
    
    cout << answer;
    


    return answer;
}