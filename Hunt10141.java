
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by snsms on 7/3/16.
 */
class Hunt10141 {
    public static void main (String [] args) {
        Scanner kb = new Scanner(System.in);
        int cas = 1;
        String result = "";
        while (kb.hasNextLine()) {
            int n = kb.nextInt();
            int p = kb.nextInt();
            kb.nextLine();
            ArrayList<Proposal> props = new ArrayList<>();
            if (n == 0 && p == 0) {
                break;
            }

            ArrayList<String> reqs = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
               reqs.add(kb.nextLine());
            }

            int max = 0;
            for (int i = 0; i < p; i++) {
                String name = kb.nextLine();
                double d = kb.nextDouble();
                int r = kb.nextInt();
                kb.nextLine();
                String[] reks = new String[r];

                int reks_met = 0;
                for (int j = 0; j < r; j++) {
                    String requirement = kb.nextLine();
                    if (reqs.contains(requirement)) {
                        reks_met++;
                    }
                    reks[j] = requirement;
                }
                if (reks_met > max) {
                    max = reks_met;
                }
                Proposal proposal = new Proposal(name, d, r, reks_met, reks);
                props.add(proposal);
            }
            Proposal min_price = new Proposal("", Double.MAX_VALUE, 0, 0, new String[0]);
            for (Proposal each : props) {
                if (each.rm == max && each.d < min_price.d) {
                    min_price = each;
                }
            }
            if (result.length() != 0) {
                result +=  "\n\n";
            }
            result += "RFP #" + cas + "\n" + min_price.name;
                cas++;
        }
        System.out.println(result);
    }

    static class Proposal {
        public String name;
        public double d;
        public int r;
        public int rm;
        public String[] reqs;

        public Proposal(String name, double d, int r, int rm, String[] reqs) {
            this.name = name;
            this.d = d;
            this.r = r;
            this.rm = rm;
            this.reqs = reqs;
        }
    }
}
