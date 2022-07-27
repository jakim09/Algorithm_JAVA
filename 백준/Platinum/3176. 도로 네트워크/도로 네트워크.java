import java.io.*;
import java.util.*;

public class Main {
	static int N, K, H;
	static List<Node>[] tree;
	static int[][] parent, maxDist, minDist;
	static int[] depth;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		// 트리 초기화
		tree = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}
		int a, b, c;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			tree[a].add(new Node(b, c));
			tree[b].add(new Node(a, c));
		}
		// parent, depth 초기화
		H = 0;
		for (int i = 1; i <= N; i *= 2) {
			H++;
		}
		parent = new int[H][N + 1];
		maxDist = new int[H][N + 1];
		minDist = new int[H][N + 1];
		depth = new int[N + 1];
		// depth 초기화
		dfs(1, 1);
		// parent, maxDist, minDist 초기화
		for (int i = 1; i < H; i++) {
			for (int j = 0; j < N + 1; j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
				maxDist[i][j] = Math.max(maxDist[i-1][j], maxDist[i-1][parent[i-1][j]]);
				minDist[i][j] = Math.min(minDist[i-1][j], minDist[i-1][parent[i-1][j]]);
				}
		}
		
		K = Integer.parseInt(br.readLine());
		int[] answer = new int[2];
		int d, e;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
	
			answer = LCA(d, e);
			sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
		}
		System.out.println(sb);
	}
	
	static int[] LCA(int a, int b) {
		// 1. 더 깊은 노드 찾기
		if(depth[a] < depth[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		// 2. depth 맞춰주기
		int min = 1000001;
		int max = -1;
		for (int i = H - 1; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[a] - depth[b]) {
				min = Math.min(min, minDist[i][a]);
				max = Math.max(max, maxDist[i][a]);
				a = parent[i][a];
			}
		}	
		// 3. depth가 같은 값이 같다면 반환
		if (a == b) {
			return new int[] {min, max};
		}
		// 4. depth가 같은 값이 다르다면 같아질 때 까지..
		for (int i = H - 1; i >= 0; i--) {
			if (parent[i][a] != parent[i][b]) {
				min = Math.min(min, Math.min(minDist[i][a], minDist[i][b]));
				max = Math.max(max, Math.max(maxDist[i][a], maxDist[i][b]));
				a = parent[i][a];
				b = parent[i][b];
			}
		}
		
		min = Math.min(min, Math.min(minDist[0][a], minDist[0][b]));
		max = Math.max(max, Math.max(maxDist[0][a], maxDist[0][b]));
		
		return new int[] {min, max};
	}
	
	static void dfs(int n, int cnt) {
		// 체크인
		depth[n] = cnt;
		// 연결 순회
		for (int i = 0; i < tree[n].size(); i++) {
			int next = tree[n].get(i).end;
			// 갈 수 있?
			if (depth[next] == 0) {
				// 가
				dfs(next, cnt + 1);
				parent[0][next] = n;
				maxDist[0][next] = tree[n].get(i).weight;
				minDist[0][next] = tree[n].get(i).weight;
			}
		}
	}
}

class Node{
	int end;
	int weight;
	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}
}
