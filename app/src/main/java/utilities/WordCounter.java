package utilities;

public class WordCounter {
    public static String getCharsCount(String input){
        return String.valueOf(input.length());
    }

    static final int OUT = 0;
    static final int IN = 1;
    public static int wordcount(String input){
        int state = OUT;
        int wc = 0;  // word count
        int i = 0;

        while (i < input.length())
        {
            if (input.charAt(i) == ' ' || input.charAt(i) == '\n' || input.charAt(i) == '\t'
                    || input.charAt(i) == '.'  || input.charAt(i) == ',')
                state = OUT;

            else if (state == OUT) {
                state = IN;
                ++wc;
            }
            ++i;
        }
        return wc;
    }
}