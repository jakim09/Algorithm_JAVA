import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;   
	static boolean[] isNotPrime;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		isNotPrime = new boolean[N + 1];
		int cnt = 0;
		int result = 0;
		// 1. 소수 구하기
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i*j <= N) {
					if(isNotPrime[j * i] == false) {
						cnt++;
						result = j * i;
					}
					
					isNotPrime[j * i] = true;
					if(cnt == K) {
						break;
					}
				} else {
					break;
				}
			}
			if(cnt == K) {
				break;
			}
		}
		System.out.println(result);
	}
}
