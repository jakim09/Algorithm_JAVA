import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        String str1 = "";
        String str2 = "";
        String answer = "";
        int i;
        for(i = 0; i < 8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(i = 0; i < 8; i++){
            if(arr[i] != i+1){
                str1 = "mixed";
                break;
            }
        }
        if(i == 8){
            str1 = "ascending";
        }
        for(i = 0; i < 8; i++){
            if(arr[i] != 8-i){
                str2 = "mixed";
                break;
            }
        }
        if(i == 8){
            str2 = "descending";
        }
        
        if(str1 == "ascending"){
            answer = str1;
        } else {
            answer = str2;
        }
       System.out.println(answer);
    }
}