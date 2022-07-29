import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAXN = 1000;
	static int T, N;
	static int[] arr;
	static int[][][] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		arr = new int[MAXN + 1];
		dp = new int[2][MAXN + 1][MAXN + 1];
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			st  = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[0][i], 0);
				Arrays.fill(dp[1][i], 0);
			}
			
			// j = 구간 시작점
			// i = 구간 종료점
			for (int e = 1; e < N + 1; e++) {
				for (int s = e; s > 0; s--) {
					for (int flag = 0; flag < 2; flag++) {
						if (s == e) {
							dp[flag][s][e] = (flag == 0 ? arr[s] : 0);
							continue;
						}
						if(flag == 0) {
							dp[flag][s][e] = Math.max(dp[1][s + 1][e] + arr[s], dp[1][s][e - 1] + arr[e]);
						} else {
							dp[flag][s][e] = Math.min(dp[0][s + 1][e], dp[0][s][e - 1]);
						}
					}
				}
			}
			System.out.println(dp[0][1][N]);
		}
	}
}
