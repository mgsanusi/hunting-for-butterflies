import java.util.Scanner;

/**
 * Created by snsms on 7/3/16.
 */
class Hunt11418 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int k = 1;
        k = kb.nextInt();
        while (k != 0) {
            int n = kb.nextInt();
            int m = kb.nextInt();
            while (k > 0) {
                k--;
                int x = kb.nextInt();
                int y = kb.nextInt();
                if (x == n || y == m) {
                    System.out.println("divisa");
                } else if (x > n && y > m) {
                    System.out.println("NE");
                } else if (x < n && y < m) {
                    System.out.println("SO");
                } else if (x > n && y < m) {
                    System.out.println("SE");
                } else {
                    System.out.println("NO");
                }
            }
            k = kb.nextInt();
        }
    }
}
