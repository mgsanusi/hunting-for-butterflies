import java.util.Scanner;

/**
 * Created by snsms on 7/3/16.
 */
class Hunt11799 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        kb.nextLine();
        for (int i = 1; i <= t; i++) {
            String[] line = kb.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            String result = "Case " + i + ": ";
            int max = 0;
            for (int j = 1; j <= n; j++) {
               if (Integer.parseInt(line[j]) > max) {
                    max = Integer.parseInt(line[j]);
               }
            }
            result += max;
            System.out.println(result);
        }
    }
}
