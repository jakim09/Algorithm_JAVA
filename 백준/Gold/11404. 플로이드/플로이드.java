import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static long INF = 1000000000;
	static long[][] dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new long[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
            	dist[i][j] = INF;
 
                if (i == j) {
                	dist[i][j] = 0;
                }
            }
        }
		int a, b, c;
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = Math.min(dist[a][b], c);
		}
		
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}		
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				if(dist[i][j] == INF) {
					dist[i][j] = 0;
				}
				sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}