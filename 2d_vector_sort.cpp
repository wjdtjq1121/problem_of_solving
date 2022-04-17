#include <stdio.h>
#include <stdlib.h> 
#include <math.h>
#include <iostream>
#include <vector>
#include <queue>
#include <cstdio>
#include <algorithm>
#define N 8001

using namespace std;



class Developer{
public:
    int doc;
    int re;
    Developer(int doc, int re):doc(doc),re(re){}
    
};
 
void Print(vector<Developer> &v){
    cout << "Student : " ;
    for(int i=0; i<8; i++){
        cout << "[" << v[i].doc << ", " << v[i].re << "]";
    }
    cout << endl;
}
 
bool compare(Developer a, Developer b){
    if(a.doc == b.doc){   //이름이 같으면, 나이가 적은순
        return a.re < b.re;
    }else{                  //이름 다르면, 이름 사전순
        return a.doc < b.doc;
    }
    
}



int main() 
{

    int applicants = 6;
    scanf("%d", &applicants);

    vector<int> document(N, 0);
    vector<int> program(N, 0);


    for(int i=0; i<applicants; i++){
        scanf("%d %d", &document[i], &program[i]);
    }

	// priority_queue<pair<int, int>, vector<pair<int, int> >, compare>pq_score;


    int max_program_value = program[0];
    for(int i=0; i<applicants; i++){
        if(max_program_value < program[i])
            max_program_value = program[i];
    }
    //cout << endl << endl;
//    cout << max_program_value << endl;


    vector<Developer> v;
    vector<Developer> group;
    vector<Developer> same;


    for(int i=0; i < applicants; i++){
        v.push_back(Developer(document[i], program[i]));
    }

    sort(v.begin(), v.end(), compare); 

    int search_index=1;
    int max_y = v[0].re;

    group.push_back(Developer(v[0].doc, v[0].re));
    
//    group.pop_back();
    // if(!group.empty())
    //     cout << "debug\n";



   // cout << "dodododo \n";
    // for(int i=0; i<applicants; i++){
    //     cout << v[i].doc << " " << v[i].re << "\n";

    // }


    while(search_index != applicants){
        //cout << "infinite loop? \n";
        // cout << "size: " << group.size() << endl;
        // cout << "index: " << group.back().doc << " y: " << group.back().re << " search: " << v[search_index].re << endl;


        if(group.back().re < v[search_index].re){
            group.push_back(Developer(v[search_index].doc, v[search_index].re));
            // 펜딩에 일리먼트들 있는지 확인 
        } else if(group.back().re == v[search_index].re){
            same.push_back(Developer(v[search_index].doc, v[search_index].re));

        } else{
            // cout << "lets find error: " << search_index << endl;

            max_y = group.back().re;
            group.pop_back();
            //여기가 그 거시기 최대값보다 낮은 경우임, 최대값보다 낮으면 pending에 있는 모든 index 둘러보면서 pending값이 더 높으면 pop해줌.
            while(!group.empty()){
                // cout << " lets \n";
                if(group.back().re > v[search_index].re){
                    group.pop_back();
                } else{
                    group.push_back(Developer(v[search_index].doc, max_y));
                    break;
                }            
            }
            if(group.empty())
                group.push_back(Developer(v[search_index].doc, max_y));            

            while(!same.empty()){
                if(same.back().re > v[search_index].re){
                    same.pop_back();
                } else{
                    break;
                }            
            }


        }

        search_index++;
    }




    // cout << "lets do debug \n";
    // cout << group[0].doc << " " << group[0].re << " \n";
    // cout << group[1].doc << " " << group[1].re << " \n";
    // cout << group[2].doc << " " << group[2].re << " \n";
    // cout << same[0].doc << " " << same[0].re << " \n";



    // cout << group.size() << " " << same.size() << " \n";
    int answer = group.size() + same.size();
    cout << answer << endl;

    return 0; 
}