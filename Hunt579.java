import java.util.Scanner;

/**
 * Created by snsms on 7/4/16.
 */
public class Hunt579 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        while (kb.hasNextLine()) {
            String[] line = kb.nextLine().split(":");
            int hour = Integer.parseInt(line[0]); // position = 6*hour + .5*min
            int min = Integer.parseInt(line[1]); // 1 min = 6 degrees = 1/60th of 1/12th of 360deg = .5 degree
                                                // position = 6*min
            if (hour == 0 && min == 0) {
                break;
            }
            if (hour == 12) {
                hour = 0;
            }

            double h_pos = 30*hour + 0.5*min;
            double m_pos = 6*min;

            double ang = 0;
            if (h_pos - m_pos >= 0) {
                ang = h_pos - m_pos;
            } else {
                ang = m_pos - h_pos;
            }
            if (ang > 180) {
                ang = 360-ang;
            }
            System.out.printf("%.3f\n", ang);
        }
    }
}
