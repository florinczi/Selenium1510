import java.util.Scanner;

public class Menu {

    private static String title = "Set1%n1: WordReversal%n2: SentenceReversal%n3: WordFinderWybierz numer zadania:%n";

    
    public static void mainmenu(){
        System.out.flush();
        System.out.printf(title);

        try (Scanner input = new Scanner(System.in)) {
           
        String selection = input.nextLine();


            switch (selection){
                case "1": 
                    WordReversal.getInput();
                    break;

                case "2": sentenceReversalMenu();
                    break;

                case "3": wordFinderMenu();

                default: System.out.println("defoult");
                
            }
        }
    }

    public static void sentenceReversalMenu() {
        String inputString;
        System.out.flush();
        System.out.printf("Wpisz zdanie które chcesz odwrócić: %n");
        try (Scanner input = new Scanner(System.in)) {
            inputString = input.nextLine();
        }
        System.out.printf("%nPrzyjęto: %s%nOdwrocone zdanie to: %s%n", inputString, SentenceReversal.reverseSentence(inputString));

        
    }

    public static void wordFinderMenu() {
        String inputString;
        int wordNumber;
        System.out.flush();
        System.out.printf("Wpisz zdanie zrodlowe: %n");

        Scanner input = new Scanner(System.in); 
        inputString = input.nextLine();
        
        System.out.printf("Wpisz numer wyrazu: %n");

        wordNumber= input.nextInt();
        
        System.out.printf("%nWyraz numer %d to: %s%n", wordNumber, WordFinder.findWord(inputString, wordNumber));
        input.close();
        
    }
}
