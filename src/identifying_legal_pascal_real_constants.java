//325

import java.util.Scanner;

public class identifying_legal_pascal_real_constants {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String line = "";
        while (!(line = s.nextLine()).equals("*")) {
            System.out.println(checkPascal(line.trim()));
        }
        
        s.close();
    }

    public static String checkPascal(String pascal) {
        return (pascal.matches("^[+-]?\\d+(\\.\\d+|[eE][+-]?\\d+|\\.\\d+[eE][+-]?\\d+)$")) 
                ? pascal + " is legal." : pascal + " is illegal.";
    }
}