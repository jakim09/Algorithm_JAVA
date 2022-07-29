import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] dp, arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][2];
		st  = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		st  = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i][1] = Integer.parseInt(st.nextToken());
			sum += arr[i][1];
		}
			
		dp = new int[N + 1][sum + 1];
		for (int i = arr[1][1]; i < sum + 1; i++) {
			dp[1][i] = arr[1][0];
		}
		for (int i = 2; i < N + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if(j - arr[i][1] < 0) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j-arr[i][1]] + arr[i][0], dp[i-1][j]);
				}
			}
		}
		
		int answer = sum + 1;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < sum + 1; j++){
				if (dp[i][j] >= M) {
					answer = Math.min(j, answer);
				}
			}
		}
		System.out.println(answer);
	}
}
