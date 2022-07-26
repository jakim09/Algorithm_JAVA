import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static int order[];
	static boolean isCut[];
	static int cnt;
	static ArrayList<Integer> adj[];
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		order = new int[V + 1];
		isCut = new boolean[V + 1];
		adj = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		int a, b;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		for (int i = 1; i <= V; i++) {
			if(order[i] == 0) {
				dfs(i, true);
			}
		}
		int ans = 0;
		for (int i = 1; i <= V; i++) {
			ans += isCut[i] ? 1 : 0;
		}
		sb.append(ans + "\n");
		for(int i = 1; i <= V; i++) {
			if (isCut[i]) {
				sb.append(i + " ");				
			}
		}
		System.out.println(sb);
	}
	
	static int dfs(int cur, boolean isRoot) {
		order[cur] = ++cnt;
		int ret = cnt;
		int child = 0;
		for (int next : adj[cur]) {
			if(order[next] == 0) {
				child++;
				int low = dfs(next, false);
				if(!isRoot && low >= order[cur]) {
					isCut[cur] = true;
				}
				ret = Math.min(ret, low);
			} else {
				ret = Math.min(ret, order[next]);
			}
		}
		if (isRoot && child > 1) {
			isCut[cur] = true;
		}
		return ret;
	}
}
