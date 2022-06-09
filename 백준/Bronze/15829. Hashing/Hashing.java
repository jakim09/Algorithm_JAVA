import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = 1234567891;
        BigInteger r = new BigInteger("31");
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long sum = 0;
        
        for (int i = 0; i < L; i++){
            sum += r.pow(i).mod(BigInteger.valueOf(m)).multiply(BigInteger.valueOf(str.charAt(i) - 'a' + 1)).longValue();
        }
        
        System.out.println(sum % m);
        
    }
}
