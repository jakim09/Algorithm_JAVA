import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int max = -1;
	static String[] words;
	static boolean[] visited = new boolean[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		words = new String[n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			str = str.replace("anta", "");
	        str = str.replace("tica", "");
			words[i] = str;
		}
		
		visited['a'-'a'] = true;
		visited['c'-'a'] = true;
		visited['i'-'a'] = true;
		visited['n'-'a'] = true;
		visited['t'-'a'] = true;
		
		if(k < 5) {
			max = 0;
		} else if (k == 26) {
			max = n;
		} else {
			dfs(0, k-5);
		}
		System.out.println(max);
	}
	
	static void dfs(int u, int depth) {				
		if(depth == 0) {
			int cnt = 0;
            for(int i = 0; i < n; i++) {
                boolean read = true;
                for(int j = 0; j < words[i].length(); j++) {
                    if(!visited[words[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if(read) {
                	cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
		}
		
		for (int i = u; i < 26; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				dfs(i, depth-1);
				visited[i] = false;
			}
		}
	}
}
