import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M; 
	static ArrayList<edge> list;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		list = new ArrayList<>();
		
		// parent 초기화
		for(int i = 0; i < N + 1; i ++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new edge(start, end, weight));
		}
		
		Collections.sort(list);
		
		int e = 0;
		int sum = 0;
		for (int i = 0; i < M; i++) {
			if (find(list.get(i).start) != find(list.get(i).end)) {
				union(list.get(i).start, list.get(i).end);
				sum += list.get(i).weight;
				e++;
			}
			
			if(e == N - 1) {
				break;
			}
		}
		System.out.println(sum);
	}
	static void union (int x, int y) {
		x = find(x);
		y = find(y);
		parent[x] = y;
	}
	
	static int find (int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}
}

class edge implements Comparable<edge> {
	int start;
	int end;
	int weight;
	
	public edge(int start, int end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(edge o) {
		return weight - o.weight;
	}
}
