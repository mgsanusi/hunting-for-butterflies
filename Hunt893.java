import java.util.*;

/**
 * Created by snsms on 7/4/16.
 */
class Hunt893 {
    public static void main (String[] args) {
        Integer[] mons = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        ArrayList<Integer> months = new ArrayList<Integer>(Arrays.asList(mons));
        Scanner kb = new Scanner(System.in);
        while (kb.hasNextLine()) {
            String[] line = kb.nextLine().split(" ");
            int add = Integer.parseInt(line[0]);
            int days = Integer.parseInt(line[1]);
            int month = Integer.parseInt(line[2]);
            int year = Integer.parseInt(line[3]);
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
