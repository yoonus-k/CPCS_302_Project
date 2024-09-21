#include <stdio.h>
#include <string.h>
#include <conio.h>  // For getch(), can be removed if not necessary

void tokenizer();
void error();
char lookahead;

// Main function to start execution
int main()
{
    // Call to tokenizer to generate tokens
    tokenizer();
    printf("Tokens have been identified successfully....!!!");
    getch();  // Remove if unnecessary
    return 0;
}

void tokenizer()
{
    // Store reserved words of C/Java into an array
    const char *reserveWords[] = {"int", "float", "if", "else", "while", "for", /* Add more reserved words */};

    // Create an array named 'lexeme' to store lexemes
    char lexeme[30];
    int state = 0;        // Variable representing states
    char specifiers[] = {'n', 'a', 't', 'r', 'b', 39, 92};  // 39 represents ' and 92 represents \
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
            // Add code for all outgoing arrows from state 0
            // Example: Identifiers, Arithmetic Operators, Relational Operators, etc.
            // ...
            // If no valid token is identified, call error function
            error();
            state = 0;
            break;

        case 1:
            // Read the next character from the input file
            lookahead = fgetc(inputFile);

            // Write code for all outgoing arrows from this state
            // ...

            break;

        case 2:
            state = 0;
            lexeme[i] = '\0';  // Storing null character at the end of lexeme

            // Check if lexeme is a reserved word
            for (j = 0; j < 32; j++)
            {
                if (strcmp(lexeme, reserveWords[j]) == 0)
                {
                    flag = 1;
                    break;
                }
            }

            // Write lexeme and token in the output file
            if (flag)  // If it is a reserved word
            {
                fprintf(outputFile, "Lexeme: %s, Token: Reserved Word\n", lexeme);
                flag = 0;
            }
            else  // If it is an identifier
            {
                fprintf(outputFile, "Lexeme: %s, Token: ID\n", lexeme);
            }
            i = 0;
            break;

        case 3:
            // Read one character and store it in lookahead variable
            lookahead = fgetc(inputFile);

            // Corresponding code for digits
            // ...

            break;

        case 4:
            state = 0;
            lexeme[i] = '\0';
            fprintf(outputFile, "Lexeme: %s, Token: INTEGER\n", lexeme);
            i = 0;
            break;

        // Continue with all states in the integrated FA for recognizing:
        // (i) Arithmetic Operators (+, -, *, /, %)
        // (ii) Arithmetic Assignment Operators (+=, -=, *=, /=, %=)
        // (iii) Relational Operators (<, <=, >, >=, ==, !=)
        // (iv) Logical Operators (&&, ||, !)
        // (v) Increment/Decrement Operators (++ --)
        // (vi) Single Line and Multi-Line Comments
        // (vii) Character and String literals
        // (viii) Integer and float literals
        // (ix) Punctuation Marks ([, ], (, ), ;, :, ,) etc.
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
    lookahead = fgetc(stdin);  // Adjust as necessary
}
