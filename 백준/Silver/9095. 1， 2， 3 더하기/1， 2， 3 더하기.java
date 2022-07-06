import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+3];
        
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
        
            for(int i = 4; i <= n; i++){
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }
		
		    System.out.println(dp[n]);
        }

    }
}