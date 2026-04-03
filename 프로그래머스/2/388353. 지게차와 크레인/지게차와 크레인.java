import java.io.*;
import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int h = storage.length; // 세로
        int w = storage[0].length(); // 가로
        
        char[][] board = new char[h+2][w+2];
        for(int i=0; i<h+2; i++) {
            for(int j=0; j<w+2; j++) {
                if(i==0 | i == h+1 | j == 0 | j == w+1) {
                    board[i][j] = '0';
                }
                else {
                    board[i][j] = storage[i-1].charAt(j-1);
                }
                
            }
        }
        
        for(String r : requests) {
            if(r.length() == 1) { // 지게차
                boolean[][] v = new boolean[h+2][w+2];
                ArrayDeque<int[]> q = new ArrayDeque<>();
                List<int[]> toRemove = new ArrayList<>(); // 제거할 좌표 저장용
                
                q.offer(new int[] {0, 0});
                v[0][0] = true;
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    for(int i=0; i<4; i++) {
                        int nx = cur[0] + dx[i];
                        int ny = cur[1] + dy[i];
                        if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2 || v[nx][ny]) continue;
                        if(0 <= nx && nx < h+2 && 0 <= ny && ny < w+2) {
                            if(!v[nx][ny] && board[nx][ny] == '0') {
                                v[nx][ny] = true;
                                q.offer(new int[] {nx, ny});
                            }
                            if(!v[nx][ny] && board[nx][ny] == r.charAt(0)) {
                                v[nx][ny] = true;
                                toRemove.add(new int[]{nx, ny}); // 나중에 지울 목록에 추가
                            }
                        }
                    }
                }
                // BFS 종료 후 한꺼번에 제거
                for (int[] pos : toRemove) {
                    board[pos[0]][pos[1]] = '0';
                }
            }
            else if(r.length() == 2) { // 크레인
                for(int i=1; i<h+1; i++) {
                    for(int j=1; j<w+1; j++) {
                        if(board[i][j] == r.charAt(0)) {
                            board[i][j] = '0';
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<h+2; i++) {
            for(int j=0; j<w+2; j++) {
                if(board[i][j] != '0') answer += 1;
            }
        }
        
        return answer;
    }
}