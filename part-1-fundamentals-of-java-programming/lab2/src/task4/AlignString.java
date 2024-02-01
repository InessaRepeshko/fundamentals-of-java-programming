package task4;

/**
 * The {@code AlignString} class performs reading a string from the command line and adding spaces so that the string
 * length is equal to the given value. Spaces are added evenly between words (if possible).
 */
class AlignString {
    /**
     * Verifies the passed {@code args} command line arguments.
     * <ul><li> If fewer or more than 2 arguments are passed, an error message is printed and the program is
     * exited. </li></ul>
     * @param args command-line arguments.
     * */
    static void verifyArgs(String[] args) {
        if (args.length != 2) {
            System.err.println("Incorrect arguments were passed.\nThe arguments should be as follows: " +
                    "<string> <required string length>. Try again!");
            System.exit(1);
        }
    }

    /**
     * Gets the required length of the aligned string from the passed {@code arg} command line argument, verifies it
     * and returns it.
     * <ul><li> If the passed required length is less than or equal to zero, an error message is printed and
     * the program is exited. </li></ul>
     * @param arg command line argument with the required length of the aligned string;
     * @return required length of the aligned string.
     * */
    static int getLength(String arg) {
        int requiredLength = Integer.parseInt(arg);

        if (requiredLength <= 0) {
            System.err.println("Invalid required string length was passed.\n" +
                    "The desired string length must be greater than zero. Try again!");
            System.exit(1);
        }

        return requiredLength;
    }

    /**
     * Gets the initial string from the passed {@code arg} command line argument, verifies it and returns it.
     * <ul><li> If the passed initial string starts or ends with spaces or is longer than the required length,
     * an error message is printed and the program is exited. </li></ul>
     * @param requiredLength required length of the aligned string;
     * @param arg command line argument with the initial string to be aligned;
     * @return initial string to be aligned.
     * */
    static String getString(int requiredLength, String arg) {
        if (arg.startsWith(" ") || arg.endsWith(" ")) {
            System.err.println("Invalid string passed.\nThe string must begin and end with words, not spaces. " +
                    "Try again!");
            System.exit(1);
        }

        if (arg.length() > requiredLength) {
            System.err.println("Invalid string or the required string length was passed.\n" +
                    "The length of the initial string must be equal to or less than the required string length. " +
                    "Try again!");
            System.exit(1);
        }

        return arg;
    }

    /**
     * Adds spaces between words (if possible) evenly in the {@code initialString}.
     * <ul><li> If the string consists of a single word or none, spaces are added evenly at the start and end of
     * the string.</li>
     * <li> If the string consists of several words, spaces are added evenly between each word.</li></ul>
     * @param wordArray array of separate words from the initial string;
     * @param totalSpacesNum total number of spaces to be added to the string for alignment;
     * @return string with added spaces evenly between words (if possible).
     */
    private static String addSpacesToString(String[] wordArray, int totalSpacesNum) {
        if (wordArray.length == 1) {
            int startSpacesNum;
            startSpacesNum = totalSpacesNum / 2;

            return " ".repeat(startSpacesNum) + wordArray[0] + " ".repeat(totalSpacesNum - startSpacesNum);
        } else {
            int betweenWordsSpacesNum = totalSpacesNum / (wordArray.length - 1);
            int remainingSpacesNum = totalSpacesNum % (wordArray.length - 1);
            StringBuilder alignedString = new StringBuilder();
            alignedString.append(wordArray[0]);

            for (int i = 1; i < wordArray.length; i++) {
                int spacesNumber = betweenWordsSpacesNum;

                if (remainingSpacesNum != 0) {
                    spacesNumber++;
                    remainingSpacesNum--;
                }

                alignedString.append(" ".repeat(spacesNumber));
                alignedString.append(wordArray[i]);
            }

            return alignedString.toString();
        }
    }

    /**
     * Aligns the {@code initialString} by removing extra spaces and adding spaces evenly using the
     * {@code addSpacesToString} method.
     * <p> The string is converted into a sentence with only one space between words by removing the extra spaces.
     * Separate words are extracted from the generated string into an array. The total number of spaces to be added
     * to the string to align it to the required length is calculated. To add spaces to a string for alignment,
     * {@code addSpacesToString} method is called.
     * @param initialString input string to be aligned;
     * @param requiredLength required length of the aligned string;
     * @return aligned string.
     */
    static String alignString(int requiredLength, String initialString) {
        while (initialString.contains("  ")) {
            initialString = initialString.replaceAll("  ", " ");
        }

        String[] wordArray = initialString.split(" ");
        int totalSpacesNum = requiredLength - initialString.length() + wordArray.length - 1;

        return addSpacesToString(wordArray, totalSpacesNum);
    }

    /**
     * Reads, aligns and prints a string.
     * <p> Reads the initial string and the required length of the aligned string from the command line. Validates
     * the passed command line arguments. Aligns the initial string to the required length. Prints the required length,
     * the initial string, the aligned string and the length of the aligned string.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        verifyArgs(args);
        int requiredLength = getLength(args[1]);
        String initialString = getString(requiredLength, args[0]);
        String alignedString = alignString(requiredLength, initialString);
        System.out.printf("The required length of the aligned string:\t%d.\n", requiredLength);
        System.out.printf("The initial string to be aligned:\t\t\t\"%s\".\n", initialString);
        System.out.printf("The aligned string:\t\t\t\t\t\t\t\"%s\".\n", alignedString);
        System.out.printf("The length of the aligned string:\t\t\t%d.\n", alignedString.length());
    }
}
