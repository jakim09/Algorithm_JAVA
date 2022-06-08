import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        
        str = str.toUpperCase();
        
        int[] arr = new int[26];
        
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i)-'A']++;
        }
        
        int max = -1;
        int idx = -1;
        boolean same = false;
        
        for(int i = 0; i < 26; i++){
            if(max < arr[i]){
                max = arr[i];
                idx = i;
                same = false;
            } else if (max == arr[i]){
                same = true;
            }
        }
        
        if(same){
            System.out.println("?");
        } else {
            char ch = (char) (idx + 'A');
            System.out.println(ch);
        }
        
    }
}