import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer(br.readLine());

		while(Integer.parseInt(sb.toString()) != 0) {
			String str = sb.toString();
			sb.reverse();
			int i = 0;
			for(i = 0; i < sb.length() / 2; i++) {
				if(str.charAt(i) != sb.charAt(i)) {
					System.out.println("no");
					break;
				}
			}
			
			if(i == sb.length() / 2) {
				System.out.println("yes");
			}
			
			sb = new StringBuffer(br.readLine());
		}		
	}
}
