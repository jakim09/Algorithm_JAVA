import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (str != null){
        	if(str.length() >= 10) {
            System.out.println(str.substring(0,10));
            str = str.substring(10);
        	} else {
        		System.out.println(str);
        		break;
        	}
        }
    }
}