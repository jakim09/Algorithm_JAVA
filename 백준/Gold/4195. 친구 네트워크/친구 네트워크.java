import java.io.*;
import java.util.*;

public class Main {
	static int T, F;
	static List<Integer> parent;
	static List<Integer> count;
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			F = Integer.parseInt(br.readLine());

			int idx = 0;
			map = new HashMap<>();
			parent = new ArrayList<>();
			count = new ArrayList<>();
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				
				String p1 = st.nextToken();
				String p2 = st.nextToken();
				
				if(map.get(p1) == null || map.get(p1) > idx) {
					map.put(p1, idx);
					parent.add(idx++);
					count.add(1);
				}
				if(map.get(p2) == null || map.get(p2) > idx) {
					map.put(p2, idx);
					parent.add(idx++);
					count.add(1);
				} 
				
				union(map.get(p1), map.get(p2));
			
				sb.append(count.get(find(map.get(p1)))).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	static int find(int a) {		 
		if(parent.get(a) == a) {
			return a;
		} else {
			parent.set(a, find(parent.get(a)));
			return parent.get(a);
		}
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			int sum = count.get(aRoot) + count.get(bRoot);
			count.set(aRoot, sum);
			count.set(bRoot, sum);
			if(aRoot < bRoot) {
				parent.set(bRoot, aRoot);
			} else {
				parent.set(aRoot, bRoot);
			}
		}
	}
}
	