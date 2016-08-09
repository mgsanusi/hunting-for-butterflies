import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by snsms on 7/5/16.
 */
public class Hunt3399 {
    public static void main (String[] argS) {
        Scanner kb = new Scanner(System.in);
        while (kb.hasNextLine()) {
            String[] cards = kb.nextLine().split(" ");
            if (Integer.parseInt(cards[0]) == 0) {
                break;
            }
            ArrayList<Integer> hers = new ArrayList<Integer>();
            ArrayList<Integer> his = new ArrayList<Integer>();
            for (int i = 0; i < 5; i++) {
                if (i >= 3) {
                    his.add(Integer.parseInt(cards[i]));
                } else {
                    hers.add(Integer.parseInt(cards[i]));
                }
            }
            Collections.sort(hers);
            Collections.sort(his);
            if (hers.get(0) > his.get(1) || hers.get(1) > his.get(1)) { // GGG BB || GG [BBG]
                System.out.println(-1);
            } else {
                int card = 0;
                if (his.get(0) > hers.get(2)) { // BB GGG
                   card = lowest(his, hers);
                } else if (his.get(1) > hers.get(2)) { // B[G+][B,G]
                    if (his.get(0) > hers.get(1)) {    // BGBGG
                        card = closest_lowest(his, hers, hers.get(1)); // make BGBBGG
                    } else {                         // BG
                        card = closest_lowest(his, hers, hers.get(2));
                    }
                } else if (his.get(1) > hers.get(1) && his.get(0) > hers.get(1)) {
                    card = closest_lowest(his, hers, hers.get(1));
                } else {
                    card = -1;
                }
                System.out.println(card);
            }
        }
    }
    private static int closest_lowest(ArrayList<Integer> his, ArrayList<Integer> hers, int x) {
        for (int i = x + 1; i <= 52; i++) {
            if (hers.contains(i) || his.contains(i)) {
                continue;
            } else {
                return i;
            }
        }
        return -1;
    }
    private static int lowest(ArrayList<Integer> his, ArrayList<Integer> hers) {
        for (int i = 1; i <= 52; i++) {
            if (his.contains(i) || hers.contains(i)) {
                continue;
            } else {
                return i;
            }
        }
        return -1;
    }
}
