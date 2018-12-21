/**
 * SyntaxError is a custom Exception used by the Parser.
 */
class SyntaxError extends Exception {

    /**
     * The message to be printed to the screen.
     */
    private String errorMessage;

    /**
     * The default constructor uses a dummy string value to
     * make error handling easier for classes that use this exception.
     * There is less description, but raising an exception also takes
     * less text. Not recommended, but the option is there.
     */
    SyntaxError() {
        super();
        errorMessage = "syntax error...";
    }

    /**
     * The String constructor sets the error message to be
     * printed to the screen.
     * @param message - the error message to print out
     */
    SyntaxError(String message) {
        super();
        errorMessage = message;
    }

    /**
     * Prints the error message to System.err so that it
     * shows up in red font.
     */
    void printErrorMessage() {
        System.err.println(errorMessage);
    }
}
