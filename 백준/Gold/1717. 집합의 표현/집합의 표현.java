import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M; 
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		
		// 초기화
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 0) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			} else {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		parent[aRoot] = bRoot;
	}
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}
}
