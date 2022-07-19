import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	 static int[] trees;

	 public static void main(String[] args) throws IOException {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());

	     N = Integer.parseInt(st.nextToken());
	     M = Integer.parseInt(st.nextToken());

	     trees = new int[N];
	     
	     int max = -1;
	     st = new StringTokenizer(br.readLine());
	     for (int i = 0; i < N; i++) {
	    	 trees[i] = Integer.parseInt(st.nextToken());
	    	 max = Math.max(trees[i], max);
	     }
	     
	     long lt = 0;
	     long rt = max;
	     long mid;
	     long result = 0;
	     while (lt <= rt) {
		     mid = (lt + rt) / 2;
	    	 long total = calc(mid);
	    	 // 1. 자른 나무 합 == M : 정답
	    	 if (total == M) {
	    		 result = mid;
	    		 break;
	    	 } else if (total > M) {
	    	// 2. 자른 나무 합 > M : 나무의 합이 M보다 클 경우도 정답 / lt = mid + 1
	             result = mid; 
	    		 lt = mid + 1;
	    	 } else {
	    	// 3. 자른 나무 합 < M : rt = mid - 1
	    		 rt = mid - 1;
	    	 }
	     }
	     System.out.println(result);
	 }
	 
	 static long calc (long mid) {
		 long sum = 0;
		 for (int i = 0; i < N; i++) {
			 if(trees[i] - mid > 0) {
				 sum += trees[i] - mid;
			 }
		 }
		 return sum;
	 }
}
