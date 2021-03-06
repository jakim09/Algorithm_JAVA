import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        int[] arr = new int[n];
        double sum = 0;
        
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]){
                max = arr[i];
            }
        }
        
        for(int i = 0; i < n; i++){
            sum += (double)arr[i] / max * 100;
        }
        
        double average = sum/n;
        
        System.out.println(average);
    }
}