import java.util.Scanner;

/**
 * Created by snsms on 7/3/16.
 */
class Hunt11559 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        while (kb.hasNextLine()) {
            int n = kb.nextInt();
            int b = kb.nextInt();
            int h = kb.nextInt();
            int w = kb.nextInt();
            int cost = -1;
            for (int i = 0; i < h; i++) {
                int p = kb.nextInt();
                kb.nextLine();
                String[] ws = kb.nextLine().split(" ");
                if (p * n > b) {
                    continue;
                }
                for (int j = 0; j < w; j++) {
                    if ((Integer.parseInt(ws[j]) >= n) && (p * n < cost || cost == -1)) {
                        cost = p * n;
                    }
                }
            }
            if (cost == -1) {
                System.out.println("stay home");
            } else {
                System.out.println(cost);
            }
        }
    }
}
