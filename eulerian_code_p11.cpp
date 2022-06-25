#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#define ALPHA 26
using namespace std;

int n = 0;
//int ALPHA = 26;
vector<vector<int> > adj;
vector<string> graph[ALPHA][ALPHA];
vector<int> inDegree, outDegree;


void makeGraph(const vector<string>& words) {
    for (int i = 0; i < n; ++i) {
        int firstLetter = words[i][0] - 'a';        // 첫 번째 문자를 숫자로
        int lastLetter = words[i].back() - 'a';     // 마지막 문자를 숫자로
        graph[firstLetter][lastLetter].push_back(words[i]); // 간선에 문자열 추가
        adj[firstLetter][lastLetter]++;     // 해당 정점에 인접 간선 개수 하나 추가
        inDegree[lastLetter]++;             // 마지막 문자 정점의 도착 차수 1 증가
        outDegree[firstLetter]++;           // 시작 문자 정점의 출발 차수 1 증가
    }
}

void dfs(int here, vector<int>& circuit) {
    for (int there = 0; there < ALPHA; ++there) {
        while (adj[here][there] > 0) {          // 더 나아갈 간선이 있다면 DFS 가능
            adj[here][there]--;                 // 방향 그래프이므로 해당 간선만 감소
            dfs(there, circuit);    // DFS
        }
    }
    circuit.push_back(here);    // 중요!!
}
// 오일러 트레일인지, 오일러 서킷인지 확인하고 문자 탐방 순서를 만든다.
vector<int> getEulerTrailOrCircuit() {
    vector<int> circuit;
    for (int i = 0; i < ALPHA; ++i) {
        // 오일러 트레일인 경우 - 시작점이 존재한다.
        if (outDegree[i] == inDegree[i] + 1) {
            dfs(i, circuit);
            return circuit;
        }
    }
    for (int i = 0; i < ALPHA; ++i) {
        // 오일러 서킷인 경우 - 시작점 따로 없으니 아무데서나 시작한다.
        if (outDegree[i]) {
            dfs(i, circuit);
            return circuit;
        }
    }   // 아무것도 없는 경우 - 빈 배열을 반환한다.
    return circuit;
}
bool checkEuler() {
    int plus = 0, minus = 0;    // 시작점과 종료점 후보 갯수
    for (int i = 0; i < ALPHA; ++i) {
        int diff = outDegree[i] - inDegree[i]; 
        if (diff < -1 || diff > 1) return false;    // 차이의 절대값이 1 이상이면 실패
        if (diff == 1) plus++;      // 시작점 후보 개수 증가
        if (diff == -1) minus++;    // 종료점 후보 개수 증가  
    }   // 시작점 후보와 종료점 후보가 1개씩이면 트레일, 0이면 서킷이다.
    return (plus == 1 && minus == 1) || (plus == 0 && minus == 0);
}

string solve(const vector<string>& words) {
    makeGraph(words);
    if (!checkEuler()) return "IMPOSSIBLE";

    vector<int> circuit(getEulerTrailOrCircuit());
    // 끝말잇기이므로 핵심 알파벳 탐방 횟수는 문자열 개수 + 1개이다.
    // 예) dog, god, dragon, need -> d, g, n -> circuit = {d, g, d, n, d}
    if (circuit.size() != words.size() + 1) return "IMPOSSIBLE";
    
    // 방향 그래프이므로 방문순서를 역순으로 뒤집이야 정상적으로 문자열이 만들어진다.
    reverse(begin(circuit), end(circuit));

    string ret;
    for (int i = 1; i < circuit.size(); ++i) {
        if (ret.size()) ret += " ";     // 단어마다 띄어쓰기 추가
        ret += graph[circuit[i - 1]][circuit[i]].back();    // 간선에 있는 문자열 추가
        graph[circuit[i - 1]][circuit[i]].pop_back();       // 간선에 있는 문자열 제거
    }
    return ret;     // 만들어진 문자열 반환
}

int main() {

        cin >> n;
        vector<string> words(n);
        adj = vector<vector<int> >(ALPHA, vector<int>(ALPHA, 0));
        inDegree = outDegree = vector<int>(ALPHA, 0);

        for (int i = 0; i < n; ++i)
            cin >> words[i];
        cout << solve(words) << '\n';
    
}