import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static Nominee[] nominees;
	// 사진틀 comparable 사용
	// 출력 시 comparator 사용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		nominees = new Nominee[101];
		List<Nominee> list = new ArrayList<>();		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int k = 0; k < K; k++) {
			int num = Integer.parseInt(st.nextToken());
			//해당 후보가 최초 호출 시
			if(nominees[num] == null) {
				nominees[num] = new Nominee(num, 0, 0, false);
			}
			// 해당 후보가 사진틀에 있을 경우
			if(nominees[num].isIn == true) {
				nominees[num].count++;
			}
			else {
				// 해당 후보가 사진틀에 없음
				// 사진틀이 가득 찬 경우
				if(list.size() == N) {
					// 정렬, 지울 후보 선정, 제거
					Collections.sort(list);
					Nominee nominee = list.remove(0);
					nominee.isIn = false;
				}
				// 사진틀에 여유가 있는 경우
				nominees[num].count = 1;
				nominees[num].isIn = true;
				nominees[num].timeStamp = k;
				list.add(nominees[num]);
			}
		}
		
		Collections.sort(list, new Comparator<Nominee>() {
			@Override
			public int compare(Nominee o1, Nominee o2) {
				return Integer.compare(o1.num, o2.num);
			}
		});
		
		for (Nominee n : list) {
			System.out.print(n.num + " ");
		}
		
	}
}

class Nominee implements Comparable<Nominee> {
	int num;
	int count;
	int timeStamp;
	boolean isIn;
	
	public Nominee(int num, int count, int timeStamp, boolean isIn) {
		this.num = num;
		this.count = count;
		this.timeStamp = timeStamp;
		this.isIn = isIn;
	}

	@Override
	public int compareTo(Nominee o) {
		// 1. 추천수 2. 시간
		int comp = Integer.compare(count, o.count);
		if (comp == 0) {
			return Integer.compare(timeStamp, o.timeStamp);
		} else {
			return comp;
		}
	}
}