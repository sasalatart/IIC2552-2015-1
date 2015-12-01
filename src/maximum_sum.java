//108

import java.util.Scanner;

public class maximum_sum {

    static int[][] d;
    static int[][] M;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt() + 1;

        M = new int[n][n];
        d = new int[n][n];

        for (int i = 0; i < n; i++) {
            d[0][i] = 0;
            d[i][0] = 0;
            M[0][i] = 0;
            M[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                d[i][j] = s.nextInt();
            }
        }

        s.close();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                M[i][j] = M[i - 1][j] + M[i][j - 1] - M[i - 1][j - 1] + d[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < n; l++) {
                        if (max < M[k][l] - M[k][j - 1] - M[i - 1][l]
                                + M[i - 1][j - 1]) {
                            max = M[k][l] - M[k][j - 1] - M[i - 1][l]
                                    + M[i - 1][j - 1];
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}