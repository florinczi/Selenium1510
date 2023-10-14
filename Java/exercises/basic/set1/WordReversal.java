import java.util.Scanner;

public class WordReversal {

    
    
    private static String reverse (String word) {


        StringBuilder wordsb = new StringBuilder(word);
        for (int i=0; i < (wordsb.length()-1)/2; i++) { 
            char temp = wordsb.charAt(i); // temp to pierwszy char
            wordsb.setCharAt(i, wordsb.charAt(wordsb.length()-1-i)); // pierwszy nadpisany ostatnim
            wordsb.setCharAt(wordsb.length()-1-i, temp); //ostatni tempem
        }

        return wordsb.toString();
    }

    public static void getInput() {
        String wordin;

        System.out.flush();
        System.out.printf("Podaj słowo które chcesz odwrócić: %n");
        try (Scanner input = new Scanner(System.in)) {
            wordin = input.nextLine();
        } 
        System.out.printf("%nPrzyjęto: %s%nOdwrocone slowo to: %s%n", wordin, reverse(wordin));

    }

}
