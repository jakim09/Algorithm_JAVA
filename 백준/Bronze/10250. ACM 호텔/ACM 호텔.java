import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            int x = n / h + 1;
            int y = n % h;
            
            if(y == 0) {
            	y = h;
            	x--;
            }
            
            if(x >= 1 && x <= 9){
                System.out.println(y + "0" + x);
            } else {
                System.out.println("" + y + x);
            }
            

        }
    }
}