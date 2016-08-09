import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by snsms on 7/5/16.
 */
public class Hunt11221 {
    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        kb.nextLine();
        for (int i = 1; i <= t; i++) {
            String sentence = kb.nextLine().trim();
            sentence = sentence.replace(" ", "");
            sentence = sentence.replace("   ", "");
            sentence = sentence.replace("?", "");
            sentence = sentence.replace("!", "");
            sentence = sentence.replace("(", "");
            sentence = sentence.replace(")", "");
            sentence = sentence.replace(",", "");
            sentence = sentence.replace(".", "");

            ArrayList<Integer> ks = findPerfectSquares(sentence);
            if (ks.size() == 0) {
               System.out.println("Case #" + i + ":\nNo magic :(");
            }
            for (int k : ks) {
                if (isRegularPalindrome(sentence) && isRegularPalindrome(downAndRight(sentence, k))) {
                   System.out.println("Case #" + i + ":\n" + k);
                } else {
                    System.out.println("Case #" + i + ":\nNo magic :(");
                }
            }
            // 1.....k
            // k+1...2k
            // 2k+1..3k
            // nk+1..k^2

            // go right and down
            // go down and right
            // go left and up
            // go up and left

        }
    }

    //checks first and last case
    private static boolean isRegularPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        if (word.charAt(0) == word.charAt(word.length()-1)) {
            return isRegularPalindrome(word.substring(1, word.length()-1));
        }
        return false;
    }

    //then just check if this is a palindrome for two middle cases
    private static String downAndRight(String word, int k) {
        String result = "";
        for (int j = 0; j < k; j++) {
            for (int i = 0; i*k + j < k * k; i++) {
               result += word.charAt(i*k+j);
            }
        }
        return result;
    }

    private static ArrayList<Integer> findPerfectSquares(String sentence) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= sentence.length(); i++) {
            if (sentence.length() == i * i) {
                result.add(i);
            }
        }
        return result;
    }
}
