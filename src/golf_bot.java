//12879

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class golf_bot {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {

            int nMoves = s.nextInt();
            HashSet<Integer> moves = new HashSet<Integer>();
            for (int i = 0; i < nMoves; i++) {
                moves.add(s.nextInt());
            }

            int dHoles = s.nextInt();
            HashMap<Integer, Integer> holes = new HashMap<Integer, Integer>();
            for (int i = 0; i < dHoles; i++) {
                int aux = s.nextInt();

                if (moves.contains(aux)) {
                    holes.put(aux, 1);
                } else {
                    holes.put(aux, 0);
                }
            }

            golfBot(moves, holes);
        }

        s.close();
    }

    public static void golfBot(HashSet<Integer> moves, HashMap<Integer, Integer> holes) {

        for (Map.Entry<Integer, Integer> entryHoles : holes.entrySet()) {
            if (entryHoles.getValue() == 0) {
                boolean rdy = false;
                for (Integer i : moves) {
                    if (rdy) {
                        break;
                    }
                    int aux = entryHoles.getKey() - i;
                    for (Integer j : moves) {
                        if (aux - j == 0) {
                            holes.put(entryHoles.getKey(), 2);
                            rdy = true;
                            break;
                        }
                    }
                }
            }
        }

        int aux = 0;
        for (Map.Entry<Integer, Integer> entryHoles : holes.entrySet()) {
            if (entryHoles.getValue() != 0) {
                aux++;
            }
        }
        System.out.println(aux);
    }
}