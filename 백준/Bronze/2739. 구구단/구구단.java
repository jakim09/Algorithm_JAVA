import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 9; i++){
            sb.append(n).append(" * ").append(i).append(" = ").append(n*i + "\n");
        }
        System.out.println(sb);

    }
}