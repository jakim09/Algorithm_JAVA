import java.util.*;
import java.awt.Point;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] visited;
    static int min = 10001;
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        // dfs(maps, 0, 0, 1, maps[0].length - 1, maps.length - 1);
        bfs(maps, 0, 0, 1, maps[0].length - 1, maps.length - 1);
        if(min == 10001){
            min = -1;
        }
        return min;
    }
    
    static void bfs(int[][] maps, int x, int y, int cnt, int n, int m){
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{x, y, cnt});
        visited[y][x] = cnt;
        while(!q.isEmpty()){
            // 큐에서 꺼냄
            int[] node = q.poll();
            // 목적지?
            if(node[0] == n && node[1] == m){
                min = visited[m][n];
            }
            // 연결 순회
            for (int i = 0; i < 4; i++){
                // 갈 수? : maps[][] == 1, map 범위내, !visited
                int nextX = node[0] + dx[i];
                int nextY = node[1] + dy[i];
                if(0 <= nextX && nextX <= n && 0 <= nextY && nextY <= m){
                    if(maps[nextY][nextX] == 1 && visited[nextY][nextX] == 0){
                        // 큐에 넣음
                        q.add(new int[]{nextX, nextY, node[2] + 1});
                        // 체크인
                        visited[nextY][nextX] = node[2] + 1;
                    }
                } 
            }
        }
    }
    // static void dfs(int[][] maps, int x, int y, int cnt, int n, int m){
    //     // 체크인
    //     visited[y][x] = true;
    //     // 목적지? n, m
    //     if(x == n && y == m){
    //         min = Math.min(min, cnt);
    //     }
    //     // 연결 순회
    //     for (int i = 0; i < 4; i++){
    //         // 갈 수? : maps[][] == 1, map 범위내, !visited
    //         int nextX = x + dx[i];
    //         int nextY = y + dy[i];
    //         if(0 <= nextX && nextX <= n && 0 <= nextY && nextY <= m){
    //             if(maps[nextY][nextX] == 1 && visited[nextY][nextX] == false){
    //             // 가
    //             dfs(maps, nextX, nextY, cnt + 1, n, m);
    //             }
    //         }
    //     }
    //     // 체크아웃
    //     visited[y][x] = false;
    // }
}