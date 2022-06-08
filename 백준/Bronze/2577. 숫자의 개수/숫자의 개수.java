import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String str = Integer.toString(a * b * c);
        int[] arr = new int[10];
        
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i)-'0']++;
        }
        
        for(int i = 0; i < 10; i++){
            System.out.println(arr[i]);
        }
        
    }
}