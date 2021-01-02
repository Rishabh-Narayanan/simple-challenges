package Challenges.Extra;
import java.util.Scanner;
import java.util.Random;
public class Unscramble {
    private char[] letters;
    private String answer;
    public Unscramble(String s) {
        answer = s;
        letters = s.toLowerCase().toCharArray();
    }
    public void scrambleLetters() {
        Random r = new Random();
        for (int i = 1; i < answer.length(); i++) {
            int rand = r.nextInt(i);
            char temp = letters[i];
            letters[i] = letters[rand];
            letters[rand] = temp;
        }
    }
    public void play(Scanner scan) {
        scrambleLetters();
        String guess;
        System.out.println("Your scrambled word is " + String.valueOf(letters));
        System.out.println();
        do {
            System.out.println("What is your guess");
            guess = scan.next();
        } while (!guess.equalsIgnoreCase(answer));
        System.out.println("That's right!");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the word: ");
        String s = scan.next();
        Unscramble u = new Unscramble(s);
        u.play(scan);
    }
}