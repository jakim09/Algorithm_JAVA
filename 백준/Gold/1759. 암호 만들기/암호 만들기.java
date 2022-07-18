import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static String[] alpa;
	static LinkedList<String> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpa = new String[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpa[i] = st.nextToken();
		}
		
		Arrays.sort(alpa);
		result = new LinkedList<>();

		dfs(0, 0, 0, -1, "");
		
		for(String str : result) {
			System.out.println(str);
		}
	}
	
	static void dfs(int length, int ja, int mo, int current, String pwd) {
		// 1. 체크인 - 생략가능
		// 2. 목적지 : length == L / ja 2개, mo 1개 이상
		if(length == L) {
			if(ja >= 2 && mo >= 1) {
			//정답처리
				result.add(pwd);
			}
		} else {
			// 3. 연결된 곳 : current + 1 ~ C
			for (int i = current + 1; i < C; i++) {
				// 4. 갈 수 있는가 : 전부 가능
				// 5. 간다 : ja, mo
				if(alpa[i].equals("a") || alpa[i].equals("e") || alpa[i].equals("i") || alpa[i].equals("o") || alpa[i].equals("u")) {
					dfs(length + 1, ja, mo + 1, i, pwd + alpa[i]);
				} else {
					dfs(length + 1, ja + 1, mo, i, pwd + alpa[i]);	
				}
			}
			// 6. 체크아웃 - 생략가능
		}
	}
}