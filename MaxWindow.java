import java.util.Arrays;

public class MaxWindow {
    public static void main(String[] args) {
        // This method is provided purely for testing. It will not be called by the
        // contest server.
        System.out.println(Arrays.toString(maxWindow(6, 4, 3, 2, new int[] {
                -63,  43, -82,  54,  26, -24,
                94, -78,  15,  49,  76, -48,
                -86,  49, -57, -15,  85,  40,
                -19, -48,  75, -22, -66, -55 })));
        System.out.println(Arrays.toString(maxWindow(4, 6, 3, 2, new int[] {
                -63,  43, -82,  54,  26, -24,
                194, 448,  15,  49,  76, 248,
                286,  49, -57, -15,  85,  40,
                -19, -48,  75, -22, -66, -55 })));
    }

    public static int[] maxWindow(int width, int height, int windowWidth, int windowHeight, int[] field) {
        // Implement your solution in this method, without changing the signature.
        int[][] win = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                win[i][j] = field[i + j*(width)];
            }
        }
        int left_x = 0;
        int left_y = 0;
        int max = 0;
        for (int i = 0; i < width-windowWidth+1; i++) {
            for (int j = 0; j < height-windowHeight+1; j++) {
                int this_max = 0;
                for (int k = i; k < windowWidth+i; k++) {
                   for (int l = j; l < windowHeight+j; l++) {
                      this_max += win[k][l];
                   }
                }
                if (this_max > max || (i == 0 && j == 0)) {
                    left_x = i;
                    left_y = j;
                    max = this_max;
                }
            }
        }
        int[] ans = new int[3];
        ans[0] = max;
        ans[1] = left_x;
        ans[2] = left_y;
        return ans;
    }
}

