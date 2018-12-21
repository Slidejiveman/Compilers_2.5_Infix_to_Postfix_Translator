import java.io.IOException;

/**
 * The parser class does all of the translation work.
 * It keeps lookahead as a reference to ensure that the
 * translation is still viable and raises an exception
 * if it determines an invalid character has been used.
 *
 * This parser handles single digit addition and subtraction translations.
 */
class Parser {
    /**
     * lookahead is used in all three of this classes methods to
     * determine whether the entered characters are valid for simple
     * arithmetic (addition and subtraction).
     */
    static private int lookahead;

    /**
     * Default constructor simply reads the first character in from
     * System.in. Once this happens, the object is ready to use it's
     * expr method to do the real work.
     * @throws IOException - thrown if System.in methods don't succeed.
     */
    Parser() throws IOException {
        lookahead = System.in.read();
    }

    /**
     * This method handles parsing out an entered expression. It calls
     * term to ensure that the character read in when the Parser was created
     * is valid. If so, it proceeds into a loop that continues until the
     * lookahead variable is not an addition or subtraction arithmetic
     * operator.
     * @throws IOException - thrown if write fails or an error percolates up from match or term
     */
    void expr() throws IOException, SyntaxError {
        term();
        while(true) {
            if( lookahead == '+' ) {
                match('+');
                term();
                System.out.write('+');
            } else if( lookahead == '-' ) {
                match('-');
                term();
                System.out.write('-');
            } else {
                return;
            }
        }
    }

    /**
     * If the read in value is a digit, then the digit
     * will be printed out and the match method will be called.
     * An Error is thrown if the character is not a digit or
     * if there is not a match.
     * @throws IOException - thrown if System.in methods don't succeed.
     */
    void term() throws IOException, SyntaxError {
        if( Character.isDigit( (char) lookahead) ) {
            System.out.write( (char) lookahead );
            match(lookahead);
        } else {
            throw new SyntaxError("term: Character was not a digit or write failed...");
        }
    }

    /**
     * Compares the passed in integer value with the lookahead variable.
     * If there is a match, then the next character from the input buffer
     * is read in. Otherwise, an Error is thrown.
     * @param t - the value to be compared with the lookahead
     * @throws IOException - thrown if System.in methods don't succeed.
     */
    void match(int t) throws IOException, SyntaxError {
        if( lookahead == t ) {
            lookahead = System.in.read();
        } else {
            throw new SyntaxError("match: The lookahead variable didn't match the input or read failed...");
        }
    }
}
