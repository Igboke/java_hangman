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
        ArrayList<String> dashes = new ArrayList<>();
        String letterguessedStr;
        char letterguessedChar;
        guessedWord = "bibles";

        for(int i=1;i<=guessedWord.length();i++){
                dashes.add("_");
        }
        while (wrongGuess < 6) {
                System.out.print("Word: ");        
                for (String c : dashes) {
                        System.out.print(c + " "); 
                }
                System.out.println();
                System.out.print("Guess a Letter: ");

                letterguessedStr = scanner.next().toLowerCase();
                letterguessedChar = letterguessedStr.charAt(0);
                if (guessedWord.indexOf(letterguessedChar) != -1) {
                        System.out.println("Correct Guess");
                        for (int i = 0; i < guessedWord.length(); i++) {
                            if (guessedWord.charAt(i) == letterguessedChar) {
                                dashes.set(i, letterguessedStr);
                            }   
                        }
                }
                else{
                        System.out.println("Wrong Guess");
                        wrongGuess++;
                        System.out.println(getHangmanArt(wrongGuess)); 
                }

                  
        }

        // System.out.println(dashes);
        
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
