import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        
        for(int i = 1; i <= n; i++){
        	for(int j = 0; j < i; j++){
                sb.append("*");
            }
        	for(int j = i; j < n; j++){
                sb.append(" ");
            }
            for(int j = i; j < n; j++){
                sb.append(" ");
            }
            for(int j = 0; j < i; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i = 1; i < n; i++){
        	for(int j = i; j < n; j++){
                sb.append("*");
            }
        	for(int j = 0; j < i; j++){
                sb.append(" ");
            }
            for(int j = 0; j < i; j++){
                sb.append(" ");
            }
            for(int j = i; j < n; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}