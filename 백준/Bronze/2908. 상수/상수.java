import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String a = st.nextToken();
        String b = st.nextToken();
        String ra = "";
        String rb = "";
        
        for(int i = 2; i >= 0; i --){
            ra += a.charAt(i);
            rb += b.charAt(i);
        }
        
        System.out.println(Integer.parseInt(ra) > Integer.parseInt(rb)? ra : rb);
    }
}