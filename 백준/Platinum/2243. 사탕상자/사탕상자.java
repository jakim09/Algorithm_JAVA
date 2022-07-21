import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
    static long[] candy, tree;
    static int MAX = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = 1;
        while (S < MAX) {
        	S *= 2;
        }
        tree = new long[S * 2];
                
        N = Integer.parseInt(br.readLine());
        
        while (N-- > 0) {       
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        if(Integer.parseInt(st.nextToken()) == 1) {
	        	int B = Integer.parseInt(st.nextToken());
	        	int idx = query(1, S, 1, B);
	        	update(1, S, 1, idx, -1);
	        	System.out.println(idx);
	        } else {
	        	int B = Integer.parseInt(st.nextToken());
	        	int C = Integer.parseInt(st.nextToken());
	        	update(1, S, 1, B, C);
	        }
        }

    }

    static int query(int left, int right, int node, int count) {
    	// 1. leaf에 도착했을 때 : 사탕 번호 반환
    	if (left == right) {
    		return left;
    	}
    	else {
    		int mid = (left + right) / 2;
        	// 2. 왼쪽 >= count : 왼쪽으로 이동
    		if(tree[node * 2] >= count) {
    			return query(left, mid, node * 2, count);
    		}
    		// 3. 왼쪽 < conut : 오른쪽으로 이동
    		else {
    			count -= tree[node * 2];
    			return query(mid + 1, right, node * 2 + 1, count);
    		}
    	}
    }
    
    static void update(int left, int right, int node, int target, long diff) {
    	// 연관없음
    	if(target < left || right < target) {
    		return;
    	} else {
    	// 연관있음 : 현재 노드에 diff 반영 -> 자식에게 diff 전달
    		tree[node] += diff;
    		// leaf node일 때
    		if(left != right) { 
    			int mid = (left + right) / 2;
    			update(left, mid, node * 2, target, diff);
    			update(mid + 1, right, node * 2 + 1, target, diff);
    		}
    	}
    }
}
