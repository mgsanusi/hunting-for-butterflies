
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by snsms on 7/5/16.
 */
public class Hunt10646 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        kb.nextLine();
        for (int i = 1; i <= t; i++) {
            String[] cards = new String[52];
            for (int j = 0; j < 52; j++) {
                cards[j] = kb.next();
            }
            int top_of_pile = 26;
            int y = 0;
            for (int j = 0; j < 3; j++) {
                String top = cards[top_of_pile];
                if (Character.isDigit(top.charAt(0))) {
                   y += Character.getNumericValue(top.charAt(0));
                    top_of_pile -= 1 + (10-Character.getNumericValue(top.charAt(0)));
                } else {
                    y += 10;
                    top_of_pile -= 1;
                }
            }
            ArrayList<String> new_cards = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(cards, 0, top_of_pile+1)));
            new_cards.addAll(Arrays.asList(Arrays.copyOfRange(cards, 27, cards.length)));
            System.out.println("Case " + i + ": " + new_cards.get(y-1));
        }
    }
}
