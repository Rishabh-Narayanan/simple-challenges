package Challenges.Extra;
import java.util.Scanner;
public class EvenFibonacciNumbers {
  private static int currentFib = 1;
  private static int prevFib = 0;
  public static void nextFib() {
    int temp = prevFib;
    prevFib = currentFib;
    currentFib += temp;
  }
  public static long sumNumbers(int l, int n) {
    long sum = 0;
    while (currentFib < l) {
      if (currentFib % n == 0) {
        sum += currentFib;
      }
      nextFib();
    }
    return sum;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("This program will sum every fibonacci number divisible by some number, n, less than some limit");
    System.out.println("What is the limit?");
    int limit = scan.nextInt();
    System.out.println("What is n?");
    int n = scan.nextInt();
    System.out.println("Sum of even fibonacci numbers: " + sumNumbers(limit, n));
  }
}
