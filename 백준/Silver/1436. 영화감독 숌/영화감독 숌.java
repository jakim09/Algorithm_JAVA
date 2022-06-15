import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int i = 666;
		
		while (cnt < N) {
            i++;
			if(String.valueOf(i).contains("666")) {
				cnt++;
			}
		}
		System.out.println(i);
	}
}