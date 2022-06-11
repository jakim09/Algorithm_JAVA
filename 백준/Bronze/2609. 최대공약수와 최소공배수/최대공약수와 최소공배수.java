import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        
        // 최소공약수
        int i;
        for (i = Math.min(n, m); i > 0; i--){
            if(n % i == 0 && m % i == 0){
                System.out.println(i);
                break;
            }
        }
        // 최소공배수
        System.out.println(n * m / i);        
        /*
        // 최소공배수
        for (int i = Math.max(n, m); i <= n * m; i++){
            if(i % n == 0 && i % m == 0){
                System.out.println(i);
                break;
            }
        }
        */
    }
}