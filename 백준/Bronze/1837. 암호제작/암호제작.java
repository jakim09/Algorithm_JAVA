import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String P;
	static int K;   
	static boolean[] isNotPrime;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		P = st.nextToken();
		K = Integer.parseInt(st.nextToken());
		isNotPrime = new boolean[K + 1];
		
		// 1. 소수 구하기
		for (int i = 2; i < Math.sqrt(K); i++) {
			for (int j = 2; j <= K; j++) {
				if(i*j <= K) {
					isNotPrime[j * i] = true;
				} else {
					break;
				}
			}
		}
		
		// 2. 나눠보기
		int cnt = 0;
		int result = 0;
		int prime = 0;
		for (int i = 2; i < K; i++) {
			int r = 0;
			int q = 0;
			if(isNotPrime[i] == false) {
				cnt++;
				for(int j = 0; j < P.length(); j++) {
					r = P.charAt(j) - '0';
					q *= 10;
					q += r;
					q %= i;
				}
				
				if(q != 0) {
					result++;
				} else {
					prime = i;
					break;
				}
			}
		}
		if(cnt == result) {
			System.out.println("GOOD");
		} else{
			System.out.println("BAD " + prime);

		}

	}
}