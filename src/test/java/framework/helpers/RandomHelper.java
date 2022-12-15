package framework.helpers;

import java.util.Locale;
import java.util.Random;

public class RandomHelper {

    private static final Random random = new Random();

    public static int getRandomInt(int bound) {
        return random.nextInt(bound);
    }

    public static String getRandomString(int length) {
        int FIRST_ENGLISH_LETTER_UNICODE = 'a';
        int LAST_ENGLISH_LETTER_UNICODE = 'z';
        return generateRandomString(length, FIRST_ENGLISH_LETTER_UNICODE, LAST_ENGLISH_LETTER_UNICODE);
    }

    public static String getRandomString(int minLength, int countOfCapitalLetter, int countOfDigit, int countOfCyrillic) {

        StringBuilder capitalRandom = new StringBuilder(getRandomString(minLength));

        if (countOfCapitalLetter > 0) {
            capitalRandom.append(getRandomString(countOfCapitalLetter).toUpperCase(Locale.ROOT));
        }

        if (countOfDigit > 0) {
            for (int i = 0; i < countOfDigit; i++) {
                int COUNT_OF_DIGIT = 10;
                capitalRandom.append(getRandomInt(COUNT_OF_DIGIT));
            }
        }

        if (countOfCyrillic > 0) {
            int FIRST_CYRILLIC_LETTER_UNICODE = 'а';
            int LAST_CYRILLIC_LETTER_UNICODE = 'я';
            capitalRandom.append(generateRandomString(countOfCyrillic, FIRST_CYRILLIC_LETTER_UNICODE, LAST_CYRILLIC_LETTER_UNICODE));
        }

        return capitalRandom.toString();
    }

    public static String getRandomString(int minLength, int countOfCapitalLetter, int countOfDigit, int countOfCyrillic, String useCharFromString) {

        String capitalRandom = getRandomString(minLength, countOfCapitalLetter, countOfDigit, countOfCyrillic);

        return capitalRandom + getRandomCharFromString(useCharFromString);
    }

    public static char getRandomCharFromString (String string) {
        return string.charAt(getRandomInt(string.length()));
    }

    private static String generateRandomString(int length, int startWithUnicode, int lastUnicode) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char letter = (char) (startWithUnicode + getRandomInt(lastUnicode - startWithUnicode + 1));
            sb.append(letter);
        }
        return sb.toString();
    }

}
