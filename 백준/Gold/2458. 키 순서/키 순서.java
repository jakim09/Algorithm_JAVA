import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Integer>[] grape;
	static boolean[] visited;
	static int[] inCnt, outCnt;

	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grape = new ArrayList[N + 1];

		// 그래프 입력
		int a, b;
		for (int i = 0; i < N + 1; i++) {
			grape[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			grape[a].add(b);
		}
		
		inCnt = new int[N + 1];
		outCnt = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
			outCnt[i] = dfs(i) - 1;
		}
		
		int result = 0;
		for (int i = 1; i < N + 1; i++) {
			if ((inCnt[i] + outCnt[i]) == N - 1) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	static int dfs(int v) {
		int outCnt = 0;
		
		for(int next : grape[v]) {
			if(visited[next] == true) {
				continue;
			}
			inCnt[next]++;
			visited[next] = true;
			outCnt += dfs(next);
		}
		return outCnt + 1;
	}
}
