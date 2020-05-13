import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * @author Christian
 */

public class Hangman {
    
    /** 
     * The main method executes the whole hangman program
     * @param args
     * @throws FileNotFoundException
     */
    // Main method
    public static void main(String[] args) throws FileNotFoundException {
        // Using the scanner class to recieve letterOrWord form the user
        Scanner kb = new Scanner(System.in);
        // File path
        File inFile = new File("C:/Users/Chris/chris/HangmanDictionary.txt");
        // Reading the Dictionnary File with the scanner class
        Scanner scFile = new Scanner(inFile);
        
        // Declaring and initializing some values
        /* This value beginning index and endIndex  is for changing the hidden letter of 
           the hidden word with the letter inputted by the user if it is valid */
        int beginningIndex = 0;
        int endIndex = 1;
        // If the user inputs a wrong answer, this value will increment
        int wrongGuess = 0;
        // A boolean value if the user guesses the word
        boolean isWordGuessed = false;
        // A value to keep track of points
        int points = 0;
        // A string value to keep track of the letter guessed
        String letterAlreadyGuessed = "";
        // This value will be used the store the answer of the user if the user wants to play again
        String answer = "";
    }
}