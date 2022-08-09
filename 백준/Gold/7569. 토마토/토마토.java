import java.util.*;
import java.io.*;

public class Main {
    static int N, M, H, day;
    static int[][][] arr;
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> q;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < H; i++) {
	        for (int j = 0; j < N; j++){
	            st = new StringTokenizer(br.readLine());
	            for (int k = 0; k < M; k++){
	                arr[i][j][k] = Integer.parseInt(st.nextToken());
	                if(arr[i][j][k] == 1){
	                    q.add(new Point(k, j, i, day));
	                } else if(arr[i][j][k] == 0){
	                    cnt++;
	                }
	            }
	        }
        }
        // 안익은 토마토가 없으면 최소일수 == 0
        if(cnt == 0){
            day = 0;
        } else{
            bfs();
            cnt = 0;
            for (int i = 0; i < H; i++){
                for (int j = 0; j < N; j++){
                	for (int k = 0; k < M; k++) {
	                    if(arr[i][j][k] == 0){
	                        cnt++;
	                    }
                	}
                }
            }
            // bfs() 후에도 안익은 토마토가 있으면 모든 토마토가 익지 못하는 경우
            if(cnt != 0){
                day = -1;
            }
        }
        System.out.println(day);
    }                  

    static void bfs(){
        while(!q.isEmpty()){
            Point cur = q.poll();
            day = cur.day;
            for(int i = 0; i < 6; i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                int newZ = cur.z + dz[i];
                if(0 <= newX && newX < M && 0 <= newY && newY < N && 0 <= newZ && newZ < H){
                    if(arr[newZ][newY][newX] == 0){
                        arr[newZ][newY][newX] = 1;
                        q.add(new Point(newX, newY, newZ, cur.day + 1));
                    }
                }
            }
        }
    }
}

class Point{
    int x;
    int y;
    int z;
    int day;
	public Point(int x, int y, int z, int day) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
	}
}