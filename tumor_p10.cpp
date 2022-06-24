#include <iostream>
#include <vector>
#include <cstring>
#define N 901

using namespace std; 

int store[N];
int graph[N][N];
int d[N];
int num;

bool is_clique(int group_size) {
// 1 2   1 3 2 3 
    for(int i=1; i < group_size; i++) {
        for(int j=i+1; j < group_size; j++) {
            if(graph[store[i]][store[j]] == 0)
                return false;
        }
    }
    return true;
}
 
void show(int group_size) {
    for(int i=1; i < group_size; i++) {
        cout << store[i] << " "; 
    }
    cout << ", ";
}



// 0, 1, k = 3
void find(int current_vertex, int num_connected_vertex, int k) {
    
    for(int j = current_vertex + 1; j <= num - (k - num_connected_vertex); j++) {

        if(d[j] >= k - 1) {

            store[num_connected_vertex] = j;

            if(is_clique(num_connected_vertex + 1)) {

                if(num_connected_vertex < k) {
                    find(j, num_connected_vertex + 1, k);
                } else {
                    show(num_connected_vertex + 1);

                }

            } 
        }
    }
}




int main() 
{ 
    num=5;

    int edges[][2] = { { 1, 2 }, 
                       { 2, 3 }, 
                       { 3, 1 }, 
                       { 4, 3 }, 
                       { 4, 5 }, 
                       { 5, 3 } }; 

    int size=6;
    int k=3;


    memset(d, 0, N);
    memset(graph, 0, N);
    memset(store, 0, N);

    for(int i=0; i < size; i++) {
        graph[edges[i][0]][edges[i][1]] = 1;
        graph[edges[i][1]][edges[i][0]] = 1;
        d[edges[i][0]]++;
        d[edges[i][1]]++;
    }

    find(0, 1, k);






    
    // for(int i=1; i <= num; i++) {
    //     cout << d[i] << " ";
    // }
    // cout << endl;

    // for(int i=1; i <= num; i++) {
    //     for(int j=1; j <= num; j++) {
    //         cout << graph[i][j] << " " << graph[j][i] << " : ";
    //     }
    // }
    // cout << endl;


    cout << "end \n";

    return 0; 
}  
