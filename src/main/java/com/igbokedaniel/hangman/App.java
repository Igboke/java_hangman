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
        int tracker;
        String guessedWord;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dashes = new ArrayList<>();

        guessedWord = "Bibles";

        for(int i=1;i<=guessedWord.length();i++){
                dashes.add("_");
        }
        System.out.println(dashes);
        
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
