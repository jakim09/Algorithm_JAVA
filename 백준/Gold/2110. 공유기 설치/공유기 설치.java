import java.io.*;
import java.util.*;

public class Main {
	static int N, C;
	static int[] house;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		int start = 1;
		int end = house[N-1] - house[0];
		int mid = 0;
		while(start < end) {
			int cnt = 1;
			mid = (start + end + 1) / 2;
			int pre = house[0];
			for(int i = 1; i < N; i++) {
				if(house[i] - pre >= mid) {
					cnt++;
					pre = house[i];
				}
			}
			if (cnt < C) {
				end = mid - 1;
			} else {
				start = mid;
			}
		}
		System.out.println(start);
	}
}
