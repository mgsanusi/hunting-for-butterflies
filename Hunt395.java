import java.util.*;

/**
 * Created by snsms on 7/6/16.
 */
public class Hunt395 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        kb.nextLine();
        kb.nextLine();
        for (int j = 0; j < t; j++) {
            ArrayList<String> original = new ArrayList<>();
            ArrayList<String> result = new ArrayList<>();
            HashMap<String, ArrayList<String>> dict = new HashMap<>();
            while (kb.hasNextLine()) {
                String line = kb.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (words[i] == "") {
                        continue;
                    }
                    original.add(words[i]);
                    char[] lowercase = words[i].toLowerCase().toCharArray();
                    Arrays.sort(lowercase);
                    String madePerfect = new String(lowercase);
                    if (dict.containsKey(madePerfect)) {
                        dict.get(madePerfect).add(words[i]);
                    } else {
                        ArrayList<String> vals = new ArrayList<>();
                        vals.add(words[i]);
                        dict.put(madePerfect, vals);
                    }
                }
            }
            for (String key : dict.keySet()) {
                if (dict.get(key).size() > 1) {
                    result.add(dict.get(key).get(0));
                }
            }
            Collections.sort(result);
            for (String word : result) {
                System.out.println(word);
            }

        }
    }
}

