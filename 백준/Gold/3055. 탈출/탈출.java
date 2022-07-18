import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static int[][] dp;
	static Queue<Point> queue;
	static boolean foundAnswer;
	static final int[] MX = {-1, 1, 0, 0};
	static final int[] MY = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		dp = new int[R][C];
		queue = new LinkedList<>();

		Point s = null;
		int dx = 0, dy = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') {
					queue.add(new Point(i, j, '*'));
				} else if (map[i][j] == 'S') {
					s = new Point(i, j, 'S');
				} else if (map[i][j] == 'D') {
					dy = i;
					dx = j;
				}
			}
		}
		queue.add(s);

		// Q [*, S]
		
		while(!queue.isEmpty()) {
			// 1. 큐에서 꺼내옴 : *, S, ., D
				Point p = queue.poll();
			// 2. 목적지인가? : D
				if(p.type == 'D') {
					foundAnswer = true;
					break;
				}
			// 3. 연결된 곳을 순회 : 상하좌우
				for (int i = 0; i < 4; i++) {
					int ty = p.y + MY[i];
					int tx = p.x + MX[i];
			//		4. 갈 수 있는가? : (공통) 지도 안
					if(tx > -1 && tx < C && ty > -1 && ty < R) {
						if(p.type == 'S' || p.type == '.') {
			//				4. 갈 수 있는가? : (고슴도치) ., D, 방문하지 않은 곳
							if((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0) {
			//					5. 체크인 : (고슴도치) dp[][] = 이동거리
								dp[ty][tx] = dp[p.y][p.x] + 1;
			//					6. 큐에 넣음
								queue.add(new Point(ty, tx, map[ty][tx]));
							}
						} else if(p.type == '*') {
			//				4. 갈 수 있는가? : (물) .
							if(map[ty][tx] == '.' || map[ty][tx] == 'S') {
			//					5. 체크인 : (물) map[][] = *
								map[ty][tx] = '*';
			//					6. 큐에 넣음
								queue.add(new Point(ty, tx, '*'));
							}
						}
						
					}
				}
		}
		if(foundAnswer) {
			System.out.println(dp[dy][dx]);
		} else {
			System.out.println("KAKTUS");
		}
	}
}

class Point {
	int x;
	int y;
	char type;
	
	Point(int y, int x, char type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}
