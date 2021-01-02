package Challenges.Extra;
import java.util.Scanner;

// Reset: "\033[0m"
// Magenta: "\033[0;35m"
// Cyan: "\033[0;36m"
public class NimGame {
    Scanner scan = new Scanner(System.in);
    private int[] heaps;
    public NimGame(int[] x) {
        heaps = x.clone();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\033[0m" + "Welcome to Nim... I hope you are ready to lose");
        System.out.println("Do you want to play with the computer or with someone else?");
        String player = scan.nextLine();
        int len;
        do {
        System.out.println("How many piles do you want to play with?");
        len = scan.nextInt();
        } while (len <= 0);
        int[] x = new int[len];
        for (int i = 1; i <= len; i++) {
            int j;
            do {
                System.out.println("How many coins do you want in pile " + i + "?");
                j = scan.nextInt();
            } while (j <= 0);
            x[i - 1] = j;
        }
        NimGame n = new NimGame(x);
        n.printHeaps();
        if (player.equalsIgnoreCase("computer")) {
            boolean compTurn = false;
            if (n.winner()) {
                System.out.println("I'll go first");
                compTurn = true;
            } else {
                System.out.println("You can go first");
                compTurn = false;
            }
            while (n.notEmptyHeaps()) {
                if (compTurn) {
                    System.out.println();
                    System.out.println("\033[0;35m" + "My Turn");
                    n.computerTurn();
                    compTurn = false;
                } else {
                    System.out.println();
                    System.out.println("\033[0;36m" + "Your Turn");
                    n.playerTurn();
                    compTurn = true;
                }
                n.printHeaps();
            }
            System.out.println("\033[0m");
            if (!compTurn) {
                System.out.println("Ha! I won... As expected");
            } else {
                System.out.println("You won? I must have messed up my calculations");
            }
        } else {
            boolean player1 = true;
            while (n.notEmptyHeaps()) {
                if (player1) {
                    System.out.println();
                    System.out.println("\033[0;35m" + "Player 1 Turn");
                    n.playerTurn();
                    player1 = false;
                } else {
                    System.out.println();
                    System.out.println("\033[0;36m" + "Player 2 Turn");
                    n.playerTurn();
                    player1 = true;
                }
                n.printHeaps();
            }
            System.out.println("\033[0m");
            if (!player1) {
                System.out.println("Player 1 won");
            } else {
                System.out.println("Player 2 won");
            }
        }
        System.out.println();
        scan.close();
    }
    public boolean notEmptyHeaps() {
        for (int i = 0; i < heaps.length; i++) {
            if (heaps[i] != 0) return true;
        }
        return false;
    }
    //true if current player will win
    public boolean winner() {
        if (nimSum() == 0) {
            return false;
        }
        return true;
    }
    public void nextMove() {
        int x = nimSum();
        for (int i = 0; i < heaps.length; i++) {
            if ((x ^ heaps[i]) < heaps[i]) {
                System.out.println("I am going to remove " + (heaps[i] - (x ^ heaps[i])) + " coins from pile " + (i + 1));
                heaps[i] = x ^ heaps[i];
                break;
            }
        }
    }
    public void calculating() {
        System.out.print("\033[0;31m" + "Calculating.");
        int d = 500;
        try {
            Thread.sleep(d);
            System.out.print(".");
            Thread.sleep(d);
            System.out.print(".");
            Thread.sleep(d);
            System.out.print("\b\b");
            System.out.print("  \b\b");
            Thread.sleep(d);
            System.out.print(".");
            Thread.sleep(d);
            System.out.print(".");
            Thread.sleep(d);
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\033[0;35m");
    }
    public void computerTurn() {
        calculating();
        nextMove();
    }
    public void playerTurn() {
        int pile;
        int number;
        boolean b;
        do {
            b = false;
            System.out.println("Which pile do you want to take from?");
            pile = scan.nextInt() - 1;
            if (pile >= heaps.length || pile < 0) {
                System.out.println("Sorry! That pile doesn't exist");
                b = true;
            } else if (heaps[pile] == 0) {
                System.out.println("Sorry! That pile has 0 coins");
                b = true;
            }
        } while (b);
        boolean b1;
        do {
            b1 = false;
            System.out.println("How many coins from pile " + (pile + 1) + " do you want to take?");
            number = scan.nextInt();
            if (number > heaps[pile]) {
                System.out.println("Sorry! There aren't that many coins in this pile");
                b1 = true;
            } else if (number == 0) {
                System.out.println("Sorry! You have to make a move");
                b1 = true;
            } else if (number < 0) {
                System.out.println("Sorry! I can't remove negative coins");
                b1 = true;
            }
        } while (b1);

        heaps[pile] -= number;
    }

    public int nimSum() {
        int sum = 0;
        for (int i = 0; i < heaps.length; i++) {
            sum = sum ^ heaps[i];
        }
        return sum;
    }
    public void printHeaps() {
        for (int i = 0; i < heaps.length; i++) {
            System.out.printf("Pile %2d: %2d coins ----> ", (i + 1), heaps[i]);
            for (int j = 0; j < heaps[i]; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}