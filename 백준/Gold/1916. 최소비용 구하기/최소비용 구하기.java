import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}
		
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		dijkstra(s);
		
		System.out.println(dist[e]);
	}
	
	static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		pq.add(new Node(s, 0));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			if(check[cur] == true) {
				continue;
			}
			
			check[cur] = true;
			
			for (Node next : list[cur]) {
				if(dist[next.end] > dist[cur] + next.weight) {
					dist[next.end] = dist[cur] + next.weight;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
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