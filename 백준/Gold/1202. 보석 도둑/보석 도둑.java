import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static List<Integer> bag;
	static List<Jewel> jewel;
	static PriorityQueue<Long> price;

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    bag = new ArrayList<>();
	    jewel = new ArrayList<>();
	    price = new PriorityQueue<Long>(Collections.reverseOrder());

	    for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
	    	jewel.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
	    for (int i = 0; i < K; i++) {
	    	bag.add(Integer.parseInt(br.readLine()));
		    }
	    
		// 1. 가방 오름차순 / 보석 무게 오름차순
	    Collections.sort(bag);
	    Collections.sort(jewel);
	    
		// 2. 가방에 넣을 수 있는 보석 중 : 보석 무게 배열에서 포인터 사용
		// 비싼 보석 : pq
	    long sum = 0;
	    int bagPos = 0;
    	int jewelPos = 0;
    	while (true){
            if(bagPos >= bag.size()) {
                break;
            }
            if (jewelPos >= jewel.size()) {
                if (price.isEmpty() == false) {
                    sum += price.poll();                    
                }
                bagPos++;               
            } else if (bag.get(bagPos) >= jewel.get(jewelPos).weight) {
                price.add((long) jewel.get(jewelPos).price);
                jewelPos++;
            } else {
                if (price.isEmpty() == false) {
                    sum += price.poll();                    
                }
                bagPos++;
            }
        }
	    
	    System.out.println(sum);
	}
}

class Jewel implements Comparable<Jewel> {
	int weight;
	int price;
	
	public Jewel(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
	
	@Override
	public int compareTo(Jewel o) {
		return weight - o.weight;
	}
	
}