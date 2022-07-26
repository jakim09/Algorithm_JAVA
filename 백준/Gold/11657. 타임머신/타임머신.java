import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Node>[] graph;
	static long INF = Long.MAX_VALUE;
	static long[] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
		}
		
		dist = new long[N + 1];
		for (int i = 0; i < N + 1; i++) {
			dist[i] = INF;
		}
		
		StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i] + "\n");
                }
            }
        }
		System.out.println(sb);
	}
	
	public static boolean bellmanFord() {
        dist[1] = 0; // 시작점은 0으로 초기화.
        boolean update = false;
 
        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
        for (int i = 1; i < N; i++) {
            update = false;
 
            // 최단거리 초기화.
            for (int j = 1; j <= N; j++) {
                for (Node Node : graph[j]) {
                    if (dist[j] == INF) {
                        break;
                    }
 
                    if (dist[Node.end] > dist[j] + Node.weight) {
                        dist[Node.end] = dist[j] + Node.weight;
                        update = true;
                    }
                }
            }
 
            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
            if (!update) {
                break;
            }
        }
 
        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Node Node : graph[i]) {
                    if (dist[i] == INF) {
                        break;
                    }
 
                    if (dist[Node.end] > dist[i] + Node.weight) {
                        return true;
                    }
                }
            }
        }
 
        return false;
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