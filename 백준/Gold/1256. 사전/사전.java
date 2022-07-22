import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;  
	static int MAX = 1000000000;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N + M + 1][N + M + 1];
		
		// 파스칼의 삼각형 만들기
		for (int i = 0; i < N + M + 1; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
			for (int j = 1; j < i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				if(dp[i][j] > MAX) {
					dp[i][j] = MAX;
				}
			}
		}
		if(dp[N+M][M] < K) {
			sb.append(-1);
		} else {
			query(N + M - 1, M, K);
		}
		System.out.println(sb);
	}
	
	static void query(int n, int m, int k) {
		if (n == 0) {
			if(m == 0) {
				sb.append("a");
			} else {
				sb.append("z");
			}
			return;
		} else if (dp[n][m] >= k) {
			sb.append("a");
			query(n-1, m, k);
		} else {
			sb.append("z");
			query(n-1, m-1, k-dp[n][m]);
		}
	}
}
