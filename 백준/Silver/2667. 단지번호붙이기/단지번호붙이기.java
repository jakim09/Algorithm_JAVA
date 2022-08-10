import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> apartments;
	static Queue<Point> q;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0 ,-1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		visited = new boolean[N][N];
		apartments = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					bfs(j, i);
				}
			}
		}
		Collections.sort(apartments);
		
		sb.append(apartments.size()).append('\n');
		
		for(int n : apartments) {
			sb.append(n).append('\n');
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		q = new LinkedList<>();
		int nextX, nextY;
		int danji = 1;
		q.add(new Point(x, y));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			// 큐에서 꺼낸다
			Point cur = q.poll();
			// 연결 순회
			for (int i = 0; i < 4; i++) {
				nextX = cur.x + dx[i];
				nextY = cur.y + dy[i];
				// 갈?
				if(0 <= nextX && nextX < N && 0 <= nextY && nextY <N) {
					if(map[nextY][nextX] == 1 && visited[nextY][nextX] == false) {
					// 큐에 넣음
						q.add(new Point(nextX, nextY));
					// 체크인
						visited[nextY][nextX] = true;
						danji++;
					}
				}
			}
		}
		apartments.add(danji);
	}
}