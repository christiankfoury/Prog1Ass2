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

        // Calling the startMenu() method
        startMenu();
        
        // A word that will be selected out of the dictionnary text file
        String word = scFile.next().toLowerCase();
        // Length of word
        int numberOfLetters = word.length();
        // Output how many letter does the word contain
        System.out.println("This word contains " + numberOfLetters + " letters");
        // A hidden word that is disguised by "?" to play as the word
        String hiddenWord = word.replaceAll(".", "?");
        // Output the hidden word
        System.out.println(hiddenWord);
    }
    /**
     * This method welcome the user and outputs the rules, 
     * then this method will ask the user if they want to start the game by entering 1 or quit game by entering 0
     */
    public static void startMenu(){
        // Welcome output
        System.out.println("Welcome to hangman!\n");
        // Output the rules
        System.out.println("These are the rules:");
        System.out.println("- You have 6 guesses at each word");
        System.out.println("- You can guess a letter or a word");
        System.out.println("- +1 points if a letter is guessed ");
        System.out.println("- -1 points if letter guessed is wrong");
        System.out.println("- +2 points if a word is guessed");
        System.out.println("- -2 points if word guessed is wrong\n");
        
        System.out.println("0. Quit Game\n1. Start Game\n Enter your choice: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) 
        {
        case 0:
            System.out.println("Thanks for playing the game");
            System.exit(0);
            break;
    
        case 1:
            System.out.println("Game Initalized");
        default:
            System.out.println("Error: unnexpected value");
            System.out.println("0. Quit Game\n1. Start Game\n Enter your choice: ");
            startMenu();
            break;
        }
    }
    public static void wrongGuess0() {
        System.out.println("---------------------|");
        System.out.println("|        |-------    |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|     ===========    |");
        System.out.println("|--------------------|");
    }
    /**
     * This method outputs to the user the face of the hangman image 
     */
    public static void wrongGuess1() {
        System.out.println("---------------------|");
        System.out.println("|        |-------    |");
        System.out.println("|       ___      |   |");
        System.out.println("|      \\  /      |   |");
        System.out.println("|        |       |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|     ===========    |");
        System.out.println("|--------------------|");
    }
}

