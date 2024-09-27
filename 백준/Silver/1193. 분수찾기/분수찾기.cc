#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int sum = 0; // 누적 합
    int inc = 0; // inc는 해당 분수가 몇 번째 대각선 위에 있는지 확인
    int top = 0; // 분자
    int bot = 0; // 분모
    // 매 행마다 45도 위로 향하는 대각선을 그어보면...
    // 각 대각선을 지나는 분수들의 개수는 1, 2, 3, 4, 5, ...
    // 누적 합은 1, 3, 6, 10, 15, ...
    // ex) 11번째 분수는? -> 10번째 분수까지는 4번째 대각선이 그어지고
    // 5번째 대각선 위에 있음
    while(1) {
        inc++;
        if (sum + inc >= n) {
            break;
        }
        sum += inc;
    }
    // 같은 대각선 위에 있는 분수들은 분모와 분자의 합이 같은 특징이 있음
    // 몇 번째 대각선 위에 있는지에 따라 분자가 증가하는가 감소하는가가 다름
    // i) 홀수번째 대각선 위의 분수들이 번호가 증가할수록 분모가 증가
    // ii) 짝수번째 대각선 위의 분수들은 번호가 증가할수록 분자가 증가
    int total = inc + 1; // 분자와 분모의 합은 대각선 번호 +1
    if(inc % 2 == 1) { // 홀수번째 대각선이라면?
        bot = n - sum; // 분모
        top = total - bot; // 분자는 total-분모임
    }
    else { // 짝수번째 대각선이라면?
        top = n - sum; // 분자
        bot = total - top; // 분모는 total-분자임
    }
    cout << top << '/' << bot;
}