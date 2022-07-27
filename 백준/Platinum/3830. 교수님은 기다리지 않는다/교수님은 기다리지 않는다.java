import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] parent;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while (N != 0 && M != 0) {
			parent = new int[N + 1];
			// 초기화
			for (int i = 1; i < N + 1; i++) {
				parent[i] = i;
			}
			dist = new int[N + 1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				// 기록
				if (c == '!') {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int w = Integer.parseInt(st.nextToken());
					
					union(a, b, w);
				} 
				// 질문
				else if (c == '?') {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
	
					if(find(a) != find(b)) {
						sb.append("UNKNOWN").append("\n");
					} else {
						sb.append(dist[b] - dist[a]).append("\n");
					}	
				}
			}
			
			// 다음 입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}
	
	static void union(int a, int b, int w) {
		int aRoot = find(a);
		int bRoot = find(b);
		dist[bRoot] = dist[a] - dist[b] + w;
		parent[bRoot] = aRoot;
	}
	
	static int find (int a) {
		if(parent[a] == a) {
			return a;
		} else {
			int p = find(parent[a]);
			dist[a] += dist[parent[a]];
			return parent[a] = p;
		}
	}
}
