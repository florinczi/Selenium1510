import java.util.Scanner;

public class WordFinder {

    public static String findWord (String sourceString, int n) {

        try (Scanner parser = new Scanner (sourceString)){
             for (int i = 1; i < n; i++) parser.next();
             return parser.next();
        }
    }
}

