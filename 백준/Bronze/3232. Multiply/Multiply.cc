#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int i = 0; i < T; i++) {
        int p,q,r;
        cin >> p >> q >> r;

        int answer = 0;

        for(int j = 2; j < 100000; j++) {
            bool valid = true;

            int temp = p;
            while(temp) {
                if(temp % 10 >= j) valid = false;
                temp /= 10;
            }

            temp = q;
            while(temp) {
                if(temp % 10 >= j) valid = false;
                temp /= 10;
            }

            temp = r;
            while(temp) {
                if(temp % 10 >= j) valid = false;
                temp /= 10;
            }

            if(!valid) continue;
            
            int ps = p, qs = q, rs = r;
            long long rr = 0;
            long long pp = 0;
            long long qq = 0;

            long long power = 1;

            while(rs || qs || ps) {
                rr += (rs % 10) * power;
                pp += ((ps % 10) * power);
                qq += ((qs % 10) * power);

                power *= j;
                ps /= 10;
                qs /= 10;
                rs /= 10;
            }

            if(rr == pp * qq) {
                answer = j;
                break;
            }
        }

        cout << answer << endl;
    }
}