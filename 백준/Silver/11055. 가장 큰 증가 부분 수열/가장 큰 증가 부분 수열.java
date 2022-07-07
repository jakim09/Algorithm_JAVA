import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
        	dp[i] = arr[i];
        	for (int j = 1; j < i; j++) {
        		if(arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
        			dp[i] = dp[j] + arr[i];
        		}
        	}
        }
        Arrays.sort(dp);
        System.out.println(dp[n]);
    }
}