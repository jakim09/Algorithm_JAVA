import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = -1;
        int idx = 0;
        
        for(int i = 0; i < 9; i++){
            int r = Integer.parseInt(br.readLine());
            if(max < r){
                max = r;
                idx = i+1;
            }
        }
        
        System.out.println(max + "\n" + idx);
        
    }
}