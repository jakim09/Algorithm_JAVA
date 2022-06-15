import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- != 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[k+1][n+1];
			
			for(int i = 1; i <= n; i++) {
				arr[0][i] = i;
			}
			
			for(int i = 0; i <= k; i++) {
				arr[i][1] = 1;
			}
			
			for (int i = 1; i <= k; i++) {
				for (int j = 2; j <= n; j++) {
					arr[i][j] = arr[i-1][j] + arr[i][j-1];
				}
			}
			System.out.println(arr[k][n]);
		}
        /*
		while(t-- != 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[k+1][n+1];
			
			for(int i = 1; i <= n; i++) {
				arr[0][i] = i;
			}
			
			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					for (int a = 1; a <= j; a++) {
					arr[i][j] += arr[i-1][a];
					}
				}
			}
			System.out.println(arr[k][n]);
		}		
        */
	}
}