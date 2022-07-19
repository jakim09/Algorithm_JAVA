import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static long T;
    static int N, M;
    static long[] inputA, inputB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Long.parseLong(br.readLine());

        N = Integer.parseInt(br.readLine());
        inputA = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputA[i] = Long.parseLong(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        inputB = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            inputB[i] = Long.parseLong(st.nextToken());
        }
        
    	// 1. subA, subB 구하기
        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            long sum = inputA[i];
            subA.add(sum);
            for (int j = i + 1; j < N; j++) {
                sum += inputA[j];
                subA.add(sum);
            }
        }
        
        for (int i = 0; i < M; i++) {
        	long sum = inputB[i];
        	subB.add(sum);
        	for (int j = i + 1; j < M; j++) {
        		sum += inputB[j];
        		subB.add(sum);
        	}
        }
        
    	// 2. 정렬
        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());
        
    	// 3. 2Pointer
        int p1 = 0, p2 = 0;
        long result = 0;
        while(p1 < subA.size() && p2 < subB.size()) {
        	long currentA = subA.get(p1);
        	long currentB = subB.get(p2);
        	long sum = currentA + currentB;
        	// 1. sum == T : 같은 수 체크 후 result 구하기
        	if (sum == T) {
        		long countA = 0, countB = 0;
        		while (p1 < subA.size() && subA.get(p1) == currentA) {
        			countA++;
        			p1++;
        		} 
        		while (p2 < subB.size() && subB.get(p2) == currentB) {
        			countB++;
        			p2++;
        		}
        		result += countA * countB;
        	} else if (sum > T) {
        	// 2. sum > T : p2++
        		p2++;
        	} else {
        	// 3. sum < T : p1++
        		p1++;
        	}
        }
        System.out.println(result);
    }
}
