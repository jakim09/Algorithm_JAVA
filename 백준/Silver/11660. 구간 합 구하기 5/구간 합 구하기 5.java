import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(j == 0) {
					dp[i][j] = arr[i][j];
				} else {
					dp[i][j] = dp[i][j-1] + arr[i][j];
				}
			}
		}

		int x1, x2, y1, y2, answer;
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()) - 1;
			y1 = Integer.parseInt(st.nextToken()) - 1;
			x2 = Integer.parseInt(st.nextToken()) - 1;
			y2 = Integer.parseInt(st.nextToken()) - 1;
			answer = 0;

			for (int i = x1; i <= x2; i++) {
				if(y1 == 0){
					answer += dp[i][y2];
				} else {
					answer += dp[i][y2] - dp[i][y1-1];
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
