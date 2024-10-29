import java.io.*;
/* Group Project ( Lexical Analyzer )
Student Names:
1. YOONUS KIZHAKKETHIL (2142644)
2. Ahmed Osama Kentar (2148843)
3. Abdulkareem Almahlawi (2148850)
Section: CS1
*/

public class Tokenizer {

    static char lookahead; // To store the current character being read

    public static void main(String[] args) {
        tokenizer();
        System.out.println("Tokens have been identified successfully....!!!");
    }

    public static void tokenizer() {
        // Reserved words of C/Java into an array
        String[] reserveWords = {
                "int", "float", "if", "else", "while", "for", "abstract", "continue", "new",
                "switch", "assert", "default", "package", "synchronized", "boolean", "do",
                "private", "this", "break", "double", "protected", "implements", "throw",
                "byte", "return", "import", "public", "throws", "case", "enum",
                "instanceof", "transient", "catch", "extends", "short", "try", "char",
                "final", "interface", "static", "void", "class", "finally", "long",
                "strictfp", "volatile", "const", "native", "super", "while", "true", "false", "null", "String",
                "System", "out", "println", "print", "Scanner", "nextInt", "nextLine", "next", "nextDouble",
                "nextFloat", "nextBoolean", "nextByte", "nextShort", "nextLong", "nextChar", "Math", "abs", "acos",
                "asin", "atan", "atan2", "cbrt", "ceil", "copySign", "cos", "cosh", "exp", "expm1", "floor",
                "getExponent", "hypot", "IEEEremainder", "log", "log10", "log1p", "max", "min", "nextAfter", "nextDown",
                "nextUp", "pow", "random", "rint", "round", "scalb", "signum", "sin", "sinh", "sqrt", "tan", "tanh",
                "toDegrees", "toRadians", "ulp", "Date", "Calendar", "SimpleDateFormat", "getTime", "setTime", "set",
                "get", "add", "roll", "clear", "before", "after", "compareTo", "equals", "getFirstDayOfWeek",
                "getMinimalDaysInFirstWeek", "getTimeZone", "setTimeZone", "getAvailableIDs", "getDisplayName",
                "getDSTSavings", "getID", "getOffset", "getTimeInMillis",
                "main", "args", "length", "out", "println", "print", "Scanner", "nextInt", "nextLine", "next",
                "nextDouble", "nextFloat", "nextBoolean", "nextByte", "nextShort", "nextLong", "nextChar",

        };

        // char to store the specifiers
        char[] specifiers = { 'n', 't', 'r', 'b', 'f', 'v', 'a', '\\', '\'', '\"' };

        // Array to store lexemes
        char[] lexeme = new char[30];
        int state = 0;
        int i = 0;

        // Use PushbackReader to allow unreading characters
        try (PushbackReader inputFile = new PushbackReader(new FileReader("input.txt"), 1);
                PrintWriter outputFile = new PrintWriter(new FileWriter("output.txt"))) {

            // Read one character at a time from the input file
            while (inputFile.ready()) {

                switch (state) { // Switch on the current state
                    case 0:
                        lookahead = (char) inputFile.read();
                        if (Character.isWhitespace(lookahead) || lookahead == '\n' || lookahead == '\r') {
                            // Ignore whitespace
                        } else if (lookahead == '>') { // Handles '>'
                            state = 1;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '<') { // Handles '<'
                            state = 4;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '=') { // Handles '='
                            state = 7;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '!') { // Handles '!' 
                            state = 10;
                            lexeme[i++] = lookahead;
                        } else if (Character.isLetter(lookahead) | lookahead == '$' | lookahead == '_') { // Handles
                                                                                                        // identifiers
                            state = 13;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '+') { // Handles '+'
                            state = 15;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '-') { // Handles '-'
                            state = 19;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '*') { // Handles '*'
                            state = 23;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '/') { // Handles '/' 
                            state = 26;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '%') { // Handles '%'
                            state = 32;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '|') { // Handles '|'
                            state = 35;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '&') { // Handles '&'
                            state = 38;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '"') { // Handles '"'
                            state = 41;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '\'') { // Handles '\''
                            state = 43;
                            lexeme[i++] = lookahead;
                        }

                        else if (lookahead == ';') { // Handles ';'
                            state = 47;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == ':') { // Handles ':'
                            state = 48;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == ',') { // Handles ',' 
                            state = 49;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '{') {  // Handles '{'
                            state = 52;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '}') { // Handles '}'
                            state = 53;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '[') { // Handles '['
                            state = 54;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == ']') { // Handles ']'
                            state = 55;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '(') { // Handles '(' 
                            state = 56;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == ')') { // Handles ')'
                            state = 57;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '#') { // Handles '#' 
                            state = 58;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '~') {  // Handles '~'
                            state = 59;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '`') { // Handles '`'
                            state = 60;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '@') { // Handles '@' 
                            state = 61;
                            lexeme[i++] = lookahead;
                        } else if (lookahead == '?') { // Handles '?'
                            state = 62;
                            lexeme[i++] = lookahead;
                        } else if (Character.isDigit(lookahead)) { // Handles digits
                            state = 63;
                            lexeme[i++] = lookahead;
                        } else { // Handles other characters
                            error(lookahead);
                        }
                        break;

                    case 1: // Handles '>'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '=') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: greater_eq_op");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: greater_op");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 4: // Handles '<'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '=') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: less_eq_op");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: less_op");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 7: // Handles '='
                        lookahead = (char) inputFile.read();
                        if (lookahead == '=') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: relational_eq");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: assign_op");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 10: // Handles '!'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '=') {
                            lexeme[i++] = lookahead;
                            outputFile
                                    .println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: relational_not_eq");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: logical_NOT");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 13: // Handles '&'
                        lookahead = (char) inputFile.read();
                        if (Character.isLetter(lookahead) | lookahead == '$' | lookahead == '_'
                                | Character.isDigit(lookahead)) {
                            lexeme[i++] = lookahead;
                            state = 13;
                            break;
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            boolean isReserveWord = false;
                            // Check if the lexeme is a reserved word
                            for (int j = 0; j < reserveWords.length; j++) {
                                if (String.valueOf(lexeme, 0, i).equals(reserveWords[j])) {
                                    outputFile.println(
                                            "Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: " + reserveWords[j]);
                                    isReserveWord = true;
                                    break;
                                }
                            }
                            if (!isReserveWord) {
                                outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: id");
                            }

                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 15: // Handles '+'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '=') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: add_assign");
                        } else if (lookahead == '+') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: inc");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: arithmetic_add");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 19: // Handles '-'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '=') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: subtract_assign");
                        } else if (lookahead == '-') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: Dec");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println(
                                    "Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: arithmetic_subtraction");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 23: // Handles '*'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '=') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: multiply_assign");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i)
                                    + ", Token: arithmetic_multiplication_op");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 26: // Handles '/'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '=') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: divide_assign");

                        } else if (lookahead == '/') {
                            lexeme[i++] = lookahead;
                            while (lookahead != '\n') {
                                lookahead = (char) inputFile.read();
                                // if the end of the file is reached

                            }

                        } else if (lookahead == '*') {
                            lexeme[i++] = lookahead;
                            state = 30;
                            break;

                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println(
                                    "Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: arithmetic_division_op");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 30: // Handles '*'

                        lookahead = (char) inputFile.read();
                        if (lookahead == '*') {
                            lexeme[i++] = lookahead;
                            state = 31;

                            break;

                        } else {

                            break;

                        }

                    case 31: // Handles '*'

                        lookahead = (char) inputFile.read();
                        if (lookahead == '/') {
                            i = 0;
                            state = 0;
                            break;
                        } else if (lookahead == '*') {

                            break;

                        } else {
                            lexeme[i++] = lookahead;
                            state = 30;
                            break;
                        }

                    case 32: // Handles '%'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '=') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: mod_assign");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile
                                    .println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: arithmetic_mod_op");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 35: // Handles '|'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '|') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: logical_OR");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: vertical_bar");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 38: // Handles '&'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '&') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: logical_AND");
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: ampersand");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 41: // Handles '"'
                        lookahead = (char) inputFile.read();
                        if (lookahead == '"') {
                            lexeme[i++] = lookahead;
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: String");
                        } else if (lookahead == '\\') {

                            // check the specifiers
                            lexeme[i++] = lookahead;
                            state = 50;
                            break;

                        }

                        else {
                            lexeme[i++] = lookahead;
                            state = 41;
                            break;
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 43: // Handles '\''
                        lookahead = (char) inputFile.read();
                        if (lookahead == '\\') {
                            lexeme[i++] = lookahead;
                            state = 45;
                            break;
                        } else if (lookahead == '\'') {
                            System.out.println("Error: UNRECOGNIZED_TOKEN: ''");
                            i = 0; // Reset lexeme
                            state = 0;
                            break;

                        } else {
                            lexeme[i++] = lookahead;
                            lookahead = (char) inputFile.read();
                            if (lookahead == '\'') {
                                lexeme[i++] = lookahead;
                                outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: Char");
                            } else {
                                error(lookahead);
                            }

                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 50: // Handles '\''
                        lookahead = (char) inputFile.read();
                        // check the specifiers
                        if (isSpecifier(lookahead)) {
                            lexeme[i++] = lookahead;
                            state = 41;
                            break;

                        } else {
                            System.out.println("Error: UNRECOGNIZED_TOKEN: " +String.valueOf(lexeme, 0, i) );
                            

                        }

                        i = 0; // Reset lexeme
                        state = 0;

                        break;

                    case 45: // Handles '\''
                        lookahead = (char) inputFile.read();
                        // check the specifiers
                        if (isSpecifier(lookahead)) {
                            lexeme[i++] = lookahead;
                            lookahead = (char) inputFile.read();
                            if (lookahead == '\'') {
                                lexeme[i++] = lookahead;
                                outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: Char");
                                i = 0; // Reset lexeme
                                state = 0;
                                break;
                            } else {
                                error(lookahead);
                            }
                            break;
                        } else {
                            error(lookahead);
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 47: // Handles ';'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: semi_colon");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 48: // Handles ';'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: colon");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 49: // Handles ';'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: comma");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 52: // Handles ';'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: Open_curly");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 53: // Handles ';'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: close_curly");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 54: // Handles ';'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: open_bracket");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 55: // Handles ';'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: close_bracket");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 56: // Handles '('
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: open_parenthesis");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 57: // Handles ')'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: close_parenthesis");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 58: // Handles '#'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: hash");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 59: // Handles '~'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: tilde");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 60: // Handles '`'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: back_quote");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 61: // Handles '@'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: at");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 62: // Handles '?'
                        outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: question_mark");
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    case 63: // Handles 'Digits'
                        lookahead = (char) inputFile.read();
                        if (Character.isDigit(lookahead)) {
                            lexeme[i++] = lookahead;
                            state = 63;
                            break;
                        } else if (lookahead == '.') {
                            lexeme[i++] = lookahead;
                            state = 65;
                            break;
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: Int_Literal");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;
                    case 65: // Handles '&'
                        lookahead = (char) inputFile.read();
                        if (Character.isDigit(lookahead)) {
                            lexeme[i++] = lookahead;
                            state = 65;
                            break;
                        } else {
                            inputFile.unread(lookahead); // Unread the character
                            outputFile.println("Lexeme: " + String.valueOf(lexeme, 0, i) + ", Token: float_point");
                        }
                        i = 0; // Reset lexeme
                        state = 0;
                        break;

                    // Add more cases as necessary for other operators
                }
            }
            outputFile.flush(); // Flush the output buffer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void error(char c) { // Function to print error message
        System.out.println("Error: UNRECOGNIZED_TOKEN: " + c);
    }
    // function to check if the character is a specifier

    public static boolean isSpecifier(char c) { // Function to check if the character is a specifier
        char[] specifiers = { 'n', 't', 'r', 'b', 'f', 'v', 'a', '\\', '\'', '\"' };
        for (int i = 0; i < specifiers.length; i++) { // Loop through the specifiers array
            if (c == specifiers[i]) {
                return true; // Return true if the character is a specifier
            }
        }
        return false;
    }
}
