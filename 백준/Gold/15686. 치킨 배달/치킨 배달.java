import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int result = Integer.MAX_VALUE;
    static int[][] map, dp;
    static List<Point> stores;
    static boolean[] check;
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        stores = new ArrayList<>();
        dp = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j < N + 1; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 2) {
        			stores.add(new Point(i, j));
        		}
        		dp[i][j] = Integer.MAX_VALUE;
        	}
        }
        
        check = new boolean[stores.size()];
        // 치킨집이 안 없어지는 경우
        if(stores.size() == M) {
        	Arrays.fill(check, true);
        	result = calDist();
        } else { // 주어진 치킨집 중 M개의 치킨집에 대한 치킨 거리를 조합으로 계산
        	 combination(stores, check, 0, stores.size(), M);
        }
        System.out.println(result);
    }
    
    static int calDist() {
    	int dist;
    	Point store;
    	for (int i = 1; i < N + 1; i ++) {
    		for (int j = 1; j < N + 1; j++) {
    			if(map[i][j] == 1) { // 집인 경우
    				for(int k = 0; k < stores.size(); k++) {
    					if(check[k] == true) { // 갈 수 있는 치킨집이면 거리 계산 후 min값 dp에 저장
    						store = stores.get(k);
    						dist = Math.abs(i - store.r) + Math.abs(j - store.c);
    						dp[i][j] = Math.min(dp[i][j], dist);
    					}
    				}
    			}
    		}
    	}
    	
    	int vDist = 0;
    	for (int i = 1; i < N + 1; i++) {
    		for (int j = 1; j < N + 1; j++) {
    			if (map[i][j] == 1) { // 동네의 치킨거리 구하기
    				vDist += dp[i][j];
    			}
    		}
    	}
    	return vDist;
    }
    
    static void combination(List<Point> stores, boolean[] check, int start, int n, int r) {
        if(r == 0) { // r개의 치킨집 경우들 구해서 min값 찾기
        	for (int i = 1; i < N + 1; i++) {
            	for (int j = 1; j < N + 1; j++) {
            		dp[i][j] = Integer.MAX_VALUE;
            	}
            }
        	int vDist = calDist();
        	result = Math.min(result, vDist);
            return;
        } 

        for(int i = start; i < n; i++) {
            check[i] = true;
            combination(stores, check, i + 1, n, r - 1);
            check[i] = false;
        }
    }
}
class Point{
	int r;
	int c;
	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}