import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> candies = new ArrayList<>(); // 원래 캔디 배열
        for(int i=0; i<n; i++) {
            candies.add(br.readLine());
        }

        ArrayList<String> tCandies = new ArrayList<>(); // 전치 캔디 배열(가로-세로 바꿈)

        for(int k=0; k<n; k++) {
            StringBuilder s = new StringBuilder();
            for(int j=0; j<n; j++) {
                s.append(candies.get(j).charAt(k));
            }
            tCandies.add(s.toString());
        }
        int finalMax = Math.max(maxCandies(candies), maxCandies(tCandies));
        // 기존 배열, 전치 배열 둘 다 계산하여 그 중 최댓값
        System.out.println(finalMax);
    }

    public static int maxCandies(ArrayList<String> l) { // 사탕 최대 개수 계산
        int n = l.size();
        int max = 0;
        // 두 행 단위로 계산, 첫 문자부터 하나씩 서로 바꾸어 보면서 최대 개수 계산
        for(int i=0; i<n-1; i++) {
            for(int j=-1; j<n; j++) {
                String newone; // 두 행 중 첫 행
                String newtwo; // 두 행 중 두번째 행
                if(j == -1) { // 문자를 서로 바꾸지 않은 경우
                    newone = l.get(i);
                    newtwo = l.get(i+1);
                }
                else { // 문자를 서로 바꾼 경우
                    char one = l.get(i).charAt(j);
                    char two = l.get(i + 1).charAt(j);
                    // 문자 하나를 서로 바꾼 새로운 두 문자열
                    newone = l.get(i).substring(0, j) + two + l.get(i).substring(j + 1);
                    newtwo = l.get(i + 1).substring(0, j) + one + l.get(i + 1).substring(j + 1);
                }
                int streak = 1; // 연속
                for(int k=1; k<n; k++) { // 첫 행의 문자열에 대해 계산
                    char prevchar = newone.charAt(k-1);
                    char curchar = newone.charAt(k);
                    if(prevchar == curchar) {
                        streak++;
                    }
                    else {
                        max = Math.max(max, streak);
                        streak = 1;
                    }
                    max = Math.max(max, streak);
                }

                streak = 1; // 연속
                for(int k=1; k<n; k++) { // 두번째 행의 문자열에 대해 계산
                    char prevchar = newtwo.charAt(k-1);
                    char curchar = newtwo.charAt(k);
                    if(prevchar == curchar) {
                        streak++;
                    }
                    else {
                        max = Math.max(max, streak);
                        streak = 1;
                    }
                    max = Math.max(max, streak);
                }

                if(j != -1) {
                    StringBuilder s = new StringBuilder();
                    char one = l.get(i).charAt(j);
                    char two = l.get(i + 1).charAt(j);
                    for(int y=0; y<n; y++) {
                        if(y == i) {
                            s.append(two);
                        }
                        else if(y == i+1) {
                            s.append(one);
                        }
                        else {
                            s.append(l.get(y).charAt(j));
                        }
                    }
                    String temp = s.toString();
                    streak = 1;
                    for(int k=1; k<n; k++) { // 두번째 행의 문자열에 대해 계산
                        char prevchar = temp.charAt(k-1);
                        char curchar = temp.charAt(k);
                        if(prevchar == curchar) {
                            streak++;
                        }
                        else {
                            max = Math.max(max, streak);
                            streak = 1;
                        }
                        max = Math.max(max, streak);
                    }

                }
            }
        }
        return max; // 최대값 반환
    }

}