import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        int max = -1;
        for (int i = 0; i < t; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	if(max < arr[i]) {
        		max = arr[i];
        	}
        }
        
        int n = max;
	    long[] dp = new long[n+1];
	    dp[1] = 1;
	    dp[2] = 1;
	    dp[3] = 1;
	    for (int i = 4; i <= n; i++) {
	    	dp[i] = dp[i-2] + dp[i-3];
	    }
	    
	    StringBuffer sb = new StringBuffer();
	    for(int i = 0; i < t; i++) {
	    	sb.append(dp[arr[i]]).append("\n");
	    }
        System.out.println(sb);
    }
}