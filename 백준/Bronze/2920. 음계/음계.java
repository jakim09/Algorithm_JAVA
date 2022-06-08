import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String answer = "";
        int asc = 1;
        int desc = 8;
        
        for(int i = 0; i < 8; i++){
            int n = Integer.parseInt(st.nextToken());
            if(asc == n){
                asc++;
            } else if (desc == n){
                desc--;
            }
        }
        if(asc == 9){
            answer = "ascending";
        } else if (desc == 1) {
            answer = "descending";
        } else {
            answer = "mixed";
        }
        System.out.println(answer);
    }
}