//12877

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class great_swerc_porto {

    static HashMap<Character, Integer> decoder = new HashMap<Character, Integer>();
    static String[] words;
    static String resultWord = "";
    static int combinations = 0;
    static HashSet<Integer> usedNums = new HashSet<Integer>();
    static HashSet<Character> restrictedChars = new HashSet<Character>();
    static int maxDepth = 0;

    public static void main(String[] args) {

        initialize();
    }

    public static boolean addStrings() {

        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            sum += parseWord(words[i]);
        }

        if (sum == parseWord(resultWord)) {
            return true;
        } else {
            return false;
        }
    }

    public static int parseWord(String word) {

        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            answer += decoder.get(word.charAt(word.length() - i - 1))
                    * Math.pow(10, i);
        }

        return answer;
    }

    public static void shuffleChars(String input, int depth) {

        if (depth == words.length + 1) {
            int auxDigit = 0;

            for (int i = 0; i < words.length; i++) {
                auxDigit += decoder.get(words[i].charAt(words[i].length() - 1));
            }

            if (auxDigit % 10 != decoder.get(resultWord.charAt(resultWord
                    .length() - 1))) {
                return;
            }
        }

        if (depth == maxDepth) {
            if (addStrings()) {
                combinations++;
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 0 && restrictedChars.contains(input.charAt(depth))) {
                continue;
            }

            if (!usedNums.contains(i)) {
                usedNums.add(i);
                decoder.put(input.charAt(depth), i);

                shuffleChars(input, depth + 1);
                usedNums.remove(i);
            }
        }

        return;
    }

    public static void initialize() {

        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            int operands = Integer.parseInt(s.nextLine()) - 1;
            words = new String[operands];

            for (int i = 0; i < operands; i++) {
                String auxStr = s.nextLine();
                restrictedChars.add(auxStr.charAt(0));

                words[i] = auxStr;
            }

            resultWord = s.nextLine();
            restrictedChars.add(resultWord.charAt(0));

            String chars = getChars(words, resultWord);

            shuffleChars(chars, 0);

            System.out.println(combinations);
            combinations = 0;
        }

        s.close();
    }

    public static String getChars(String[] words, String resultWord) {
        String chars = resultWord.charAt(resultWord.length() - 1) + "";

        for (int i = 0; i < words.length; i++) {
            if (!chars.contains(words[i].charAt(words[i].length() - 1) + "")) {
                chars = chars + words[i].charAt(words[i].length() - 1);
            }
        }

        for (int i = 0; i < resultWord.length(); i++) {
            if (!chars.contains(resultWord.charAt(i) + "")) {
                chars = chars + resultWord.charAt(i);
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!chars.contains(words[i].charAt(j) + "")) {
                    chars = chars + words[i].charAt(j);
                }
            }
        }

        maxDepth = chars.length();

        return chars;
    }
}