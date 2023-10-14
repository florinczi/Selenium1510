import java.util.Scanner;


public class SentenceReversal {
    

    

    public static String reverseSentence (String sourceString) {

        StringBuilder resultSentence = new StringBuilder();
        Scanner parser = new Scanner (sourceString);

        boolean isUpper = false, isFirstWord=true;

        while (parser.hasNext()){
            StringBuilder parserBuffer = new StringBuilder();
            parserBuffer.append(parser.next());

            if(!parser.hasNext()) relocatePunctuation(resultSentence, parserBuffer); // if this is the last word, fix the punctuation
                
            resultSentence.insert(0, parserBuffer);

            if (isFirstWord) {

                char c = resultSentence.charAt(0);
                isUpper = Character.isUpperCase(c); // remembers if the sentence started with upper case
                resultSentence.setCharAt(0, Character.toLowerCase(c)); // first source char to lowercase.    
                isFirstWord = false;   

            }
            
            if (parser.hasNext()) resultSentence.insert(0, " "); // inserts spaces
            
        }
        parser.close();
        
        if (isUpper) resultSentence.setCharAt(0, Character.toUpperCase(resultSentence.charAt(0))); // Changes to uppercase if the original sentence was upper case.


        return resultSentence.toString();
    }

    public static boolean isPunctuationMark (char c) {
        String marks = ".,!?";
        return marks.indexOf(c) != -1;
    }

    public static void relocatePunctuation (StringBuilder result, StringBuilder source){
        Character c = source.charAt(source.length()-1);
        if (isPunctuationMark(c)) {
            result.append(c);            
            source.deleteCharAt(source.length()-1);
            relocatePunctuation(result, source);
        }
        
    }
}