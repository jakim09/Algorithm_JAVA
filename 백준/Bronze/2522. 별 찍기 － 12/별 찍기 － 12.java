import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        
        for(int i = 1; i < n; i++){
            sb.append(" ".repeat(n-i)).append("*".repeat(i)).append("\n");
        }
        for(int i = n; i > 0; i--){
        	sb.append(" ".repeat(n-i)).append("*".repeat(i)).append("\n");
        }
        System.out.println(sb);
    }
}