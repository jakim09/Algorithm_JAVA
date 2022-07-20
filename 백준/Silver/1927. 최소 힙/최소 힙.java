import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int N;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < N; i++) {
        	int x = Integer.parseInt(br.readLine());
        	if (x == 0) {
        		sb.append(delete()).append("\n");
        	} else if (x > 0) {
        		insert(x);
        	}
        }
        System.out.println(sb);
	}
	
	static void insert(int val) {
		// 1. leaf 마지막에 삽입
		list.add(val);
		// 2. 부모와 비교 후 조건에 맞지 않으면 Swap
		// 3. 조건이 만족되거나 root까지 반복
		int current = list.size() - 1;
		int parent = current / 2;
		while(true) {
			if(parent == 0 || list.get(parent) <= list.get(current)) {
				break;
			}
			
			int temp = list.get(parent);
			list.set(parent, list.get(current));
			list.set(current, temp);
			
			current = parent;
			parent = current / 2;
		}
	}
	
	static int delete() {
		if(list.size() == 1) {
			return 0;
		}
		// 1. Root에 leaf 마지막 데이터 가져옴
		int top = list.get(1);
		list.set(1, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		// 2. 자식과 비교 후 조건이 맞지 않으면 Swap
		// 3. 조건이 연속되거나 leaf까지(자식이 없을 때 leaf) 반복
		int currentPos = 1;
		while (true) {
			int leftPos = currentPos * 2;
			int rightPos = currentPos * 2 + 1;
			
			// 왼쪽 자식 먼저 확인
			if(leftPos >= list.size()) {
				break;
			}
			int minValue = list.get(leftPos);
			int minPos = leftPos;
			
			// 오른쪽 자식 확인
			if (rightPos < list.size() && minValue > list.get(rightPos)) {
				minValue = list.get(rightPos);
				minPos = rightPos;
			}
			
			// Swap
			if(list.get(currentPos) > minValue) {
				int temp = list.get(currentPos);
				list.set(currentPos, minValue);
				list.set(minPos, temp);
				currentPos = minPos;
			} else {
				break;
			}
		}
		
		return top;
	}
}
