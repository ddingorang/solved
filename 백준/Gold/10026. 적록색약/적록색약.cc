#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int bfs(vector<vector<int>> v, vector<string> f, int n) {
        queue<vector<int>> q; // BFS 수행할 큐
        int dx[4] = {1, 0, -1, 0}; // 열 방향
        int dy[4] = {0, 1, 0, -1}; // 행 방향
        int count = 0;
        for(int i=0; i<n; i++) { // 그리드 한 구역씩 훑기 시작
            for(int j=0; j<n; j++) {
                if(v[i][j] == 0) { // 방문 안했을 때만 bfs 시작
                    char firstcolor = f[i][j]; // 그 구역의 색깔 저장
                    q.push({i, j}); // push
                    v[i][j] = 1; // 방문 처리
                    while(q.empty() == false) { // 큐가 빌때까지 계속
                        vector<int> cur = q.front();
                        for(int k=0; k<4; k++) { // 상하좌우 이동
                            int newy = cur[0] + dy[k]; // 열 방향 이동
                            int newx = cur[1] + dx[k]; // 행 방향 이동
                            if(0 <= newy && newy < n && 0 <= newx && newx < n) { // 그리드 내 유효 범위 내
                                if(v[newy][newx] == 0 && f[newy][newx] == firstcolor) { // 방문 안했고, 처음 저장했던 색깔과 동일할 때
                                    q.push({newy, newx});
                                    v[newy][newx] = 1; // 방문 처리
                                }
                            }
                        }
                        q.pop();
                    }
                    count += 1;
                }
                
            }
        }
        return count;
    }


int main() {
    int n;
    std:cin >> n; // 그리드 크기
    queue<vector<int>> q; // BFS 수행할 큐
    vector<string> field; // 그리드
    vector<vector<int>> visited1(n, vector<int>(n, 0)); // 방문 체크 벡터
    vector<vector<int>> visited2(n, vector<int>(n, 0)); // 방문 체크 벡터
    
    for(int m = 0; m < n; m++) {
        string row;
        cin >> row; // 한 행씩 입력 받음
        field.push_back(row); // 그리드에 push
    }
    cout << bfs(visited1, field, n) << ' ';

    for(int a=0; a<n; a++) {
        for(int b=0; b<n; b++) {
            if(field[a][b] == 'G') {
                field[a][b] = 'R';
            }
        }
    }

    cout << bfs(visited2, field, n) << endl;

}

