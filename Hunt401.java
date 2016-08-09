import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by snsms on 7/5/16.
 */
public class Hunt401 {

    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<Character> validChars = new ArrayList<>();
        validChars.add('A');
        validChars.add('H');
        validChars.add('I');
        validChars.add('M');
        validChars.add('O');
        validChars.add('T');
        validChars.add('U');
        validChars.add('V');
        validChars.add('W');
        validChars.add('X');
        validChars.add('Y');
        validChars.add('1');
        validChars.add('8');
        while (kb.hasNextLine()) {
            String word = kb.nextLine().trim();
            if (word == "") {
                break;
            }
            boolean isP = isPalindrome(word);
            boolean isM = isMirrored(word, validChars);
            if (isP && isM) {
                System.out.println(word + " -- is a mirrored palindrome.\n");
            } else if (isP) {
                System.out.println(word + " -- is a regular palindrome.\n");
            } else if (isM) {
                System.out.println(word + " -- is a mirrored string.\n");
            } else {
                System.out.println(word + " -- is not a palindrome.\n");
            }
        }
    }

    private static boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        if (first == last) {
            return isPalindrome(word.substring(1, word.length()-1));
        } else {
            return false;
        }
    }

    private static boolean isMirrored(String word, ArrayList<Character> validChars) {
        if (word.length() == 0) {
            return true;
        }
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        if ((word.length() == 1 && validChars.contains(first))) {
            return true;
        } else if (word.length() == 1) {
            return false;
        }
        if ((first == last && validChars.contains(first))||
                ((first == 'E' && last == '3') || first == '3' && last == 'E') ||
                ((first == 'Z' && last == '5') || first == '5' && last == 'Z') ||
                ((first == 'J' && last == 'L') || first == 'L' && last == 'J') ||
                ((first == 'S' && last == '2') || first == '2' && last == 'S')) {
            return isMirrored(word.substring(1, word.length()-1), validChars);
        } else {
            return false;
        }
    }
}
