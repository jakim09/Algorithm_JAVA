import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        
        sb.append(" ".repeat(n-1)).append("*").append("\n");
        for(int i = 2; i < n; i++){
            sb.append(" ".repeat(n-i)).append("*").append(" ".repeat(2*(i-1)-1)).append("*").append("\n");
        }
        if(n != 1) {
        	sb.append("*".repeat(2*n-1));
        }
        System.out.println(sb);
    }
}