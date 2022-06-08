import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if(m >= 45){
            m -= 45;
        } else {
            if(h == 0){
                h = 23;
            } else {
                h--;
            }
           m = 60 - (45 - m);
        }
        
        System.out.println(h + " " + m);
    }
}