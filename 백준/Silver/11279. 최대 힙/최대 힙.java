import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < N; i++) {
        	int x = Integer.parseInt(br.readLine());
        	// 값 출력, 제거
        	if(x == 0) {
        		if(q.isEmpty()) { 
        			sb.append(0 + "\n");
        			} else {
                	sb.append(q.poll() + "\n");
                }
        	} else if (x > 0) {
        		// 자연수일 경우 배열에 추가
        		q.add(x);
        	}
        }
        System.out.println(sb);
	}
}
