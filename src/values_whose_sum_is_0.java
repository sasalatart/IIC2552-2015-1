//1152

import java.util.*;

public class values_whose_sum_is_0 {

    static Scanner s;

    static int test_cases;
    static int list_size;
    static int[][] matrix;
    static int zeroes;

    static int[] col1;
    static int[] col2;

    public static void main(String[] args) {
        s = new Scanner(System.in);

        test_cases = s.nextInt();

        for (int t = 0; t < test_cases; t++) {
            list_size = s.nextInt();
            matrix = new int[list_size][4];
            for (int i = 0; i < list_size; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = s.nextInt();
                }
            }

            int n_squared = list_size * list_size;
            col1 = new int[n_squared];
            col2 = new int[n_squared];

            int counter = 0;
            for (int i = 0; i < list_size; i++) {
                for (int j = 0; j < list_size; j++) {
                    col1[counter] = matrix[i][0] + matrix[j][1];
                    col2[counter] = matrix[i][2] + matrix[j][3];
                    counter++;
                }
            }

            Arrays.sort(col2);

            zeroes = 0;
            for (int i = 0; i < n_squared; i++) {
                int num = -1 * col1[i];
                int index = Arrays.binarySearch(col2, num);

                if (index >= 0) {
                    int num2 = col2[index];

                    int a = 1;
                    while (true) {
                        int index2 = index + a;
                        if (index2 >= n_squared) {
                            break;
                        }

                        int aux = col2[index2];
                        a++;

                        if (aux != num2) {
                            break;
                        }

                        zeroes++;
                    }

                    a = 1;
                    while (true) {
                        int index2 = index - a;
                        if (index2 < 0) {
                            break;
                        }

                        int aux = col2[index2];
                        a++;

                        if (aux != num2) {
                            break;
                        }

                        zeroes++;
                    }

                    zeroes++;
                }
            }

            if (t == test_cases - 1) {
                System.out.println(zeroes);
            } else {
                System.out.println(zeroes);
                System.out.println();
            }
        }

        s.close();
    }
}
