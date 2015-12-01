//11291

import java.util.Scanner;

public class smeech {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String line = "";
        while (!(line = s.nextLine()).equals("()")) {
            System.out.format("%.2f\n", smeechValue(line));
        }

        s.close();
    }

    static double smeechValue(String smeech) {

        if (!(smeech.charAt(0) == '(')) {
            return Double.parseDouble(smeech);
        }

        smeech = smeech.substring(1, smeech.length() - 1);

        int pSpaceIndex = smeech.indexOf(' ');

        double p = Double.parseDouble(smeech.substring(0, pSpaceIndex));
        double smeech1;
        double smeech2;

        smeech = smeech.substring(pSpaceIndex + 1);

        int initialSmeech = smeech.indexOf('(');

        if (initialSmeech == 0) {
            int finalSmeech = 0;
            int counter = 1;
            for (int i = initialSmeech + 1; i < smeech.length(); i++) {
                if (smeech.charAt(i) == '(') {
                    counter++;
                } else if (smeech.charAt(i) == ')') {
                    counter--;
                }

                if (counter == 0) {
                    finalSmeech = i;
                    break;
                }
            }

            smeech1 = smeechValue(smeech.substring(0, finalSmeech + 1));
            smeech2 = smeechValue((smeech.substring(finalSmeech + 1)).trim());
        } else {
            int firstSmeechIndex = smeech.indexOf(" ");

            smeech1 = smeechValue(smeech.substring(0, firstSmeechIndex));
            smeech2 = smeechValue(smeech.substring((firstSmeechIndex + 1)).trim());
        }

        return p * (smeech1 + smeech2) + (1 - p) * (smeech1 - smeech2);
    }
}