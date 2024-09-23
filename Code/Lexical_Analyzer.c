// ahmed yoonus
#include <stdio.h>
#include <string.h>
#include <conio.h> // For getch(), can be removed if not necessary

void tokenizer();
void error();
char lookahead;

// Main function to start execution
int main()
{
    // Call to tokenizer to generate tokens
    tokenizer();
    printf("Tokens have been identified successfully....!!!");
    getch(); // Remove if unnecessary
    return 0;
}

void tokenizer()
{
    // Store reserved words of C/Java into an array
    const char *reserveWords[] = {"int", "float", "if", "else", "while", "for", "abstract", "continue", "new", "switch", "assert", "default",
                                  "package", "synchronized", "boolean", "do", "private", "this", "break", "double", "protected", "implements", "throw", "byte", "return",
                                  "import", "public", "throws", "case", "enum", "instanceof", "transient", "catch", "extands", "short", "try", "char", "final", "interface",
                                  "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"};

    // Create an array named 'lexeme' to store lexemes
    char lexeme[30];
    int state = 0;                                                                      // Variable representing states
    char specifiers[] = {'n', 'a', 't', 'r', 'b', 'f', 0, 1, 2, 3, 4, 5, 6, 7, 39, 92}; // 39 represents ' and 92 represents
    int i = 0, j = 0, k = 0, flag = 0;

    // Open input.txt for reading and output.txt for writing
    FILE *inputFile = fopen("input.txt", "r");
    FILE *outputFile = fopen("output.txt", "w");

    if (inputFile == NULL)
    {
        printf("Error: input.txt does not exist.");
        return;
    }

    // Read one character from the input file and store it in lookahead variable
    while ((lookahead = fgetc(inputFile)) != EOF)
    {
        switch (state)
        {
        case 0:
            if (lookahead == ('\t' | '\n' | '\r' | ' '))
            {
                state = 0;
                lookahead = fgetc(inputFile);
                break;
            }
            else if (lookahead == '>')
            {
                state = 1;
                lexeme[i++] = lookahead;
            }
            else if (lookahead == '<')
            {
                state = 4;
                lexeme[i++] = lookahead;
            }

            // Add code for all outgoing arrows from state 0
            // Example: Identifiers, Arithmetic Operators, Relational Operators, etc.
            // ...
            // If no valid token is identified, call error function
            else
            {
                error();
                state = 0;
                break;
            }

        case 1:
            if (lookahead == '=')
            {
                state = 3;
            }
            else
            {
                state = 2;
            }
            break;

        case 2:
            state = 0;
            fprintf(outputFile, "Lexeme: %s, Token: grater_op\n", lexeme);
            i = 0;
            break;

        case 3:
            state = 0;
            lexeme[i] = '\0';
            fprintf(outputFile, "Lexeme: %s, Token: grater_eq_op\n", lexeme);
            i = 0;
            break;

        case 4:
            if (lookahead == '=')
            {
                state = 6;
            }
            else
            {
                state = 5;
            }
            break;

        case 5:
            state = 0;
            fprintf(outputFile, "Lexeme: %s, Token: less_op\n", lexeme);
            i = 0;
            break;
        case 6:
            state = 0;
            lexeme[i] = '\0';
            fprintf(outputFile, "Lexeme: %s, Token: less_eq_op\n", lexeme);
            i = 0;
            break;
        }
    }

    // Close the files
    fclose(inputFile);
    fclose(outputFile);
}

void error()
{
    printf("Error: UNRECOGNIZED_TOKEN\n");
    // Read one character and store it in lookahead variable
    lookahead = fgetc(stdin); // Adjust as necessary
}
