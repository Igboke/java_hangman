package com.igbokedaniel.hangman;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Used Maven
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int wrongGuess = 0;
        String guessedWord;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> dashes = new ArrayList<>();
        char letterguessedChar;
        guessedWord = "bibles";

        for(int i=1;i<=guessedWord.length();i++){
                dashes.add('_');
        }
        while (wrongGuess < 6) {
                System.out.print(getHangmanArt(wrongGuess));
                System.out.print("Word: ");        
                for (char c : dashes) {
                        System.out.print(c + " "); 
                }
                System.out.println();
                System.out.print("Guess a Letter: ");

                letterguessedChar = scanner.next().toLowerCase().charAt(0);
                if (guessedWord.indexOf(letterguessedChar) != -1) {
                        for (int i = 0; i < guessedWord.length(); i++) {
                            if (guessedWord.charAt(i) == letterguessedChar) {
                                dashes.set(i, letterguessedChar);
                            }   
                        }
                        if (!dashes.contains('_')) {
                           System.out.println("You win");
                           break;     
                        }
                }
                else{
                        System.out.println("Wrong Guess");
                        wrongGuess++; 
                }

                  
        }

        if (wrongGuess >= 6) {
                System.out.printf("\nThe Correct word is %s",guessedWord);
        }
        
        scanner.close();
    }

    // creating the hangman stickman figure function
    static String getHangmanArt(int wrongGuess){
        return switch(wrongGuess){
            case 0 -> """
                    


                    """;
            case 1 -> """
                    O
                    

                    """;
            case 2 -> """
                    O
                    |

                    """;
            case 3 -> """
                    O
                   /|
                        
                    """;
            case 4 ->"""
                    O
                   /|\\
                   
                    """;
            case 5 ->"""
                    O
                   /|\\ 
                   /
            """;
            case 6 -> """
                    O
                   /|\\    
                   / \\
                    """;
            default -> " ";
        };
    }
}
