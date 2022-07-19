import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int X;
	static int Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        
        int original = (int) ((long) Y * 100 / X);
        int result = -1;
        int left = 0;
        int right = (int) 1e9;
        while (left <= right) {
        	int mid = (left + right) / 2;
        	
        	if((int)((long) (Y + mid) * 100 / (X + mid)) != original) {
        		result = mid;
        		right = mid - 1;
        	} else {
        		left = mid + 1;
        	}
        }
        System.out.println(result);
    }
}
