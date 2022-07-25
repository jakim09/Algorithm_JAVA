import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K; 
	static List[] tree;
	static int[] depth;
	static int[][] parent;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		K = 0;
		for (int i = 1; i <= N; i*=2) {
			K++;
		}
		
		tree = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		depth = new int[N + 1];
		parent = new int[K][N + 1];
		
		// depth 채우기
		dfs(1, 1);
		
		// DP로 parent 채우기
		for (int i = 1; i < K; i++) {
			for (int j = 0; j < N + 1; j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
			}
		}
		
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lca(a, b)).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int n, int cnt) {
		// 체크인
		depth[n] = cnt;
		// 연결된 곳 순회
		for (int i = 0; i < tree[n].size(); i++) {
			int next = (int) tree[n].get(i);
			// 갈 수 있는가
			if (depth[next] == 0) {
				// 간다
				dfs(next, cnt + 1);
				parent[0][next] = n;
			}
		}
		return;
	}
	
	static int lca(int a, int b) {
		// 1. 더 깊은 노드 찾기
		if(depth[a] < depth[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		// 2. depth 맞춰주기
		for (int i = K - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				a = parent[i][a];
			}
		}		
		// 3. depth가 같은 값이 같다면 반환
		if (a == b) {
			return a;
		}
		// 4. depth가 같은 값이 다르다면 같아질 때 까지..
		for (int i = K - 1; i >= 0; i--) {
			if (parent[i][a] != parent[i][b]) {
				a = parent[i][a];
				b = parent[i][b];
			}
		}
		return parent[0][a];
	}
}
