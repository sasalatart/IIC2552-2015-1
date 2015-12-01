//10116

import java.util.Scanner;

public class robot_motion {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String line = "";
        while (true) {
            line = s.nextLine();
            String[] params = line.split(" ");

            int rows = Integer.parseInt(params[0]);
            int cols = Integer.parseInt(params[1]);
            int start = Integer.parseInt(params[2]);

            if (rows == 0 && cols == 0 && start == 0) {
                break;
            }

            Node[][] matrix = new Node[cols][rows];
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    matrix[i][j] = new Node();
                }
            }

            for (int j = 0; j < rows; j++) {
                line = s.nextLine();

                for (int i = 0; i < cols; i++) {
                    matrix[i][j].dir = line.charAt(i);

                    if (i > 0) {
                        matrix[i][j].wNode = matrix[i - 1][j];
                    }
                    if (i < cols - 1) {
                        matrix[i][j].eNode = matrix[i + 1][j];
                    }
                    if (j > 0) {
                        matrix[i][j].nNode = matrix[i][j - 1];
                    }
                    if (j < rows - 1) {
                        matrix[i][j].sNode = matrix[i][j + 1];
                    }
                }
            }

            int steps = 0;
            Node currentNode = matrix[start - 1][0];
            currentNode.visited = true;
            while (true) {
                steps++;

                switch (currentNode.dir) {
                case 'N':
                    currentNode = currentNode.nNode;
                    break;
                case 'E':
                    currentNode = currentNode.eNode;
                    break;
                case 'S':
                    currentNode = currentNode.sNode;
                    break;
                case 'W':
                    currentNode = currentNode.wNode;
                    break;
                }

                if (currentNode == null) {
                    System.out.println(steps + " step(s) to exit");
                    break;
                }

                if (currentNode.visited) {
                    System.out.println(currentNode.steps
                            + " step(s) before a loop of "
                            + (steps - currentNode.steps) + " step(s)");
                    break;
                } else {
                    currentNode.visited = true;
                }

                currentNode.steps = steps;
            }
        }

        s.close();
    }
}

class Node {
    public char dir;
    public int steps;
    public boolean visited;
    public Node nNode;
    public Node eNode;
    public Node sNode;
    public Node wNode;

    public Node() {
        this.steps = 0;
        this.visited = false;
        this.nNode = null;
        this.eNode = null;
        this.sNode = null;
        this.wNode = null;
    }
}