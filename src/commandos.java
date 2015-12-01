//11463

import java.util.Scanner;

public class commandos {

    static Scanner s;

    static int num_tests;
    static int num_buildings;
    static int num_roads;
    static int starting_building;
    static int reunion_building;
    static int max_distance;
 
    static int[][] adj_matrix;

    public static void main(String[] args) {
        s = new Scanner(System.in);

        num_tests = s.nextInt();

        for (int i = 0; i < num_tests; i++) {
            ReadData();
            FloydWarshall();
            Commandos();
            System.out.println("Case " + (i + 1) + ": " + max_distance);
        }

        s.close();
    }

    public static void ReadData() {
        max_distance = 0;
        num_buildings = s.nextInt();
        num_roads = s.nextInt();
        adj_matrix = new int[num_buildings][num_buildings];

        for (int i = 0; i < num_buildings; i++) {
            for (int j = 0; j < num_buildings; j++) {
                if (i == j) {
                    adj_matrix[i][j] = 0;   
                }
                else {
                    adj_matrix[i][j] = 99999;
                }
            }
        }

        for (int i = 0; i < num_roads; i++) {
            int x = s.nextInt();
            int y = s.nextInt();

            adj_matrix[x][y] = 1;
            adj_matrix[y][x] = 1;
        }

        starting_building = s.nextInt();
        reunion_building = s.nextInt();
    }

    public static void FloydWarshall() {
        for (int k = 0; k < num_buildings; k++) {
            for (int i = 0; i < num_buildings; i++) {
                for (int j = 0; j < num_buildings; j++) {
                    adj_matrix[i][j] = Math.min(adj_matrix[i][j], adj_matrix[i][k] + adj_matrix[k][j]);
                }
            }
        }
    }

    public static void Commandos() {
        for (int i = 0; i < num_buildings; i++) {
            max_distance = Math.max(max_distance, adj_matrix[starting_building][i] + adj_matrix[i][reunion_building]);
        }
    }
}
