import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[10];
        
        for(int i = 0; i < 10; i++){
            arr[i] = Integer.parseInt(br.readLine()) % 42;
        }
        
        int[] result = new int[42];
        
        for(int i = 0; i < 10; i++){
            result[arr[i]]++;
        }
        int cnt = 0;
        for(int i = 0; i < 42; i++){
            if(result[i] != 0){
                cnt++;
            }
        }
        
        System.out.println(cnt);
        
    }
}