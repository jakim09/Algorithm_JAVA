import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int s, d;
	static int u, v, p;
	static List<Node>[] graph;
	static int[] dist;
	static int INF = 10000000;
	static boolean[][] check;
	static List<Integer>[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) {
				break;
			}
			
			graph = new ArrayList[N];
			parent = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
				parent[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				p = Integer.parseInt(st.nextToken());
				
				graph[u].add(new Node(v, p));
			}
			
			check = new boolean[N][N];

			dijkstra();
			backTracking(s, d);
			dijkstra();
			
			if(dist[d] == INF) {
				sb.append(-1).append("\n");
			} else {
				sb.append(dist[d]).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		dist = new int[N];
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}
	    queue.add(new Node(s, 0));
	    dist[s] = 0;

	    while(!queue.isEmpty()){
	    	Node curNode = queue.poll();
	    	int cur = curNode.end;
	    	if (curNode.weight > dist[cur])
				continue;
	    	for(Node node : graph[cur]){
	    		int next = node.end;
	    		if(check[cur][next] == true) {
		    		continue;
		    	}
		    	
		    	if(dist[next] == curNode.weight + node.weight) {
		    		parent[next].add(cur);
		    	} else if(dist[node.end] > dist[cur] + node.weight){
	    			dist[node.end] = dist[cur] + node.weight;
					parent[next].clear();
					parent[next].add(cur);
	    			queue.add(new Node(node.end, dist[node.end]));
	    		}
	    	}
	    }
	}
	
	public static void backTracking(int s, int node) {

		if (node == s)
			return;

		for (int n : parent[node]) {

			if (!check[n][node]) {
		    	check[n][node] = true;
				backTracking(s, n);
			}
		}
	}
}

class Node implements Comparable<Node> {
	int end;
	int weight;
	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
	
}
