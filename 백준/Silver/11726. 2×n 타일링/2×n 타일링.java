import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] tile = new int[n+2];
        tile[1] = 1;
        tile[2] = 2;
        for (int i = 3; i <= n; i++) {
        	tile[i] = (tile[i-1] + tile[i-2])%10007;
        }
        System.out.println(tile[n]);
    }
}
