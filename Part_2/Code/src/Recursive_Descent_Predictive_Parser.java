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
    private static StringTokenizer tokens;
    private static String lookahead;
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tokens = new StringTokenizer(line);
                lookahead = getNextToken();
                
                try {
                    E();
                    if (lookahead.equals("$")) {
                        System.out.println("Correct Syntax");
                    } else {
                        throw new Exception("Syntax Error");
                    }
                } catch (Exception e) {
                    System.out.println("Syntax Error");
                }
            }
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        }
    }
    
    // Grammar Rule: E -> T E'
    private static void E() throws Exception {
        T();
        EPrime();
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
        }
        // ε - do nothing
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
        }
        // ε - do nothing
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
