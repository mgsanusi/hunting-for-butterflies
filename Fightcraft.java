public class Fightcraft {

    public static void main(String[] args) {
        // This method is provided purely for testing. It will not be called by the
        // contest server.

        System.out.println(fight(100000, 100, 50, 100, 150));
        System.out.println(fight(100000, 1000, 50, 100, 150));
    }

    public static Double fight(int monsterHp, int monsterDps, int healerHps,
                               int attackDps, int timeLimit) {
        // Implement your solution in this method, without changing the signature.

        double min_time = timeLimit+1;
        for (int i = 0; i < 10; i++) {
            // i = # healers
            if (i*healerHps < monsterDps) {
                continue;
            }
            if (monsterHp/((9.0-i)*attackDps) < min_time) {
               min_time = monsterHp/((9.0-i)*attackDps);
            }
        }
        if (min_time > timeLimit) {
           return null;
        }
        return min_time;
    }
}

