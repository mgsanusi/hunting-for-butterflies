import java.util.Scanner;

/**
 * Created by snsms on 7/3/16.
 */
class Hunt11172 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        while (t > 0) {
            t--;
            int a = kb.nextInt();
            int b = kb.nextInt();
            String result = "";
            if (a < b) {
                result = "<";
            } else if (a > b) {
                result = ">";
            } else {
                result = "=";
            }
            System.out.println(result);
        }

    }
}
