import java.util.Scanner;

/**
 * Created by snsms on 7/3/16.
 */
class Hunt11727 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        for (int m = 1; m <= t; m++) {
            int i = kb.nextInt();
            int j = kb.nextInt();
            int k = kb.nextInt();
            if ((i <= j && j <= k) || (k <= j && j <= i)) {
                System.out.println("Case " + m + ": " + j);
            } else if ((j <= i && i <= k) || (k <= i && i <= j)) {
                System.out.println("Case " + m + ": " + i);
            } else {
                System.out.println("Case " + m + ": " + k);
            }
        }
    }
}
