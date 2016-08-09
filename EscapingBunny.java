import java.util.Arrays;
import java.util.List;

public class EscapingBunny {

    private static int[][] field;
    public static void main(String[] args) throws Exception {
        // This method is provided purely for testing. It will not be called by the
        // contest server.
        System.out.println(run(2, 2, Arrays.asList(
                new int[]{1, 2}
        ))); // -> 1

        System.out.println(run(3, 3, Arrays.asList(
                new int[]{2, 2}
        ))); // -> 2

        System.out.println(run(3, 3, Arrays.asList(
                new int[]{3, 2}
        ))); // -> 3

        System.out.println(run(5, 5, Arrays.asList(
                new int[]{1, 2},
                new int[]{3, 3}
        ))); // -> 17
    }

    public static long run(int holeX, int holeY, List<int[]> traps) {
        field = new int[holeX+1][holeY+1];
        // Implement your solution in this method, without changing the signature.
        return help(1, 1, holeX, holeY, traps);
    }

    private static int help (int x, int y, int holeX, int holeY, List<int[]> traps) {
        if (x == holeX && y == holeY) {
            return 1;
        }
        if (x > holeX || y > holeY || x < 1 || y < 1) {
            return 0;
        }
        if (field[x][y] > 0) {
            return field[x][y];
        }
        for (int i = 0; i < traps.size(); i++) {
            if (traps.get(i)[0] == x && traps.get(i)[1] == y) {
                return 0;
            }
        }
        int sum =  help(x + 1, y, holeX, holeY, traps) + help(x, y + 1, holeX, holeY, traps);
        if (sum > 0) {
            field[x][y] = sum;
        }
        return sum;
    }

}

