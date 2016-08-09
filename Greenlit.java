import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greenlit {

    public static void main(String[] args) {
        // This method is provided purely for testing. It will not be called by the
        // grading robot.
        System.out.println(run(Arrays.asList(1d, 2d), Arrays.asList(200, 100)));

    }

    public static double run(List<Double> prices, List<Integer> demand) {
        int max_index = 0;
        double max_price = 0.0;
        double max = 0.0;
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i)*demand.get(i) > max) {
                max = prices.get(i)*demand.get(i);
                max_price = prices.get(i);
                max_index = i;
            }
        }
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i)*demand.get(i) == max) {
                if (prices.get(i) < max_price) {
                    max_price = prices.get(i);
                    max_index = i;
                }
            }
        }
        return prices.get(max_index);
    }
}
