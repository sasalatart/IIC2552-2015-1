//11878

import java.util.Scanner;

public class homework_checker {

    static int correctAnswers = 0;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            correctAnswers += checkLine(s.nextLine());
        }

        System.out.println(correctAnswers);

        s.close();
    }

    public static int checkLine(String line) {

        String[] aux = line.split("=");
        if (aux[1].equals("?")) {
            return 0;
        }

        char operation = ' ';
        String[] op = null;
        if (aux[0].contains("+")) {
            op = aux[0].split("\\+");
            operation = '+';
        } else {
            op = aux[0].split("-");
            operation = '-';
        }

        int num1 = Integer.parseInt(op[0]);
        int num2 = Integer.parseInt(op[1]);
        int result = Integer.parseInt(aux[1]);

        if (operation == '+') {
            return ((num1 + num2) == result) ? 1 : 0;
        } else {
            return ((num1 - num2) == result) ? 1 : 0;
        }
    }
}