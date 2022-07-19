import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] array = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int sum = array[0];
        int low = 0;
        int high = 0;

        while (true) {
            // 1. sum == M -> 답 low++
            if (sum == M) {
                count++;
                sum -= array[low++];
            }
            // 2. sum > M -> low++
            else if (sum > M) {
                sum -= array[low++];
            }
            // 3. sum < M -> high++
            else {
                sum += array[++high];
            }
            if(high == N) {
                break;
            }
        }
        System.out.println(count);
    }
}