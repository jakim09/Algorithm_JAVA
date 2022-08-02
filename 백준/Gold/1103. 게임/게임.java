import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int answer = -1;
	static boolean isloop = false;
	static int[][] map, dp;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map  = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j) == 'H') {
					map[i][j] = 0;
				} else {
					map[i][j] = str.charAt(j) - '0';
				}
			}
		}
		visited = new boolean[N][M];
		dp = new int[N][M];
		dfs(0, 0, 1);
		if(isloop == true) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		
	}
	static void dfs(int y, int x, int cnt) {
		// 체크인 visited == true
		visited[y][x] = true;
		// 목적지인가
		if(isloop == true) {
			return;
		}
		answer = Math.max(answer, cnt);
		dp[y][x] = cnt;
		// 연결된 곳 순회
			int moveNum = map[y][x];
			// 갈 수 있는가 map범위, 0이 아님
			if(-1 < x - moveNum) { // 좌
				if(visited[y][x - moveNum] == true) {
					isloop = true;
					return;
				}
				if(map[y][x - moveNum] != 0 && dp[y][x-moveNum] <= cnt) {
					dfs(y, x - moveNum, cnt + 1);
				}
			}
			if(x + moveNum < M) { // 우
				if(visited[y][x + moveNum] == true) {
					isloop = true;
					return;
				}
				if(map[y][x + moveNum] != 0 && dp[y][x+moveNum] <= cnt) {
					dfs(y, x + moveNum, cnt + 1);
				}
			}
			if(-1 < y - moveNum) { // 상
				if(visited[y - moveNum][x] == true) {
					isloop = true;
					return;
				}
				if(map[y - moveNum][x] != 0 && dp[y - moveNum][x] <= cnt) {
					dfs(y - moveNum, x, cnt + 1);
				}
			}
			if(y + moveNum < N) { // 하
				if(visited[y + moveNum][x] == true) {
					isloop = true;
					return;
				}
				if(map[y + moveNum][x] != 0  && dp[y + moveNum][x] <= cnt) {
					dfs(y + moveNum, x, cnt + 1);
				}
			}
		// 체크아웃 visited == false
		visited[y][x] = false;
	}
	
}