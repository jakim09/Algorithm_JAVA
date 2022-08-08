import java.util.*;
import java.io.*;

public class Main {
    static int N, M, day;
    static int[][] arr;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<xy> q;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    q.add(new xy(j, i, day));
                } else if(arr[i][j] == 0){
                    cnt++;
                }
            }
        }
        if(cnt == 0){
            day = 0;
        } else{
            bfs();
            cnt = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if(arr[i][j] == 0){
                        cnt++;
                    }
                }
            }
            if(cnt != 0){
                day = -1;
            }
        }
        System.out.println(day);
    }                  

    static void bfs(){
        while(!q.isEmpty()){
            xy cur = q.poll();
            day = cur.day;
            for(int i = 0; i < 4; i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                if(0 <= newX && newX < M && 0 <= newY && newY < N){
                    if(arr[newY][newX] == 0){
                        arr[newY][newX] = 1;
                        q.add(new xy(newX, newY, cur.day + 1));
                    }
                }
            }
        }
    }
}

class xy{
    int x;
    int y;
    int day;
	public xy(int x, int y, int day) {
		super();
		this.x = x;
		this.y = y;
		this.day = day;
	}
}