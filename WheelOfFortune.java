import java.util.*;

public class WheelOfFortune {

    public static void main(String[] args) {
        // This method is provided purely for testing. It will not be called by the
        // contest server.
        System.out.println(run("__EE _I__A", Arrays.asList("FREE PIZZA", "GOOD PIZZA", "TREE NINJA", "FLEE VISTA", "CAPTAIN OBVIOUSLY WRONG ANSWER")));
        System.out.println(run("L___", Arrays.asList("AAAA", "BBBB", "CCCC")));
        System.out.println(run("L___", Arrays.asList("LOVE", "LAVA", "LAMP")));
        System.out.println(run("M_R__A ", Arrays.asList("MARINA ", "LAVA", "MIRLLA ", "G R  A ", "M R  T")));
    }

    public static String run(String currentState, List<String> dictionary) {
        // Implement your solution in this method, without changing the signature.
        Set<Character> s = new HashSet<>();
        for (String entry : dictionary) {
            ArrayList<Character> guess = new ArrayList<>();
            for (int i = 0; i < entry.length(); i++) {
                if (entry.length() != currentState.length()) {
                    break;
                }
                if (entry.charAt(i) == currentState.charAt(i)) {
                    continue;
                } else if (currentState.charAt(i) == '_') {
                    guess.add(entry.charAt(i));
                } else {
                    guess.clear();
                    break;
                }
            }
            s.addAll(guess);
        }
        ArrayList<Character> chars = new ArrayList<>();
        chars.addAll(s);
        Collections.sort(chars);
        String result = "";
        for (int i = 0; i < chars.size(); i++) {
           result += chars.get(i);
        }
        if (chars.size() == 0) {
            result = "No letters";
        }
        return result;
    }
}

