package Challenges.Extra;
import java.util.Scanner;
public class HangMan {
    // write your instance variables/attributes here
    private String secretWord;
    private int totalGuesses;
    private int incorrectGuesses;
    private String currentWord;
    public int numLetters;

    public HangMan(String word, int parts) {
        secretWord = word;
        totalGuesses = parts;
        incorrectGuesses = 0;
        currentWord = "";
        for (int i = 0; i < word.length(); i++) {
            if (secretWord.charAt(i) == ' ') {
                currentWord = currentWord + " ";
            } else {
                currentWord = currentWord + "-";
                numLetters++;
            }
        }
    }

    public void guessLetter(char c) {
        boolean inWord = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.toLowerCase().charAt(i) == Character.toLowerCase(c)) {
                currentWord = currentWord.substring(0, i) + c + currentWord.substring(i + 1);
                inWord = true;
            }
        }
        if (!inWord) {
            incorrectGuesses++;
            System.out.println("Current word: " + currentWord);
            System.out.println(incorrectGuesses + " wrong guesses out of " + totalGuesses);
        } else {
            System.out.println("Current word: " + currentWord);
            System.out.println(incorrectGuesses + " wrong guesses out of " + totalGuesses);
        }
    }

    public void play(Scanner s) {
        while (incorrectGuesses != totalGuesses && !currentWord.equalsIgnoreCase(secretWord)) {
            System.out.println("What letter do you want to guess? ");
            char c = s.next().charAt(0);
            guessLetter(c);
        }
        if (totalGuesses == incorrectGuesses) {
            System.out.println("You lost, the word was " + secretWord);
        } else {
            System.out.println("That right! You won");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of body parts that make up a complete stick figure: ");
        int parts = Integer.parseInt(scan.nextLine());
        System.out.print("Enter your secret word: ");
        String word = scan.nextLine();
        HangMan h = new HangMan(word, parts);

        System.out.println("The secret word has " + h.numLetters + " letters. Press enter to play!");
        scan.nextLine();
        h.play(scan);
    }
}