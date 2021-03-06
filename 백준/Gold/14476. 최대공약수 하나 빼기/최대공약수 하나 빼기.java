import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		static int N;   
		static int[] nums;
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			      
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] arr1 = new int[N];
			int[] arr2 = new int[N];
			arr1[0] = nums[0];
			for (int i = 1; i < N; i++) {
				arr1[i] = gcd(arr1[i - 1], nums[i]);
			}
			arr2[N - 1] = nums[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				arr2[i] = gcd(arr2[i + 1], nums[i]);
			}
			
			int[] gcdResult = new int[N];
			gcdResult[0] = arr2[1];
			gcdResult[N-1] = arr1[N - 2];
			for (int i = 1; i < N - 1; i++) {
				gcdResult[i] = gcd(arr1[i-1], arr2[i+1]);
			}
			
			int max = -1;
			int k = 0;
			for (int i = 0; i < N; i++) {
				if(nums[i] % gcdResult[i] != 0) {
					if (max < gcdResult[i]) {
						max = gcdResult[i];
						k = nums[i];
					}
				}
			}
			
			if(max == -1) {
				System.out.println("-1");
			} else {
				System.out.println(max + " " + k);
			}
		}

		// 반복문
		// gcd(a, b) == gcd(b, r) == gcd(b, a%b), stop when a%b==0
		public static int gcd(int a, int b) {
			while(b != 0) {
				int r = a % b;
				a = b;
				b = r;
			}
			return a;
		}

		// 재귀 (생각 안나면 써도 되나 확장 유클리드 호제법에서 사용하기 어려움)
//		public static int gcd(int a, int b) {
//			int r = a % b;
//			if(r == 0) {
//				return b;
//			} else {
//				return gcd(b, r);
//			}
//		}	
}
