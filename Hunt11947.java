import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by snsms on 7/5/16.
 */
public class Hunt11947 {
    public static void main (String[] args) {
        Integer[] mons = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        ArrayList<Integer> months = new ArrayList<Integer>(Arrays.asList(mons));
        Scanner kb = new Scanner(System.in);
        while (kb.hasNextLine()) {
            String line = kb.nextLine();
            int add = 280;
            int days = Integer.parseInt(line.substring(0, 2));
            int month = Integer.parseInt(line.substring(2, 4));
            int year = Integer.parseInt(line.substring(4, line.length()-1));
            if (add == 0 && days == 0 && month == 0 && year == 0) {
                break;
            }

            if (month == 12) {
                month = 0;
            }

            int days_in_month = months.get(month);
            if (year % 4 == 0 && days_in_month == 28) {
                days_in_month = 29;
            }

            int days_to_add = add;
            while (days + days_to_add > days_in_month) {
                month = (month + 1) % 12;
                if (month == 1) {
                    year++;
                }
                days_to_add -= (days_in_month-days);
                days_in_month = months.get(month);
                if (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0) && days_in_month == 28) {
                    days_in_month = 29;
                }
                days = 0;
            }
            days = days_to_add;
            if (month == 0) {
                month = 12;
            }

            System.out.printf("%d %d %d\n", days, month, year);
        }
    }

}
