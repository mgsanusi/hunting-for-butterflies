import java.util.Scanner;

/**
 * Created by snsms on 7/3/16.
 */
class Hunt573 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        while (kb.hasNextLine()) {
            String[] line = kb.nextLine().split(" ");
            int h = Integer.parseInt(line[0]); // height of well
            int u = Integer.parseInt(line[1]); // distance during day
            int d = Integer.parseInt(line[2]); // slide down
            int f = Integer.parseInt(line[3]); // fatigue factor

            if (h == 0) {
                break;
            }

            double height = 0;
            int day = 1;
            double previous_day = u;

            while (!(height > h || height < 0)) {
                System.out.println("initial height: " + height);
                System.out.println("distance climbed: " + previous_day);
                if (previous_day >= 0) {
                    height += previous_day;
                        previous_day -= previous_day * (f / 100.0);
                }
                if (height > h) {
                    System.out.println("success on day " + day);
                    break;
                }
                height -= d;
                if (height < 0) {
                    System.out.println("failure on day " + day);
                    break;
                }
                day++;
            }
        }
    }
}
