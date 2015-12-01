//558

import java.util.Scanner;

public class wormholes {

    static Scanner s;

    static int num_cases;
    static int num_stars;
    static int num_wormholes;

    static int[][] adjacency_list;

    public static void main(String[] args) {
        s = new Scanner(System.in);

        num_cases = s.nextInt();

        for (int i = 0; i < num_cases; i++) {
            ReadData();
            BellmanFord(0);
        }

        s.close();
    }

    public static void ReadData() {
        num_stars = s.nextInt();
        num_wormholes = s.nextInt();

        adjacency_list = new int[num_wormholes][3];

        for (int k = 0; k < num_wormholes; k++) {
            int i = s.nextInt();
            int j = s.nextInt();
            int w = s.nextInt();
            adjacency_list[k][0] = i;
            adjacency_list[k][1] = j;
            adjacency_list[k][2] = w;
        }
    }

    public static void BellmanFord(int source) {
        int[] distance = new int[num_stars];

        for (int i = 0; i < distance.length; i++) {
            distance[i] = 99999;
        }
        distance[source] = 0;

        for (int i = 0; i < num_stars; i++) {
            for (int j = 0; j < num_wormholes; j++) {
                if (distance[adjacency_list[j][0]] + adjacency_list[j][2] < distance[adjacency_list[j][1]]) {
                    distance[adjacency_list[j][1]] = distance[adjacency_list[j][0]] + adjacency_list[j][2];
                }
            }
        }

        for (int i = 0; i < num_wormholes; i++) {
            if (distance[adjacency_list[i][0]] + adjacency_list[i][2] < distance[adjacency_list[i][1]]) {
                System.out.println("possible");
                return;
            }
        }
 
        System.out.println("not possible");
    }
}
