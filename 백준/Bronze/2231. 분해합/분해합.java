import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i = 0; i < n; i++){
            int m = i + numberSum(i);
            if(n == m){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
    public static int numberSum(int a){
        if(a < 10){
            return a;
        } 
        return a % 10 + numberSum(a/10);
    }
}