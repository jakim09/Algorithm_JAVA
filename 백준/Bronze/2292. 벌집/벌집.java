import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0; 
        int pre = 1;
        
        for(int i = 0; i < n; i++){
            if (n == 1) {
                result = 1;
                break;
            } else if (n > pre && n <= (i + 1) * 6 + pre){
                result = i + 2;
                break;
            }
            pre += (i + 1) * 6;
        }
        System.out.println(result);
    }
}