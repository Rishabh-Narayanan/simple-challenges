package Challenges.Extra;
import java.util.Scanner;
public class JavaSum {
  public static boolean divisible(int num, int factor1, int factor2) {
    if (num % factor1 == 0 || num % factor2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static int sumNumbers(int num, int factor1, int factor2) {
    int sum = 0;
    for (int i = 0; i < num; i++) {
      if (divisible(i, factor1, factor2)) {
        sum += i;
      }
    }
    return sum;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("This program will take the sum of every number less than some number, n, given that " +
                      "the number is divisible by any one of two other numbers, f1 and f2.");

    System.out.println("What is n?");
    int n = scan.nextInt();
    System.out.println("What is f1?");
    int f1 = scan.nextInt();
    System.out.println("What is f2?");
    int f2 = scan.nextInt();
    System.out.println("The sum is: " + sumNumbers(n, f1, f2));
  }
}
