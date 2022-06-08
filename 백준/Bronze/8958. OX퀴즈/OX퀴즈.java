import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++){
            String str = br.readLine();
            
            int point = 0; // 각 점수
            int sum = 0;
            char pre = str.charAt(0);
            
            if(pre == 'O'){
                point++;
                sum += point;
            }
            for(int j = 1; j < str.length(); j++){
                if(pre == 'O'){
                    if(pre == str.charAt(j)){
                        point++;
                        sum += point;
                        pre = 'O';
                    } else {
                        point = 0;
                        pre = 'X';
                    }
                } else {
                	if(pre != str.charAt(j)){
                        point = 1;
                        sum += point;
                        pre = 'O';
                    }
                }
            }
            
            System.out.println(sum);
        }
    }
}