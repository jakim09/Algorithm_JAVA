import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i = 0; i < n; i++){
            int sum = 0;
            int x = i;
            while(x != 0){
                sum += x % 10;
                x /= 10;
            }
            int m = i + sum;
            
            if(n == m){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}