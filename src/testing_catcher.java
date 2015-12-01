//231

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testing_catcher {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int counter = 1;
        while (s.hasNext()) {
            
            List<Integer> misiles = new ArrayList<Integer>();
            
            int n;
            while ((n = s.nextInt()) != -1) {
                misiles.add(n);
            }

            if (misiles.isEmpty()) {
                break;
            }
            
            int[] interceptions = new int[misiles.size()];
            
            interceptions[misiles.size() - 1] = 1;

            n = misiles.size();
            for (int i = n - 2; i > -1; i--) {
                int max_index = 0;
                for (int j = i + 1; j < n; j++) {
                    if (interceptions[j] > interceptions[max_index]
                            && misiles.get(j) < misiles.get(i)) {
                        max_index = j;
                    }
                }

                interceptions[i] = 1 + interceptions[max_index];
            }

            int max = 0;
            for (int i = 0; i < interceptions.length; i++) {
                if (interceptions[i] > max) {
                    max = interceptions[i];
                }
            }

            if (counter > 1) {
                System.out.println();   
            }
            
            System.out.println("Test #" + counter + ":");
            System.out.println("  maximum possible interceptions: " + max);
            
            counter++;
        }
        
        s.close();
    }
}