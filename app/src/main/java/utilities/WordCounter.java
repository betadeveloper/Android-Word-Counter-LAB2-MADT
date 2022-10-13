package utilities;

public class WordCounter {
    public static String wordcount(String input) {
        long numWords = 0;
        int index = 0;
        boolean prevWhiteSpace = true;
        while (index < input.length()) {
            char c = input.charAt(index++);
            boolean currWhiteSpace = Character.isWhitespace(c);
            if (prevWhiteSpace && !currWhiteSpace) {
                numWords++;
            }
            prevWhiteSpace = currWhiteSpace;
        }
        return String.valueOf(numWords);
    }
}
