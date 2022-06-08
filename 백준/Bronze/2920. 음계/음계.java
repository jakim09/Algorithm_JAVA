import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        String answer = "";
        int asc = 1;
        int desc = 8;
        int i;
        for(i = 0; i < 8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(i = 0; i < 8; i++){
            if(asc == arr[i]){
                asc++;
            } else if (desc == arr[i]){
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