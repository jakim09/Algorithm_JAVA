import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] nums;
	static long[] fact;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		fact = new long[N + 1];
		visited = new boolean[N + 1];
		// 1. 펙토리얼 구하기
		// 순열 long에 넣을 수 있음 (21 부터 못 넘)
		fact[0] = 1;
		for (int i = 1; i < N + 1; ++i) {
			fact[i] = fact[i - 1] * i;
		}
		
		// 1번 문제 : K번째 순열
		if(Integer.parseInt(st.nextToken()) == 1){
			long target = Long.parseLong(st.nextToken());
			for(int i = 0; i < N; i++) {
				for (int j = 1; j <= N; j++) {
					if(visited[j] == true) {
						continue;
					}
					if(target > fact[N - i - 1]) {
						target -= fact[N - i - 1];
					} else {
						sb.append(j).append(" ");
						visited[j] = true;
						break;
					}
				}
			}
			System.out.println(sb);
		} 
		// 2번 문제 : 몇 번째 순열?
		else {
			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			long result = 0;
			
			for(int i = 0; i < N; i++) {
				for (int j = 1; j < nums[i]; j++) {
					if(visited[j] == false) {
						result += fact[N - i - 1];
					}
				}
				visited[nums[i]] = true;
			}
			System.out.println(result + 1);
		}
	}
}
