//10377

import java.util.Scanner;

public class maze_traversal {

    static char[][] map;
    static int c_row;
    static int c_col;
    static char dir;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int rows = s.nextInt();
            int cols = s.nextInt();

            map = new char[rows + 1][cols + 1];

            s.nextLine();
            for (int j = 1; j < map.length; j++) {
                String line = "*" + s.nextLine();
                map[j] = line.toCharArray();
            }

            c_row = s.nextInt();
            c_col = s.nextInt();

            String line = "";
            while (!line.contains("Q")) {
                line += s.nextLine();
            }
            line = line.replaceAll(" ", "");
            char[] commands = line.toCharArray();

            dir = 'N';
            for (int j = 0; j < commands.length; j++) {
                if (commands[j] != 'Q') {
                    Move(commands[j]);
                }
            }

            if (i == n - 1) {
                System.out.println(c_row + " " + c_col + " " + dir);   
            }
            else {
                System.out.println(c_row + " " + c_col + " " + dir + "\n");
            }
        }

        s.close();
    }

    static void Move(char command) {
        switch (dir) {
        case 'N':
            if (command == 'R') {
                dir = 'E';
            } else if (command == 'L') {
                dir = 'W';
            } else if (command == 'F') {
                if (map[c_row - 1][c_col] != '*') {
                    c_row--;
                }
            }
            break;

        case 'E':
            if (command == 'R') {
                dir = 'S';
            } else if (command == 'L') {
                dir = 'N';
            } else if (command == 'F') {
                if (map[c_row][c_col + 1] != '*') {
                    c_col++;
                }
            }
            break;

        case 'S':
            if (command == 'R') {
                dir = 'W';
            } else if (command == 'L') {
                dir = 'E';
            } else if (command == 'F') {
                if (map[c_row + 1][c_col] != '*') {
                    c_row++;
                }
            }
            break;

        case 'W':
            if (command == 'R') {
                dir = 'N';
            } else if (command == 'L') {
                dir = 'S';
            } else if (command == 'F') {
                if (map[c_row][c_col - 1] != '*') {
                    c_col--;
                }
            }
            break;

        default:
            break;
        }
    }
}