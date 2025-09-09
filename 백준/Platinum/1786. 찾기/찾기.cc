#include <bits/stdc++.h>
using namespace std;

vector<int> computeLPS(const string &pat) {
    int M = pat.size();
    vector<int> lps(M, 0);
    int len = 0; // 이전까지의 가장 긴 접두사-접미사 길이
    for (int i = 1; i < M; i++) {
        while (len > 0 && pat[i] != pat[len]) {
            len = lps[len - 1];
        }
        if (pat[i] == pat[len]) {
            len++;
            lps[i] = len;
        }
    }
    return lps;
}

vector<int> KMP(const string &txt, const string &pat) {
    vector<int> result;
    vector<int> lps = computeLPS(pat);
    int N = txt.size(), M = pat.size();
    int j = 0; // 패턴 인덱스

    for (int i = 0; i < N; i++) {
        while (j > 0 && txt[i] != pat[j]) {
            j = lps[j - 1]; // 불일치 시 점프
        }
        if (txt[i] == pat[j]) {
            j++;
        }
        if (j == M) {
            result.push_back(i - M + 2); // 위치 저장 (1-based index)
            j = lps[j - 1];
        }
    }
    return result;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string txt, pat;
    getline(cin, txt);
    getline(cin, pat);

    vector<int> matches = KMP(txt, pat);

    cout << matches.size() << '\n';
    for (int pos : matches) {
        cout << pos << '\n';
    }

    return 0;
}
