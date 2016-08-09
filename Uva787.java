import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by snsms on 7/15/16.
 */
public class Uva787 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        while (kb.hasNextInt()) {
            ArrayList<BigInteger> seq = new ArrayList<>();
            long n = kb.nextLong();
            seq.add(BigInteger.valueOf(n));
            while (n != -999999) {
                n = kb.nextLong();
                if (n == -999999) { break; };
                seq.add(BigInteger.valueOf(n));
            }
            BigInteger[] max = new BigInteger[seq.size()];
            BigInteger[] min = new BigInteger[seq.size()];
            max[0] = min[0] = seq.get(0);
            BigInteger curr = seq.get(0);
            for (int i = 1; i < seq.size(); i++) {
              if (seq.get(i).compareTo(BigInteger.ZERO) > 0) {
                max[i] = seq.get(i).max(seq.get(i).multiply(max[i-1]));
                min[i] = seq.get(i).min(seq.get(i).multiply(max[i-1]));
              } else {
                max[i] = seq.get(i).max(min[i-1].multiply(seq.get(i)));
                min[i] = seq.get(i).min(max[i-1].multiply(seq.get(i)));
              }
              curr = curr.max(max[i]);
            }
            System.out.println(curr.toString());
            seq.clear();
        }
    }
}
