import java.io.*;
import java.util.StringTokenizer;

/* Group Project ( Lexical Analyzer )
Student Names:
1. YOONUS KIZHAKKETHIL (2142644)
2. Ahmed Osama Kentar (2148843)
3. Abdulkareem Almahlawi (2148850)
Section: CS1
*/
public class Recursive_Descent_Predictive_Parser {
    private static StringTokenizer tokens; // Tokenizer to read the input
    private static String lookahead; // Current token

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) { // Read the input file line by line
                tokens = new StringTokenizer(line); // Tokenize the input line
                lookahead = getNextToken(); // Get the first token

                try {
                    E();
                    if (lookahead.equals("$")) { // Check if it's the end of the expression
                        System.out.println("Correct Syntax");
                    } else { // If there are more tokens after the expression, it's a syntax error
                        throw new Exception("Syntax Error");
                    }
                } catch (Exception e) {
                    System.out.println("Syntax Error");
                }
            }
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage()); // Error reading the file
        }
    }

    // Grammar Rule: E -> T E'
    private static void E() throws Exception {
        T(); // Call the T function
        EPrime(); // Call the E' function
    }

    // Grammar Rule: E' -> + T E' | - T E' | ε
    private static void EPrime() throws Exception {
        if (lookahead.equals("+")) {
            match("+");
            T();
            EPrime();
        } else if (lookahead.equals("-")) {
            match("-");
            T();
            EPrime();
        } else {
            // ; Null statement
            ;
        }

    }

    // Grammar Rule: T -> F T'
    private static void T() throws Exception {
        F();
        TPrime();
    }

    // Grammar Rule: T' -> * F T' | / F T' | ε
    private static void TPrime() throws Exception {
        if (lookahead.equals("*")) {
            match("*");
            F();
            TPrime();
        } else if (lookahead.equals("/")) {
            match("/");
            F();
            TPrime();
        } else {
            // ; Null statement
            ;
        }
    }

    // Grammar Rule: F -> ( E ) | id
    private static void F() throws Exception {
        if (lookahead.equals("(")) {
            match("(");
            E();
            match(")");
        } else if (lookahead.equals("id")) {
            match("id");
        } else {
            throw new Exception("Syntax Error");
        }
    }

    // Match function to check the expected token
    private static void match(String token) throws Exception {
        if (lookahead.equals(token)) {
            lookahead = getNextToken();
        } else {
            throw new Exception("Syntax Error");
        }
    }

    // Get the next token from the tokenizer
    private static String getNextToken() {
        if (tokens.hasMoreTokens()) {
            return tokens.nextToken();
        }
        return "$"; // End of expression
    }
}
