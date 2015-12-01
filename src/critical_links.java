//796

import java.util.Scanner;

public class critical_links {

    static Scanner s;
    static int[][] adjMatrix;
    static int[][] cLinks;
    static int[] dfs_low;
    static int[] dfs_num;
    static int[] dfs_color;
    static int[] dfs_parent;
    static int criticalLinks;
    static int nodes;

    public static void main(String[] args) {
        s = new Scanner(System.in);

        while (s.hasNext()) {
            readData();

            for (int i = 0; i < nodes; i++) {
                dfs_color[i] = 0;
                dfs_parent[i] = -1;
            }

            criticalLinks = 0;
            int dfsNumberCounter = 0;
            for (int i = 0; i < nodes; i++) {
                if (dfs_color[i] == 0) {
                    dfsNumberCounter = articulationPointAndBridge(i, dfsNumberCounter);
                }
            }

            printResult();
        }

        s.close();
    }

    static int articulationPointAndBridge(int u, int dfsNumberCounter) {
        dfs_color[u] = 1;
        dfsNumberCounter++;
        dfs_low[u] = dfsNumberCounter;
        dfs_num[u] = dfsNumberCounter;

        for (int v = 0; v < adjMatrix[u].length; v++) {
            if (adjMatrix[u][v] == 0) {
                continue;
            }

            if (dfs_color[v] == 0) {
                dfs_parent[v] = u;
                dfsNumberCounter = articulationPointAndBridge(v, dfsNumberCounter);
                if (dfs_low[v] > dfs_num[u]) {
                    int aux1 = u;
                    int aux2 = v;

                    if (u > v) {
                        aux1 = v;
                        aux2 = u;
                    }

                    if (cLinks[aux1][aux2] == 0) {
                        cLinks[aux1][aux2] = 1;
                        criticalLinks++;
                    }
                }
                dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
            } else if (dfs_parent[u] != v && dfs_parent[u] != -1) {
                dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
            }
        }

        dfs_color[u] = 2;
        return dfsNumberCounter;
    }

    static void readData() {
        nodes = s.nextInt();
        s.nextLine();
        adjMatrix = new int[nodes][nodes];
        cLinks = new int[nodes][nodes];
        dfs_low = new int[nodes];
        dfs_num = new int[nodes];
        dfs_color = new int[nodes];
        dfs_parent = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            String line = s.nextLine();
            line = line.replaceAll("\\(", "");
            line = line.replaceAll("\\)", "");
            String[] numbers = line.split(" ");

            int index = Integer.parseInt(numbers[0]);
            int q = Integer.parseInt(numbers[1]);

            for (int j = 0; j < q; j++) {
                adjMatrix[index][Integer.parseInt(numbers[j + 2])] = 1;
            }
        }
    }

    static void printResult() {
        System.out.println(criticalLinks + " critical links");

        for (int i = 0; i < cLinks.length; i++) {
            for (int j = 0; j < cLinks[0].length; j++) {
                if (cLinks[i][j] == 1) {
                    System.out.println(i + " - " + j);
                }
            }
        }

        System.out.println();
    }
}
