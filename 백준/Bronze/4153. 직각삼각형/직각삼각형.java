import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        
        
        
        while(x != 0 && y != 0 && z != 0){
            int max = Math.max(x, Math.max(y, z));
            
            if(max == x){
                x = z;
            } else if (max == y) {
                y = z;
            }
            
            if(Math.pow(x,2) + Math.pow(y,2) == Math.pow(max,2)){
                System.out.println("right");
            } else {
                System.out.println("wrong");                
            }
            
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
        }
    }
}