import java.io.IOException;

/**
 * The entry point of the Infix to Postfix translator.
 * This method creates a parser object and calls the
 * expression method (expr), which allows the user to
 * enter infix math expressions and have them translated
 * into postix notation.
 */
public class PostfixMain {
    public static void main(String args[]) throws IOException {
        Parser parser = new Parser();
        try {
            parser.expr();
        } catch (SyntaxError se) {
            se.printErrorMessage();
        }
        System.out.write('\n');
    }
}
