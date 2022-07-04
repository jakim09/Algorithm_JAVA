import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		System.out.println(makeOne(N, 0));
	}
 
	static int makeOne(int N, int count) {
		if (N < 2) {
			return count;
		}
		return Math.min(makeOne(N / 2, count + 1 + (N % 2)), makeOne(N / 3, count + 1 + (N % 3)));
 
	}
}