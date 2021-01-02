package Challenges.Extra;

import java.util.Scanner;
import java.util.Arrays;


public class LongestCollatz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What number do you want to check?");
        int limit = scan.nextInt();

        long[] current = sequence(limit);
        System.out.println("The collatz sequence of " + limit + " is: " + Arrays.toString(current));
        System.out.println("It has a length of: " + current.length);
        System.out.println("Do you want to know the longest sequence less than " + limit + "? (Y or N)");
        char c = scan.next().charAt(0);
        if (c == 'Y' || c == 'y') {
            System.out.println("\n\n");
            longest(limit);
        }

    }
    public static void longest(int limit) {
        int[] collatz = {0, 0};
        for (int i = 1; i <= limit; i++) {
            int x = collatzLength(i);
            if (x > collatz[1]) {
                collatz[1] = x;
                collatz[0] = i;
            }
        }
        System.out.println("The number with the longest collatz sequence less than " + limit + " is: " + collatz[0]);
        System.out.println("It has a length of: " + collatz[1]);
        System.out.println("Collatz sequence: " + Arrays.toString(sequence(collatz[0])));
    }
    public static int collatzLength(int i) {
        long j = i;
        int counter = 1;
        while (j != 1) {
           j = nextCollatz(j);
           counter++;
        } 
        return counter;
    }
    public static long[] sequence(int i) {
        long[] seq = new long[collatzLength(i)];
        long x = i;
        int counter = 0;
        while (x != 1) {
            seq[counter] = x;
            x = nextCollatz(x);

            counter++;
        }
        seq[counter] = x;
        return seq;
    }
    public static long nextCollatz(long x) {
        if (x % 2 == 0) {
            return x / 2;
        } else {
            return 3 * x + 1;
        }
    }
}