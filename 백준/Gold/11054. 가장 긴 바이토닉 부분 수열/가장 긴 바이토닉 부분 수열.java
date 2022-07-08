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
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        for (int i = 1; i <= n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        dp1[1] = 1;
        for (int i = 1; i <= n; i++) {
        	dp1[i] = 1;
        	for (int j = 1; j < i; j++) {
        		if(arr[i] > arr[j] && dp1[i] < dp1[j]+1) {
        			dp1[i] = dp1[j]+1;
        		}
        	}
        }
        dp2[1] = 1;
        for (int i = n; i >= 1; i--) {
        	dp2[i] = 1;
        	for (int j = n; j > i; j--) {
        		if(arr[i] > arr[j] && dp2[i] < dp2[j]+1) {
        			dp2[i] = dp2[j]+1;
        		}
        	}
        }
        for (int i = 1; i <= n; i++) {
        	dp1[i] += dp2[i];
        }
        Arrays.sort(dp1);
        System.out.println(dp1[n] - 1);
    }
}