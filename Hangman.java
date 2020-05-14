import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This program is a hangman game. The user can guess a letter or a word from the word to be guessed. There is also a points system
 * in which a user tries to accumulate the most points while trying to guess the word. If the word is guessed the user can 
 * play again for another round.
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
                        // Output the word
                        System.out.println("The word was " + word);
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
                // Else if the user wants to guess a word then...
                else if (letterOrWord.equals(thisIsWord)){
                    // Output
                    System.out.println("Take a guess!");
                    // Taking input from the user
                    String guessedWord = kb.next();
                    // If the word inputted corresponds to the word to be guessed then...
                    if (word.equalsIgnoreCase(guessedWord)) {
                        hiddenWord = word;
                        // Change the value of isWordGuessed
                        isWordGuessed = true;
                        // Increment points
                        points += 2;
                        System.out.println("+2 points!");
                        System.out.println("You now have " + points + " points");

                      // Else the word inputted by the user does not correspond to the word to be guess then...
                    } else {
                        // Output to the user they haven't guessed the right word
                        System.out.println("The word you have entered is not the right word!");
                        // Decrement the points
                        points -= 2;
                        System.out.println("-2 points!");
                        System.out.println("You now have " + points + " points");
                        // Increment the wrongGuess value
                        wrongGuess++;
                    } 
                }
                // Else the user inputs something else when they are asked to input a letter or word then..
                else {
                    // Output the input they have done is not valid
                    System.out.println("This was not a valid choice!");
                }

                // IF the hidden word does not contain anymore "?" then the user has fully guessed the word
                if (!hiddenWord.contains("?")) {
                    // Change the value of isWordGuessed to true
                    isWordGuessed = true;
                    System.out.println("You have guessed the word!\n");
                    // Ask the user if they want to play again
                    System.out.println("Do you want to play again? Yes or no");
                    // Getting their input and putting it into a lower case value to reduce confusion for future comparaisons
                    answer = kb.next().toLowerCase();

                    // If the user does not input yes or no loop the question 
                    while (!answer.equals("yes") && !answer.equals("no")){
                        // Output
                        System.out.println("This was not a valid input");
                        System.out.println("Do you want to play again? Yes or no");
                        // Recieve input from the user
                        answer = kb.next().toLowerCase();
                    }

                    // If their input is yes then...
                    if (answer.equals("yes")) {
                        // Take a word from the hangman dictionnary
                        if (scFile.hasNext()) {
                            word = scFile.next().toLowerCase();
                        } else {
                            System.out.println("Congratulations! You are the hangman king or queen!");
                            System.out.println("You completed with a total of " + points + " points!");
                            System.out.println("Thanks for playing!");
                            System.exit(0);
                        }
                        // Length of word
                        numberOfLetters = word.length();
                        // Output how many letter does the word contain
                        System.out.println("This word contains " + numberOfLetters + " letters");
                        // A hidden word that is disguised by "?" to play as the word
                        hiddenWord = word.replaceAll(".", "?");
                        // Output the hidden word
                        System.out.println(hiddenWord);
                        isWordGuessed = false;
                        wrongGuess = 0;
                        letterAlreadyGuessed = "";
                    }
                    // Else if their input if no then...
                    else if (answer.equals("no")){
                        // Output their amount of points accumulated
                        System.out.println("The amount of points accumulated were " + points + " points!");
                        System.out.println("Thanks for playing! Goodbye!");
                        // System exit
                        System.exit(0);
                    }
                }
            } while(isWordGuessed == false);
        }
        
        while (answer.equals("yes"));
        
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
     /**
     * This method outputs the full hangman to the user which consists the face, the body, both of the legs and both of the arms of the hangman
     */
    public static void wrongGuess6() {
        System.out.println("---------------------|");
        System.out.println("|        |-------    |");
        System.out.println("|       ___      |   |");
        System.out.println("|      \\  /      |   |");
        System.out.println("|        |       |   |");
        System.out.println("|       /|\\      |   |");
        System.out.println("|      / | \\     |   |");
        System.out.println("|       /\\       |    |");
        System.out.println("|      /  \\      |   |");
        System.out.println("|                |   |");
        System.out.println("|                |   |");
        System.out.println("|     ===========    |");
        System.out.println("|--------------------|");
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
        
        // Game menu
        System.out.println("0. Quit Game\n1. Start Game\n Enter your choice: ");
        // Using the scanner class
        Scanner input = new Scanner(System.in);
        // The choice of the user
        int choice = 0;
        boolean isNumber = false;
        // A do while loop if the user does not input a valid number
        do{
            isNumber = false;
            if (input.hasNextInt()){
                choice = input.nextInt();
                isNumber = true;
            } else {
                System.out.println("This was not a valid input!");
                System.out.println("0. Quit Game\n1. Start Game\n Enter your choice: ");
                input.next();
            }
        } while(!isNumber);
        

        // Using the switch case statement
        switch (choice) 
        {
        // If the user inputs 0 then exit the game
        case 0:
            System.out.println("Thanks for playing the game");
            System.exit(0);
            break;
    
        // If the use inputs 1 then play the game
        case 1:
            System.out.println("Game Initalized");
            break;
        default:
        // If the user inputs something else than a number, then loop back the startMenu method
            System.out.println("Error: unnexpected value");
            System.out.println("0. Quit Game\n1. Start Game\n Enter your choice: ");
            startMenu();
            break;
        }
    }
}