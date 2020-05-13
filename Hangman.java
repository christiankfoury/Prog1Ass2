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
        
        // Skipping a line
        System.out.println();

        // A first do while loop to loop over if the user wants to play again
        do{
            // A second do while loop to loop over if the user guesses the word or terminated the game
            do {
                switch (wrongGuess){
                    case 1:
                        // Call this method if the wrong guess is equal to 1
                        wrongGuess1();
                        // Skip a line
                        System.out.println();
                        break;
                    
                    case 2:
                        // Call this method if the wrong guess is equal to 2
                        wrongGuess2();
                        // Skip a line
                        System.out.println();
                        break;

                    case 3:
                        // Call this method if the wrong guess is equal to 3
                        wrongGuess3();
                        // Skip a line
                        System.out.println();
                        break;
                    
                    case 4:
                        // Call this method if the wrong guess is equal to 4
                        wrongGuess4();
                        // Skip a line
                        System.out.println();
                        break;

                    case 5: 
                        // Call this method if the wrong guess is equal to 5
                        wrongGuess5();
                        // Output to the user that this is their last guess
                        System.out.println("**THIS IS YOUR LAST GUESS**");
                        // Skip a line
                        System.out.println();
                        break;

                    case 6:
                        // Call this method if the wrong guess is equal to 6
                        wrongGuess6();
                        // Output that the is game over
                        System.out.println("Game Over!");
                        // Output the amount of points
                        System.out.println("The amount of points accumulated were " + points + " points!");
                        // Output
                        System.out.println("Thanks for playing! Goodbye!");
                        // System exit
                        System.exit(0);
                        break;
                    default:
                        // The default case is to call the standart wrongGuess method 
                        wrongGuess0();
                        // Skip a line
                        System.out.println();
                        break;
                }
            
                // Prompt to the user if their guess is letter or a word
                System.out.println("Do you want to guess a letter or a word?");
                System.out.println("Type \"letter\" to guess a letter or \"word\" to guess a word");
                String letterOrWord = kb.next();
                String letter = "letter";
                String thisIsWord = "word";
                
                // If the user wants guess a letter, the program will do the following
                if (letterOrWord.equals(letter)) {
                    // Output
                    System.out.println("Take a guess!");
                    // Taking input of the user of a letter
                    char guessLetter = kb.next().charAt(0);
                    // Converting a char value into a string for future method appplications
                    String guessLetterToString = Character.toString(guessLetter);

                    if (letterAlreadyGuessed.contains(guessLetterToString)){
                        System.out.println("You have already guessed this letter");
                    }
                    // If the guessed letter inputted by the user corresponds to the word
                    else if (word.contains(guessLetterToString) && !hiddenWord.contains(guessLetterToString)) {
                        // Increment the points
                        points++;
                        System.out.println("+1 point");
                        System.out.println("You now have " + points + " points");
                        // A for loop to itterate over the whole word by changing all the "?" that corresponds to the letter inputted
                        for (int i = 0; i < hiddenWord.length(); i++) {
                            // This loop itterated letter by letter
                            if (word.charAt(i) == guessLetter) {
                                hiddenWord = hiddenWord.substring(0,i) + guessLetterToString + hiddenWord.substring(i+1);
                            }
                        }
                        letterAlreadyGuessed = letterAlreadyGuessed + guessLetterToString;
                        // Output the new hidden word
                        System.out.println("The letter " + guessLetterToString + " was found!");
                        System.out.println(hiddenWord);
                        
                    // If the letter inputted does not correspond to a letter in the word, then..
                    } else {
                        // Output to the user that the letter has not been found
                        System.out.println("The letter you have inputted was not found in the word");
                        letterAlreadyGuessed = letterAlreadyGuessed + guessLetterToString;
                        // Increment the wrong guess value
                        wrongGuess++;
                        // Decrement the points
                        points--;
                        System.out.println("-1 point!");
                        System.out.println("You now have " + points + " points");
                    }
                }
            }
        }
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
    /**
     * This method outputs to the user the standard hangman image
     */
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
    /**
     * This method outputs to the user the face and the body of the hangman image
     */
    public static void wrongGuess2() {
        System.out.println("---------------------|");
        System.out.println("|        |-------    |");
        System.out.println("|       ___      |   |");
        System.out.println("|      \\  /      |   |");
        System.out.println("|        |       |   |");
        System.out.println("|        |       |   |");
        System.out.println("|        |       |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|     ===========    |");
        System.out.println("|--------------------|");
    }
    
    /**
     * This method outputs to the user the face, the body and one of the legs of the hangman
     */
    public static void wrongGuess3() {
        System.out.println("---------------------|");
        System.out.println("|        |-------    |");
        System.out.println("|       ___      |   |");
        System.out.println("|      \\  /      |   |");
        System.out.println("|        |       |   |");
        System.out.println("|        |       |   |");
        System.out.println("|        |       |   |");
        System.out.println("|       /        |   |");
        System.out.println("|      /         |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|     ===========    |");
        System.out.println("|--------------------|");
    }
    /**
     * This method outputs to the user the face, the body and both of the legs of the hangman
     */
    public static void wrongGuess4() {
        System.out.println("---------------------|");
        System.out.println("|        |-------    |");
        System.out.println("|       ___      |   |");
        System.out.println("|      \\  /      |   |");
        System.out.println("|        |       |   |");
        System.out.println("|        |       |   |");
        System.out.println("|        |       |   |");
        System.out.println("|       /\\       |   |");
        System.out.println("|      /  \\      |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|     ===========    |");
        System.out.println("|--------------------|");
    }
    /**
     * This method outputs to the user the face, the body, both of the legs and one of the arms of the hangman
     */
    public static void wrongGuess5() {
        System.out.println("---------------------|");
        System.out.println("|        |-------    |");
        System.out.println("|       ___      |   |");
        System.out.println("|      \\  /      |   |");
        System.out.println("|        |       |   |");
        System.out.println("|       /|       |   |");
        System.out.println("|      / |       |   |");
        System.out.println("|       /\\       |   |");
        System.out.println("|      /  \\      |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|     ===========    |");
        System.out.println("|--------------------|");
    }
    public static void wrongGuess6() {
        System.out.println("---------------------|");
        System.out.println("|        |-------    |");
        System.out.println("|       ___      |   |");
        System.out.println("|      \\  /      |   |");
        System.out.println("|        |       |   |");
        System.out.println("|       /|\\     |   |");
        System.out.println("|      / | \\    |   |");
        System.out.println("|       /\\      |   |");
        System.out.println("|      /  \\     |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|     ===========    |");
        System.out.println("|--------------------|");
    }
}

