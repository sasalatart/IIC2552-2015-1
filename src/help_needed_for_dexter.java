//11384

import java.util.Scanner;

public class help_needed_for_dexter {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            long i = s.nextInt();
            long j = DeeDee(i);
            System.out.println(j);
        }

        s.close();
    }

    static long DeeDee(long input) {
        if (input == 1) {
            return 1;
        }
        else {
            return 1 + DeeDee(input/2);
        }
    }
}